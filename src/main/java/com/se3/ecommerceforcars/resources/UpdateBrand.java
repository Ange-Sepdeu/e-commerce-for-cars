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

/**
 *
 * @author HP
 */
@WebServlet(name = "UpdateBrand", urlPatterns = {"/UpdateBrand"})
public class UpdateBrand extends HttpServlet {

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
        
        String id = request.getParameter("brandId");
        String name = request.getParameter("brandName");
        String desc = request.getParameter("description");
 
        try{
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement("UPDATE brand set brandName=?, description=? where brandId=?");
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setString(3, id);
            ps.executeUpdate();
            request.setAttribute("successTitle", "Success");
            request.setAttribute("successMessage", "Brand updated successfully !");
            request.getRequestDispatcher("success.jsp").include(request, response);
        }catch (Exception e){
            System.out.println("Impossible to update :"+e.getMessage());
        }
    }

}
