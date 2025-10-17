package org.example.biblioteca.dao;

import org.example.biblioteca.db.SQLiteConnectionManager;
import org.example.biblioteca.model.Biblioteca;
import org.example.biblioteca.model.Livro;
import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LivroDaoTest {
    private SQLiteConnectionManager cm;
    private LivroDao livroDao;
    private BibliotecaDao bibliotecaDao;

    private final String TEST_DB = "target/test-db/test-biblioteca.db";

    @BeforeAll
    public void setup() throws Exception {
        new File("target/test-db").mkdirs();
        cm = new SQLiteConnectionManager(TEST_DB);
        try (Connection conn = cm.getConnection(); Statement st = conn.createStatement()) {
            st.executeUpdate("PRAGMA foreign_keys = ON;");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Biblioteca (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, endereco TEXT);");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Livro (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, autor TEXT, isbn TEXT UNIQUE, biblioteca_id INTEGER, FOREIGN KEY (biblioteca_id) REFERENCES Biblioteca(id) ON DELETE SET NULL);");
        }
        livroDao = new LivroDao(cm);
        bibliotecaDao = new BibliotecaDao(cm);
    }

    @AfterAll
    public void teardown() {
        File f = new File(TEST_DB);
        if (f.exists()) f.delete();
    }

    @Test
    public void testCreateAndGetAndDelete() throws Exception {
        Biblioteca b = new Biblioteca("TesteLib", "Rua T");
        bibliotecaDao.create(b);

        Livro l = new Livro("Titulo", "Autor", "ISBN-1", b.getId());
        int id = livroDao.create(l);
        assertTrue(id > 0);

        Livro fetched = livroDao.getById(id);
        assertNotNull(fetched);
        assertEquals("Titulo", fetched.getTitulo());

        List<Livro> all = livroDao.getAll();
        assertTrue(all.size() >= 1);

        boolean deleted = livroDao.delete(id);
        assertTrue(deleted);
        assertNull(livroDao.getById(id));
    }

    @Test
    public void testUpdate() throws Exception {
        Biblioteca b = new Biblioteca("TesteLib2", "Rua X");
        bibliotecaDao.create(b);

        Livro l = new Livro("Old", "Autor", "ISBN-2", b.getId());
        livroDao.create(l);

        l.setTitulo("Novo");
        boolean ok = livroDao.update(l);
        assertTrue(ok);

        Livro updated = livroDao.getById(l.getId());
        assertEquals("Novo", updated.getTitulo());

        livroDao.delete(l.getId());
    }
}