/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import estoque.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Movimentacao;

/**
 *
 * @author nmpetry
 */
public class movController {
static Movimentacao objMovimentacao;

//public movController (Movimentacao objMovimentacao)
//{
//    this.objMovimentacao=objMovimentacao;
//}
 public int buscarQuantidadeAtual(int idp)
 {
     int qntd=0;
     try 
        {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;
            int id = idp;
            String SQL = "";
            SQL = " SELECT (SELECT SUM(qntd) FROM movimentacoes WHERE operacao='E' AND codprod = '" +id +"'-";
            SQL += " (SELECT SUM(qntd) FROM movimentacoes WHERE operacao = 'S' AND codprod = codprod = '" +id +"')) ";

            //stm.executeQuery(SQL);  
        
            try {
//                System.out.println("Vai Executar Conexão em buscar grupo");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
//                System.out.println("Executou Conexão em buscar grupo");

                if (rs.next() == true) {
                    qntd = rs.getInt(1);
                }
            }
            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return 0;
            }
        }
         catch (Exception e) 
        {
            System.out.println("ERRO: " + e.getMessage().toString());
            return 0;
        }
     return qntd;
 }
 
     public boolean incluir()
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO movimentacoes (dthora, codprod, qntd, vlunit, id_produto, status)VALUES(?,?,?,?,?,?)");
//            stmt.setInt(1,objGrupo.getId());
//            stmt.setString(1, objPrateleira.getNome());
//            stmt.setDouble(2, objPrateleira.getAltura());
//            stmt.setDouble(3, objPrateleira.getLargura());
//            stmt.setInt(4, objPrateleira.getSecao());
//            stmt.setInt(5, objPrateleira.getProduto());
//            stmt.setInt(6, objPrateleira.getStatus());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
            return false;
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
