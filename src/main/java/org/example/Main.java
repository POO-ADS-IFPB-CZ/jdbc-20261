package org.example;

import org.example.database.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    static void main() {

        try {
            Connection connection = new ConnectionFactory()
                    .getConnection();
            if(connection!=null){
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
