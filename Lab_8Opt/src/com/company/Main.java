package com.company;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {

        DatabaseController database = new DatabaseController();

        ChartController chartController = new ChartController();
        AlbumController albumController = new AlbumController();
        ArtistController artistController = new ArtistController();

        database.createTables();
        chartController.createTable();


        try {
           artistController.create("Artist1", "Dody");
            artistController.create("Artist2", "Ina");


            System.out.println("\n==========Artists==========");
            System.out.println("-------------------------");
            artistController.print();

           albumController.create("Album1", artistController.findArtistIdByName("Artist1"), 2015);
            albumController.create("Album2", artistController.findArtistIdByName("Artist2"), 2020);

            //generez si adaug 10 albume cu cate 1 artist








            //afisez ranking-ul
            System.out.println("\n=========Chart==========");
            System.out.println("-------------------------");
            chartController.print();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        database.closeConnection();

    }
}