/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import estoque.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import models.Produto;

/**
 *
 * @author nmp
 */
public class produtoController {

    static Produto objProduto;
    JTable jtbProdutos = null;

    public produtoController(Produto objProduto, JTable jtbProdutos) {
        this.objProduto = objProduto;
        this.jtbProdutos = jtbProdutos;
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
                    SQL = " SELECT p.id,p.nome,p.info,p.qntd_min,s.nome  ";
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
                    SQL += " AND p.nome LIKE '%" + nome + "%'";
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
                        SQL += " AND p.nome LIKE '%" + nome + "%'";
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
                linha.add(result.getString(4));
                linha.add(result.getInt(5));
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
            SQL = " SELECT id,nome,info,id_grupo,qntd_min,status,dt_add  ";
            SQL += " FROM grupos ";
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
    
    
    
        }
