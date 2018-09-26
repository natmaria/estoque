/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Usuario;
import estoque.ConnectionFactory;

/**
 *
 * @author nmpetry
 */
public class loginController {
    String usuario;
    String senha;
    public Usuario login(String usuario, String senha) 
    {
        this.usuario = usuario;
        this.senha = senha;
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
//       System.out.println("Vai abrir a conexão com o banco de dados");
        ConnectionFactory.abreConexao();
        Usuario user = null;
        
        ResultSet rs = null;

        StringBuilder comandoSQL = new StringBuilder();
        comandoSQL.append(" SELECT id,login,nome,senha ");
        comandoSQL.append(" FROM usuarios ");
        comandoSQL.append(" WHERE login ='" + usuario +"'" );
        comandoSQL.append(" AND senha ='" + senha + "'" );
        try 
        {
//            System.out.println("Vai Executar Conexão em buscar area");
            rs = ConnectionFactory.stmt.executeQuery(comandoSQL.toString());
//           System.out.println("Executou Conexão em buscar area");
            
            if (rs.next() == true) {
                user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            return user;
        }
        finally
        {
            Connection con = ConnectionFactory.getConnection();
//           System.out.println("Vai fechar a conexão com o banco de dados");
            ConnectionFactory.closeConnection(con);
        }
        
        return user;
        }
}
