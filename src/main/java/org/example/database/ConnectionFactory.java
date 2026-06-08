package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private Connection connection;

    public Connection getConnection() throws SQLException,
            ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url =
                "url";
        Properties props = new Properties();
        props.setProperty("user", "user");
        props.setProperty("password", "senha");
        return DriverManager.getConnection(url, props);
    }

}
