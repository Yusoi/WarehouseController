package com.example.yusoi.warehousecontroller.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    private Connection connection;

    public boolean connect(String url,String user, String password){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);

            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Example");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

        }catch(Exception e){
            return false;
        }

        return true;
    }

    public boolean close() {
        try {
            connection.close();
            return true;
        }catch(Exception e){
            return false;
        }

    }
}
