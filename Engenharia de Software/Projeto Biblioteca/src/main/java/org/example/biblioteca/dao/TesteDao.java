package org.example.biblioteca.dao;

import org.example.biblioteca.db.SQLiteConnectionManager;
import org.example.biblioteca.model.Teste;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TesteDao {
    private final SQLiteConnectionManager cm;

    public TesteDao(SQLiteConnectionManager cm) { this.cm = cm; }

    public int create(Teste t) throws SQLException {
        String sql = "INSERT INTO Teste(nome, resultado, usuario_id) VALUES(?, ?, ?)";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getNome());
            ps.setString(2, t.getResultado());
            if (t.getUsuarioId() == null) ps.setNull(3, Types.INTEGER);
            else ps.setInt(3, t.getUsuarioId());

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserção falhou.");

            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    t.setId(id);
                    return id;
                } else {
                    throw new SQLException("Falha ao recuperar id gerado.");
                }
            }
        }
    }

    public Teste getById(int id) throws SQLException {
        String sql = "SELECT id, nome, resultado, usuario_id FROM Teste WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Teste(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("resultado"),
                        rs.getObject("usuario_id") == null ? null : rs.getInt("usuario_id")
                );
                return null;
            }
        }
    }

    public List<Teste> getAll() throws SQLException {
        String sql = "SELECT id, nome, resultado, usuario_id FROM Teste";
        List<Teste> list = new ArrayList<>();
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(new Teste(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("resultado"),
                    rs.getObject("usuario_id") == null ? null : rs.getInt("usuario_id")
            ));
        }
        return list;
    }

    public boolean update(Teste t) throws SQLException {
        if (t.getId() == null) throw new IllegalArgumentException("id null");
        String sql = "UPDATE Teste SET nome = ?, resultado = ?, usuario_id = ? WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getNome());
            ps.setString(2, t.getResultado());
            if (t.getUsuarioId() == null) ps.setNull(3, Types.INTEGER);
            else ps.setInt(3, t.getUsuarioId());
            ps.setInt(4, t.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Teste WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
