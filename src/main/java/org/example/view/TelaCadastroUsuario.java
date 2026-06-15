package org.example.view;

import org.example.dao.UsuarioDaoJdbc;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.Arrays;

public class TelaCadastroUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private UsuarioDaoJdbc usuarioDao;

    public TelaCadastroUsuario() {
        usuarioDao = new UsuarioDaoJdbc();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener(e->{
            dispose();
        });
        buttonOK.addActionListener(e ->{
            if(validarFormulario()){
                Usuario usuario = new Usuario(
                        textField1.getText(),
                        new String(passwordField1.getPassword())
                );
                try{
                    if(usuarioDao.salvar(usuario)){
                        JOptionPane.showMessageDialog(null,
                                "Salvo com sucesso");
                        dispose();
                    }
                } catch (SQLException ex) {
                    exibirMensagemErro("Usuário já cadastrado");
                } catch (IOException | ClassNotFoundException ex) {
                    exibirMensagemErro("Falha na conexão com o banco");
                }
            }
        });
    }

    private boolean validarFormulario(){
        if(textField1.getText().equals("") ||
                passwordField1.getPassword().length==0 ||
                passwordField2.getPassword().length==0
        ){
            exibirMensagemErro("Preencha todos os campos");
            return false;
        }
        if(!textField1.getText().contains("@")){
            exibirMensagemErro("Informe um e-mail válido");
            return false;
        }
        if(!Arrays.equals(passwordField1.getPassword(),
                passwordField2.getPassword())){
            exibirMensagemErro("As senhas não conferem");
            return false;
        }
        return true;
    }

    private void exibirMensagemErro(String mensagem){
        JOptionPane.showMessageDialog(null,
                mensagem,
                "Mensagem de erro",
                JOptionPane.ERROR_MESSAGE);
    }

}
