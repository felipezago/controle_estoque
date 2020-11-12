/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lz.view;

import br.com.lz.dao.ClientesDAO;
import br.com.lz.dao.ProdutosDAO;
import br.com.lz.dao.VeiculoDAO;
import br.com.lz.domain.Clientes;
import br.com.lz.domain.Veiculo;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalBorders;

/**
 *
 * @author felip
 */
public class CadastroClientes extends javax.swing.JFrame {

    /**
     * Creates new form CadCli
     */
    List<Veiculo> lista= new ArrayList<>();
    int id;
    boolean salvar= true;
    
    public CadastroClientes() {
        initComponents();
        setLocationRelativeTo(null);
        preencheCombo();
        setResizable(false);
    }
    
    public CadastroClientes(Clientes c) {
        initComponents();
        setLocationRelativeTo(null);
        id= c.getId();
        salvar= false;
        preencherCampos(c);
        preencheCombo();
    }
    
    public final void preencheCombo(){
        try{      
           cbVeic.removeAllItems();
           cbVeic.addItem("SELECIONE O VEICULO");
           lista = VeiculoDAO.pesquisar();
           for(Veiculo f: lista){
               cbVeic.addItem(f.getNome()+" - "+f.getPlaca());
           }           
        }catch(SQLException e){
            System.out.println("Erro ao inserir dados na ComboBox");
        }      
    }
    
    public final void preencheComboT(){
        try{      
           cbVeic.removeAllItems();
           cbVeic.addItem("SELECIONE O VEICULO");
           lista = VeiculoDAO.pesquisar();
           for(Veiculo f: lista){
               cbVeic.addItem(f.getNome()+" - "+f.getPlaca());
               cbVeic.setSelectedItem(f.getNome()+" - "+f.getPlaca());
           }           
        }catch(SQLException e){
            System.out.println("Erro ao inserir dados na ComboBox");
        }      
    }
    
    public Clientes retornaObjeto(){
        Clientes c= new Clientes();
        
        c.setCidade(txCidade.getText());
        c.setContato(txContato.getText());
        c.setCpfcnpj(txCpf.getText());
        c.setEmail(txEmail.getText());
        c.setEstado(txEstado.getText());
        c.setId(id);
        c.setNome(txNome.getText());
        Veiculo veiculoSelec= lista.get(cbVeic.getSelectedIndex()-1);
        c.setVeiculo(veiculoSelec);
        
        return c;
    }
    
    private void preencherCampos(Clientes c) {       
        
        txNome.setText(c.getNome());
        txContato.setText(c.getContato());
        txCpf.setText(c.getCpfcnpj());
        cbVeic.setSelectedItem(c.getVeiculo().getNome());
        txCidade.setText(c.getCidade());
        txEstado.setText(c.getEstado());
        txEmail.setText(c.getEmail());
        //cbVeic.setSelectedItem(c.getVeiculo().getNome()+" - "+c.getVeiculo().getPlaca());
        cbVeic.setSelectedIndex(c.getVeiculo().getId());
                
    }
    
    public boolean validaCampos(){
        boolean validador;
        validador= true;
        
        txNome.setText(txNome.getText().trim());
        
        if(txContato.getText().equals("")){
            validador = false;
            txContato.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Preencher campos obrigatorios");
        }else{
            txContato.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if(txNome.getText().equals("")){
            validador = false;
            txNome.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Preencher campos obrigatorios");
        }else{
            txNome.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if(txCpf.getText().equals("")){
            validador = false;
            txCpf.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Preencher campos obrigatorios");
        }else{
            txCpf.setBorder(MetalBorders.getTextFieldBorder());
        }
        
        if(txEmail.getText().equals("")){
            validador = false;
            txEmail.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Preencher campos obrigatorios");
        }else{
            txEmail.setBorder(MetalBorders.getTextFieldBorder());
        }
        
         if(txEstado.getText().equals("")){
            validador = false;
            txEstado.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Preencher campos obrigatorios");
        }else{
            txEstado.setBorder(MetalBorders.getTextFieldBorder());
        }

        if(txCidade.getText().equals("")){
            validador = false;
            txCidade.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Preencher campos obrigatorios");
        }else{
            txCidade.setBorder(MetalBorders.getTextFieldBorder());
        }
            
        return validador;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        txContato = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txCpf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbVeic = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        txCidade = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txEstado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");
        setPreferredSize(new java.awt.Dimension(868, 300));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(868, 320));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Nome:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Contato (Fone):");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("CPF/CNPJ:");

        cbVeic.setForeground(new java.awt.Color(0, 51, 102));
        cbVeic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Veiculo:");

        btnSalvar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(0, 51, 102));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarbtnSalvarActionPerformed(evt);
            }
        });

        btnVoltar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(0, 51, 102));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarbtnVoltarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Email:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 102));
        jLabel13.setText("Cidade:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("Estado:");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCidade)
                            .addComponent(txCpf)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(txEmail)
                            .addComponent(txContato))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txContato, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbVeic, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarbtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarbtnSalvarActionPerformed
        if(validaCampos()){
            try{
                if(salvar){
                    ClientesDAO.inserir(retornaObjeto());
                    txCidade.setText("");
                    txContato.setText("");
                    txNome.setText("");
                    txEmail.setText("");
                    txCpf.setText("");
                    txEstado.setText("");
                    cbVeic.setSelectedItem("SELECIONE O VEICULO");
                    
                    JOptionPane.showMessageDialog(null, "Registro Salvo");
                    
                }else{
                    ClientesDAO.alterar(retornaObjeto());
                    txCidade.setText("");
                    txContato.setText("");
                    txNome.setText("");
                    txEmail.setText("");
                    txCpf.setText("");
                    txEstado.setText("");
                    
                    JOptionPane.showMessageDialog(null, "Registro Salvo");
                    new VisualizaProdutos();
                    this.dispose();
                    
                }
            }catch(SQLException ex){
                    System.out.println("Erro ao persistir no Banco de dados");
                    ex.printStackTrace();
                           
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Por favor, digite um valor válidos para os campos Estoque ou Valor");
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Por favor, Selecione um veículo!");

            }
        }
    }//GEN-LAST:event_btnSalvarbtnSalvarActionPerformed

    private void btnVoltarbtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarbtnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarbtnVoltarActionPerformed

    private void jButton1jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1jButton1ActionPerformed
        CadastroVeiculo c= new CadastroVeiculo();
        c.setVisible(true);
        
    }//GEN-LAST:event_jButton1jButton1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
        preencheCombo();
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbVeic;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txCidade;
    private javax.swing.JTextField txContato;
    private javax.swing.JTextField txCpf;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txEstado;
    private javax.swing.JTextField txNome;
    // End of variables declaration//GEN-END:variables
}
