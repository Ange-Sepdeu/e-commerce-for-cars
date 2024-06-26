<%-- 
    Document   : admin
    Created on : 24 mai 2024, 00:50:30
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    <link rel="stylesheet" href="styleadmin.css">
    </head>
    <body>
        <div style="width: 97vw;">
        <h1>Welcome Admin</h1>
        
                <h2>List of brands </h2>
            <a href="addbrand.html"><button style="background-color: green;">Add a brand</button></a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Brand Name</th>
                    <th>Description</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allBrands}" var="brand">
                <tr>
                    <td>${brand.brandId}</td>
                    <td>${brand.brandName}</td>
                    <td>${brand.description}</td>
                    <td style="display: flex; flex-direction: row; justify-content: center; align-items: center;">
                        <form action="SelectBrand" method="POST">
                            <input type="text" hidden name="brandId" value='${brand.brandId}'>
                            <button type="submit">Edit</button>
                        </form>
                        <form action="DeleteBrand" method="GET">
                            <input type="text" hidden name="brandId" value='${brand.brandId}'>
                            <button style="background-color: red" type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                                <tr>
                    <th>ID</th>
                    <th>Brand Name</th>
                    <th>Description</th>
                    <th>Operation</th>
                </tr>
            </tfoot>
        </table>
        
            <hr>
            
            <h2 style="margin-top: 10vh; margin-bottom: 2vh;">List of cars </h2>
<!--            <a href="SelectCarBrand">Add a car</a>-->
        <form action="SelectCarBrand" method="GET">
            <input type="text" hidden name="redirect" value="true" >
            <button type="submit" style="background-color: green;">Add a car</button>
        </form>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Brand Id</th>
                    <th>Model Name</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Number of Cars</th>
                    <th>Images</th>
                    <th>Description</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allCars}" var="car">
                <tr>
                    <td>${car.carId}</td>
                    <td>${car.brandId}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.price}</td>
                    <td>${car.numberOfCarsAvailable}</td>
                    <td>
                        <img src="${car.image}" >
                    </td>
                    <td>${car.otherDetails}</td>
                    <td style="display: flex; flex-direction: row; justify-content: space-between; align-items: center;">
                        <form action="SelectCar" method="POST">
                            <input type="text" hidden name="carId" value='${car.carId}'>
                            <button type="submit">Edit</button>
                        </form>
                        <form action="DeleteCar" method="GET">
                            <input type="text" hidden name="carId" value='${car.carId}'>
                            <input type="text" hidden name="image" value="${car.image}">
                            <button style="background-color: red" type="submit">Delete</button>
                        </form>
                        <form action="AddCarNumber" method="POST">
                            <input type="number" hidden name="numberOfCarsAvailable" value="${car.numberOfCarsAvailable}">
                            <input type="text" hidden name="carId" value='${car.carId}'>
                            <button type="submit">Add</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                                <tr>
                    <th>ID</th>
                    <th>Brand Id</th>
                    <th>Model Name</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Number of Cars</th>
                    <th>Images</th>
                    <th>Description</th>
                    <th>Operation</th>
                </tr>
            </tfoot>
        </table>
    </div>
    </body>
</html>
