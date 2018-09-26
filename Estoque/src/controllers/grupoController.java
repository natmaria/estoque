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
import models.Grupo;

/**
 *
 * @author nmpetry
 */
public class grupoController {
    Grupo objGrupo;
    JTable jtbGrupos = null;
    
      public grupoController (Grupo objGrupo, JTable jtbGrupos) 
      {
        this.objGrupo = objGrupo;
        this.jtbGrupos = jtbGrupos;
      }
      
      public void preencherTabela() 
      {
        ConnectionFactory.abreConexao();
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector();
        cabecalhos.add("ID");
        cabecalhos.add("Nome");
        cabecalhos.add("Informações");
        cabecalhos.add("Status");
        
        ResultSet result = null;
        try
        {
            String SQL = "";
            SQL = " SELECT id,nome,info,status ";
            SQL+=" FROM grupos ";
            SQL+=" WHERE status=1 ";
            SQL+= " ORDER BY nome ";
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
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
        
        jtbGrupos.setModel
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
        
        jtbGrupos.setSelectionMode(0);
        
        TableColumn column = null;
        for (int i=0; i<4; i++) 
        {
            column = jtbGrupos.getColumnModel().getColumn(i);
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
                    column.setPreferredWidth(50);
                    break;
            }
        }
        
        jtbGrupos.setDefaultRenderer
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
