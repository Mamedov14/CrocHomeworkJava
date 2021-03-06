package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    public static Connection getMyConnection() throws SQLException {

        String hostName = "localhost";
        String dbName = "test";
        String userName = "root";
        String password = "root";

        return getMySQLConnection(hostName, dbName, userName, password);
    }


    private static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException {

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
        return connection;
    }
}