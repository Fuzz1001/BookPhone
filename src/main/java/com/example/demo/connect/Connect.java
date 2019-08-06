package com.example.demo.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/phonebook";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        Connection connection = null;
        try {
                Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            System.out.println("Error!");
            }
         return connection;



    }


}

