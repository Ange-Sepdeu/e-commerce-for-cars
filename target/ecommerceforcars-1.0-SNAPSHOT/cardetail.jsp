<%-- 
    Document   : cardetail
    Created on : 27 mai 2024, 18:04:15
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Detail</title>
            <link rel="stylesheet" href="styleaddcar.css">
    </head>
    <body>
            <div class="container">
        <h2>Add Car</h2>
        <button onclick="window.history.back()">← Go Back</button>
        <form action="ReserveCar" method="POST">
            <label for="model">Model Id:</label>
            <input type="text" id="model" disabled value='${car.carId}' name="carId"><br><br>
            
            <label for="model">Model Name:</label>
            <input type="text" disabled id="model" value="${car.model}" name="model"><br><br>

            <label for="year">Year:</label>
            <input type="text" value="${car.year}" id="year" name="year" disabled><br><br>

            <label for="price">Price:</label>
            <div> ${car.price} </div> <br><br>

            <label for="quantity">Number of Cars To Reserve:</label>
            <input type="number" min="1" id="quantity" name="number"><br><br>
            
            <label for="quantity">Number of Cars Available:</label>
            <input type="number" disabled value='${car.numberOfCarsAvailable}' id="quantity" name="numberOfCarsAvailable"><br><br>

            <label for="image">Image:</label>
            <img src='${car.image}'><br><br>

            <label for="description">Description:</label><br>
            <textarea id="description" disabled name="otherDetails" rows="4" cols="50">${car.otherDetails}</textarea><br><br>

            <button type="submit">Reserve Car</button>
        </form>
    </div>
    </body>
</html>
