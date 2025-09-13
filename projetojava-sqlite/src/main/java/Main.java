import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:meubanco.db"; // cria o arquivo do banco na pasta do projeto

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("✅ Conexão estabelecida com SQLite!");

                // Criar tabela
                String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                             "nome TEXT NOT NULL," +
                             "idade INTEGER" +
                             ");";

                Statement stmt = conn.createStatement();
                stmt.execute(sql);

                // Inserir dado
                stmt.execute("INSERT INTO pessoas (nome, idade) VALUES ('João', 25)");

                // Ler dados
                ResultSet rs = stmt.executeQuery("SELECT * FROM pessoas");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                                       " | Nome: " + rs.getString("nome") +
                                       " | Idade: " + rs.getInt("idade"));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}