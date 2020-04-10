package com.company;

import java.sql.*;

public class ArtistController {

    public void create(String name, String country) {
        Connection connection = Database.getConnection();
        String query = "INSERT INTO artists(name,country) VALUES('" + name + "'," + country + ")";


    }

    public int findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select id from artists where name like '" + name + "'")) {
            return resultSet.getInt(1);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }
}
