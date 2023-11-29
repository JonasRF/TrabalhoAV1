/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controleclient.cliente;

import ClientCommon.controller.ControladorLogin;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jonas
 */
public class MainView extends javax.swing.JFrame {


    public MainView()  {
   
        initComponents();
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     private ControladorLogin ctldLogin = new ControladorLogin();
    
     public void atualizaMenus(){
        mnuSignin.setEnabled(!true);
        mnuSignout.setEnabled(true);
        menuCadastro.setEnabled(true);
    }
     
     public void atualizaMenus01(){
        mnuSignin.setEnabled(!true);
        mnuSignout.setEnabled(true);
        menuCadastro.setEnabled(true);
        mnuVendedor.setEnabled(false);
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        mnuVendedor = new javax.swing.JMenuItem();
        mnuDepartamento = new javax.swing.JMenuItem();
        menuLogin = new javax.swing.JMenu();
        mnuSignin = new javax.swing.JMenuItem();
        mnuSignout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastro.setText("Cadastro");
        menuCadastro.setEnabled(false);

        mnuVendedor.setText("Vendedor");
        mnuVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVendedorActionPerformed(evt);
            }
        });
        menuCadastro.add(mnuVendedor);

        mnuDepartamento.setText("Departamento");
        mnuDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDepartamentoActionPerformed(evt);
            }
        });
        menuCadastro.add(mnuDepartamento);

        MenuBar.add(menuCadastro);

        menuLogin.setText("Login");

        mnuSignin.setText("SignIn");
        mnuSignin.setToolTipText("");
        mnuSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSigninActionPerformed(evt);
            }
        });
        menuLogin.add(mnuSignin);

        mnuSignout.setText("SignOut");
        mnuSignout.setEnabled(false);
        mnuSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSignoutActionPerformed(evt);
            }
        });
        menuLogin.add(mnuSignout);

        MenuBar.add(menuLogin);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSigninActionPerformed
       new LoginView().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuSigninActionPerformed

    private void mnuVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVendedorActionPerformed
        new SellerView().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_mnuVendedorActionPerformed

    private void mnuDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDepartamentoActionPerformed
        new DepartamentView().setVisible(rootPaneCheckingEnabled);// TODO add  your handling code here:
    }//GEN-LAST:event_mnuDepartamentoActionPerformed

    private void mnuSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSignoutActionPerformed
        mnuSignout.setEnabled(false);
        mnuSignin.setEnabled(true);
    }//GEN-LAST:event_mnuSignoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException{
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        String servidor = JOptionPane.showInputDialog(null,
                "Endereco do Servidor", "127.0.0.1");
        Socket s1 = new Socket(servidor, 332); // Porta 332  

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainView pf = new MainView();
                    pf.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuLogin;
    private javax.swing.JMenuItem mnuDepartamento;
    private javax.swing.JMenuItem mnuSignin;
    private javax.swing.JMenuItem mnuSignout;
    private javax.swing.JMenuItem mnuVendedor;
    // End of variables declaration//GEN-END:variables
}