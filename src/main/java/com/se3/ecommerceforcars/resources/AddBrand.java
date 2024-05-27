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
import com.se3.ecommerceforcars.Brand;
import java.util.*;
import java.sql.*;

/**
 *
 * @author HP
 */
@WebServlet(name = "AddBrand", urlPatterns = {"/AddBrand"})
public class AddBrand extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = UUID.randomUUID().toString();
        String name = request.getParameter("brandName");
        String desc = request.getParameter("description");
        Brand newBrand = new Brand();
        newBrand.setBrandId(id);
        newBrand.setBrandName(name);
        newBrand.setDescription(desc);
        int status = BrandCrud.createBrand(newBrand);
        if (status > 0){
            request.setAttribute("successTitle", "Success");
            request.setAttribute("successMessage", "Brand added successfully !");
            request.getRequestDispatcher("success.jsp").include(request, response);
        }else {
            request.setAttribute("errorMessage", "Brand already exists !");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
    }

}    
