package org.example.view;

import javax.swing.*;
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
        getRootPane().setDefaultButton(buttonOK);
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
