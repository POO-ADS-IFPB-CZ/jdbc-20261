package org.example;

import org.example.dao.UsuarioDaoJdbc;

import javax.swing.*;

public class Main {
    static void main() {

        UsuarioDaoJdbc dao = new UsuarioDaoJdbc();

        try{
            System.out.println(dao.getUsuariobyEmail("joao@gmail.com"));
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o banco");
        }

    }
}
