package com.example.registry;

import com.example.registry.dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            System.out.println("✅ Anslutning lyckades!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Kunde inte ansluta till databasen.");
            e.printStackTrace(); // Skriver ut mer detaljer om felet
        }
    }
}
