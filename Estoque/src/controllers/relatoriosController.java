/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import estoque.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nmpetry
 */
public class relatoriosController {
    public ResultSet buscarRelatorioGrupos()
    {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();
            
            String SQL = "";
            SQL = " select g.nome as grupo, po.nome, po.qntd_min from grupos g, produtos po where g.status=1 and g.id in (select pt.id_grupo from produtos pt where pt.status=1) ";

            try{
                //System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return rs;
        }
        
        //System.out.println ("Executou buscar visitante com sucesso");
        return rs;
    } 
           
    public ResultSet buscarRelatorioProdutos()
    {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();
            
            String SQL = "";
            SQL = " SELECT po.nome, po.info, po.qntd_min, g.nome as grupo, ";
            SQL+= " to_char(data_add,'DD/MM/YYYY') as data ";
            SQL+= " from produtos po, grupos g where po.status=1 and po.id_grupo=g.id ";

            try{
                //System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return rs;
        }
        
        //System.out.println ("Executou buscar visitante com sucesso");
        return rs;
    }
    
 public ResultSet buscarRelatorioPrateleiras()
    {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();
            
            String SQL = "";
            SQL = " select pt.nome as prateleira, po.nome, po.qntd_min from produtos po, prateleiras pt where pt.status=1 and pt.id_produto=po.id ";

            try{
                //System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return rs;
        }
        
        //System.out.println ("Executou buscar visitante com sucesso");
        return rs;
    } 
}