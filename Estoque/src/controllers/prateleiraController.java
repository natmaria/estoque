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
import models.Prateleira;

/**
 *
 * @author nmp
 */
public class prateleiraController {
    static Prateleira objPrateleira;
    JTable jtbPrateleiras = null;
    
    public prateleiraController (Prateleira objPrateleira, JTable jtbPrateleiras)
    {
        this.objPrateleira=objPrateleira;
        this.jtbPrateleiras=jtbPrateleiras;
    }
    
    public prateleiraController (Prateleira objPrateleira)
    {
        this.objPrateleira=objPrateleira;
    }
    
    public prateleiraController ()
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
        cabecalhos.add("Seção");
        cabecalhos.add("Produto");
        cabecalhos.add("Status");
        
        ResultSet result = null;
        if (type==2)
        {
            if (busca==0)
            {
                try 
                {
                    String SQL = "";
                    SQL = " SELECT pr.id,pr.nome,se.nome,po.nome,s.nome  ";
                    SQL += " FROM prateleiras pr, produtos po, secoes se, status s ";
                    SQL += " WHERE pr.status=s.id ";
                    SQL += " AND pr.id_produto=po.id ";
                    SQL += " AND pr.id_secao=se.id ";
                    SQL += " AND pr.status=1 ";
                    SQL += " ORDER BY pr.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } 
                catch (SQLException e) 
                {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                }
            }
            else
            {
                try
                {
                    String SQL = "";
                    SQL = " SELECT pr.id,pr.nome,se.nome,po.nome,s.nome  ";
                    SQL += " FROM prateleiras pr, produtos po, secoes se, status s ";
                    SQL += " WHERE pr.status=s.id ";
                    SQL += " AND pr.id_produto=po.id ";
                    SQL += " AND pr.id_secao=se.id ";
                    SQL += " AND pr.status=1 ";
                    SQL += " AND LOWER(pr.nome) LIKE '%" + nome.toLowerCase() + "%'";
                    SQL += " ORDER BY pr.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } 
                catch (SQLException e) 
                {
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
                    SQL = " SELECT pr.id,pr.nome,se.nome,po.nome,s.nome  ";
                    SQL += " FROM prateleiras pr, produtos po, secoes se, status s ";
                    SQL += " WHERE pr.status=s.id ";
                    SQL += " AND pr.id_produto=po.id ";
                    SQL += " AND pr.id_secao=se.id ";
                    SQL += " ORDER BY pr.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } 
                catch (SQLException e) 
                {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                }
                }
                else
                {
                    try 
                    {
                        String SQL = "";
                        SQL = " SELECT pr.id,pr.nome,se.nome,po.nome,s.nome  ";
                        SQL += " FROM prateleiras pr, produtos po, secoes se, status s ";
                        SQL += " WHERE pr.status=s.id ";
                        SQL += " AND pr.id_produto=po.id ";
                        SQL += " AND pr.id_secao=se.id ";
                        SQL += " AND LOWER(pr.nome) LIKE '%" + nome.toLowerCase() + "%'";
                        SQL += " ORDER BY pr.nome ";
                        result = ConnectionFactory.stmt.executeQuery(SQL);
                    } 
                    catch (SQLException e) 
                    {
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
              linha.add(result.getString(5));
              dadosTabela.add(linha);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Problema ao popular tabela");
            System.out.println(e);
        }
        
        jtbPrateleiras.setModel
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
        
        jtbPrateleiras.setSelectionMode(0);
        
        TableColumn column = null;
        for (int i=0; i<5; i++) 
        {
            column = jtbPrateleiras.getColumnModel().getColumn(i);
            switch (i)
            {
                case 0:
                    column.setPreferredWidth(10);
                    break;
                case 1:
                    column.setPreferredWidth(50);
                    break;
                case 2:
                    column.setPreferredWidth(50);
                    break;
                case 3:
                    column.setPreferredWidth(150);
                    break;
                case 4:
                column.setPreferredWidth(100);
                break;
            }
        }
        
        jtbPrateleiras.setDefaultRenderer
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
    
    public  static Prateleira buscar(int id)
    {
        try 
        {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id,nome,altura,largura,id_secao,id_produto,status ";
            SQL += " FROM prateleiras ";
            SQL += " WHERE id = '" + id + "'";
            //stm.executeQuery(SQL);  
        
            try 
            {
//                System.out.println("Vai Executar Conexão em buscar grupo");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
//                System.out.println("Executou Conexão em buscar grupo");

                objPrateleira = new Prateleira();

                if (rs.next() == true) {
                    objPrateleira.setId(rs.getInt(1));
                    objPrateleira.setNome(rs.getString(2));
                    objPrateleira.setAltura(rs.getDouble(3));
                    objPrateleira.setLargura(rs.getDouble(4));
                    objPrateleira.setSecao(rs.getInt(5));
                    objPrateleira.setProduto(rs.getInt(6));
                    objPrateleira.setStatus(rs.getInt(7));
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
    return objPrateleira;
    }
    
    public boolean incluir()
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO prateleiras (nome, altura, largura, id_secao, id_produto, status)VALUES(?,?,?,?,?,?)");
//            stmt.setInt(1,objGrupo.getId());
            stmt.setString(1, objPrateleira.getNome());
            stmt.setDouble(2, objPrateleira.getAltura());
            stmt.setDouble(3, objPrateleira.getLargura());
            stmt.setInt(4, objPrateleira.getSecao());
            stmt.setInt(5, objPrateleira.getProduto());
            stmt.setInt(6, objPrateleira.getStatus());
            
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
            stmt = con.prepareStatement("UPDATE prateleiras SET nome=?, altura=?, largura=?, id_secao=?, id_produto=?, status=? WHERE id=?");
            stmt.setString(1, objPrateleira.getNome());
            stmt.setDouble(2, objPrateleira.getAltura());
            stmt.setDouble(3, objPrateleira.getLargura());
            stmt.setInt(4, objPrateleira.getSecao());
            stmt.setInt(5, objPrateleira.getProduto());
            stmt.setInt(6, objPrateleira.getStatus());
            stmt.setInt(7, objPrateleira.getId());

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
            stmt = con.prepareStatement("UPDATE prateleiras SET status=2,dt_inativado=? WHERE id=?");
            stmt.setDate(1,Date.valueOf(objPrateleira.getDt_inativado()));
            stmt.setInt(2, objPrateleira.getId());

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
            stmt = con.prepareStatement("DELETE FROM prateleiras WHERE id=?");
            stmt.setInt(1, objPrateleira.getId());

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
