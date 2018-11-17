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
    public ResultSet buscarRelatorioGrupos(int grupo)
    {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();
            if (grupo == 0)
            {
            String SQL = "";
            SQL = " select g.nome as grupo, po.nome, po.qntd_min,((SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao='E' and codprod=po.id)-(SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao = 'S' and codprod=po.id)) as qntd_atual from grupos g, produtos po where g.id=po.id_grupo and g.status=1 and po.status=1 ";
            
            try{
                //System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
            }
            
            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;
            }
            }
            else
            {
             String SQL = "";
            SQL = " select g.nome as grupo, po.nome, po.qntd_min,((SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao='E' and codprod=po.id)-(SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao = 'S' and codprod=po.id)) as qntd_atual from grupos g, produtos po where g.id=po.id_grupo and g.status=1 and po.status=1 ";
            SQL+= " AND po.id_grupo= '" + grupo + "'";
            
            try{
                //System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
            }
            
            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;  
            }
            }
        }
            catch (Exception e) 
            {
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
            SQL+= " from produtos po, grupos g where po.status=1 and po.id_grupo=g.id and po.status=1 order by po.nome";

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
            SQL = " select s.nome as secao,pt.nome as prateleira,po.nome,po.qntd_min from secoes s, prateleiras pt,produtos po ";
            SQL+= " where pt.id_secao=s.id and pt.id_produto=po.id and s.status=1 and po.status=1 and pt.status=1 ";
            SQL+=" order by s.nome, pt.nome ";

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
  public ResultSet buscarRelatorioGrupo()
    {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();
            
            String SQL = "";
            SQL = " select g.id,g.nome,g.info,COUNT(pr.id) from grupos g, produtos pr WHERE g.id=pr.id_grupo GROUP BY g.id ";

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
    public ResultSet buscarRelatorioProdutosFalta()
    {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();
            
            String SQL = "";
            SQL = " select po.id,po.nome, po.info, po.qntd_min, g.nome as grupo, ((SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao='E' and codprod=po.id)-(SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao = 'S' and codprod=po.id)) as qntd_atual ";
            SQL+= " from produtos po, grupos g where po.id_grupo=g.id AND g.status=1 AND po.status=1 GROUP BY g.nome,po.id ";
            SQL+= " HAVING ((SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao='E' and codprod=po.id)-(SELECT COALESCE(SUM(qntd),0) FROM movimentacoes WHERE operacao = 'S' and codprod=po.id)) < qntd_min ";

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
