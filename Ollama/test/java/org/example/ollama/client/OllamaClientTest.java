package org.example.ollama.client;


import org.example.ollama.model.ChatMessage;
import org.junit.jupiter.api.Test;


import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


public class OllamaClientTest {
    @Test
    public void testChat() throws Exception {
        OllamaClient client = new OllamaClient("http://localhost:11434");
        String model = "llama3";
        String pergunta = "2 + 2 = ?";
        String resposta = client.chat(model, List.of(new ChatMessage("user", pergunta)));
        assertNotNull(resposta);
        assertTrue(resposta.contains("4") || resposta.toLowerCase().contains("quatro"));
    }
}