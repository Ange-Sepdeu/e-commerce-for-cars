/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.se3.ecommerceforcars.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import jakarta.servlet.http.Part;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import com.se3.ecommerceforcars.Car;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author PC
 */
@WebServlet(name = "EditCar", urlPatterns = {"/EditCar"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class EditCar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String model = request.getParameter("model");
        float price = Float.parseFloat(request.getParameter("price"));
        int year = Integer.parseInt(request.getParameter("year"));
        String otherDetails = request.getParameter("otherDetails");
        String carId = request.getParameter("carId");
        Part part = request.getPart("image");
        InputStream fileContent = part.getInputStream();
        String fileName = extractFileName(part);
        File uploads = new File(request.getServletContext().getRealPath("")+ File.separator + getServletContext().getInitParameter("upload.location"));
        String filePath = "uploads" + File.separator + fileName;
        File file = new File(uploads, fileName);
        try (InputStream input = fileContent) {
            Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        Car newCar = new Car();
        newCar.setCarId(carId);
        newCar.setModel(model);
        newCar.setYear(year);
        newCar.setOtherDetails(otherDetails);
        newCar.setImage(filePath);
        newCar.setPrice(price);
        int status = CarCrud.updateCar(newCar);
        if (status > 0){
            request.setAttribute("successTitle", "Success");
            request.setAttribute("successMessage", "Car updated successfully !");
            request.getRequestDispatcher("success.jsp").include(request, response);
        }else {
            request.setAttribute("errorMessage", "Unknown error, Can't update");
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        out.close();
    }
    private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
        if (s.trim().startsWith("filename")) {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
        }
    }
    return "";
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
