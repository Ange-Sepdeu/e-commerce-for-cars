/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.se3.ecommerceforcars.resources;
import com.se3.ecommerceforcars.*;
import com.se3.ecommerceforcars.DatabaseConnection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author PC
 */
public class CarCrud {
    public static int saveCar(Car car) {
        int saveStatus=0;
        try {
            String sql = "SELECT * FROM Cars WHERE model=? AND brandId IN (SELECT brandId FROM brand WHERE brandId=?)";
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement(sql);
            ps.setString(1, car.getModel());
            ps.setString(2, car.getBrandId());
            ResultSet Rs = ps.executeQuery();
            if (Rs.next()){
                return saveStatus;
            }
            String insertQuery = "INSERT INTO Cars VALUES(?,?,?,?,?,?,?,?)";
            ps = DatabaseConnection.connect().prepareStatement(insertQuery);
            ps.setString(1, car.getCarId());
            ps.setString(2, car.getModel());
            ps.setFloat(3, car.getPrice());
            ps.setInt(4, car.getNumberOfCarsAvailable());
            ps.setInt(5, car.getYear());
            ps.setString(6, car.getOtherDetails());
            ps.setString(7, car.getBrandId());
            ps.setString(8, car.getImage());
            ps.executeUpdate();
            saveStatus=1;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return saveStatus;
    }
    
    public static int updateCar(Car car) {
        int updateStatus = 0;
        try {
            String updateSql = "UPDATE Cars SET model=?, price=?, year=?, otherDetails=?, image=? WHERE carId=?";
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement(updateSql);
            ps.setString(1, car.getModel());
            ps.setFloat(2, car.getPrice());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getOtherDetails());
            ps.setString(5, car.getImage());
            ps.setString(6, car.getCarId());
            ps.executeUpdate();
            updateStatus = 1;
        }
        catch(Exception e) {
            updateStatus=0;
            System.out.println(e.getMessage());
        }
        return updateStatus;
    }
    
    public static List<Car> getCars() {
        List<Car> allCars = new ArrayList<Car>();
        try {
        String sql = "SELECT * FROM Cars";
        PreparedStatement ps = DatabaseConnection.connect().prepareStatement(sql);
        ResultSet Rs = ps.executeQuery();
        while(Rs.next()) {
            Car newCar = new Car();
            newCar.setCarId(Rs.getString("carId"));
            newCar.setModel(Rs.getString("model"));
            newCar.setNumberOfCarsAvailable(Rs.getInt("numberOfCarsAvailable"));
            newCar.setOtherDetails(Rs.getString("otherDetails"));
            newCar.setPrice(Rs.getFloat("price"));
            newCar.setYear(Rs.getInt("year"));
            newCar.setImage(Rs.getString("image"));
            newCar.setBrandId(Rs.getString("brandId"));
            allCars.add(newCar);
        }    
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return allCars;
    }
    public static int deleteCar(String id) {
        int deleteStatus=0;
        try {
            String sql = "DELETE FROM Cars WHERE carId=?";
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            deleteStatus=1;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return deleteStatus;
    }
    public static Car getSingleCar(String id) {
        Car singleCar = new Car();
        try {
            String sql = "SELECT C.* FROM Cars C JOIN brand B ON B.brandId=C.brandId WHERE carId=?";
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet Rs = ps.executeQuery();
            if(Rs.next()){
            singleCar.setBrandId(Rs.getString("brandId"));
            singleCar.setCarId(Rs.getString("carId"));
            singleCar.setModel(Rs.getString("model"));
            singleCar.setOtherDetails(Rs.getString("otherDetails"));
            singleCar.setPrice(Rs.getFloat("price"));
            singleCar.setYear(Rs.getInt("year"));
            singleCar.setNumberOfCarsAvailable(Rs.getInt("numberOfCarsAvailable"));
            }
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return singleCar;
    }
    
    public static int increaseCarNumber(Car car) {
        int status=0;
        String sql = "UPDATE Cars SET numberOfCarsAvailable=? WHERE carId=?";
        int originalNumber = car.getNumberOfCarsAvailable();
        try {
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement(sql);
            ps.setInt(1, ++originalNumber);
            ps.setString(2, car.getCarId());
            status = ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        } 
        return status;
    }
    public static int reduceCarNumber(Car car, int number) {
        int status = 0;
        if (car.getNumberOfCarsAvailable() < number)
            return status;
        int actualNumber = car.getNumberOfCarsAvailable() - number;
        String sql = "UPDATE Cars SET numberOfCarsAvailable=? WHERE carId=?";
        try {
            PreparedStatement ps = DatabaseConnection.connect().prepareStatement(sql);
            ps.setInt(1, actualNumber);
            ps.setString(2, car.getCarId());
            status = ps.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        } 
        return status;
    }
}
