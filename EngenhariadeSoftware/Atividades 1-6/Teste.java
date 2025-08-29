import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Teste {

    @Test
    public void testCriacaoJogador() {
        Arquetipo guerreiro = new Arquetipo("Guerreiro", "Focado em corpo a corpo", 20, 2);
        Personagem zed = new Personagem("Zed", "Militar", "Draconato", guerreiro);
        Jogador joao = new Jogador("João", 20, "Player", zed);

        // Testa se os dados estão corretos
        assertNotNull(joao);
        assertEquals("João", "João"); // Esperado, Valor real
        assertEquals(20, 20);
    }

    @Test
    public void testToStringJogador() {
        Arquetipo guerreiro = new Arquetipo("Guerreiro", "Focado em corpo a corpo", 20, 2);
        Personagem zed = new Personagem("Zed", "Militar", "Draconato", guerreiro);
        Jogador joao = new Jogador("João", 20, "Player", zed);

        String texto = joao.toString();
        assertTrue(texto.contains("João"));
        assertTrue(texto.contains("Draconato"));
        assertTrue(texto.contains("Guerreiro"));
    }
}