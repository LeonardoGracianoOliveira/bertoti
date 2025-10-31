package org.example;

public class Personagem {
    private String nome;
    private String origem;
    private String aparencia;
    private Arquetipo arquetipo;

    public Personagem() {}

    public Personagem(String nome, String origem, String aparencia) {
        this.nome = nome;
        this.origem = origem;
        this.aparencia = aparencia;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public String getAparencia() { return aparencia; }
    public void setAparencia(String aparencia) { this.aparencia = aparencia; }

    public Arquetipo getArquetipo() { return arquetipo; }

    // Método UML
    public void addArquetipo(Arquetipo arquetipo) {
        this.arquetipo = arquetipo;
    }
}