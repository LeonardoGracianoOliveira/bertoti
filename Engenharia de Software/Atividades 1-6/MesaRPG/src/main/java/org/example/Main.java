package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria uma campanha
        Campanha campanha = new Campanha("Sombras do Abismo", 1);

        // Cria jogadores
        Jogador jogador1 = new Jogador("Mestre", "Leonardo", 28);
        Jogador jogador2 = new Jogador("Jogador", "Carla", 25);

        // Cria personagens
        Personagem personagem1 = new Personagem("Darian", "Reino do Norte", "Cabelos brancos");
        Personagem personagem2 = new Personagem("Lyra", "Floresta Élfica", "Olhos verdes");

        // Cria arquétipos
        Arquetipo guerreiro = new Arquetipo("Guerreiro", 100, 20, "Especialista em combate corpo a corpo");
        Arquetipo maga = new Arquetipo("Maga", 60, 100, "Usuária de magia ancestral");

        // Atribui arquétipos aos personagens
        personagem1.addArquetipo(guerreiro);
        personagem2.addArquetipo(maga);

        // Adiciona personagens aos jogadores
        jogador1.addPersonagem(personagem1);
        jogador2.addPersonagem(personagem2);

        // Adiciona jogadores à campanha
        campanha.addJogador(jogador1);
        campanha.addJogador(jogador2);

        // --- EXIBIÇÃO COMPLETA ---
        System.out.println("=== CAMPANHA ===");
        System.out.println("Nome: " + campanha.getNome());
        System.out.println("Sessão: " + campanha.getSessao());
        System.out.println("Jogadores:");

        for (Jogador j : campanha.getJogadores()) {
            System.out.println("\n>> Jogador: " + j.getNome());
            System.out.println("Função: " + j.getFuncao());
            System.out.println("Idade: " + j.getIdade());

            if (j.getPersonagens().isEmpty()) {
                System.out.println("Nenhum personagem associado.");
            } else {
                for (Personagem p : j.getPersonagens()) {
                    System.out.println("   Personagem: " + p.getNome());
                    System.out.println("   Origem: " + p.getOrigem());
                    System.out.println("   Aparência: " + p.getAparencia());

                    if (p.getArquetipo() != null) {
                        Arquetipo a = p.getArquetipo();
                        System.out.println("   Arquetipo: " + a.getNome());
                        System.out.println("   Vida: " + a.getPontosDeVida());
                        System.out.println("   Mana: " + a.getPontosDeMana());
                        System.out.println("   Descrição: " + a.getDescricao());
                    }
                }
            }
        }

        // --- BUSCAS ---
        System.out.println("\n=== TESTES DE BUSCA ===");

        System.out.println("\nBuscando jogador 'Carla':");
        List<Jogador> encontrados = campanha.buscarJogadorNome("Carla");
        for (Jogador j : encontrados) {
            System.out.println("Encontrado: " + j.getNome() + " (" + j.getFuncao() + "), Idade: " + j.getIdade());
        }

        System.out.println("\nBuscando personagem 'Darian':");
        List<Personagem> personagens = campanha.buscarPersonagemNome("Darian");
        for (Personagem p : personagens) {
            Arquetipo a = p.getArquetipo();
            System.out.println("Encontrado: " + p.getNome() + " | Origem: " + p.getOrigem() +
                    " | Aparência: " + p.getAparencia() +
                    " | Arquetipo: " + a.getNome() +
                    " (Vida: " + a.getPontosDeVida() +
                    ", Mana: " + a.getPontosDeMana() + ")");
        }

        System.out.println("\n--- Execução concluída com sucesso ---");
    }
}