package org.example.biblioteca.dao;

import org.example.biblioteca.db.SQLiteConnectionManager;
import org.example.biblioteca.model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    // ✅ Gerenciador de conexão
    private final SQLiteConnectionManager cm;

    // ✅ Construtor que recebe o ConnectionManager
    public LivroDao(SQLiteConnectionManager cm) {
        this.cm = cm;
    }

    // ✅ Criação da tabela (se não existir)
    public void createTable() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS Livro (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                titulo TEXT NOT NULL,
                autor TEXT NOT NULL,
                isbn TEXT,
                biblioteca_id INTEGER,
                FOREIGN KEY(biblioteca_id) REFERENCES Biblioteca(id)
            )
        """;
        try (Connection conn = cm.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    // ✅ CREATE
    public int create(Livro l) throws SQLException {
        String sql = "INSERT INTO Livro(titulo, autor, isbn, biblioteca_id) VALUES(?, ?, ?, ?)";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getIsbn());
            if (l.getBibliotecaId() == null)
                ps.setNull(4, Types.INTEGER);
            else
                ps.setInt(4, l.getBibliotecaId());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Falha ao inserir livro.");

            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    l.setId(id);
                    return id;
                } else {
                    throw new SQLException("Falha ao recuperar ID gerado.");
                }
            }
        }
    }

    // ✅ READ (por ID)
    public Livro getById(int id) throws SQLException {
        String sql = "SELECT * FROM Livro WHERE id = ?";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Livro l = new Livro();
                    l.setId(rs.getInt("id"));
                    l.setTitulo(rs.getString("titulo"));
                    l.setAutor(rs.getString("autor"));
                    l.setIsbn(rs.getString("isbn"));
                    l.setBibliotecaId(rs.getInt("biblioteca_id"));
                    return l;
                }
            }
        }
        return null;
    }

    // ✅ READ (todos)
    public List<Livro> getAll() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro";
        try (Connection conn = cm.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Livro l = new Livro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setIsbn(rs.getString("isbn"));
                l.setBibliotecaId(rs.getInt("biblioteca_id"));
                livros.add(l);
            }
        }
        return livros;
    }

    // ✅ UPDATE
    public boolean update(Livro l) throws SQLException {
        String sql = "UPDATE Livro SET titulo=?, autor=?, isbn=?, biblioteca_id=? WHERE id=?";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setString(3, l.getIsbn());
            if (l.getBibliotecaId() == null)
                ps.setNull(4, Types.INTEGER);
            else
                ps.setInt(4, l.getBibliotecaId());
            ps.setInt(5, l.getId());

            return ps.executeUpdate() > 0;
        }
    }

    // ✅ DELETE
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Livro WHERE id = ?";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}