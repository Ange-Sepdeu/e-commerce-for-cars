<%-- 
    Document   : editbrand.jsp
    Created on : 24 mai 2024, 01:22:18
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit brand</title>
        <link rel="stylesheet" href="styleaddcar.css">
    </head>
    <body>
    <div class="container">
        <h2>Edit brand</h2>
        <button onclick="window.history.back()">← Go Back</button>
        <form action="UpdateBrand" method="POST">
            <label for="brand">Brand Name:</label>
            <input type="text" id="brand" placeholder='${activeBrand.brandName}' value='${activeBrand.brandName}' name="brandName"><br><br>
                
            <input hidden name="brandId" value='${activeBrand.brandId}'>
            
            <label for="description">Description:</label><br>
            <textarea id="description" name="description" placeholder='${activeBrand.description}' value='${activeBrand.description}' rows="4" cols="50"></textarea><br><br>

            <button type="submit">Edit brand</button>
        </form>
    </div>
    </body>
</html>
