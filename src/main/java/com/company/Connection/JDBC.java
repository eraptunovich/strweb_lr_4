package com.company.Connection;

import java.util.*;
import java.sql.*;

public class JDBC {

    public static Connection connection = null;

    public static void connect() throws SQLException{
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("MySQL JDBC Driver registered");
//        } catch(ClassNotFoundException e){
//            System.out.println(" where is your MySQL JDBC Driver?");
//            e.printStackTrace();
//        throw new SQLException();
//        }

        connection = DriverManager
                .getConnection("jdbc:mysql://localhost/strweb_lr4", "root", "8140723");
        if(connection==null){
            throw new SQLException();
        } else {
            System.out.println("Successfully connected!");
        }
    }
    public static void close() {
        try {
            if(connection != null) {
                connection.close();
                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }

}


