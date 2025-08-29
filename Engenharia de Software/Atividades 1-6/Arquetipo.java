// Classe Arquétipo
public class Arquetipo {
    private String nome;
    private String descricao;
    private int vida;
    private int mana;

    public Arquetipo(String nome, String descricao, int vida, int mana) {
        this.nome = nome;
        this.descricao = descricao;
        this.vida = vida;
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Classe: " + nome + " (" + descricao + ")" +
               "\nVida: " + vida + ", Mana: " + mana;
    }
}