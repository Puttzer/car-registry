package com.example.registry.dao;

import com.example.registry.model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO {

    public List<Brand> getAllBrands() throws SQLException {
        List<Brand> brands = new ArrayList<>();
        String sql = "SELECT id, name FROM brands";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement state = conn.prepareStatement(sql);
            ResultSet res = state.executeQuery()){
            while(res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                Brand brand = new Brand(id, name);
                brands.add(brand);
            }
        }
        return brands;
    }
}
