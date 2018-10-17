/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import estoque.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Secao;

/**
 *
 * @author nmp
 */
public class secaoController {
    static Secao objSecao;
    JTable jtbSecoes = null;
    
    public secaoController (Secao objSecao, JTable jtbSecoes) 
      {
        this.objSecao = objSecao;
        this.jtbSecoes = jtbSecoes;
      }
    
     public secaoController (Secao objSecao) 
      {
       this.objSecao=objSecao;
      }
     
      public secaoController () 
      {
       
      }
      
      public void preencherTabela(int type,int busca, String nome) 
      {
          // type para saber se é select com inativos ou não
          //busca é para saber se é select com busca por nome ou não
        ConnectionFactory.abreConexao();
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("Tamanho");
        cabecalhos.add("Status");
        
        ResultSet result = null;
        if (type==2)
        {
            if (busca==0)
            {
                try 
                {
                    String SQL = "";
                    SQL = " SELECT se.id,se.nome,se.tamanho,s.nome  ";
                    SQL += " FROM secoes se, status s ";
                    SQL += " WHERE se.status=s.id ";
                    SQL += " AND se.status=1 ";
                    SQL += " ORDER BY se.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } catch (SQLException e) {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                }
            }
            else
            {
                try
                {
                    String SQL = "";
                    SQL = " SELECT se.id,se.nome,se.tamanho,s.nome  ";
                    SQL += " FROM secoes se, status s ";
                    SQL += " WHERE se.status=s.id ";
                    SQL += " AND se.status=1 ";
                    SQL += " AND LOWER(se.nome) LIKE '%" + nome.toLowerCase() + "%'";
                    SQL += " ORDER BY se.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } catch (SQLException e) {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                } 
            }
        }
        else
        {
            if (type == 1) 
            {
                if (busca==0)
                {
                try {
                    String SQL = "";
                    SQL = " SELECT se.id,se.nome,se.tamanho,s.nome  ";
                    SQL += " FROM secoes se, status s ";
                    SQL += " WHERE se.status=s.id ";
                    SQL += " ORDER BY se.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } catch (SQLException e) {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                }
                }
                else
                {
                    try 
                    {
                        String SQL = "";
                        SQL = " SELECT se.id,se.nome,se.tamanho,s.nome  ";
                        SQL += " FROM secoes se, status s ";
                        SQL += " WHERE se.status=s.id ";
                        SQL += " AND LOWER(se.nome) LIKE '%" + nome.toLowerCase() + "%'";
                        SQL += " ORDER BY se.nome ";
                        result = ConnectionFactory.stmt.executeQuery(SQL);
                    } catch (SQLException e) {
                        System.out.println("Problema ao popular tabela");
                        System.out.println(e);
                    }
                }
            }
        }
        try
        {
            while (result.next())
            {
              Vector<Object> linha = new Vector<Object>();
              linha.add(result.getInt(1));
              linha.add(result.getString(2));
              linha.add(result.getString(3));
              linha.add(result.getString(4));
              dadosTabela.add(linha);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Problema ao popular tabela");
            System.out.println(e);
        }
        
        jtbSecoes.setModel
        (
         new DefaultTableModel(dadosTabela,cabecalhos) 
         {
            @Override
            public boolean isCellEditable(int row, int column) 
            {
                return false;
            }
         }
        );
        
        jtbSecoes.setSelectionMode(0);
        
        TableColumn column = null;
        for (int i=0; i<4; i++) 
        {
            column = jtbSecoes.getColumnModel().getColumn(i);
            switch (i)
            {
                case 0:
                    column.setPreferredWidth(10);
                    break;
                case 1:
                    column.setPreferredWidth(150);
                    break;
                case 2:
                    column.setPreferredWidth(50);
                    break;
                case 3:
                    column.setPreferredWidth(50);
                    break;
            }
        }
        
        jtbSecoes.setDefaultRenderer
        (
          Object.class, new DefaultTableCellRenderer()
         {
            public Component getTableCellReComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column)
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0)
                {
                    setBackground(Color.LIGHT_GRAY);
                } else 
                {
                    setBackground(Color.WHITE);
                }
                return this;
            }
          }
        );
    }
      
    public  static Secao buscar(int id)
    {
        try 
        {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id,nome,tamanho,status ";
            SQL += " FROM secoes ";
            SQL += " WHERE id = '" + id + "'";
            //stm.executeQuery(SQL);  
        
            try 
            {
//                System.out.println("Vai Executar Conexão em buscar grupo");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
//                System.out.println("Executou Conexão em bu

                objSecao = new Secao();

                if (rs.next() == true) {
                    objSecao.setId(rs.getInt(1));
                    objSecao.setNome(rs.getString(2));
                    objSecao.setTamanho(rs.getDouble(3));
                    objSecao.setStatus(rs.getInt(4));
                }
            }
            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return null;
            }
        }
         catch (Exception e) 
        {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }
//    System.out.println ("Executou buscar aluno com sucesso");
    return objSecao;
    }
    
    public boolean incluir()
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO secoes (nome, tamanho, status)VALUES(?,?,?)");
//            stmt.setInt(1,objGrupo.getId());
            stmt.setString(1, objSecao.getNome());
            stmt.setDouble(2, objSecao.getTamanho());
            stmt.setInt(3, objSecao.getStatus());
            
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
    
    public boolean alterar()
    {
 
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE secoes SET nome=?, tamanho=?, status=? WHERE id=?");
            stmt.setString(1, objSecao.getNome());
            stmt.setDouble(2, objSecao.getTamanho());
            stmt.setInt(3, objSecao.getStatus());
            stmt.setInt(4, objSecao.getId());

            stmt.executeUpdate();

            return true;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
            return false;
        } 
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean inativar()
    {
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE secoes SET status=2,dt_inativado=? WHERE id=?");
            stmt.setDate(1,Date.valueOf(objSecao.getDt_inativado()));
            stmt.setInt(2, objSecao.getId());

            stmt.executeUpdate();

            return true;

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
            return false;
        }
        finally 
        {
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public boolean excluir()
    {
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
        try 
        {
            stmt = con.prepareStatement("DELETE FROM secoes WHERE id=?");
            stmt.setInt(1, objSecao.getId());

            stmt.executeUpdate();

            return true;

        } 
        catch (SQLException ex) 
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

