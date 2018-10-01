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
    
    public produtoController(Produto objProduto, JTable jtbProdutos)
    {
        this.objProduto=objProduto;
        this.jtbProdutos=jtbProdutos;
    }
    
      public produtoController()
      {
          
      }
    
      public void preencherTabela() 
      {
        ConnectionFactory.abreConexao();
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("Informações");
        cabecalhos.add("Grupo");
        cabecalhos.add("Quantidade mínima");
        cabecalhos.add("Status");
        
        ResultSet result = null;
        try
        {
            String SQL = "";
            SQL = " SELECT p.id,p.nome,p.info,g.nome,p.qntd_min,g.nome  ";
            SQL+=" FROM produtos p, grupos g, status s ";
            SQL+=" WHERE g.status=s.id ";
            SQL+=" AND g.id=p.idgrupo ";
            SQL+=" AND p.status=1 ";
            SQL+= " ORDER BY p.nome ";
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            while (result.next())
            {
              Vector<Object> linha = new Vector<Object>();
              linha.add(result.getInt(1));
              linha.add(result.getString(2));
              linha.add(result.getString(3));
              linha.add(result.getString(4));
              linha.add(result.getInt(5));
              linha.add(result.getString(6));
              dadosTabela.add(linha);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Problema ao popular tabela");
            System.out.println(e);
        }
        
        jtbProdutos.setModel
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
        
        jtbProdutos.setSelectionMode(0);
        
        TableColumn column = null;
        for (int i=0; i<6; i++) 
        {
            column = jtbProdutos.getColumnModel().getColumn(i);
            switch (i)
            {
                case 0:
                    column.setPreferredWidth(10);
                    break;
                case 1:
                    column.setPreferredWidth(120);
                    break;
                case 2:
                    column.setPreferredWidth(300);
                    break;
                case 3:
                    column.setPreferredWidth(100);
                    break;
                case 4:
                    column.setPreferredWidth(10);
                    break;
                case 5:
                    column.setPreferredWidth(50);
                    break;
            }
        }
        
        jtbProdutos.setDefaultRenderer
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
}
