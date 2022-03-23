/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leave_management_system;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hsqldb.Library.user;

/**
 *
 * @author Binara
 */
public class progessbar extends javax.swing.JFrame {

    
    public progessbar() 
    {
        initComponents();
        new Thread(new Runnable() {

            public void run() {
                setTitle("");
                String arr[]=  "L O A D I N G . . . . . .".split(" ");
                jProgressBar1.setBackground(Color.magenta);
                while (true){
                    for (int i = 0; i < arr.length; i++) {
                        try {
                            setTitle(getTitle()+arr[i]);
                            Thread.sleep(400);
                        } catch (Exception e) {
                        }
                        
                    }
                    setTitle("");
                }
            }

            
        }).start();
        
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet.");
                for(int i=0; i<=100;i++){
                    jProgressBar1.setValue(i);
                    if(i<10){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Checking System");
                    }
                    else if(i<20){
                        try {
                            Thread.sleep(75);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Configuring Database");
                    }
                    else if(i<30){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Connecting");
                    }
                    else if(i<40){
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Creating Tables");
                    }
                    else if(i<50){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Loading....");
                    }
                    else if(i<60){
                        try {
                            Thread.sleep(75);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Creating Interfaces....");
                    }
                    else if(i<70){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Please Wait....");
                    }
                    else if(i<80){
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Finalizing....");
                    }
                    else if(i<90){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Finalizing........");
                    }
                    else if(i==100){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(progessbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Finalizing............");
                        u();
                    }
                    
                }
            }
            
        }).start();
    }
    void u()
    {
        new login().setVisible(true);
        this.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Leave Management System");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 550, 50));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 420, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("1.0");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 190, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 280));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(progessbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(progessbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(progessbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(progessbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new progessbar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
