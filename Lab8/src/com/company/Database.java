package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/MusicAlbums";
    private static final String USER = "dba";
    private static final String PASS = "sql";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null)
            createConnection();
        return connection;

    }

    public static Connection createConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;

    }

    public static void closeConnection()
    {

    }


}
