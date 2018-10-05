/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.produtoController;
import estoque.CaixaDeDialogo;
import estoque.Principal;
import java.sql.SQLException;
import models.Produto;
import tools.Combos;
import tools.formatacao;

/**
 *
 * @author nmp
 */
public class viewProdutos extends javax.swing.JFrame {
 Combos objComboStatus;
 Combos objComboGrupos;
 int id;
 Produto objProduto;
 int type;
    /**
     * Creates new form viewProdutos
     */
    public viewProdutos() {
        initComponents();
        produtoController produtoCon = new produtoController(null, jtbProdutos);
        produtoCon.preencherTabela(2,0,null);
        btnAlterar.setEnabled(false);
        btnInativar.setEnabled(false);
        btnExcluir.setEnabled(false);
        formatacao.colocaMascara(txtDataAdd, "##/##/####");
        try 
        {
         objComboStatus = new Combos(jcbStatus);
         objComboStatus.PreencheCombo("SELECT id, nome FROM status ORDER BY nome",false);
        
        }    
        catch (SQLException e) 
        {
            System.out.println("Erro ao preencher combobox");
        }
        jcbStatus.setEnabled(false);
        try 
        {
         objComboGrupos = new Combos(jcbGrupos);
         objComboGrupos.PreencheCombo("SELECT id, nome FROM grupos WHERE status=1 ORDER BY nome",false);
        }    
        catch (SQLException e) 
        {
            System.out.println("Erro ao preencher combobox");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtbProdutos = new javax.swing.JTable();
        btnInserir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jcbInativos = new javax.swing.JCheckBox();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<String>();
        lblInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInfo = new javax.swing.JTextArea();
        lblGrupo = new javax.swing.JLabel();
        jcbGrupos = new javax.swing.JComboBox<String>();
        lblQntdMin = new javax.swing.JLabel();
        txtQntdMin = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        lblDataAdd = new javax.swing.JLabel();
        txtDataAdd = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jtbProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbProdutos);

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

        jcbInativos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbInativos.setForeground(new java.awt.Color(204, 0, 0));
        jcbInativos.setText("Mostrar Inativos");
        jcbInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInativosActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setText("Produtos");

        lblId.setBackground(new java.awt.Color(204, 0, 0));
        lblId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblId.setForeground(new java.awt.Color(204, 0, 0));
        lblId.setText("ID:");

        txtId.setEditable(false);

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(204, 0, 0));
        lblNome.setText("Nome:");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(204, 0, 0));
        lblStatus.setText("Status");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(204, 0, 0));
        lblInfo.setText("Informações:");

        jtaInfo.setColumns(20);
        jtaInfo.setRows(5);
        jScrollPane1.setViewportView(jtaInfo);

        lblGrupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGrupo.setForeground(new java.awt.Color(204, 0, 0));
        lblGrupo.setText("Grupo");

        jcbGrupos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblQntdMin.setBackground(new java.awt.Color(204, 0, 0));
        lblQntdMin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQntdMin.setForeground(new java.awt.Color(204, 0, 0));
        lblQntdMin.setText("Quantidade mínima:");

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

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnBusca.setToolTipText("");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        lblDataAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDataAdd.setForeground(new java.awt.Color(204, 0, 0));
        lblDataAdd.setText("Data Adicionado:");

        txtDataAdd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblId)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInfo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jcbInativos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnVoltar))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterar)
                                .addGap(14, 14, 14)
                                .addComponent(btnInativar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(59, 59, 59)
                                .addComponent(btnLimpar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblGrupo)
                                        .addGap(71, 71, 71)
                                        .addComponent(lblQntdMin))
                                    .addComponent(jcbGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(260, 260, 260)
                                        .addComponent(txtQntdMin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(253, 253, 253))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStatus)
                                        .addGap(72, 72, 72)
                                        .addComponent(lblDataAdd))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNome)
                    .addComponent(lblInfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblStatus)
                                    .addComponent(lblDataAdd))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblGrupo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblQntdMin)
                                        .addComponent(txtQntdMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInserir)
                            .addComponent(btnAlterar)
                            .addComponent(btnInativar)
                            .addComponent(btnLimpar)
                            .addComponent(btnExcluir))
                        .addGap(18, 18, 18)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jcbInativos))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProdutosMouseClicked
        // TODO add your handling code here:
        int linha = jtbProdutos.getSelectedRow();
        id = (int) jtbProdutos.getModel().getValueAt(linha, 0);
        
        produtoController produtoCon = new produtoController();
        objProduto = produtoCon.buscar(id);
        preencherCampos(objProduto);
        
        int s=objProduto.getStatus();
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
    }//GEN-LAST:event_jtbProdutosMouseClicked

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        if (validarDados()==true)
        {
            guardarInclusao();
            produtoController produtoCon = new produtoController(objProduto); 
            try
            {
            boolean inclusao = produtoCon.incluir();
                if (inclusao ==true)
                {
                    type = checkboxInativar();
                    atualizarTabela(type);
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Produto inserido com sucesso!", "Inserido", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir produto.", "ERRO", 'e');
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

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (validarDados()==true)
        {
            guardarDados();
            produtoController produtoCon = new produtoController(objProduto); 
            try
            {
            boolean alteracao = produtoCon.alterar();
                if (alteracao ==true)
                {
                    type = checkboxInativar();
                    atualizarTabela(type);
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Produto alterado com sucesso!", "Alterado", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar produto.", "ERRO", 'e');
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

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        // TODO add your handling code here:
            guardarDados();
            objProduto.setDt_inativado(formatacao.retornaDataAtual("yyyy-MM-dd"));
            produtoController produtoCon = new produtoController(objProduto); 
            try
            {
            boolean inativacao = produtoCon.inativar();
                if (inativacao ==true)
                {
                    type=checkboxInativar();
                    atualizarTabela(type);
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Produto inativado com sucesso!", "Inativado", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao inativar produto.", "ERRO", 'e');
                }
            }
            catch (Exception e)
            {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
            }    
            limparCampos();
    }//GEN-LAST:event_btnInativarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
            guardarDados();
            produtoController produtoCon = new produtoController(objProduto); 
            boolean escolha= CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza que deseja excluir o produto?", 
                            "Excluir?", 'p');
            if (escolha==true)
            {
                try {
                    boolean exclusao = produtoCon.excluir();
                    if (exclusao == true) {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Produto excluído com sucesso!", "Excluído", 'i');

                    } else {
                        CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir grupo.", "ERRO", 'e');
                    }
                } catch (Exception e) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
                }
            }
        type = checkboxInativar();
        atualizarTabela(type);
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:
        produtoController produtoCon = new produtoController(null, jtbProdutos);
        type=checkboxInativar();
        produtoCon.preencherTabela(type,1,txtBusca.getText());
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void jcbInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInativosActionPerformed
        // TODO add your handling code here:
        type =checkboxInativar();
        atualizarTabela(type);
    }//GEN-LAST:event_jcbInativosActionPerformed

    /**
     * @param args the command line arguments
     */

    private void limparCampos()
    {
        txtId.setText("");
        txtNome.setText("");
        objComboStatus.SetaComboBox("");
        jtaInfo.setText("");
        txtQntdMin.setText("");
        formatacao.colocaMascara(txtDataAdd, "##/##/####");
        objComboGrupos.SetaComboBox("");

        jcbStatus.setSelectedIndex(0);
        jcbGrupos.setSelectedIndex(0);
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
            produtoController produtoCon = new produtoController(null, jtbProdutos);
            produtoCon.preencherTabela(type,0,null);

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
 
    private void preencherCampos(Produto objProduto)
    {
        txtId.setText(String.valueOf(objProduto.getId()));
        txtNome.setText(objProduto.getNome());
        jtaInfo.setText(objProduto.getInfo());
        objComboStatus.SetaComboBox(String.valueOf(objProduto.getStatus()));
        objComboGrupos.SetaComboBox(String.valueOf(objProduto.getGrupo()));
        txtQntdMin.setText(String.valueOf(objProduto.getQntd_min()));
        txtDataAdd.setText(String.valueOf(formatacao.ajustaDataDMA(objProduto.getData_add())));
    }
    
    private boolean validarDados() 
    {
        try {
            produtoController produtoCon = new produtoController();
           if ((jtaInfo.getText().trim().length()>0) && (txtNome.getText().trim().length()>1) && 
                   (txtQntdMin.getText().trim().length()!=0) && (txtDataAdd.getText().trim().length()==10))
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
            objProduto = new Produto();
            objProduto.setNome(txtNome.getText());
            objProduto.setInfo(jtaInfo.getText());
            objProduto.setQntd_min(Integer.parseInt(txtQntdMin.getText()));
            objProduto.setData_add(txtDataAdd.getText());

            Combos c = (Combos) jcbStatus.getSelectedItem();
            String status = c.getCodigo();
            objProduto.setStatus(Integer.parseInt(status));
            
            Combos co = (Combos) jcbGrupos.getSelectedItem();
            String grupo = co.getCodigo();
            objProduto.setGrupo(Integer.parseInt(grupo));
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
            objProduto = new Produto();
            objProduto.setId(Integer.parseInt(txtId.getText()));
            objProduto.setNome(txtNome.getText());
            objProduto.setInfo(jtaInfo.getText());
            objProduto.setData_add(txtDataAdd.getText());
            
            Combos c = (Combos) jcbStatus.getSelectedItem();
            String status = c.getCodigo();
            objProduto.setStatus(Integer.parseInt(status));
            
            Combos co = (Combos) jcbGrupos.getSelectedItem();
            String grupo = co.getCodigo();
            objProduto.setGrupo(Integer.parseInt(grupo));
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInativar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbGrupos;
    private javax.swing.JCheckBox jcbInativos;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTextArea jtaInfo;
    private javax.swing.JTable jtbProdutos;
    private javax.swing.JLabel lblDataAdd;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQntdMin;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JFormattedTextField txtDataAdd;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQntdMin;
    // End of variables declaration//GEN-END:variables
}
