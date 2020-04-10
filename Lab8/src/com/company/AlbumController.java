package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {

    public void create(String name, int artistId, int releaseYear) {
        Connection connection = Database.getConnection();
        String query = "INSERT INTO artists(name, artist_id, release_year) VALUES('" + name + "'," + artistId + "," + releaseYear + ")";
    }

    public int findByArtist(int artistId) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select id from albums where name like '" + artistId + "'")) {
            return resultSet.getInt(1);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }
}
