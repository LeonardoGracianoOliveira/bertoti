package org.example;

import java.util.ArrayList;
import java.util.List;

public class Arquetipo {
    private String nome;
    private int pontosDeVida;
    private int pontosDeMana;
    private String descricao;

    public Arquetipo() {}

    public Arquetipo(String nome, int pontosDeVida, int pontosDeMana, String descricao) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.pontosDeMana = pontosDeMana;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getPontosDeVida() { return pontosDeVida; }
    public void setPontosDeVida(int pontosDeVida) { this.pontosDeVida = pontosDeVida; }

    public int getPontosDeMana() { return pontosDeMana; }
    public void setPontosDeMana(int pontosDeMana) { this.pontosDeMana = pontosDeMana; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    // Método UML
    public static List<Arquetipo> buscarArquetipoNome(List<Arquetipo> lista, String nome) {
        List<Arquetipo> encontrados = new ArrayList<>();
        for (Arquetipo a : lista) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(a);
            }
        }
        return encontrados;
    }
}