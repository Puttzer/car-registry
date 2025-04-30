package com.example.registry.test;


import com.example.registry.dao.CarDAO;
import com.example.registry.model.Car;

import java.sql.SQLException;

/**
 * Syfte: Den här testklassen verifierar att CarDAO fungerar som förväntat.
 * Den gör två saker:
 *   1. Lägger till en testbil i databasen med registreringsnummer "TEST123"
 *   2. Tar bort samma bil direkt efter
 *
 * När testet körs korrekt bör du se två rader i konsolen som bekräftar
 * att bilen först lades till och sedan togs bort.
 */
public class CarDAOTest {

    public static void main(String[] args) {
        try {
            // Skapar ett objekt av CarDAO för att kunna anropa DAO-metoderna
            CarDAO carDAO = new CarDAO();

            // Skapar ett testobjekt av Car med ett registreringsnummer och ett giltigt brandId
            // OBS: brandId måste existera i databasen för att INSERT ska fungera!
            Car testCar = new Car("TEST123", 1); // Använd t.ex. brandId = 1 (t.ex. Volvo)

            // Försöker lägga till testbilen i databasen
            carDAO.addCar(testCar);
            System.out.println("✔ Bil tillagd: " + testCar.getRegistration());

            // Tar bort samma bil från databasen baserat på registreringsnummer
            carDAO.deleteCar("TEST123");
            System.out.println("✔ Bil borttagen: " + testCar.getRegistration());

        } catch (SQLException e) {
            // Om något går fel under databasoperationerna visas ett felmeddelande
            System.out.println("✘ Något gick fel med databasåtkomst:");
            e.printStackTrace();
        }
    }
}
