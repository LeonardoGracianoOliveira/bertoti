// Classe Personagem
public class Personagem {
    private String nome;
    private String origem;
    private String raca;

    private Arquetipo arquetipo; // Associação com a classe Arquétipo

    public Personagem(String nome, String origem, String raca, Arquetipo arquetipo) {
        this.nome = nome;
        this.origem = origem;
        this.raca = raca;
        this.arquetipo = arquetipo;
    }

    @Override
    public String toString() {
        return "Personagem " + nome + ", um " + raca + " de origem " + origem +
               "\n" + arquetipo;
    }
}