package com.company.TestOfTables;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class GetAllRows {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            // Retrieve data from Authors table
            retrieveDataFromTable(stmt, "Authors");

            // Retrieve data from Titles table
            retrieveDataFromTable(stmt, "Titles");

            // Retrieve data from Publishers table
            retrieveDataFromTable(stmt, "Publishers");

            // Retrieve data from authorISBN table
            retrieveDataFromTable(stmt, "authorISBN");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }
    }

    private static void retrieveDataFromTable(Statement stmt, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;
        System.out.println(tableName + ":");

        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            for (int i = 1; i <= columnsNumber; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}

