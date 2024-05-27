/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se3.ecommerceforcars.resources;

import com.se3.ecommerceforcars.DatabaseConnection;
import com.se3.ecommerceforcars.Brand;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
/**
 *
 * @author HP
 */
public class BrandCrud {
    
    public static int createBrand(Brand b){
        int status=0;
        try{
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement("SELECT * FROM brand WHERE brandName='"+b.getBrandName()+"' ");
           ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("already exist");
            }
            else{
                PreparedStatement p = DatabaseConnection.connect().prepareStatement("INSERT INTO brand VALUES(?, ?, ?)");
                p.setString(1, b.getBrandId());
                p.setString(2, b.getBrandName());
                p.setString(3, b.getDescription());
                p.executeUpdate();
                status=1;
            }
        }catch (Exception e){
            System.out.println("Impossible to create :"+e.getMessage());
        }
        return status;
        
    }
    
    public static int updateBrand(Brand b){
        int status=0;
        try{
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement("UPDATE brand set brandName=?, description=? where brandId=?");
            ps.setString(1, b.getBrandName());
            ps.setString(2, b.getDescription());
            ps.setString(3, b.getBrandId());
            ps.executeUpdate();
            status=1;
        }catch (Exception e){
            System.out.println("Impossible to update :"+e.getMessage());
        }
        return status;
    }
    
    public static int deleteBrand(String id){
        int status=0;
        try{
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement("delete from brand where brandId=?");
            PreparedStatement p = DatabaseConnection.connect().prepareStatement("delete from cars where brandId=?");
            p.setString(1, id);
            p.executeUpdate();
            ps.setString(1, id);
            ps.executeUpdate();
            status=1;
        }catch (Exception e){
            System.out.println("Error in deleting :"+e.getMessage());
        }
        return status;
    }
    
    public static Brand readBrand(String id){
                    Brand b = new Brand();
        try{
            PreparedStatement p = DatabaseConnection.connect().prepareStatement("SELECT * FROM brand where brandId=?");
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            if(r.next())
            {
            b.setBrandName(r.getString("brandName"));
            b.setDescription(r.getString("description"));
            b.setBrandId(id);
            }
        }catch (Exception e){
            System.out.println("Impossible to read :"+e.getMessage());
        }
        return b;
    }
    
    public static List<Brand> getBrands(){
         List<Brand> allBrands = new ArrayList<Brand>();
        try{
            PreparedStatement p = DatabaseConnection.connect().prepareStatement("SELECT * FROM brand");
            ResultSet r = p.executeQuery();
            while(r.next()){
                Brand brand = new Brand();
                brand.setBrandId(r.getString("brandId"));
                brand.setBrandName(r.getString("brandName"));
                brand.setDescription(r.getString("description"));
                allBrands.add(brand);
            }
        }catch (Exception e){
            System.out.println("Impossible to read :"+e.getMessage());
        }
        return allBrands;
    }
    
}
