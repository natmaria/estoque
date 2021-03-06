/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.secaoController;
import estoque.CaixaDeDialogo;
import estoque.Principal;
import java.sql.SQLException;
import models.Secao;
import tools.Combos;
import tools.formatacao;

/**
 *
 * @author nmp
 */
public class viewSecoes extends javax.swing.JFrame {
 Combos objComboStatus;
 int id;
 Secao objSecao;
 int type;
    /**
     * Creates new form viewSecoes
     */
    public viewSecoes() {
        initComponents();
        secaoController secaoCon = new secaoController(null, jtbSecoes);
        secaoCon.preencherTabela(2,0,null);
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

        btnAlterar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        btnInativar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        jcbStatus = new javax.swing.JComboBox<>();
        jcbInativos = new javax.swing.JCheckBox();
        btnExcluir = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbSecoes = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        lblTamanho = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JFormattedTextField();
        lblReg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

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

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(204, 0, 0));
        lblNome.setText("Nome:");

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

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbInativos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbInativos.setForeground(new java.awt.Color(204, 0, 0));
        jcbInativos.setText("Mostrar Inativos");
        jcbInativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInativosActionPerformed(evt);
            }
        });

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

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnBusca.setToolTipText("");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        jtbSecoes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbSecoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbSecoesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbSecoes);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setText("Seções");

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

        lblTamanho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTamanho.setForeground(new java.awt.Color(204, 0, 0));
        lblTamanho.setText("Tamanho");

        try {
            txtTamanho.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTamanho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTamanhoKeyTyped(evt);
            }
        });

        jLabel1.setText("Registros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblReg, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel1))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jcbInativos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnVoltar))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitulo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTamanho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTamanho))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNome)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblStatus)
                                            .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblTamanho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnAlterar)
                    .addComponent(btnInativar)
                    .addComponent(btnLimpar)
                    .addComponent(btnExcluir))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusca)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblReg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar)
                    .addComponent(jcbInativos))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if (validarDados()==true)
        {
            guardarDados();
            secaoController secaoCon = new secaoController(objSecao);
            try
            {
                boolean alteracao = secaoCon.alterar();
                if (alteracao ==true)
                {
                    type=checkboxInativar();
                    atualizarTabela(type);
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Seção alterada com sucesso!", "Alterado", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar seção.", "ERRO", 'e');
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
        objSecao.setDt_inativado(formatacao.retornaDataAtual("yyyy-MM-dd"));
        secaoController secaoCon = new secaoController(objSecao);
        try
        {
            boolean inativacao = secaoCon.inativar();
            if (inativacao ==true)
            {
                type=checkboxInativar();
                atualizarTabela(type);
                CaixaDeDialogo.obterinstancia().exibirMensagem("Seção inativada com sucesso!", "Inativada", 'i');
            }
            else
            {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao inativar seção.", "ERRO", 'e');
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

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jcbInativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInativosActionPerformed
        // TODO add your handling code here:
        type =checkboxInativar();
        atualizarTabela(type);
    }//GEN-LAST:event_jcbInativosActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        guardarDados();
        secaoController secaoCon = new secaoController(objSecao);
        boolean escolha= CaixaDeDialogo.obterinstancia().pedirConfirmacao("Tem certeza que deseja excluir a seção?",
            "Excluir?", 'p');
        if (escolha==true)
        {
            try {
                boolean exclusao = secaoCon.excluir();
                if (exclusao == true) {
                    type = checkboxInativar();
                    atualizarTabela(type);
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Seção excluída com sucesso!", "Excluída", 'i');

                } else {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir seção.", "ERRO", 'e');
                }
            } catch (Exception e) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:
        secaoController secaoCon = new secaoController(null, jtbSecoes);
        type=checkboxInativar();
        secaoCon.preencherTabela(type,1,txtBusca.getText());
        countRegistros();
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void jtbSecoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbSecoesMouseClicked
        // TODO add your handling code here:
        int linha = jtbSecoes.getSelectedRow();
        id = (int) jtbSecoes.getModel().getValueAt(linha, 0);

        secaoController secaoCon = new secaoController();
        objSecao = secaoCon.buscar(id);
        preencherCampos(objSecao);

        int s=objSecao.getStatus();
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
    }//GEN-LAST:event_jtbSecoesMouseClicked

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        // TODO add your handling code here:
        if (validarDados()==true)
        {
            guardarInclusao();
            secaoController secaoCon = new secaoController(objSecao);
            try
            {
                boolean inclusao = secaoCon.incluir();
                if (inclusao ==true)
                {
                    type=checkboxInativar();
                    atualizarTabela(type);
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Seção inserida com sucesso!", "Inserida", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir seção.", "ERRO", 'e');
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

    private void txtTamanhoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTamanhoKeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtTamanhoKeyTyped

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        // TODO add your handling code here:
        int maximo = 50;
        if((txtNome.getText().length()>=maximo))
        {
            evt.consume();
            txtNome.setText(txtNome.getText().substring(0,maximo));
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void preencherCampos(Secao objSecao)
    {
        
        txtNome.setText(objSecao.getNome());
        objComboStatus.SetaComboBox(String.valueOf(objSecao.getStatus()));
        String tam;
        tam = formatacao.formataDecimal(objSecao.getTamanho());
        txtTamanho.setValue(tam);
    }
    
    private void limparCampos()
    {
      
        txtNome.setText("");
        objComboStatus.SetaComboBox("");
        txtTamanho.setValue("");
        
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
            secaoController secaoCon = new secaoController(null, jtbSecoes);
            secaoCon.preencherTabela(type,0,null);
            countRegistros();
        } 
        catch (Exception ex) 
        {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }

    private boolean validarDados() 
    {
        try 
        {
            secaoController secaoCon = new secaoController();
           if ((txtTamanho.isEditValid()) && (txtNome.getText().trim().length()>1))
            {
            return true;
            } else
           {
               return false;
           }
        } 
        catch (Exception ex) 
        {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
            return false;
        }
    }
    
    private void guardarDados() 
    {
        try 
        {
            objSecao = new Secao();
            objSecao.setId(id);
            objSecao.setNome(txtNome.getText());
            objSecao.setTamanho(Double.parseDouble(txtTamanho.getText()));

            Combos c = (Combos) jcbStatus.getSelectedItem();
            String status = c.getCodigo();
            objSecao.setStatus(Integer.parseInt(status));
        }
        catch(Exception ex)
        {
        CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
    }
    
    private void guardarInclusao() 
    {
        try 
        {
            objSecao = new Secao();
            objSecao.setNome(txtNome.getText());
            objSecao.setTamanho(Double.parseDouble(txtTamanho.getText()));

            Combos c = (Combos) jcbStatus.getSelectedItem();
            String status = c.getCodigo();
            objSecao.setStatus(Integer.parseInt(status));
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
     int count = jtbSecoes.getRowCount();
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
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable jtbSecoes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblReg;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTamanho;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}
