package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;

public class Query4 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            // Replace 1 with the desired publisherID
            String publisherID = "1";
            String booksQuery = "SELECT * FROM Titles WHERE publisherID = " + publisherID + " ORDER BY title";
            System.out.println("Books from the specific publisher:");

            ResultSet rs = stmt.executeQuery(booksQuery);

            while (rs.next()) {
                String title = rs.getString("title");
                System.out.println(title);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}

