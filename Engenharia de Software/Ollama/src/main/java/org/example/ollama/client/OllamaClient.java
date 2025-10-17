package org.example.ollama.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ollama.model.ChatMessage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

/**
 * Cliente simples para Ollama usando /api/chat.
 * Método público: chat(model, messages)
 */
public class OllamaClient {
    private final HttpClient http;
    private final ObjectMapper mapper;
    private final String baseUrl;

    public OllamaClient(String baseUrl) {
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length()-1) : baseUrl;
        this.http = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
        this.mapper = new ObjectMapper();
    }

    /**
     * Envia um chat-style request para o Ollama e retorna o conteúdo da resposta do assistant.
     *
     * @param model nome do modelo (ex: "llama3.2")
     * @param messages lista de ChatMessage (role/content)
     * @return resposta do assistant (texto) ou mensagem de erro
     */
    public String chat(String model, List<ChatMessage> messages) {
        try {
            // Monta JSON manualmente com ObjectMapper
            JsonNode root = mapper.createObjectNode()
                    .put("model", model)
                    .put("stream", false)
                    .set("messages", mapper.valueToTree(messages));

            String body = mapper.writeValueAsString(root);

            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/api/chat"))
                    .timeout(Duration.ofSeconds(30))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> resp = http.send(req, HttpResponse.BodyHandlers.ofString());

            if (resp.statusCode() / 100 != 2) {
                return "HTTP error " + resp.statusCode() + ": " + resp.body();
            }

            JsonNode respRoot = mapper.readTree(resp.body());
            if (respRoot.has("message") && respRoot.get("message").has("content")) {
                return respRoot.get("message").get("content").asText();
            }
            if (respRoot.has("response")) {
                return respRoot.get("response").asText();
            }
            // fallback: choices[0].message.content ou choices[0].text
            if (respRoot.has("choices") && respRoot.get("choices").isArray() && respRoot.get("choices").size() > 0) {
                JsonNode c = respRoot.get("choices").get(0);
                if (c.has("message") && c.get("message").has("content")) {
                    return c.get("message").get("content").asText();
                }
                if (c.has("text")) {
                    return c.get("text").asText();
                }
            }
            return "[Resposta não encontrada no JSON retornado]";
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Erro ao comunicar com Ollama: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
    }
}