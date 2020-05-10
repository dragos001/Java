package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "dba";
    private static final String PASSWORD = "sql";
    private static Connection connection = null;
    private static DataBase instance;

    private DataBase() {
        createConnection();
    }

    public static DataBase getInstance(){
        if(instance == null){
            instance = new DataBase();
        }
        return instance;
    }

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


    public Connection getConnection() {
        return connection;
    }


    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}