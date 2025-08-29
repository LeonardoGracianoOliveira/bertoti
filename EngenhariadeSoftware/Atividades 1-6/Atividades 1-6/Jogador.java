// Classe Jogador
public class Jogador {
    private String nome;
    private int idade;
    private String papel; // mestre ou player

    private Personagem personagem; // Associação com a classe Personagem

    public Jogador(String nome, int idade, String papel, Personagem personagem) {
        this.nome = nome;
        this.idade = idade;
        this.papel = papel;
        this.personagem = personagem;
    }

    @Override
    public String toString() {
        return "Jogador " + nome + " de " + idade + " anos, papel: " + papel +
               "\n" + personagem;
    }
}