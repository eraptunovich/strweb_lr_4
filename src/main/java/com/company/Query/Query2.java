package com.company.Query;


import com.company.Connection.JDBC;

import java.sql.*;

public class Query2 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String newPublisherQuery = "INSERT INTO Publishers (publisherName) VALUES ('NewPublisher')";
            stmt.executeUpdate(newPublisherQuery);

            System.out.println("New publisher added");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}

