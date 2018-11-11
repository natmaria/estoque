/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.prateleiraController;
import estoque.CaixaDeDialogo;
import estoque.Principal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import models.Prateleira;
import tools.Combos;
import tools.formatacao;

/**
 *
 * @author nmp
 */
public class viewPrateleiras extends javax.swing.JFrame {
 Combos objComboStatus;
 Combos objComboSecao;
 Combos objComboProduto;
 int id;
 Prateleira objPrateleira;
 int type;
    /**
     * Creates new form viewPrateleiras
     */
    public viewPrateleiras() {
        initComponents();
        prateleiraController prateleiraCon = new prateleiraController(null, jtbPrateleiras);
        prateleiraCon.preencherTabela(2,0,null);
        btnAlterar.setEnabled(false);
        btnInativar.setEnabled(false);
        btnExcluir.setEnabled(false);
        
        try 
        {
         objComboStatus = new Combos(jcbStatus);
         objComboStatus.PreencheCombo("SELECT id, nome FROM status ORDER BY nome",0);
        }    
        catch (SQLException e) 
        {
            System.out.println("Erro ao preencher combobox");
        }
        jcbStatus.setEnabled(false);
                
        try 
        {
         objComboSecao = new Combos(jcbSecao);
         objComboSecao.PreencheCombo("SELECT id, nome FROM secoes WHERE status=1 ORDER BY nome",1);
        }    
        catch (SQLException e) 
        {
            System.out.println("Erro ao preencher combobox");
        }
        
        try 
        {
         objComboProduto = new Combos(jcbProduto);
         objComboProduto.PreencheCombo("SELECT id, nome FROM produtos WHERE status=1 ORDER BY nome",1);
        }    
        catch (SQLException e) 
        {
            System.out.println("Erro ao preencher combobox");
        }
        countRegistros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExcluir = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbPrateleiras = new javax.swing.JTable();
        btnInativar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblAltura = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jcbInativos = new javax.swing.JCheckBox();
        lblLargura = new javax.swing.JLabel();
        lblStatus1 = new javax.swing.JLabel();
        jcbSecao = new javax.swing.JComboBox<>();
        lblProduto = new javax.swing.JLabel();
        jcbProduto = new javax.swing.JComboBox<>();
        txtAltura = new javax.swing.JFormattedTextField();
        txtLargura = new javax.swing.JFormattedTextField();
        lblReg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExcluir.setBackground(new java.awt.Color(51, 153, 255));
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-error.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtBusca.setText(" ");
        txtBusca.setToolTipText("");

        btnAlterar.setBackground(new java.awt.Color(51, 153, 255));
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setBorderPainted(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnBusca.setToolTipText("");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(204, 0, 0));
        lblNome.setText("Nome:");

        jtbPrateleiras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbPrateleiras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPrateleirasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbPrateleiras);

        btnInativar.setBackground(new java.awt.Color(51, 153, 255));
        btnInativar.setForeground(new java.awt.Color(255, 255, 255));
        btnInativar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-delete.png"))); // NOI18N
        btnInativar.setText("Inativar");
        btnInativar.setBorderPainted(false);
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setText("Prateleiras");

        btnVoltar.setBackground(new java.awt.Color(51, 153, 255));
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-left.png"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(204, 0, 0));
        lblStatus.setText("Status");

        btnInserir.setBackground(new java.awt.Color(51, 153, 255));
        btnInserir.setForeground(new java.awt.Color(255, 255, 255));
        btnInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-check.png"))); // NOI18N
        btnInserir.setText("Inserir");
        btnInserir.setBorderPainted(false);
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(51, 153, 255));
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-sync.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorderPainted(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblAltura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAltura.setForeground(new java.awt.Color(204, 0, 0));
        lblAltura.setText("Altura");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbInativos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbInativos.setForeground(new java.awt.Color(204, 0, 0));
        jcbInativos.setText("Mostrar Inativos");
        jcbInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInativosActionPerformed(evt);
            }
        });

        lblLargura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLargura.setForeground(new java.awt.Color(204, 0, 0));
        lblLargura.setText("Largura");

        lblStatus1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatus1.setForeground(new java.awt.Color(204, 0, 0));
        lblStatus1.setText("Seção");

        jcbSecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProduto.setForeground(new java.awt.Color(204, 0, 0));
        lblProduto.setText("Produto");

        jcbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            txtAltura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAlturaKeyTyped(evt);
            }
        });

        try {
            txtLargura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtLargura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLarguraKeyTyped(evt);
            }
        });

        jLabel1.setText("Registros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAltura)
                                        .addGap(27, 27, 27)
                                        .addComponent(lblLargura))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtLargura, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatus1)
                                    .addComponent(jcbSecao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblProduto)
                                .addGap(153, 153, 153))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatus)
                            .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInserir)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnInativar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbInativos)
                        .addGap(350, 350, 350)
                        .addComponent(btnVoltar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblReg, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(13, 13, 13)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus1)
                            .addComponent(lblProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbSecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLargura, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAltura, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLargura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnInativar)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusca)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblReg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jcbInativos))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        guardarDados();
        prateleiraController prateleiraCon = new prateleiraController(objPrateleira);
        boolean escolha= CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza que deseja excluir a prateleira?",
            "Excluir?", 'p');
        if (escolha==true)
        {
            try {
                boolean exclusao = prateleiraCon.excluir();
                if (exclusao == true) {
                    type = checkboxInativar();
                    atualizarTabela(type);
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Prateleira excluída com sucesso!", "Excluída", 'i');

                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir prateleira.", "ERRO", 'e');
                }
            } catch (Exception e) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (validarDados()==true)
        {
            guardarDados();
            prateleiraController prateleiraCon = new prateleiraController(objPrateleira);
            try
            {
                boolean alteracao = prateleiraCon.alterar();
                if (alteracao ==true)
                {
                    type=checkboxInativar();
                    atualizarTabela(type);
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Prateleira alterada com sucesso!", "Alterada", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar prateleira.", "ERRO", 'e');
                }
            }
            catch (Exception e)
            {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
            }
        } else
        {
            CaixaDeDialogo.obterinstancia().exibirMensagem("É necessário preencher todos os campos!", "Preencher campos!", 'e');
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:
        prateleiraController prateleiraCon = new prateleiraController(null, jtbPrateleiras);
        type=checkboxInativar();
        prateleiraCon.preencherTabela(type,1,txtBusca.getText());
        countRegistros();
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void jtbPrateleirasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPrateleirasMouseClicked
        // TODO add your handling code here:
        int linha = jtbPrateleiras.getSelectedRow();
        id = (int) jtbPrateleiras.getModel().getValueAt(linha, 0);
        //        System.out.println(id);

        prateleiraController prateleiraCon = new prateleiraController();
        objPrateleira = prateleiraController.buscar(id);
        preencherCampos(objPrateleira);

        int s=objPrateleira.getStatus();
        if (s==1)
        {
            jcbStatus.setEnabled(false);
        }
        else
        {
            jcbStatus.setEnabled(true);
        }
        btnAlterar.setEnabled(true);
        btnInativar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_jtbPrateleirasMouseClicked

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        // TODO add your handling code here:
        guardarDados();
        objPrateleira.setDt_inativado(formatacao.retornaDataAtual("yyyy-MM-dd"));
        prateleiraController prateleiraCon = new prateleiraController(objPrateleira);
        try
        {
            boolean inativacao = prateleiraCon.inativar();
            if (inativacao ==true)
            {
                type=checkboxInativar();
                atualizarTabela(type);
                limparCampos();
                CaixaDeDialogo.obterinstancia().exibirMensagem("Prateleira inativada com sucesso!", "Inativada", 'i');
            }
            else
            {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao inativar prateleira.", "ERRO", 'e');
            }
        }
        catch (Exception e)
        {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnInativarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        if (validarDados()==true)
        {
            guardarInclusao();
            prateleiraController prateleiraCon = new prateleiraController(objPrateleira);
            try
            {
                boolean inclusao = prateleiraCon.incluir();
                if (inclusao ==true)
                {
                    type=checkboxInativar();
                    atualizarTabela(type);
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Prateleira inserida com sucesso!", "Inserida", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir prateleira.", "ERRO", 'e');
                }
            }
            catch (Exception e)
            {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
            }
        } else
        {
            CaixaDeDialogo.obterinstancia().exibirMensagem("É necessário preencher todos os campos!", "Preencher campos!", 'e');
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jcbInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInativosActionPerformed
        // TODO add your handling code here:
        type =checkboxInativar();
        atualizarTabela(type);
    }//GEN-LAST:event_jcbInativosActionPerformed

    private void txtAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlturaKeyTyped
        // TODO add your handling code here:
           String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtAlturaKeyTyped

    private void txtLarguraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLarguraKeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtLarguraKeyTyped

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        // TODO add your handling code here:
        int maximo = 50;
        if((txtNome.getText().length()>=maximo))
        {
            evt.consume();
            txtNome.setText(txtNome.getText().substring(0,maximo));
        }
    }//GEN-LAST:event_txtNomeKeyTyped

 private void limparCampos()
    {
        txtNome.setText("");
        objComboStatus.SetaComboBox("");
        objComboSecao.SetaComboBox("");
        objComboProduto.SetaComboBox("");
        txtAltura.setValue("");
        txtLargura.setValue("");

        jcbStatus.setSelectedIndex(0);
        jcbStatus.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnInativar.setEnabled(false);
        btnExcluir.setEnabled(false);
        jcbInativos.setSelected(false);
        type=checkboxInativar();
        atualizarTabela(type);
    }

 private void atualizarTabela(int type) 
    {
        try 
        {
            prateleiraController prateleiraCon = new prateleiraController(null, jtbPrateleiras);
            prateleiraCon.preencherTabela(type,0,null);
            countRegistros();
        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
 
 private void preencherCampos(Prateleira objPrateleira)
    {
      try{
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        txtNome.setText(objPrateleira.getNome());
        objComboStatus.SetaComboBox(String.valueOf(objPrateleira.getStatus()));
        objComboSecao.SetaComboBox(String.valueOf(objPrateleira.getSecao()));
        objComboProduto.SetaComboBox(String.valueOf(objPrateleira.getProduto()));
        String alt;
        alt = formatacao.formataDecimal(objPrateleira.getAltura());
        txtAltura.setText(alt);
        String larg;
        larg = formatacao.formataDecimal(objPrateleira.getLargura());
        txtLargura.setText(larg);

       //  System.out.println(objPrateleira.getLargura());
        
      }catch(Exception e){
          System.out.println(e.getMessage());   
      }
    }
 
  private boolean validarDados() 
    {
        try {
            int produto = jcbProduto.getSelectedIndex();
            int secao = jcbSecao.getSelectedIndex();
            prateleiraController prateleiraCon = new prateleiraController();
           if ((txtAltura.isEditValid()) && (txtNome.getText().trim().length()>1) && 
                   (txtLargura.isEditValid()) && (produto!=0) && (secao!=0))
            {
            return true;
            } else
               return false;
        } 
        catch (Exception ex) 
        {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            return false;
        }
    }
  
  private void guardarInclusao() 
    {
        try 
        {
            objPrateleira = new Prateleira();
            objPrateleira.setNome(txtNome.getText());
            objPrateleira.setAltura(Double.parseDouble(txtAltura.getText()));
            objPrateleira.setLargura(Double.parseDouble(txtLargura.getText()));

            Combos c = (Combos) jcbStatus.getSelectedItem();
            String status = c.getCodigo();
            objPrateleira.setStatus(Integer.parseInt(status));
            
            Combos co = (Combos) jcbSecao.getSelectedItem();
            String secao = co.getCodigo();
            objPrateleira.setSecao(Integer.parseInt(secao));
            
            Combos com = (Combos) jcbProduto.getSelectedItem();
            String prod = com.getCodigo();
            objPrateleira.setProduto(Integer.parseInt(prod));
        }
        catch(Exception ex)
        {
        CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
  
      private void guardarDados() 
    {
        try 
        {
            objPrateleira = new Prateleira();
            objPrateleira.setId(id);
            objPrateleira.setNome(txtNome.getText());
            objPrateleira.setAltura(Double.parseDouble((String) txtAltura.getValue()));
            objPrateleira.setLargura(Double.parseDouble((String) txtLargura.getValue()));

            Combos c = (Combos) jcbStatus.getSelectedItem();
            String status = c.getCodigo();
            objPrateleira.setStatus(Integer.parseInt(status));
            
            Combos co = (Combos) jcbSecao.getSelectedItem();
            String secao = co.getCodigo();
            objPrateleira.setSecao(Integer.parseInt(secao));
            
            Combos com = (Combos) jcbProduto.getSelectedItem();
            String prod = com.getCodigo();
            objPrateleira.setProduto(Integer.parseInt(prod));
        }
        catch(Exception ex)
        {
        CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
      
    public int checkboxInativar()
    {
        if (jcbInativos.isSelected())
        {
           return 1;
        }
        else
        {
            return 2;
        }   
    }

    private void countRegistros()
    {
     int count = jtbPrateleiras.getRowCount();
     lblReg.setText(String.valueOf(count));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jcbInativos;
    private javax.swing.JComboBox<String> jcbProduto;
    private javax.swing.JComboBox<String> jcbSecao;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable jtbPrateleiras;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblLargura;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblReg;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFormattedTextField txtAltura;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JFormattedTextField txtLargura;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
