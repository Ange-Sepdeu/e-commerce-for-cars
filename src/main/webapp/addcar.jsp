<%-- 
    Document   : addcar
    Created on : 24 mai 2024, 09:31:44
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Cars</title>
    <link rel="stylesheet" href="styleaddcar.css">
</head>
<body>
    <div class="container">
        <h2>Add Car</h2>
        <button onclick="window.history.back()">← Go Back</button>
        <form action="AddCar" method="POST" enctype="multipart/form-data" >
            <label for="brand">Brand Name:</label>
            <select name="brandId" style="width: 100%; padding: 8px; margin-bottom: 3%;border:none;outline:none;">
                <c:forEach items="${carBrands}" var="brands">
                <option value='${brands.brandId}'>${brands.brandName}</option>
                </c:forEach>
            </select>

            <label for="model">Model Name:</label>
            <input type="text" id="model" required name="model"><br><br>

            <label for="year">Year:</label>
            <input type="number" id="year" required style="width: 100%; padding: 8px;border:none;outline:none;" name="year"><br><br>

            <label for="price">Price:</label>
            <input type="number" id="price" required name="price" style="width: 100%; padding: 8px;border:none;outline:none;"><br><br>

            <label for="image">Image:</label>
            <input type="file" required accept="images/*" id="image" name="image" style="background-color: lightgray; width: 100%; padding: 8px;border:none;outline:none;"><br><br>

            <label for="description">Description:</label><br>
            <textarea id="description" required name="otherDetails" rows="4" cols="50"></textarea><br><br>

            <button type="submit">Add Car</button>
        </form>
    </div>
    </body>
</html>
