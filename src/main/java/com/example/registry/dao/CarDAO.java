package com.example.registry.dao;

import com.example.registry.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDAO {

    public void addCar(Car car) throws SQLException {
        String sql = "INSERT INTO cars (registration, brand_id) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement state = conn.prepareStatement(sql)) {
            state.setString(1, car.getRegistration());
            state.setInt(2, car.getBrand_id());
            state.executeUpdate();
        }
    }

    public void deleteCar(String registration) throws SQLException {
        String sql = "DELETE FROM cars WHERE registration = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, registration);
            stmt.executeUpdate();
        }
    }



}
