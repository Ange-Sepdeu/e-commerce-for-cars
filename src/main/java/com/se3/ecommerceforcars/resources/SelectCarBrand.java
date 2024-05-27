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
import com.se3.ecommerceforcars.Brand;
import java.util.*;

/**
 *
 * @author PC
 */
@WebServlet(name = "SelectCarBrand", urlPatterns = {"/SelectCarBrand"})
public class SelectCarBrand extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try{
            List <Brand> allBrands = new ArrayList<>();
            allBrands = BrandCrud.getBrands();
            request.setAttribute("carBrands", allBrands);
            request.getRequestDispatcher("addcar.jsp").include(request, response);
        }catch (Exception e){
            out.print("Impossible to read :"+e.getMessage());
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
