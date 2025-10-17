package org.example.biblioteca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionManager {
    private final String databaseUrl;

    /**
     * databasePath example: "database.db" (file in project root) or full path "/home/user/db/database.db"
     */
    public SQLiteConnectionManager(String databasePath) {
        this.databaseUrl = "jdbc:sqlite:" + databasePath;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseUrl);
    }
}