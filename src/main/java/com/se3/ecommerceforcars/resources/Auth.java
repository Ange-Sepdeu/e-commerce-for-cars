/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se3.ecommerceforcars.resources;
import com.se3.ecommerceforcars.Admin;
import com.se3.ecommerceforcars.DatabaseConnection;
import java.sql.*;
import java.security.MessageDigest;
import java.util.*;
/**
 *
 * @author PC
 */
public class Auth {
    public static int login(Admin admin) {
        int loginStatus = 0;
        try {
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement("SELECT * FROM admin WHERE email=? AND password=?");
            ps.setString(1, admin.getEmail());
            ps.setString(2, admin.getPassword());
            ResultSet Rs = ps.executeQuery();
            if (Rs.next())
            {
                loginStatus=1;
                return loginStatus;
            }
                return loginStatus;
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return loginStatus;
    }
    public static int register(Admin admin) {
        int registerStatus = 0;
        try {
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement("SELECT * FROM Admin WHERE email=?");
            ps.setString(1, admin.getEmail());
            String adminPassword = admin.getPassword();
            ResultSet Rs = ps.executeQuery();
            if (Rs.next()) 
                return registerStatus;
            // IMPLEMENT HASHING
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(adminPassword.getBytes());
            byte [] bytes = md.digest();
             StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            /* Complete hashed password in hexadecimal format */  
            String encryptedPassword = s.toString();  
            String registerSql = "INSERT INTO Admin VALUES(?,?,?,?,?)";
            ps = DatabaseConnection.connect().prepareStatement(registerSql);
            String adminId = UUID.randomUUID().toString();
            ps.setString(1, adminId);
            ps.setString(2, admin.getName());
            ps.setString(3, admin.getEmail());
            ps.setString(4, encryptedPassword);
            ps.setInt(5, admin.getTel());
            ps.executeQuery();
            registerStatus=1;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return registerStatus;
    }
}
