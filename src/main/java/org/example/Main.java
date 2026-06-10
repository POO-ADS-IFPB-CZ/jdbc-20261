package org.example;

import org.example.dao.UsuarioDaoJdbc;
import org.example.model.Usuario;

import javax.swing.*;

public class Main {
    static void main() {

        UsuarioDaoJdbc dao = new UsuarioDaoJdbc();

        try{
            if(dao.salvar(new Usuario("pedro@gmail.com","Pedro"))){
                JOptionPane.showMessageDialog(null,
                        "Salvo com sucesso");
            }else{
                JOptionPane.showMessageDialog(null,
                        "Falha ao salvar");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o banco");
        }

    }
}
