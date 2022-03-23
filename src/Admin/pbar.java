/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

/**
 *
 * @author Devin
 */

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.login2;
import static org.hsqldb.Library.user;


public class pbar extends javax.swing.JFrame {

    /**
     * Creates new form pbar
     */
    public pbar() {
        initComponents();
        colorChange();
        
        
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
                 percent.setText(String.valueOf(i)+"%");
                    jProgressBar1.setValue(i);
                    if(i<10){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Checking System");
                    }
                    else if(i<20){
                        try {
                            Thread.sleep(75);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Configuring Database");
                    }
                    else if(i<30){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Connecting");
                    }
                    else if(i<40){
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Creating Tables");
                    }
                    else if(i<50){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Loading....");
                    }
                    else if(i<60){
                        try {
                            Thread.sleep(75);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Creating Interfaces....");
                    }
                    else if(i<70){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Please Wait....");
                    }
                    else if(i<80){
                        try {
                            Thread.sleep(25);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Finalizing....");
                    }
                    else if(i<90){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Finalizing........");
                    }
                    else if(i==100){
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(pbar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        jLabel4.setText("Finalizing............");
                       loadLogin();
                    }
                    
                }
            }
            
        }).start();
		
    
        
        
        
        
        
        
        
        
        
        
        
        
    }
     private void colorChange(){
    
        this.jPanel1.setBackground(Color.black);
    }
    public void loadLogin(){
        
            login2 lg = new login2();
            lg.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        percent = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        jPanel1.setLayout(null);

        percent.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        percent.setText("jLabel2");
        jPanel1.add(percent);
        percent.setBounds(200, 130, 50, 20);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(10, 120, 420, 40);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 170, 190, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(pbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pbar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pbar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel percent;
    // End of variables declaration//GEN-END:variables
}
