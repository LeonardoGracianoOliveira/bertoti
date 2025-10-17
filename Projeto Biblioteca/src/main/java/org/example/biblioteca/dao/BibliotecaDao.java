package org.example.biblioteca.dao;

import org.example.biblioteca.db.SQLiteConnectionManager;
import org.example.biblioteca.model.Biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDao {
    private final SQLiteConnectionManager cm;

    public BibliotecaDao(SQLiteConnectionManager cm) { this.cm = cm; }

    public int create(Biblioteca b) throws SQLException {
        String sql = "INSERT INTO Biblioteca(nome, endereco) VALUES(?, ?)";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNome());
            ps.setString(2, b.getEndereco());
            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserção falhou.");

            // Recupera last_insert_rowid() na mesma conexão
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    b.setId(id);
                    return id;
                } else {
                    throw new SQLException("Falha ao recuperar id gerado.");
                }
            }
        }
    }

    public Biblioteca getById(int id) throws SQLException {
        String sql = "SELECT id, nome, endereco FROM Biblioteca WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Biblioteca(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"));
                return null;
            }
        }
    }

    public List<Biblioteca> getAll() throws SQLException {
        String sql = "SELECT id, nome, endereco FROM Biblioteca";
        List<Biblioteca> list = new ArrayList<>();
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(new Biblioteca(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco")));
        }
        return list;
    }

    public boolean update(Biblioteca b) throws SQLException {
        if (b.getId() == null) throw new IllegalArgumentException("id null");
        String sql = "UPDATE Biblioteca SET nome = ?, endereco = ? WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNome());
            ps.setString(2, b.getEndereco());
            ps.setInt(3, b.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Biblioteca WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}