package com.example.registry.test;


import com.example.registry.dao.BrandDAO;
import com.example.registry.model.Brand;

import java.sql.SQLException;
import java.util.List;


public class BrandDAOTest {
    public static void main(String[] args) throws SQLException {
        BrandDAO brandDAO = new BrandDAO();

        List<Brand> brands = brandDAO.getAllBrands();

        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
            System.out.println(brand.getId() + " - " + brand.getName());
        }

    }



}
