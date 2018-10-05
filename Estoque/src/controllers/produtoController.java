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
import models.Produto;
import tools.formatacao;

/**
 *
 * @author nmp
 */
public class produtoController 
{

    static Produto objProduto;
    JTable jtbProdutos = null;

    public produtoController(Produto objProduto, JTable jtbProdutos) 
    {
        this.objProduto = objProduto;
        this.jtbProdutos = jtbProdutos;
    }

    public produtoController(Produto objProduto) 
    {
        this.objProduto=objProduto;
    }
      
    public produtoController() {

    }

    public void preencherTabela(int type, int busca, String nome) {
        ConnectionFactory.abreConexao();
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("Informações");
        cabecalhos.add("Quant. min.");
        cabecalhos.add("Status");

        ResultSet result = null;
        if (type == 2) 
        {
            if (busca == 0) 
            {
                try 
                {
                    String SQL = "";
                    SQL = " SELECT p.id,p.nome,p.info,p.qntd_min,s.nome ";
                    SQL += " FROM produtos p,status s ";
                    SQL += " WHERE p.status=s.id ";
                    SQL += " AND p.status=1 ";
                    SQL += " ORDER BY p.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } 
                catch (SQLException e) 
                {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                }
            } else 
            {
                try 
                {
                    String SQL = "";
                    SQL = " SELECT p.id,p.nome,p.info,p.qntd_min,s.nome  ";
                    SQL += " FROM produtos p,status s ";
                    SQL += " WHERE p.status=s.id ";
                    SQL += " AND p.status=1 ";
                    SQL += " AND LOWER(p.nome) LIKE '%" + nome.toLowerCase() + "%'";
                    SQL += " ORDER BY p.nome ";
                    result = ConnectionFactory.stmt.executeQuery(SQL);
                } 
                catch (SQLException e) 
                {
                    System.out.println("Problema ao popular tabela");
                    System.out.println(e);
                }
            }
        } else 
        {
            if (type == 1) 
            {
                if (busca == 0) 
                {
                    try 
                    {
                        String SQL = "";
                        SQL = " SELECT p.id,p.nome,p.info,p.qntd_min,s.nome  ";
                        SQL += " FROM produtos p,status s ";
                        SQL += " WHERE p.status=s.id ";
                        SQL += " ORDER BY p.nome ";
                        result = ConnectionFactory.stmt.executeQuery(SQL);
                    } 
                    catch (SQLException e) 
                    {
                        System.out.println("Problema ao popular tabela");
                        System.out.println(e);
                    }
                } else
                {
                    try 
                    { 
                        String SQL = "";
                        SQL = " SELECT p.id,p.nome,p.info,p.qntd_min,s.nome  ";
                        SQL += " FROM produtos p,status s ";
                        SQL += " WHERE p.status=s.id ";
                        SQL += " AND LOWER(p.nome) LIKE '%" + nome.toLowerCase() + "%'";
                        SQL += " ORDER BY p.nome ";
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
                linha.add(result.getInt(4));
                linha.add(result.getString(5));
                dadosTabela.add(linha);
            }
        }
        catch (SQLException e) 
        {
            System.out.println("Problema ao popular tabela");
            System.out.println(e);
        }

                jtbProdutos.setModel(
                        new DefaultTableModel(dadosTabela, cabecalhos) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                }
                );

                jtbProdutos.setSelectionMode(0);

                TableColumn column = null;
                for (int i = 0; i < 5; i++) {
                    column = jtbProdutos.getColumnModel().getColumn(i);
                    switch (i) {
                        case 0:
                            column.setPreferredWidth(10);
                            break;
                        case 1:
                            column.setPreferredWidth(100);
                            break;
                        case 2:
                            column.setPreferredWidth(190);
                            break;
                        case 3:
                            column.setPreferredWidth(40);
                            break;
                        case 4:
                            column.setPreferredWidth(20);
                            break;
                    }
                }

                jtbProdutos.setDefaultRenderer(
                        Object.class, new DefaultTableCellRenderer() {
                    public Component getTableCellReComponent(JTable table, Object value,
                            boolean isSelected, boolean hasFocus, int row, int column) {
                        super.getTableCellRendererComponent(table, value, isSelected,
                                hasFocus, row, column);
                        if (row % 2 == 0) {
                            setBackground(Color.LIGHT_GRAY);
                        } else {
                            setBackground(Color.WHITE);
                        }
                        return this;
                    }
                }
                );
            }
    
    public  static Produto buscar(int id)
    {
        try 
        {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id,nome,info,id_grupo,qntd_min,status,data_add  ";
            SQL += " FROM produtos ";
            SQL += " WHERE id = '" + id + "'";
            //stm.executeQuery(SQL);  
        
            try 
            {
//                System.out.println("Vai Executar Conexão em buscar grupo");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
//                System.out.println("Executou Conexão em buscar grupo");

                objProduto = new Produto();

                if (rs.next() == true) {
                    objProduto.setId(rs.getInt(1));
                    objProduto.setNome(rs.getString(2));
                    objProduto.setInfo(rs.getString(3));
                    objProduto.setGrupo(rs.getInt(4));
                    objProduto.setQntd_min(rs.getInt(5));
                    objProduto.setStatus(rs.getInt(6));
                    objProduto.setData_add(String.valueOf(rs.getDate(7)));
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
    return objProduto;
    }
    
    public boolean incluir()
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO produtos (nome, info, id_grupo, qntd_min, status, data_add)VALUES(?,?,?,?,?,?)");
//            stmt.setInt(1,objGrupo.getId());
            stmt.setString(1, objProduto.getNome());
            stmt.setString(2, objProduto.getInfo());
            stmt.setInt(3, objProduto.getGrupo());
            stmt.setInt(4, objProduto.getQntd_min());
            stmt.setInt(5, objProduto.getStatus());
            stmt.setDate(6, Date.valueOf(formatacao.ajustaDataAMD(objProduto.getData_add())));
            
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
    
    public boolean alterar()
    {
 
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
        try 
        {
            stmt = con.prepareStatement("UPDATE produtos SET nome=?, info=?, id_grupo=?, qntd_min=?, status=?, data_add=? WHERE id=?");
            stmt.setString(1, objProduto.getNome());
            stmt.setString(2, objProduto.getInfo());
            stmt.setInt(3, objProduto.getGrupo());
            stmt.setInt(4, objProduto.getQntd_min());
            stmt.setInt(5, objProduto.getStatus());
            stmt.setDate(6, Date.valueOf(formatacao.ajustaDataAMD(objProduto.getData_add())));
            stmt.setInt(7, objProduto.getId());

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
 
        try 
        {
            stmt = con.prepareStatement("UPDATE produtos SET status=2,dt_inativado=? WHERE id=?");
            stmt.setDate(1,Date.valueOf(objProduto.getDt_inativado()));
            stmt.setInt(2, objProduto.getId());

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
 
        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE id=?");
            stmt.setInt(1, objProduto.getId());

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
