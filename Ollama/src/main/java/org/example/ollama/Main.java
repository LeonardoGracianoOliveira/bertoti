package org.example.ollama;

import org.example.ollama.client.OllamaClient;
import org.example.ollama.model.ChatMessage;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:11434"; // ajuste se necessário
        OllamaClient client = new OllamaClient(baseUrl);

        String model = "llama3"; // ajuste para o modelo que você tem
        String pergunta = "Qual é a capital do Brasil?";

        String resposta = client.chat(model, List.of(
                new ChatMessage("user", pergunta)
        ));

        System.out.println("Pergunta: " + pergunta);
        System.out.println("Resposta: " + resposta);
    }
}
