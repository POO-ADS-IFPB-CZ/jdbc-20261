package org.example.view;

import javax.swing.*;

public class TelaLogin extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public TelaLogin() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        TelaLogin dialog = new TelaLogin();
        dialog.pack();
        dialog.setVisible(true);
    }
}
