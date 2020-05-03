package com.company.lab8.compulsory;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        DatabaseController database = new DatabaseController();

        ChartController chartController = new ChartController();
        AlbumController albumController = new AlbumController();
        ArtistController artistController = new ArtistController();

        database.createTables();
        chartController.createTable();


        try {
        
            System.out.println("\n=========Chart==========");
            System.out.println("-------------------------");
            chartController.print();
            chartController.report();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        database.closeConnection();

    }
}