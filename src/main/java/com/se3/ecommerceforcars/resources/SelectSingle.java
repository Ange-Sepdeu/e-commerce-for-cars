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
@WebServlet(name = "SelectSingle", urlPatterns = {"/SelectSingle"})
public class SelectSingle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("carId");
        
        try{
            Car newCar = new Car();
            newCar = CarCrud.getSingleCar(id);
             request.setAttribute("car", newCar);
            request.getRequestDispatcher("cardetail.jsp").include(request, response);
        }catch (Exception e){
            System.out.println("Impossible to read :"+e.getMessage());
        }
    }
}
