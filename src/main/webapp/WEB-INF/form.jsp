<%--
  Created by IntelliJ IDEA.
  User: carra
  Date: 30/04/2025
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.registry.model.Brand" %>
<<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // Hämta bilmärken från attributet (skickas av CarServlet)
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");

    // Hämta eventuellt bekräftelsemeddelande
    String message = (String) request.getAttribute("message");
%>

<html>
<head>
    <title>Registrera eller ta bort bil</title>
</head>
<body>
<h1>Registrera eller ta bort bil</h1>

<%-- Visa bekräftelsemeddelande om det finns --%>
<% if (message != null) { %>
<p style="color: green;"><%= message %></p>
<% } %>

<form action="cars" method="post">
    <label for="registration">Registreringsnummer:</label><br>
    <input type="text" id="registration" name="registration" required><br><br>

    <label for="brandId">Bilmärke:</label><br>
    <select id="brandId" name="brandId">
        <% for (Brand brand : brands) { %>
        <option value="<%= brand.getId() %>"><%= brand.getName() %></option>
        <% } %>
    </select><br><br>

    <button type="submit" name="action" value="add">Lägg till bil</button>
    <button type="submit" name="action" value="delete">Ta bort bil</button>
</form>
</body>
</html>
