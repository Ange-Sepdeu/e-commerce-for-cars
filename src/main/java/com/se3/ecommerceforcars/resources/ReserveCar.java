/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se3.ecommerceforcars.resources;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.se3.ecommerceforcars.Car;

/**
 *
 * @author PC
 */
@WebServlet(name = "ReserveCar", urlPatterns = {"/ReserveCar"})
public class ReserveCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 String carId = request.getParameter("carId");
        PrintWriter out = response.getWriter();
        String number = request.getParameter("number");
        String numberOfCarsAvailable = request.getParameter("numberOfCarsAvailable");
        try {
        Car car = new Car();
        car.setCarId(carId);
        car.setNumberOfCarsAvailable(Integer.parseInt(numberOfCarsAvailable));
        int status = CarCrud.reduceCarNumber(car, Integer.parseInt(number));
        if (status > 0)
        {
            out.println("<script> alert('Car reserved successfully !') </script>");
            response.sendRedirect("index.jsp");
        }
        else {
            request.setAttribute("errorMessage", "Error reserving car");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }   
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
