package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseController {

    public void closeConnection()
    {
        Connection con = DataBase.getInstance().getConnection();
        if(con!=null)
        {
            try {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
