package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TelaLogin extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JLabel label1;

    public TelaLogin() {
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);
        buttonCancel.addActionListener((e)->{
            TelaCadastroUsuario cadastro = new TelaCadastroUsuario();
            cadastro.pack();
            cadastro.setVisible(true);
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
}
