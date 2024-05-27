<%-- 
    Document   : success
    Created on : 27 mai 2024, 13:50:31
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
        <style>
            body {
                background-image: url('images/car-bg.jpg');
                background-repeat: no-repeat;
                background-size: cover;
            }
            h2 {
                font-size: 48px;
                font-weight: 800;
                text-align: center;
            }
            h3 {
                font-size: 20px;
                font-weight: 700;
                text-align: center;
                color: green;
            }
            a {
                text-decoration: none;
                font-size: 30px;
                margin-left: 40%;
            }
            div {
                margin: 0 auto;
                padding: 10px;
                background-color: white;
                border-radius: 10px;
                margin-top: 10%;
                width: 50%;
            }
        </style>
    </head>
    <body>
        <div>
        <h2>${successTitle} </h2>
        <h3>${successMessage}</h3>
        <a href='admin.html'>View results</a>
        </div>
    </body>
</html>
