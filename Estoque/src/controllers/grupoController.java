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
import models.Grupo;
import tools.formatacao;

/**
 *
 * @author nmpetry
 */
public class grupoController {
    static Grupo objGrupo;
    JTable jtbGrupos = null;
    
      public grupoController (Grupo objGrupo, JTable jtbGrupos) 
      {
        this.objGrupo = objGrupo;
        this.jtbGrupos = jtbGrupos;
      }
      
       public grupoController (Grupo objGrupo) 
      {
       this.objGrupo=objGrupo;
      }
       
       public grupoController () 
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
        cabecalhos.add("Status");
        
        ResultSet result = null;
        try
        {
            String SQL = "";
            SQL = " SELECT g.id,g.nome,g.info,s.nome  ";
            SQL+=" FROM grupos g, status s ";
            SQL+=" WHERE g.status=s.id ";
            SQL+=" AND g.status=1 ";
            SQL+= " ORDER BY g.nome ";
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

    public  static Grupo buscar(int id)
    {
        try 
        {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;

            String SQL = "";
            SQL = " SELECT id,nome,info,status ";
            SQL += " FROM grupos ";
            SQL += " WHERE id = '" + id + "'";
            //stm.executeQuery(SQL);  
        
            try {
//                System.out.println("Vai Executar Conexão em buscar grupo");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
//                System.out.println("Executou Conexão em buscar grupo");

                objGrupo = new Grupo();

                if (rs.next() == true) {
                    objGrupo.setId(rs.getInt(1));
                    objGrupo.setNome(rs.getString(2));
                    objGrupo.setInfo(rs.getString(3));
                    objGrupo.setStatus(rs.getInt(4));
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
    return objGrupo;
    }
    
    
    public boolean incluir()
    {
        
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try 
        {
            stmt = con.prepareStatement("INSERT INTO grupos (id, nome, info, status)VALUES(?,?,?,?)");
            stmt.setInt(1,objGrupo.getId());
            stmt.setString(2, objGrupo.getNome());
            stmt.setString(3, objGrupo.getInfo());
            stmt.setInt(4, objGrupo.getStatus());
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
   
    public boolean alterar()
    {
 
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE grupos SET nome=?, info=? WHERE id=?");
            stmt.setString(1, objGrupo.getNome());
            stmt.setString(2, objGrupo.getInfo());
            stmt.setInt(3, objGrupo.getId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean inativar()
    {
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
 
        try {
            stmt = con.prepareStatement("UPDATE grupos SET status=2,dt_inativado=? WHERE id=?");
            stmt.setDate(1,Date.valueOf(objGrupo.getDt_inativado()));
            stmt.setInt(2, objGrupo.getId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }    
    }
    
    public boolean validarId(int id)
    {
    ConnectionFactory.abreConexao();
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;  
    
    try 
    {
        ResultSet result = null;
            String SQL = "";
            SQL = " SELECT id  ";
            SQL+=" FROM grupos ";
            SQL += " WHERE id = '" + id + "'";
            result = ConnectionFactory.stmt.executeQuery(SQL);
            
            if (result.next() == true) 
            {
            return false;
            }    
            else
            {
              return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Problema ao buscar ID");
            System.out.println(e);    
            return false;
        }
    }
}
