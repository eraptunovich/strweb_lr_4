package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;

public class Query3 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            String updatePublisherQuery = "UPDATE Publishers SET publisherName = 'UpdatedPublisher' WHERE publisherID = 1";
            stmt.executeUpdate(updatePublisherQuery);

            System.out.println("Publisher name updated");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
