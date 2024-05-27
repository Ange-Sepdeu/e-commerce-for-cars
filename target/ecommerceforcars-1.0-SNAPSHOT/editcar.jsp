<%-- 
    Document   : editcar.jsp
    Created on : 24 mai 2024, 01:22:43
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit car</title>
    <link rel="stylesheet" href="styleaddcar.css">
    </head>
    <body>
    <div class="container">
        <h2>Edit Car</h2>
        <button onclick="window.history.back()">← Go Back</button>
        <form action="EditCar" method="POST" enctype="multipart/form-data">
            <label for="brand">Model:</label>
            <input type="text" id="brand" placeholder='${activeCar.model}' value='${activeCar.model}' name="model"><br><br>
            
            <label for="brand">Price:</label>
            <input type="number" id="price" placeholder='${activeCar.price}' value='${activeCar.price}' name="price"><br><br>
             <label for="image">Image:</label>
            <input type="file" accept="images/*" id="image" name="image"><br><br>
            <label for="brand">Year:</label>
            <input type="number" id="year" placeholder='${activeCar.year}' value='${activeCar.year}' name="year"><br><br>
            <input hidden name="carId" value='${activeCar.carId}'>
            <label for="description">Description:</label><br>
            <textarea id="description" name="otherDetails" placeholder='${activeCar.otherDetails}' value='${activeCar.otherDetails}' rows="4" cols="50"></textarea><br><br>
            <button type="submit">Edit</button>
        </form>
    </div>
    </body>
</html>
