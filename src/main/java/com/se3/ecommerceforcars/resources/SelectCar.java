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
@WebServlet(name = "SelectCar", urlPatterns = {"/SelectCar"})
public class SelectCar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("carId");
        
        try{
            Car newCar = new Car();
            newCar = CarCrud.getSingleCar(id);
             request.setAttribute("activeCar", newCar);
//             request.setAttribute("brandName", );
            request.getRequestDispatcher("editcar.jsp").include(request, response);
        }catch (Exception e){
            System.out.println("Impossible to read :"+e.getMessage());
        }
    }

}
