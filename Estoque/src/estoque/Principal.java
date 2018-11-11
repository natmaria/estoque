/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estoque;

import controllers.relatoriosController;
import java.sql.ResultSet;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import views.viewGrupos;
import views.viewMovimentacao;
import views.viewPrateleiras;
import views.viewProdutos;
import views.viewSecoes;

/**
 *
 * @author nmpetry
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnGrupos = new javax.swing.JMenu();
        mnGrupos = new javax.swing.JMenuItem();
        mnProdutos = new javax.swing.JMenuItem();
        mnSecoes = new javax.swing.JMenuItem();
        mnPrateleiras = new javax.swing.JMenuItem();
        mnMovimentacao = new javax.swing.JMenu();
        mvMovimentar = new javax.swing.JMenuItem();
        rltSecoes = new javax.swing.JMenu();
        rltGrupo = new javax.swing.JMenuItem();
        rltGruposxProdutos = new javax.swing.JMenuItem();
        rltPrateleiras = new javax.swing.JMenuItem();
        rltProdutos = new javax.swing.JMenuItem();
        rltProdutosFalta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 300));
        setSize(new java.awt.Dimension(600, 300));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setText("Sistema de Estrutura de Estoque");

        btnGrupos.setText("Cadastros");

        mnGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/grupos.png"))); // NOI18N
        mnGrupos.setText("Grupos");
        mnGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGruposActionPerformed(evt);
            }
        });
        btnGrupos.add(mnGrupos);

        mnProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/produtos.png"))); // NOI18N
        mnProdutos.setText("Produtos");
        mnProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnProdutosActionPerformed(evt);
            }
        });
        btnGrupos.add(mnProdutos);

        mnSecoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/secoes.png"))); // NOI18N
        mnSecoes.setText("Seções");
        mnSecoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSecoesActionPerformed(evt);
            }
        });
        btnGrupos.add(mnSecoes);

        mnPrateleiras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/prateleiras.png"))); // NOI18N
        mnPrateleiras.setText("Prateleiras");
        mnPrateleiras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPrateleirasActionPerformed(evt);
            }
        });
        btnGrupos.add(mnPrateleiras);

        jMenuBar1.add(btnGrupos);

        mnMovimentacao.setText("Movimentações");

        mvMovimentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/movimentar.png"))); // NOI18N
        mvMovimentar.setText("Movimentar");
        mvMovimentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mvMovimentarActionPerformed(evt);
            }
        });
        mnMovimentacao.add(mvMovimentar);

        jMenuBar1.add(mnMovimentacao);

        rltSecoes.setText("Relatórios");

        rltGrupo.setText("Grupos");
        rltGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rltGrupoActionPerformed(evt);
            }
        });
        rltSecoes.add(rltGrupo);

        rltGruposxProdutos.setText("Produtos x Grupo");
        rltGruposxProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rltGruposxProdutosActionPerformed(evt);
            }
        });
        rltSecoes.add(rltGruposxProdutos);

        rltPrateleiras.setText("Produtos x Prateleiras");
        rltPrateleiras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rltPrateleirasActionPerformed(evt);
            }
        });
        rltSecoes.add(rltPrateleiras);

        rltProdutos.setText("Todos Produtos");
        rltProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rltProdutosActionPerformed(evt);
            }
        });
        rltSecoes.add(rltProdutos);

        rltProdutosFalta.setText("Produtos em falta");
        rltSecoes.add(rltProdutosFalta);

        jMenuBar1.add(rltSecoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblTitulo)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lblTitulo)
                .addContainerGap(483, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rltGruposxProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rltGruposxProdutosActionPerformed
        // TODO add your handling code here:
    selecaoRelatorio sr = new selecaoRelatorio(null,true);
    sr.setVisible(true);
    
    }//GEN-LAST:event_rltGruposxProdutosActionPerformed

    private void rltGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rltGrupoActionPerformed
        // TODO add your handling code here:
            try
            {
                relatoriosController rlCon = new relatoriosController();
                ResultSet resultSet = rlCon.buscarRelatorioGrupo();//Buscar os dados do relatório
                JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
                JasperPrint jpPrint = JasperFillManager.fillReport("ireport/Grupos.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
                JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
                jpViewer.setVisible(true);//abre o relatório para visualização
                jpViewer.toFront();//define o form a frente da aplicação
            }
            catch (JRException ex)
            {
             CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');           
            }      
    }//GEN-LAST:event_rltGrupoActionPerformed

    private void rltProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rltProdutosActionPerformed
        // TODO add your handling code here:
                    try
            {
                relatoriosController rlCon = new relatoriosController();
                ResultSet resultSet = rlCon.buscarRelatorioProdutos();//Buscar os dados do relatório
                JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
                JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioProdutos.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
                JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
                jpViewer.setVisible(true);//abre o relatório para visualização
                jpViewer.toFront();//define o form a frente da aplicação
            }
            catch (JRException ex)
            {
             CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');           
            }
    }//GEN-LAST:event_rltProdutosActionPerformed

    private void rltPrateleirasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rltPrateleirasActionPerformed
        // TODO add your handling code here:
        
        try
            {
                relatoriosController rlCon = new relatoriosController();
                ResultSet resultSet = rlCon.buscarRelatorioPrateleiras();//Buscar os dados do relatório
                JRResultSetDataSource relResult = new JRResultSetDataSource(resultSet);//Passa um resultSet para a fonte de dados do relatório
                JasperPrint jpPrint = JasperFillManager.fillReport("ireport/RelatorioProdutosxPrateleira.jasper", new HashMap(), relResult);//Prepara o relatório para ser impresso, recebe o gerenciador JASPER
                JasperViewer jpViewer = new JasperViewer(jpPrint, false); //
                jpViewer.setVisible(true);//abre o relatório para visualização
                jpViewer.toFront();//define o form a frente da aplicação
            }
            catch (JRException ex)
            {
             CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage(), 'e');           
            }     
    }//GEN-LAST:event_rltPrateleirasActionPerformed

    private void mnGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGruposActionPerformed
        // TODO add your handling code here:
        viewGrupos grupo = new viewGrupos();
        grupo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnGruposActionPerformed

    private void mnProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnProdutosActionPerformed
        // TODO add your handling code here:
        viewProdutos produtos = new viewProdutos();
        produtos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnProdutosActionPerformed

    private void mnSecoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSecoesActionPerformed
        // TODO add your handling code here:
        viewSecoes secoes = new viewSecoes();
        secoes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnSecoesActionPerformed

    private void mnPrateleirasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPrateleirasActionPerformed
        // TODO add your handling code here:
        viewPrateleiras prateleiras = new viewPrateleiras();
        prateleiras.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnPrateleirasActionPerformed

    private void mvMovimentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mvMovimentarActionPerformed
        // TODO add your handling code here:
        viewMovimentacao movi = new viewMovimentacao();
        movi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mvMovimentarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnGrupos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenuItem mnGrupos;
    private javax.swing.JMenu mnMovimentacao;
    private javax.swing.JMenuItem mnPrateleiras;
    private javax.swing.JMenuItem mnProdutos;
    private javax.swing.JMenuItem mnSecoes;
    private javax.swing.JMenuItem mvMovimentar;
    private javax.swing.JMenuItem rltGrupo;
    private javax.swing.JMenuItem rltGruposxProdutos;
    private javax.swing.JMenuItem rltPrateleiras;
    private javax.swing.JMenuItem rltProdutos;
    private javax.swing.JMenuItem rltProdutosFalta;
    private javax.swing.JMenu rltSecoes;
    // End of variables declaration//GEN-END:variables
}
