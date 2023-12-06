package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;

public class Query6 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String updateAuthorQuery = "UPDATE Authors SET firstName = 'UpdatedName' WHERE authorID = 1";
            stmt.executeUpdate(updateAuthorQuery);

            System.out.println("Author name updated");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}

