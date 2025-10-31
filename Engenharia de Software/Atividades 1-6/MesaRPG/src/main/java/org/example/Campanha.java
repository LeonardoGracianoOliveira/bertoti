package org.example;

import java.util.ArrayList;
import java.util.List;

public class Campanha {
    private String nome;
    private int sessao;
    private List<Jogador> jogadores;

    public Campanha() {
        jogadores = new ArrayList<>();
    }

    public Campanha(String nome, int sessao) {
        this.nome = nome;
        this.sessao = sessao;
        this.jogadores = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getSessao() { return sessao; }
    public void setSessao(int sessao) { this.sessao = sessao; }

    public List<Jogador> getJogadores() { return jogadores; }

    // Métodos UML
    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public List<Jogador> buscarJogadorNome(String nome) {
        List<Jogador> encontrados = new ArrayList<>();
        for (Jogador j : jogadores) {
            if (j.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(j);
            }
        }
        return encontrados;
    }

    public List<Personagem> buscarPersonagemNome(String nome) {
        List<Personagem> encontrados = new ArrayList<>();
        for (Jogador j : jogadores) {
            for (Personagem p : j.getPersonagens()) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    encontrados.add(p);
                }
            }
        }
        return encontrados;
    }
}