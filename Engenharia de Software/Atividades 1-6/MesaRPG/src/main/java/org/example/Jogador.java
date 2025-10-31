package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String funcao;
    private String nome;
    private int idade;
    private List<Personagem> personagens;

    public Jogador() {
        personagens = new ArrayList<>();
    }

    public Jogador(String funcao, String nome, int idade) {
        this.funcao = funcao;
        this.nome = nome;
        this.idade = idade;
        this.personagens = new ArrayList<>();
    }

    // Getters e Setters
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public List<Personagem> getPersonagens() { return personagens; }

    // Método UML
    public void addPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }
}