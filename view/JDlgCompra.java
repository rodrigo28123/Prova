/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CompraProdutoRal;
import bean.CompraRal;
import bean.FornecedorRal;
import bean.FuncionarioRal;
import dao.CompraDAO;
import dao.CompraProdutoDAO;
import dao.FornecedorDAO;
import dao.FuncionarioDAO;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;
import view.controle.CompraProdutosControle;

/**
 *
 * @author u07679183120
 */
public class JDlgCompra extends javax.swing.JDialog {
    
    MaskFormatter mascaraData;
    
    
private boolean incluindo;
public CompraRal compra;
private CompraDAO compraDAO;
CompraProdutosControle compraProdutosControle;
JDlgCompraProdutoPesquisar compraProdutoPesquisar;


    /**
     * Creates new form JDlgUsuario
     */
    public JDlgCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
          initComponents();
        setTitle("Compra");
        habilitar(false);
        setLocationRelativeTo(null);
        compraDAO = new CompraDAO();
        List lista = new ArrayList();
        
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List listaFor = fornecedorDAO.listAll();
        for (int i = 0; i < listaFor.size(); i++) {
            jCboFornecedor.addItem(((FornecedorRal) listaFor.get(i)));
        }
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List listaVend = funcionarioDAO.listAll();
        for (int i = 0; i < listaVend.size(); i++) {
            jCboFuncionario.addItem(((FuncionarioRal) listaVend.get(i)));
        }
        compraProdutosControle = new CompraProdutosControle();
       compraProdutosControle.setList(lista);
        jTable1.setModel(compraProdutosControle);
        
        
        
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraData)); 
    }
    

    
    
    
    
    
    
    public void habilitar(boolean valor) {
        Util.habilitar(valor, jTxtNumCompra, jFmtData, jCboFornecedor, jCboFuncionario, jTxtTotal, jTxtNotaFiscal, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(valor, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        Util.habilitar(!valor, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }

    public CompraRal viewBean() {
        CompraRal compra = new CompraRal();
        compra.setIdcompraRal(Integer.parseInt(jTxtNumCompra.getText()));
        compra.setDataCompraRal(Util.strDate(jFmtData.getText()));
        compra.setFornecedorRal((FornecedorRal) jCboFornecedor.getSelectedItem());
        compra.setFuncionarioRal((FuncionarioRal) jCboFuncionario.getSelectedItem());
        compra.setCompraTotalRal(Util.strDouble(jTxtTotal.getText()));
        compra.setNotaFiscalRal(jTxtNotaFiscal.getText());
        return compra;
    }

    public void beanView(CompraRal compra) {
        jTxtNumCompra.setText(String.valueOf(compra.getIdcompraRal()));
        jFmtData.setText(Util.dateStr(compra.getDataCompraRal()));
        jCboFornecedor.setSelectedItem(compra.getFornecedorRal());
        jCboFuncionario.setSelectedItem(compra.getFuncionarioRal());
        jTxtTotal.setText(String.valueOf(compra.getCompraTotalRal()));
        jTxtNotaFiscal.setText(compra.getNotaFiscalRal());
        CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();
            List listaProd = (List) compraProdutoDAO.ListProdutos(compra);

        compraProdutosControle.setList(listaProd);
        jTable1.setModel(compraProdutosControle);
    }

    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTxtTotal = new javax.swing.JTextField();
        jCboFornecedor = new javax.swing.JComboBox<FornecedorRal>();
        jCboFuncionario = new javax.swing.JComboBox<FuncionarioRal>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtNumCompra = new javax.swing.JTextField();
        jFmtData = new javax.swing.JFormattedTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jTxtNotaFiscal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jCboFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCboFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboFornecedorActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Data");

        jLabel3.setText("Fornecedor");

        jLabel4.setText("Funcionario");

        jLabel7.setText("Total");

        jTxtNumCompra.setText(" ");

        jFmtData.setText(" ");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Exluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        jLabel8.setText("Nota Fiscal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnAlterarProd)
                            .addComponent(jBtnIncluirProd)
                            .addComponent(jBtnExcluirProd)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTxtNumCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jCboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTxtNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTxtNumCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)))
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnIncluir)
                            .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnExcluir))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
//        if(compra != null){
//            if(Util.perguntar("deseja excluir a compra ?") == true){
//                CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();
//                CompraProdutoRal compraProduto;
//                for (int linha = 0; linha < jTable1.getRowCount(); linha++){
//                    compraProduto = compraProdutosControle.getBean(linha);
//                    compraProdutoDAO.delete(compraProduto);
//                }
//                compraDAO.delete(compra);
//            }
//            
//        }else{
//        Util.mensagem("Deve ser realizada uma pesquisa antes");
//        }
        
       if (Util.perguntar("Deseja excluir a compra ?") == true){
       for (int i = 0; i < jTable1.getRowCount(); i++){
       
       compraDAO.delete(compraProdutosControle.getList(i));
       
       
       }
       }
       else{
         Util.mensagem("Compra não excluida");
               };
       
       
       
        
        
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
       habilitar(false);
        Util.limparCampo(jTxtNumCompra, jFmtData, jCboFornecedor, jCboFuncionario, jTxtTotal, jTxtNotaFiscal);
        compraProdutosControle.setList(new ArrayList());
        compra = null;

    }//GEN-LAST:event_jBtnCancelarActionPerformed

    
    
    
    ////////////////////////////////
    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        int linha = jTable1.getSelectedRow();
        if (linha == -1) {
            Util.mensagem("Nenhuma linha selecionada");
        } else {
            if (Util.perguntar("Confirma exclusão do produto?") == true) {
                compraProdutosControle.removeBean(linha);
            }
        }

//    int linSel = jTable1.getSelectedRow();
//        compraProdutosControle.removeBean(linSel);
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
         Util.limparCampo(jTxtNumCompra, jFmtData, jCboFornecedor, jCboFuncionario, jTxtTotal, jTxtNotaFiscal);
        habilitar(true);
          compraProdutosControle.setList(new ArrayList());
        jTxtNumCompra.grabFocus();
        incluindo = true;
        compra = new CompraRal();
        
        
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
//       if (compra != null) {
//            habilitar(true);
//            incluindo = false;
//        } else {
//            Util.mensagem("Deve ser realizada uma pesquisa antes");
//        } 
//       

if (compra != null){
            Util.habilitar(true, jFmtData, jTxtNumCompra, jTxtTotal, jCboFornecedor, jCboFuncionario, jTxtNotaFiscal
                , jBtnConfirmar, jBtnCancelar,jBtnAlterarProd, jBtnExcluirProd, jBtnIncluirProd);
            Util.habilitar(false, jBtnAlterar, jBtnExcluir, jBtnIncluir, jBtnPesquisar);
            incluindo = false;
        } else {
            Util.mensagem("Deve ser feita uma pesquisa antes");
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed
//////////////////////////
    
    
    
    
    
    
    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
         compra = viewBean();
        if (incluindo == true) {
            compraDAO.insert(compra);
            CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();
            CompraProdutoRal compraProduto;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                compraProduto = compraProdutosControle.getBean(linha);
                compraProduto.setCompraRal(compra);
                compraProdutoDAO.insert(compraProduto);
            }
        } else {
            compraDAO.update(compra);
            //remover todos os pedidos produtos deste pedido

            //incluir todos os pedidosProduto que estao no jtable
            CompraProdutoDAO compraProdutoDAO = new CompraProdutoDAO();
            CompraProdutoRal compraProdutos;
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                compraProdutos = compraProdutosControle.getBean(linha);
                compraProdutos.setCompraRal(compra);
                compraProdutoDAO.insert(compraProdutos);
            }
        }
        habilitar(false);
        Util.limparCampo(jTxtNumCompra, jFmtData, jCboFornecedor, jCboFuncionario, jTxtTotal, jTxtNotaFiscal);
        compraProdutosControle.setList(new ArrayList());

        compra = null;
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        JDlgCompraPesquisar jDlgCompraPesquisar = new JDlgCompraPesquisar(null, true);
        jDlgCompraPesquisar.setTelaAnterior(this);
        jDlgCompraPesquisar.setVisible(true);
        compra = new CompraRal();
             
        
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
          JDlgCompraProduto jDlgCompraProduto = new JDlgCompraProduto(null, true);
        jDlgCompraProduto.setTitle("inclusão de produtos");
        jDlgCompraProduto.setTelaAnterior(this);
        jDlgCompraProduto.setVisible(true);
        
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        JDlgCompraProduto jDlgCompraProduto = new JDlgCompraProduto(null, true);
        jDlgCompraProduto.setTitle("Alteração de produtos");
        jDlgCompraProduto.setTelaAnterior(this);
        int linSel = jTable1.getSelectedRow();
        CompraProdutoRal compraProduto = (CompraProdutoRal) compraProdutosControle.getBean(linSel);
        jDlgCompraProduto.beanView(compraProduto);
        jDlgCompraProduto.setVisible(true);
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jCboFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboFornecedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCompra dialog = new JDlgCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<FornecedorRal> jCboFornecedor;
    private javax.swing.JComboBox<FuncionarioRal> jCboFuncionario;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNotaFiscal;
    private javax.swing.JTextField jTxtNumCompra;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}
