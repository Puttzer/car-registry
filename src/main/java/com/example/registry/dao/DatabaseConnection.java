package com.example.registry.dao;

public class DatabaseConnection {

    public static java.sql.Connection getConnection() throws java.sql.SQLException {
        String url = "jdbc:mysql://localhost:3306/car_registry";
        String user = "root";
        String password = "root";
        return java.sql.DriverManager.getConnection(url, user, password);

    }
}


/*
 * Klass: DatabaseConnection
 *
 * Syfte:
 * Denna klass används för att skapa en anslutning mellan Java-programmet och MySQL-databasen.
 * När andra klasser vill hämta eller spara data, behöver de först ansluta till databasen.
 *
 * Hur det fungerar:
 * - Metoden getConnection() bygger upp en anslutning genom att använda tre saker:
 *     1. URL – var databasen finns (t.ex. på localhost, port 3306, databasnamn car_registry)
 *     2. Användarnamn – oftast 'root' när du jobbar lokalt
 *     3. Lösenord – det du satte när du skapade containern (i vårt fall: 'root')
 *
 * - DriverManager är en del av Java som kan prata med databaser.
 * - Om anslutningen misslyckas (fel lösenord, databas stängd osv.) kastas ett fel (SQLException).
 *   Just nu hanterar vi inte felet själva utan skickar det vidare.
 *
 * Exempel på hur man använder denna klass:
 *     Connection conn = DatabaseConnection.getConnection();
 *
 * OBS:
 * För att detta ska fungera behöver du ha:
 * - Lagt till mysql-connector-j som dependency i pom.xml
 * - Startat din MySQL-container och verifierat att databasen kör
 */
