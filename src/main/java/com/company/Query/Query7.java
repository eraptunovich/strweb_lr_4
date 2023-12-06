package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;

public class Query7 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();

            // Add a new publisher
            String newPublisherQuery = "INSERT INTO Publishers (publisherName) VALUES ('NewPublisher')";
            stmt.executeUpdate(newPublisherQuery);

            // Retrieve the newly added publisher's ID
            ResultSet rsPublisher = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            rsPublisher.next();
            int newPublisherID = rsPublisher.getInt(1);

            // Add a new title with the new publisher
            String newTitleQuery = "INSERT INTO Titles (title, publisherID) VALUES ('NewTitle', " + newPublisherID + ")";
            stmt.executeUpdate(newTitleQuery);

            // Retrieve the newly added title's ISBN
            ResultSet rsTitle = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            rsTitle.next();
            String newISBN = rsTitle.getString(1);

            // Add authorISBN with the new author and title
            String newAuthorISBNQuery = "INSERT INTO authorISBN (authorID, isbn) VALUES (1, '" + newISBN + "')";
            stmt.executeUpdate(newAuthorISBNQuery);

            System.out.println("New publisher, title, and authorISBN added");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
