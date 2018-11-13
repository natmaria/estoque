/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import estoque.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Movimentacao;
import tools.formatacao;

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
            String SQL = "";
            SQL = " SELECT ( ";
            SQL += " (SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao='E' AND codprod = '" + idp + "')- ";
            SQL += " (SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao = 'S' AND codprod = '" + idp + "')) ";

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
 
     public boolean incluir(Movimentacao objMovimentacao)
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO movimentacoes(dthora,codprod,operacao,qntd,vlunit) VALUES (?,?,?,?,?)");
            stmt.setDate(1, Date.valueOf(objMovimentacao.getDtmov()));
            stmt.setInt(2,objMovimentacao.getCodprod());
            stmt.setString(3,String.valueOf(objMovimentacao.getOperacao()));
            stmt.setInt(4,objMovimentacao.getQntd());
            stmt.setDouble(5,objMovimentacao.getVlunit());
            
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
