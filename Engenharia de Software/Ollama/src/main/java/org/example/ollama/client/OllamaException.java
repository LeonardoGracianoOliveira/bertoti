package org.example.ollama.client;


public class OllamaException extends Exception {
    public OllamaException(String message) { super(message); }
    public OllamaException(String message, Throwable cause) { super(message, cause); }
}