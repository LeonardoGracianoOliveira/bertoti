// Classe principal para testar
public class Main {
    public static void main(String[] args) {
        // Criando o arquétipo
        Arquetipo guerreiro = new Arquetipo(
            "Guerreiro",
            "Focado em corpo a corpo",
            20,
            2
        );

        // Criando o personagem
        Personagem zed = new Personagem(
            "Zed",
            "Militar",
            "Draconato",
            guerreiro
        );

        // Criando o jogador
        Jogador joao = new Jogador(
            "João",
            20,
            "Player",
            zed
        );

        // Mostrando as informações
        System.out.println(joao);
    }
}
