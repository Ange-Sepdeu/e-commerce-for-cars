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
@WebServlet(name = "DeleteBrand", urlPatterns = {"/DeleteBrand"})
public class DeleteBrand extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("brandId");
        
        try{
            int status = BrandCrud.deleteBrand(id);
            if (status > 0){
            request.setAttribute("successTitle", "Success");
            request.setAttribute("successMessage", "Brand deleted successfully !");
            request.getRequestDispatcher("success.jsp").include(request, response);
        }else {
            request.setAttribute("errorMessage", "Unknown error");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        }catch (Exception e){
            System.out.println("Error in deleting :"+e.getMessage());
        }
    }

}
