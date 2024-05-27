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
@WebServlet(name = "AddCarNumber", urlPatterns = {"/AddCarNumber"})
public class AddCarNumber extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");
            String id = request.getParameter("carId");
            String numberOfCarsAvailable = request.getParameter("numberOfCarsAvailable");
            try {
                Car newCar = new Car();
                newCar.setCarId(id);
                newCar.setNumberOfCarsAvailable(Integer.parseInt(numberOfCarsAvailable));
                int status = CarCrud.increaseCarNumber(newCar);
                if (status > 0) {
                    response.sendRedirect("admin.html");
                }
                else {
                    response.sendRedirect("admin.html");
                }
            }
            catch(Exception e) {
                out.print("Error: "+e.getMessage());
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
