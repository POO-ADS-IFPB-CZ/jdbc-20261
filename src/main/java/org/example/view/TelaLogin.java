package org.example.view;

import org.example.dao.UsuarioDaoJdbc;
import org.example.model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class TelaLogin extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;
    private UsuarioDaoJdbc usuarioDao;

    public TelaLogin() {
        usuarioDao = new UsuarioDaoJdbc();
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener((e)->{
            TelaCadastroUsuario cadastro = new TelaCadastroUsuario();
            cadastro.pack();
            cadastro.setVisible(true);
        });
        buttonOK.addActionListener(e->{
            Usuario usuario = null;
            try{
                usuario = usuarioDao.getUsuariobyEmail(
                        textField1.getText());
            } catch (Exception ex) {
                exibirMensagemErro("Falha na conexão com o banco");
            }
            if(usuario == null){
                exibirMensagemErro("Usuário não encontrado");
            }
            if(usuario != null){
                String senhaDigitada = new String(
                        passwordField1.getPassword());
                if(!senhaDigitada.equals(usuario.getSenha())){
                    exibirMensagemErro("Senha incorreta");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Bem vindo");
                }
            }
        });
    }

    public static void main(String[] args) {
        TelaLogin dialog = new TelaLogin();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        label1 = new JLabel();
        ImageIcon icon = new ImageIcon(
                "img/login.png");
        label1.setIcon(icon);
    }

    private void exibirMensagemErro(String mensagem){
        JOptionPane.showMessageDialog(null,
                mensagem,
                "Mensagem de erro",
                JOptionPane.ERROR_MESSAGE);
    }

}
