package com.example.registry.servlets;

import com.example.registry.dao.BrandDAO;
import com.example.registry.dao.CarDAO;
import com.example.registry.model.Brand;
import com.example.registry.model.Car;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Hämta alla bilmärken från DAO
            BrandDAO brandDAO = new BrandDAO();
            List<Brand> brands = brandDAO.getAllBrands();

            // Skicka listan till JSP via request attribute
            request.setAttribute("brands", brands);

            // Skicka vidare till JSP-sidan (View)
            request.getRequestDispatcher("form.jsp").forward(request, response);

        } catch (Exception e) {
            // Om något går fel: visa fel i konsolen och skicka felmeddelande
            e.printStackTrace();
            response.getWriter().write("Kunde inte hämta bilmärken: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Hämta data från formuläret
        String registration = request.getParameter("registration");
        String brandIdStr = request.getParameter("brandId");
        String action = request.getParameter("action");

        try {
            CarDAO carDAO = new CarDAO();

            if ("add".equals(action)) {
                // 2. Skapa bil och lägg till
                int brandId = Integer.parseInt(brandIdStr);
                Car car = new Car(registration, brandId);
                carDAO.addCar(car);
                request.setAttribute("message", "Bil tillagd: " + registration);

            } else if ("delete".equals(action)) {
                // 3. Ta bort bil
                carDAO.deleteCar(registration);
                request.setAttribute("message", "Bil borttagen: " + registration);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Fel vid operation: " + e.getMessage());
        }

        // 4. Hämta bilmärken igen så dropdown fungerar även efter POST
        try {
            List<Brand> brands = new BrandDAO().getAllBrands();
            request.setAttribute("brands", brands);
        } catch (Exception e) {
            request.setAttribute("message", "Kunde inte ladda bilmärken: " + e.getMessage());
        }

        // 5. Skicka tillbaka till samma formulärsida
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

}
