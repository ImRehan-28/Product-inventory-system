package com.productinventory.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
        "jdbc:oracle:thin:@localhost:1521/orclpdb";

    private static final String USERNAME = "rehannew";
    private static final String PASSWORD = "rehan12345";

    private DBConnection() {
        // prevent object creation
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
