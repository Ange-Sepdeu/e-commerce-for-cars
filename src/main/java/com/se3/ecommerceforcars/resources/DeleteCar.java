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
import jakarta.servlet.annotation.MultipartConfig;
import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author PC
 */
@WebServlet(name = "DeleteCar", urlPatterns = {"/DeleteCar"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class DeleteCar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
            String carId = request.getParameter("carId");
            int status = CarCrud.deleteCar(carId);
            String filePath = request.getParameter("image");
            File uploads = new File(request.getServletContext().getRealPath("")+ File.separator + filePath);
            Files.deleteIfExists(uploads.toPath());
            if (status > 0){
            request.setAttribute("successTitle", "Success");
            request.setAttribute("successMessage", "Car deleted successfully !");
            request.getRequestDispatcher("success.jsp").include(request, response);
        }else {
            request.setAttribute("errorMessage", "Unknown error");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        out.close();
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
