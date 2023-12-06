package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;

public class Query1 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String query = "SELECT * FROM Authors ORDER BY firstName, lastName";
            System.out.println("Authors sorted by Name and Last Name:");

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("authorID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}

