package org.example.biblioteca;

import org.example.biblioteca.db.SQLiteConnectionManager;
import org.example.biblioteca.dao.*;
import org.example.biblioteca.model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dbPath = "biblioteca.db"; // arquivo do banco na raiz do projeto
        SQLiteConnectionManager cm = new SQLiteConnectionManager(dbPath);

        // cria tabelas (se ainda não existirem)
        try (Connection conn = cm.getConnection(); Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, email TEXT UNIQUE NOT NULL);");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Biblioteca (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, endereco TEXT);");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Livro (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, autor TEXT, isbn TEXT UNIQUE, biblioteca_id INTEGER, FOREIGN KEY (biblioteca_id) REFERENCES Biblioteca(id) ON DELETE SET NULL);");
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Teste (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, resultado TEXT, usuario_id INTEGER, FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE SET NULL);");
            System.out.println("Tabelas verificadas/criadas.");
        } catch (SQLException e) {
            System.err.println("Erro criando tabelas: " + e.getMessage());
            return;
        }

        UsuarioDao usuarioDao = new UsuarioDao(cm);
        BibliotecaDao bibliotecaDao = new BibliotecaDao(cm);
        LivroDao livroDao = new LivroDao(cm);
        TesteDao testeDao = new TesteDao(cm);

        try {
            // --- Usuario: cria apenas se não existir (evita UNIQUE constraint) ---
            Usuario u = new Usuario("Maria", "maria@example.com");
            int userId = usuarioDao.createIfNotExists(u);
            System.out.println("Usuario id em uso: " + userId + " -> " + u);

            // --- Biblioteca ---
            Biblioteca b = new Biblioteca("Central", "Rua A, 123");
            int bId = bibliotecaDao.create(b);
            System.out.println("Biblioteca criada id: " + bId + " -> " + b);

            // --- Livro ---
            Livro l = new Livro("Java Básico", "Autor Exemplo", "ISBN-1234", b.getId());
            int livroId = livroDao.create(l);
            System.out.println("Livro criado id: " + livroId + " -> " + l);

            // --- Listar livros ---
            List<Livro> livros = livroDao.getAll();
            System.out.println("Livros no DB:");
            livros.forEach(System.out::println);

            // --- Atualizar livro ---
            l.setTitulo("Java Básico — 2ª ed.");
            boolean ok = livroDao.update(l);
            System.out.println("Atualizado? " + ok + " -> " + livroDao.getById(l.getId()));

            // --- Teste ---
            Teste t = new Teste("Teste Unitário", "Ok", u.getId());
            int tid = testeDao.create(t);
            System.out.println("Teste criado id: " + tid + " -> " + t);

        } catch (SQLException e) {
            System.err.println("Erro SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}