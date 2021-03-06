/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controllers.movController;
import estoque.CaixaDeDialogo;
import estoque.Principal;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import models.Movimentacao;
import tools.Combos;
import tools.formatacao;
/**
 *
 * @author nmpetry
 */
public class viewMovimentacao extends javax.swing.JFrame {
Combos objComboProduto;
Movimentacao objMovimentacao;
    /**
     * Creates new form viewMovimentacao
     */
    public viewMovimentacao() {
        initComponents();
        try 
        {
         objComboProduto = new Combos(jcbProduto);
         objComboProduto.PreencheCombo("SELECT id, nome FROM produtos WHERE status=1 ORDER BY nome",1);
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

        groupOperacao = new javax.swing.ButtonGroup();
        lblTitulo = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        jcbProduto = new javax.swing.JComboBox<>();
        lblVlunit = new javax.swing.JLabel();
        txtVlunit = new javax.swing.JFormattedTextField();
        lbOpercao = new javax.swing.JLabel();
        jrbEntrada = new javax.swing.JRadioButton();
        jrbSaida = new javax.swing.JRadioButton();
        lblQntd = new javax.swing.JLabel();
        txtQntd = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        lblQntdAtual = new javax.swing.JLabel();
        txtQntdAtual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 400));
        setSize(new java.awt.Dimension(400, 400));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setText("Movimentações");

        lblProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblProduto.setForeground(new java.awt.Color(204, 0, 0));
        lblProduto.setText("Produto:");

        jcbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbProdutoItemStateChanged(evt);
            }
        });

        lblVlunit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVlunit.setForeground(new java.awt.Color(204, 0, 0));
        lblVlunit.setText("Valor p/ \nunidade:");

        try {
            txtVlunit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVlunit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVlunitKeyTyped(evt);
            }
        });

        lbOpercao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbOpercao.setForeground(new java.awt.Color(204, 0, 0));
        lbOpercao.setText("Operação:");

        groupOperacao.add(jrbEntrada);
        jrbEntrada.setText("Entrada");

        groupOperacao.add(jrbSaida);
        jrbSaida.setText("Saída");

        lblQntd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQntd.setForeground(new java.awt.Color(204, 0, 0));
        lblQntd.setText("Quantidade:");

        txtQntd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQntdKeyTyped(evt);
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

        btnOk.setBackground(new java.awt.Color(51, 153, 255));
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sign-check.png"))); // NOI18N
        btnOk.setText("OK");
        btnOk.setBorderPainted(false);
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        lblQntdAtual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblQntdAtual.setForeground(new java.awt.Color(204, 0, 0));
        lblQntdAtual.setText("Quantidade atual:");

        txtQntdAtual.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVlunit)
                            .addComponent(txtVlunit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblProduto)
                                    .addGap(143, 143, 143))
                                .addComponent(jcbProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblQntdAtual)
                            .addComponent(txtQntdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQntd)
                                    .addComponent(txtQntd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(288, 288, 288))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lbOpercao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))
                                    .addComponent(jrbSaida)
                                    .addComponent(jrbEntrada))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(193, 193, 193)
                        .addComponent(btnOk)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQntd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQntd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVlunit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVlunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblQntdAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQntdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVoltar)
                            .addComponent(btnOk)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbOpercao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jrbEntrada)
                            .addGap(24, 24, 24))
                        .addComponent(jrbSaida)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtVlunitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVlunitKeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtVlunitKeyTyped

    private void txtQntdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQntdKeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+""))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtQntdKeyTyped

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        if (validarCampos() == true)
        {
            guardaDados();
            movController mov = new movController();
            try 
            {
                boolean inclusao = mov.incluir(objMovimentacao);
                if (inclusao == true)
                {
                    limparCampos();
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Movimentação feita com sucesso!", "SUCESSO", 'i');
                }
                else
                {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro na movimentação.", "ERRO", 'e');
                }
            }
            catch (Exception e)
            {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + e.getMessage());
            }
        }
        else
        {
                CaixaDeDialogo.obterinstancia().exibirMensagem("É necessário preencher todos os campos!", "CAMPOS!", 'e');

        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void jcbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbProdutoItemStateChanged
        // TODO add your handling code here:   
        preencherQntdAtual();
    }//GEN-LAST:event_jcbProdutoItemStateChanged

public void preencherQntdAtual()
{
          if (jcbProduto != null && jcbProduto.getSelectedIndex()>0)
        {
            Combos com = (Combos) jcbProduto.getSelectedItem();
            if(com != null){
                String prod = com.getCodigo();
                int id=Integer.parseInt(prod);
                movController mov = new movController();
                 int qntd_atual = mov.buscarQuantidadeAtual(id);
                 txtQntdAtual.setText(String.valueOf(qntd_atual));
            }
        }  
}

public boolean validarCampos()
{
          try {
            int produto = jcbProduto.getSelectedIndex();
           if ((txtVlunit.isEditValid()) && (txtQntd.getText().trim().length()>0) && 
                   (groupOperacao.getSelection()!=null) && (produto!=0))
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

public void limparCampos()
{
    objComboProduto.SetaComboBox("");
    txtQntd.setText("");
    txtQntdAtual.setText("");
    txtVlunit.setValue("");
}

public void guardaDados()
{
    try 
        {
            objMovimentacao = new Movimentacao();
            objMovimentacao.setDtmov(formatacao.retornaDataAtual("yyyy-MM-dd"));
            if (jrbEntrada.isSelected())
            {
            objMovimentacao.setOperacao('E');
            }
            else
            {
                if (jrbSaida.isSelected())
                {
                    objMovimentacao.setOperacao('S');
                }
            }
            objMovimentacao.setQntd(Integer.parseInt(txtQntd.getText()));
            objMovimentacao.setVlunit(Double.parseDouble(txtVlunit.getText()));
            Combos c = (Combos) jcbProduto.getSelectedItem();
            String prod = c.getCodigo();
            objMovimentacao.setCodprod(Integer.parseInt(prod));
        }
        catch (Exception ex)
        {
         CaixaDeDialogo.obterinstancia().exibirMensagem("Problemas no guardaDados: " + ex.getMessage());
        }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup groupOperacao;
    private javax.swing.JComboBox<String> jcbProduto;
    private javax.swing.JRadioButton jrbEntrada;
    private javax.swing.JRadioButton jrbSaida;
    private javax.swing.JLabel lbOpercao;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQntd;
    private javax.swing.JLabel lblQntdAtual;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVlunit;
    private javax.swing.JTextField txtQntd;
    private javax.swing.JTextField txtQntdAtual;
    private javax.swing.JFormattedTextField txtVlunit;
    // End of variables declaration//GEN-END:variables
}
