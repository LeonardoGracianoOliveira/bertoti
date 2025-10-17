package org.example.ollama.model;


import java.util.List;


/**
 * Estrutura do request para /api/chat
 */
public class ChatRequest {
    private String model;
    private boolean stream = false;
    private List<ChatMessage> messages;


    public ChatRequest() {}


    public ChatRequest(String model, List<ChatMessage> messages) {
        this.model = model;
        this.messages = messages;
    }


    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }


    public boolean isStream() { return stream; }
    public void setStream(boolean stream) { this.stream = stream; }


    public List<ChatMessage> getMessages() { return messages; }
    public void setMessages(List<ChatMessage> messages) { this.messages = messages; }
}