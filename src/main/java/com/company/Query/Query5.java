package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;

public class Query5 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String newAuthorQuery = "INSERT INTO Authors (firstName, lastName) VALUES ('New', 'Author')";
            stmt.executeUpdate(newAuthorQuery);

            System.out.println("New author added");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
