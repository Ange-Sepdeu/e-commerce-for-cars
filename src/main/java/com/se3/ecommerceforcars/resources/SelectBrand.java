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
import com.se3.ecommerceforcars.DatabaseConnection;
import java.sql.*;
import com.se3.ecommerceforcars.Brand;

/**
 *
 * @author HP
 */
@WebServlet(name = "SelectBrand", urlPatterns = {"/SelectBrand"})
public class SelectBrand extends HttpServlet {

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
        
        String id = request.getParameter("brandId");
        
        try{
            Brand newBrand = new Brand();
            newBrand = BrandCrud.readBrand(id);
             request.setAttribute("activeBrand", newBrand);
            request.getRequestDispatcher("editbrand.jsp").forward(request, response);
        }catch (Exception e){
            System.out.println("Impossible to read :"+e.getMessage());
        }
    }
}
