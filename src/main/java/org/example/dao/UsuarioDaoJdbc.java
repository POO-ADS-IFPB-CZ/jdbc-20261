package org.example.dao;

import org.example.database.ConnectionFactory;
import org.example.model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDaoJdbc {

    public Usuario getUsuariobyEmail(String email) throws SQLException,
            IOException, ClassNotFoundException {
        Usuario usuario = null;
        try(Connection con = new ConnectionFactory().getConnection()){
            PreparedStatement stmt = con
                    .prepareStatement("SELECT * FROM usuario WHERE email=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String email1 = rs.getString("email");
                String senha = rs.getString("senha");
                return new Usuario(email1, senha);
            }
        }
        return usuario;
    }

    public boolean salvar(Usuario usuario) throws SQLException,
            IOException, ClassNotFoundException {
        try(Connection con = new ConnectionFactory().getConnection()){
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO usuario (email, senha) VALUES (?,?)"
            );
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            return stmt.executeUpdate()>0;
        }
    }

}
