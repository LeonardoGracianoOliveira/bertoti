package org.example.biblioteca.dao;

import org.example.biblioteca.db.SQLiteConnectionManager;
import org.example.biblioteca.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private final SQLiteConnectionManager cm;

    public UsuarioDao(SQLiteConnectionManager cm) {
        this.cm = cm;
    }

    /**
     * Cria um usuário e retorna o id gerado.
     * Lança SQLException em caso de erro (incluindo UNIQUE constraint).
     */
    public int create(Usuario u) throws SQLException {
        String sql = "INSERT INTO Usuario(nome, email) VALUES(?, ?)";
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserção falhou.");

            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SELECT last_insert_rowid()")) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    u.setId(id);
                    return id;
                } else {
                    throw new SQLException("Falha ao recuperar id gerado.");
                }
            }
        }
    }

    /**
     * Retorna o usuário pelo id, ou null se não existir.
     */
    public Usuario getById(int id) throws SQLException {
        String sql = "SELECT id, nome, email FROM Usuario WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                return null;
            }
        }
    }

    /**
     * Retorna o usuário pelo email, ou null se não existir.
     */
    public Usuario getByEmail(String email) throws SQLException {
        if (email == null) return null;
        String sql = "SELECT id, nome, email FROM Usuario WHERE email = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                return null;
            }
        }
    }

    /**
     * Cria o usuário se não existir (verificando pelo email). Retorna o id existente ou criado.
     */
    public int createIfNotExists(Usuario u) throws SQLException {
        Usuario existing = getByEmail(u.getEmail());
        if (existing != null) {
            u.setId(existing.getId());
            return existing.getId();
        }
        return create(u);
    }

    /**
     * Retorna todos os usuários.
     */
    public List<Usuario> getAll() throws SQLException {
        String sql = "SELECT id, nome, email FROM Usuario";
        List<Usuario> list = new ArrayList<>();
        try (Connection conn = cm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
        }
        return list;
    }

    /**
     * Atualiza o usuário; retorna true se atualizou alguma linha.
     */
    public boolean update(Usuario u) throws SQLException {
        if (u.getId() == null) throw new IllegalArgumentException("id null");
        String sql = "UPDATE Usuario SET nome = ?, email = ? WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getId());
            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Deleta usuário pelo id; retorna true se deletou.
     */
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE id = ?";
        try (Connection conn = cm.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}