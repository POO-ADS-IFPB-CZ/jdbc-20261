package org.example;

import org.example.dao.UsuarioDaoJdbc;
import org.example.model.Usuario;

import javax.swing.*;

public class Main {
    static void main() {

        UsuarioDaoJdbc dao = new UsuarioDaoJdbc();

        try{
            if(dao.atualizar(new Usuario("joao@gmail.com","654321"))){
                JOptionPane.showMessageDialog(null,
                        "Atualizado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,
                        "Falha ao atualizar");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o banco");
        }

    }
}
