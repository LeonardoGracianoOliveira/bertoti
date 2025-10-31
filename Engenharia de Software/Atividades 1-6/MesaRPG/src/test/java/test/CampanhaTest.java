package test;

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CampanhaTest {

    @Test
    public void testAdicionarJogador() {
        Campanha campanha = new Campanha("Aventura Épica", 1);
        Jogador jogador = new Jogador("Mestre", "Leonardo", 25);

        campanha.addJogador(jogador);

        assertEquals(1, campanha.getJogadores().size());
        assertEquals("Leonardo", campanha.getJogadores().get(0).getNome());
    }

    @Test
    public void testBuscarJogadorPorNome() {
        Campanha campanha = new Campanha("Aventura", 2);
        Jogador j1 = new Jogador("Jogador", "Carlos", 22);
        Jogador j2 = new Jogador("Jogador", "Ana", 20);
        campanha.addJogador(j1);
        campanha.addJogador(j2);

        List<Jogador> resultado = campanha.buscarJogadorNome("Ana");
        assertEquals(1, resultado.size());
        assertEquals("Ana", resultado.get(0).getNome());
    }

    @Test
    public void testBuscarPersonagemPorNome() {
        Campanha campanha = new Campanha("Missão", 3);
        Jogador jogador = new Jogador("Jogador", "Pedro", 30);
        Personagem personagem = new Personagem("Thorin", "Anão", "Barba longa");
        jogador.addPersonagem(personagem);
        campanha.addJogador(jogador);

        List<Personagem> resultado = campanha.buscarPersonagemNome("Thorin");
        assertEquals(1, resultado.size());
        assertEquals("Thorin", resultado.get(0).getNome());
    }
}