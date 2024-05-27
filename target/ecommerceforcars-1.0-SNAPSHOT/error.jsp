<%-- 
    Document   : error
    Created on : 27 mai 2024, 13:50:04
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <style>
            body {
                background-image: url('images/error-pic.jpg');
                background-repeat: no-repeat;
                background-size: cover;
            }
            h2 {
                font-size: 48px;
                font-weight: 800;
                text-align: center;
            }
            h3 {
                font-size: 40px;
                font-weight: 700;
                text-align: center;
                color: red;
            }
            a {
                text-decoration: none;
                font-size: 40px;
                margin-left: 40%;
            }
        </style>
    </head>
    <body>
        <div style=" margin: 0 auto; padding: 10px; border-radius: 10px; background-color: white;margin-top: 10%;width: 50%;">
        <h2>An error occured :</h2>
        <h3>${errorMessage}</h3>
        <a href='admin.html'>Go back</a>
        </div>
    </body>
</html>
