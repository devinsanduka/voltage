/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package I_manager;

import Admin.Administrator;
import connections.DB_Connect;
import homes.Home_Ad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import net.proteanit.sql.DbUtils;
import login.login2;
import about_us.AboutUs;
import java.sql.Statement;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author chathura93
 */
public class InventoryManager extends javax.swing.JFrame {

    /**
     * Creates new form InventoryManager
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    
    public InventoryManager() {
        initComponents();
        con = DB_Connect.getConnection();
             
        cat_tableload();
        indent_tableload();
        supp_tableload();
        item_tableload();
        order_tableload();
        
         try {
             item_indnt();
             indntBox();
             itemcat();
             sitem_manager();
             //comuserid();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /* public void comuserid()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT User_Type_Name FROM user_type";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
           order_uid2.addItem(rs1.getString(1));
           
         
        }
    }*/
    
    
    
     public void item_indnt()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Item_Name FROM item";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            item_id.addItem(rs1.getString(1));
           
           
        }
    }
    
    
     public void sitem_manager()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Item_Name FROM item";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            itemname.addItem(rs1.getString(1));
           
        }
    }
    
    
    
    
      public void itemcat()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Category_Name FROM category";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            i_cat.addItem(rs1.getString(1));
            item_cat.addItem(rs1.getString(1));
        }
    }
    
    
    
    
     public void indntBox()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Supplier_Name FROM supplier";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            sup_id.addItem(rs1.getString(1));
            s_id.addItem(rs1.getString(1));
        }
    }
    
    
    
    
        
   public void supp_tableload(){
       
       String sql = "SELECT * from supplier";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            supp_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
   }
   
   public void item_tableload(){
   
       String sql = "SELECT * from item";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
    
    
    
    
    
    
    public void cat_tableload(){
        try {
            
            String sql = "SELECT * FROM category";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            cat_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void indent_tableload(){
        try {
            
            String sql = "SELECT * FROM indent";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            indent_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void order_tableload(){
        try {
            
            String sql = "SELECT * FROM orders";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            order_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        to1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        to2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        itemstat = new javax.swing.JComboBox();
        jButton16 = new javax.swing.JButton();
        item_cat = new javax.swing.JComboBox();
        itemname = new javax.swing.JComboBox();
        reportR1 = new javax.swing.JTextField();
        reportR2 = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        i_name = new javax.swing.JTextField();
        i_price = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        i_qty = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        i_stat = new javax.swing.JComboBox();
        i_id = new javax.swing.JLabel();
        i_cat = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        item_table = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cat_table = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cat_id = new javax.swing.JTextField();
        cat_name = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        st = new javax.swing.JComboBox();
        jButton24 = new javax.swing.JButton();
        in_date = new com.toedter.calendar.JDateChooser();
        jButton25 = new javax.swing.JButton();
        s_id = new javax.swing.JComboBox();
        jButton31 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        idate1 = new com.toedter.calendar.JDateChooser();
        idate2 = new com.toedter.calendar.JDateChooser();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        indent_table = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        indnt_cal = new com.toedter.calendar.JDateChooser();
        indt_status = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        Quantity = new javax.swing.JLabel();
        indnt_qty = new javax.swing.JTextField();
        indt_id = new javax.swing.JLabel();
        sup_id = new javax.swing.JComboBox();
        total = new javax.swing.JLabel();
        item_id = new javax.swing.JComboBox();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        sup_name = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        supp_table = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        supp_id = new javax.swing.JTextField();
        supp_name = new javax.swing.JTextField();
        supp_add = new javax.swing.JTextField();
        supp_tel = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        supp_email = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        order_cid2 = new javax.swing.JTextField();
        jButton42 = new javax.swing.JButton();
        order_iid2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        order_date2 = new com.toedter.calendar.JDateChooser();
        order_status2 = new javax.swing.JComboBox();
        jButton26 = new javax.swing.JButton();
        order_uid2 = new javax.swing.JComboBox();
        order_pm2 = new javax.swing.JComboBox();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButton47 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        order_table = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel12.setText("Item Name");

        jLabel13.setText("Category Name");

        jLabel14.setText("Price Range");

        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        to1.setText("0");

        jLabel15.setText("to");

        to2.setText("1000");

        jLabel16.setText("Status");

        itemstat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Out Of Stock", "Available" }));
        itemstat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemstatActionPerformed(evt);
            }
        });

        jButton16.setText("Display All");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        item_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        itemname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        reportR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportR1ActionPerformed(evt);
            }
        });

        jButton32.setText("pReport");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton29.setText("iReport");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel40.setText("between");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(item_cat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemname, 0, 156, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemstat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16)))
                .addGap(66, 66, 66)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton32))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 256, Short.MAX_VALUE)
                        .addComponent(reportR1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(reportR2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(itemstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(item_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton32)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jButton16)
                    .addComponent(jLabel40)
                    .addComponent(reportR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel23.setText("Item ID");

        jLabel24.setText("Category");

        jLabel25.setText("Item Name");

        jLabel26.setText("Item Price");

        i_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i_nameActionPerformed(evt);
            }
        });

        jLabel27.setText("Item Qty");

        jLabel28.setText("Status");

        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Clear");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        i_stat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Out Of Stock", "Available" }));

        i_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(i_name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(34, 34, 34)
                        .addComponent(i_price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(i_id, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(i_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addGap(34, 34, 34)
                        .addComponent(jButton14)))
                .addGap(184, 184, 184))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel27)
                    .addComponent(i_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel28)
                    .addComponent(i_stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(i_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(i_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(i_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        item_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Category ID", "Item Name", "Price", "Item Qty", "Item Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        item_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(item_table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jTabbedPane1.addTab("Items Manager", jPanel3);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        cat_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Category ID", "Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cat_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cat_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(cat_table);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel37.setText("Category ID");

        jLabel38.setText("Category Name");

        jButton20.setText("Add");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("Update");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("Delete");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("Clear");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(46, 46, 46)
                        .addComponent(cat_id, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(cat_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jButton20)
                        .addGap(34, 34, 34)
                        .addComponent(jButton21)
                        .addGap(33, 33, 33)
                        .addComponent(jButton22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton23)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(cat_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cat_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21)
                    .addComponent(jButton22)
                    .addComponent(jButton23))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Category Manager", jPanel16);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel49.setText("Supplier");

        jLabel50.setText("On Date");

        jLabel51.setText("Status");

        st.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Confirmed", "Pending", " " }));

        jButton24.setText("Search");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Display All");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        s_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        jButton31.setText("pReport");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton28.setText("iReport");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51))
                .addGap(24, 24, 24)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton25)))
                    .addComponent(in_date, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(idate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(idate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton31)))
                .addGap(59, 59, 59))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28)
                            .addComponent(jButton31))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jButton25)
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50)
                            .addComponent(in_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(jButton24))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        indent_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Indent ID", "Supplier ID", "Item ID", "Quantity", "On Date", "Total", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        indent_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                indent_tableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(indent_table);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel52.setText("Indent ID");

        jLabel53.setText("Supplier ID");

        jLabel54.setText("On Date");

        jLabel55.setText("Total");

        jLabel56.setText("Status");

        jButton33.setText("Add");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("Update");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setText("Delete");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("Clear");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        indt_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Confirmed", "Pending" }));

        jLabel2.setText("Item ID");

        Quantity.setText("Quantity");

        sup_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        item_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(46, 46, 46)))
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(indt_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sup_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(item_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)
                                .addComponent(indt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Quantity)
                                    .addComponent(jLabel54))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(indnt_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(indnt_qty)))))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jButton33)
                        .addGap(33, 33, 33)
                        .addComponent(jButton34)
                        .addGap(27, 27, 27)
                        .addComponent(jButton35)
                        .addGap(47, 47, 47)
                        .addComponent(jButton36)))
                .addContainerGap(585, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel52)
                        .addComponent(indt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(indt_id))
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(Quantity)
                        .addComponent(indnt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sup_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel54)
                        .addComponent(item_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(indnt_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(total))
                .addGap(33, 33, 33)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(jButton34)
                    .addComponent(jButton35)
                    .addComponent(jButton36))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Indent Manager", jPanel19);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel57.setText("Supplier Name");

        jButton37.setText("Search");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton18.setText("Display All");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(24, 24, 24)
                .addComponent(sup_name, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton37)
                .addGap(66, 66, 66)
                .addComponent(jButton18)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(sup_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37)
                    .addComponent(jButton18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        supp_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "Supplier Name", "Address", "Telephone", "Emai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supp_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supp_tableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(supp_table);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel58.setText("Supplier ID");

        jLabel59.setText("Supplier Name");

        jLabel60.setText("Address");

        jLabel61.setText("Telephone");

        supp_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supp_nameActionPerformed(evt);
            }
        });

        jLabel62.setText("Email");

        jButton38.setText("Add");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Update");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setText("Delete");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setText("Clear");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel58))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supp_id, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(supp_name)
                            .addComponent(supp_add)
                            .addComponent(supp_tel))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel62))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jButton38)
                        .addGap(47, 47, 47)
                        .addComponent(jButton39)
                        .addGap(33, 33, 33)
                        .addComponent(jButton40)))
                .addGap(43, 43, 43)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton41)
                    .addComponent(supp_email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(supp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(supp_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(supp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(supp_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(supp_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton38)
                    .addComponent(jButton39)
                    .addComponent(jButton40)
                    .addComponent(jButton41))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );

        jTabbedPane1.addTab("Supplier Manager", jPanel25);

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel63.setText("User ID");

        jLabel64.setText("Customer ID");

        jLabel65.setText("Item ID");

        jButton42.setText("Search");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jLabel66.setText("Payment Method");

        jLabel67.setText("Status");

        jLabel30.setText("Date");

        order_status2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Confirmed", "Pending", "Canceled" }));

        jButton26.setText("Display All");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        order_uid2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Sales Manager", "Salesmen" }));

        order_pm2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "cash", "cheque", "credit card" }));

        jButton47.setText("pReport");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton27.setText("iReport");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addGap(24, 24, 24)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(order_cid2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(order_iid2)
                    .addComponent(order_uid2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addComponent(jLabel67)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(order_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jButton42))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(order_status2, 0, 150, Short.MAX_VALUE)
                            .addComponent(order_pm2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton26)))
                .addGap(18, 18, 18)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton47))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel30Layout.createSequentialGroup()
                                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel63)
                                        .addComponent(order_uid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11)
                                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel64)
                                        .addComponent(order_cid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jButton27))
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton47)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton42, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(order_iid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30))
                            .addComponent(jLabel65)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jButton26)
                            .addComponent(order_pm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(order_status2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(order_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        order_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "User ID", "Customer ID", "Item ID", "Qty", "Date", "Payment Method", "Total Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        order_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_tableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(order_table);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order Manager", jPanel29);

        jMenu3.setText("File");

        jMenuItem1.setText("Logout");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("About");

        jMenuItem3.setText("About Us");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String i_name1 = itemname.getSelectedItem().toString();
        String categoryid = item_cat.getSelectedItem().toString();
        String i_stat1 = itemstat.getSelectedItem().toString();
        String to_1 = to1.getText();
        String to_2 = to2.getText();
         
   
        try {
           
           if(categoryid.equals("All")){
           
                if(i_stat1.equals("All") && i_name1.equals("All")){
            
            String sql = "SELECT * FROM item WHERE  (Item_Price between '"+to_1 +"' and '"+ to_2+"')" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));  
                
            }else if(i_stat1.equals("All")){
            
            String sql = "SELECT * FROM item WHERE Item_Name ='"+i_name1 +"'  AND (Item_Price between '"+to_1 +"' and '"+ to_2+"')" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } else if(i_name1.equals("All")){ 
            
            
            String sql = "SELECT * FROM item WHERE  Item_Status='"+i_stat1+"' AND Item_Price between '"+to_1 +"' and '"+ to_2+"'" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
          
        
            } else{ 
            
            
            String sql = "SELECT * FROM item WHERE Item_Name ='"+i_name1 +"'  AND Item_Status='"+i_stat1+"' AND Item_Price between '"+to_1 +"' and '"+ to_2+"'" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
           
        
            }
           
           
           
           
           
           
           }else{
           
                if(i_stat1.equals("All") && i_name1.equals("All")){
            
            String sql = "SELECT * FROM item WHERE  Category_Name LIKE '%"+categoryid+"%' AND (Item_Price between '"+to_1 +"' and '"+ to_2+"')" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }else if(i_stat1.equals("All")){
            
            String sql = "SELECT * FROM item WHERE Item_Name ='"+i_name1 +"' AND Category_Name LIKE '%"+categoryid+"%'   AND (Item_Price between '"+to_1 +"' and '"+ to_2+"')" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } else if(i_name1.equals("All")){ 
            
            
            String sql = "SELECT * FROM item WHERE  Category_Name = '"+categoryid+"' AND Item_Status='"+i_stat1+"' AND Item_Price between '"+to_1 +"' and '"+ to_2+"'" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        
            }else{ 
            
            
            String sql = "SELECT * FROM item WHERE Item_Name ='"+i_name1+"' AND Category_Name = '"+categoryid+"' AND Item_Status='"+i_stat1+"' AND Item_Price between '"+to_1 +"' and '"+ to_2+"'" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        
            }
           
           
           
           }  
          
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void itemstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemstatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemstatActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String sql = "SELECT * FROM item";

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            item_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void i_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_i_nameActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

       
        String categoryid = i_cat.getSelectedItem().toString();
        String itemname = i_name.getText();
        float itemprice = Float.parseFloat(i_price.getText());
        int itemqty = Integer.parseInt(i_qty.getText());
        String itemstat = i_stat.getSelectedItem().toString();

       

        try{
            // String q = "INSERT INTO user (User_ID,Type_ID,Username,Password,Name,Address,Phone,Email) values('"+userid+"','"+athr+"','"+username+"','"+password+"','"+u_name+"','"+address+"','"+telephone+"','"+eml+"')";
            String q = "INSERT INTO item values('"+categoryid+"','"+itemname+"','"+itemprice+"','"+itemqty+"','"+itemstat+"')";
            pst = con.prepareStatement(q);
            pst.execute();

            item_tableload();

        }catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you really want to update this field? ");

        String itemid = i_id.getText();
        String categoryid = i_cat.getSelectedItem().toString();
        String itemname2 = i_name.getText();
        float itemprice = Float.parseFloat(i_price.getText());
        int itemqty = Integer.parseInt(i_qty.getText());
        String itemstat2 = i_stat.getSelectedItem().toString();
        
        

        String sql = "UPDATE item set Category_Name = '"+ categoryid+"',Item_Name = '"+ itemname2+"',Item_Price = '"+itemprice+"',Item_Qty = '"+itemqty+"',Item_Status = '"+ itemstat2+"' WHERE Item_ID = '"+itemid+"' ";
        try {
            pst= con.prepareStatement(sql);
            pst.execute();
            item_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");

        if(x==0){
            String itemid = i_id.getText();

            String sql = "DELETE FROM item where Item_ID = '"+itemid+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                item_tableload();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        i_id.setText(null);
        i_cat.setSelectedItem(null);
        i_name.setText(null);
        i_price.setText(null);
        i_qty.setText(null);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void item_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_tableMouseClicked
        int r = item_table.getSelectedRow();
        String itemid= item_table.getValueAt(r, 0).toString();
        String catid = item_table.getValueAt(r, 1).toString();
        String itemname= item_table.getValueAt(r, 2).toString();
        String iprice = item_table.getValueAt(r, 3).toString();
        String iqty= item_table.getValueAt(r, 4).toString();
        String istat= item_table.getValueAt(r, 5).toString();

        i_id.setText(itemid);
        i_cat.setSelectedItem(catid);
        i_name.setText(itemname);
        i_price.setText(iprice);
        i_qty.setText(iqty);
        i_stat.setSelectedItem(istat);
    }//GEN-LAST:event_item_tableMouseClicked

    private void cat_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat_tableMouseClicked
        int r = cat_table.getSelectedRow();
        String catid= cat_table.getValueAt(r, 0).toString();
        String catname = cat_table.getValueAt(r, 1).toString();

        cat_id.setText(catid);
        cat_name.setText(catname);

    }//GEN-LAST:event_cat_tableMouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String catid = cat_id.getText();
        String catname = cat_name.getText();

        try{
            String q = "INSERT INTO category values('"+catid+"','"+catname+"')";
            pst = con.prepareStatement(q);
            pst.execute();

            cat_tableload();

        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you really want to update this field? ");

        String catid = cat_id.getText();
        String catname = cat_name.getText();

        String sql = "UPDATE category set Category_ID = '"+catid+"', Category_Name = '"+ catname+"' WHERE Category_ID = '"+catid+"' ";
        try {
            pst= con.prepareStatement(sql);
            pst.execute();
            cat_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");

        if(x==0){
            String catid = cat_id.getText();

            String sql = "DELETE FROM category where Category_ID = '"+ catid+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                cat_tableload();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        cat_id.setText(null);
        cat_name.setText(null);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

       
         String supplier = s_id.getSelectedItem().toString();
        String stat = st.getSelectedItem().toString();
       
         
       
        
        SimpleDateFormat dte = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
        String d_date = dte.format(in_date.getDate());
        String sql="";
        
        if(supplier.equals("All")){
        
        if("All".equals(stat)){
            sql = "SELECT * from indent where onDate ='"+ d_date+"' ";
        }else{
        
            sql = "SELECT Indent_ID,Supplier_Name,Item_Name,Qty,onDate,Total,Status from indent where  onDate ='"+ d_date+"' AND Status='"+stat+"' ";
        
        }
        }else{
        
             if("All".equals(stat)){
             sql = "SELECT * from indent where Supplier_Name LIKE'%"+supplier+"%' AND onDate ='"+ d_date+"' ";
             }else{
        
            sql = "SELECT Indent_ID,Supplier_Name,Item_Name,Qty,onDate,Total,Status from indent where Supplier_Name LIKE '%"+supplier+"%' AND onDate ='"+ d_date+"' AND Status='"+stat+"' ";
        
        }
        }
        
        try {
           
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            indent_table.setModel(DbUtils.resultSetToTableModel(rs));
         
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed

        String sql = "SELECT * FROM indent";

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            indent_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton25ActionPerformed

    private Date parseDate(String date, String format) throws ParseException
        {
             SimpleDateFormat formatter = new SimpleDateFormat(format);
              return formatter.parse(date);
        }
    
    private void indent_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_indent_tableMouseClicked

      int r = indent_table.getSelectedRow();
        String in_id= indent_table.getValueAt(r, 0).toString();
        String su_id = indent_table.getValueAt(r, 1).toString();
        String itemid =  indent_table.getValueAt(r, 2).toString();
        String qty= indent_table.getValueAt(r, 3).toString();
        String d_date1 = indent_table.getValueAt(r, 4).toString();  
        
       
        Date date = new Date();
         try {
             date = parseDate(d_date1, "yyyy-MM-dd");
        } catch (ParseException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        String tot= indent_table.getValueAt(r, 5).toString();
        String stat=indent_table.getValueAt(r, 6).toString();    
        
        indt_id.setText(in_id);
        sup_id.setSelectedItem(su_id);
        item_id.setSelectedItem(itemid);
        indnt_qty.setText(qty);
        indnt_cal.setDate(date);
        total.setText(tot);
        indt_status.setSelectedItem(stat);
        

    }//GEN-LAST:event_indent_tableMouseClicked

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed

       
        String su_id = sup_id.getSelectedItem().toString();
        
        SimpleDateFormat dte = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
        String d_date = dte.format(indnt_cal.getDate());
        String itemid = item_id.getSelectedItem().toString();
        String uprice = "SELECT * FROM item WHERE Item_Name='"+itemid+"'";
        
      
        
        float qty = Float.parseFloat(indnt_qty.getText());
        
        String stat = indt_status.getSelectedItem().toString();
        Statement st = null;
       try {
            
           Statement sta = con.createStatement();
           ResultSet res = sta.executeQuery(uprice);
           float points = 0;
      
           while(res.next()){
                points = res.getFloat("Item_Price");
            
           }
       
             float tot=qty*points; 
             String sql = "INSERT INTO indent (Supplier_Name,Item_Name,Qty,onDate,Total,Status) values ('"+su_id +"','"+ itemid+"','"+ qty+"','"+d_date +"','"+tot +"','"+stat +"')"; 
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            indent_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
    
       JOptionPane.showConfirmDialog(null, "Do you really want to update this field? ");
        
        String in_id = indt_id.getText();
        String su_id = sup_id.getSelectedItem().toString();
        
        SimpleDateFormat dte = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
        String d_date = dte.format(indnt_cal.getDate());
        
        String stat = indt_status.getSelectedItem().toString();
        float tot1 = Float.parseFloat(total.getText());
        String itemid = item_id.getSelectedItem().toString();
        int qty = Integer.parseInt(indnt_qty.getText());
        
        String uprice = "SELECT * FROM item WHERE Item_Name='"+itemid+"'";
        
        
            
          
        
        
        try {
            
             Statement sta = con.createStatement();
           ResultSet res = sta.executeQuery(uprice);
           float points = 0;
      
           while(res.next()){
                points = res.getFloat("Item_Price");
            
           }
       
             float tot=qty*points; 
            
            
            
            
            String sql = "UPDATE indent SET Supplier_Name='"+su_id+"',Item_Name = '"+itemid+"',Qty ='"+qty+"',onDate='"+d_date+"',Total='"+tot+"',Status='"+stat+"' WHERE Indent_ID='"+in_id+"'"; 
            pst= con.prepareStatement(sql);
            pst.execute();
            indent_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");
                
        if(x==0){
             String indtid = indt_id.getText();
             
             String sql = "DELETE FROM indent where Indent_ID = '"+ indtid+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                indent_tableload();
            } catch (SQLException ex) {
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }    
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
         String supp_name = sup_name.getText();
       
        
        String sql = "SELECT * from supplier where Supplier_Name LIKE  '%"+supp_name+"%'"; 
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            supp_table.setModel(DbUtils.resultSetToTableModel(rs));
         
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed

        String supp_name = sup_name.getText();

        String sql = "SELECT * from supplier where Supplier_Name LIKE  '%"+supp_name+"%'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            supp_table.setModel(DbUtils.resultSetToTableModel(rs));
            // tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String sql = "SELECT * FROM supplier";

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            supp_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void supp_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supp_tableMouseClicked

        int r = supp_table.getSelectedRow();
        String sup_id= supp_table.getValueAt(r, 0).toString();
        String sup_name = supp_table.getValueAt(r, 1).toString();
        String address= supp_table.getValueAt(r, 2).toString();
        String telephone = supp_table.getValueAt(r, 3).toString();
        String eml= supp_table.getValueAt(r, 4).toString();

        supp_id.setText(sup_id);
        supp_name.setText(sup_name);
        supp_add.setText(address);
        supp_tel.setText(telephone);
        supp_email.setText(eml);

    }//GEN-LAST:event_supp_tableMouseClicked

    private void supp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supp_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supp_nameActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed

        String sup_name = supp_name.getText();
        String address = supp_add.getText();
        String telephone = supp_tel.getText();
        String eml = supp_email.getText();
       
       
        
        
        
     
        
        
        try{
          
            String q = "INSERT INTO supplier (Supplier_Name,Address,Telephone,Email) values('"+sup_name+"','"+address+"','"+telephone+"','"+eml+"')";
            pst = con.prepareStatement(q);
            pst.execute();
            
            supp_tableload();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        

    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you really want to update this field? ");
        
        String sup_id = supp_id.getText();
        String sup_name = supp_name.getText();
        String address = supp_add.getText();
        String telephone = supp_tel.getText();
        String eml = supp_email.getText();
        
        String sql = "UPDATE supplier set Supplier_Name = '"+sup_name+"',   Address = '"+ address+"',Telephone = '"+ telephone+"',Email = '"+eml +"' WHERE Supplier_ID = '"+sup_id+"' ";
        try {
            pst= con.prepareStatement(sql);
            pst.execute();
            supp_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");

        if(x==0){
            String supid = supp_id.getText();

            String sql = "DELETE FROM supplier where Supplier_ID = '"+ supid+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                supp_tableload();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        supp_id.setText(null);
        supp_name.setText(null);
        supp_add.setText(null);
        supp_tel.setText(null);
        supp_email.setText(null);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
       String order_uid3  = order_uid2.getSelectedItem().toString();
        String order_cid3  = order_cid2.getText();
        String order_iid3  = order_iid2.getText();
        String order_pm3  = order_pm2.getSelectedItem().toString();
        String stat = order_status2.getSelectedItem().toString();
        
        SimpleDateFormat dte = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
        String d_date2 = dte.format(order_date2.getDate());
        String sql2="";
        
        if(order_uid3.equals("All")){
        
            if(stat.equals("All") && order_pm3.equals("All")){
                 sql2 = "SELECT * FROM orders WHERE Customer_ID LIKE '%"+ order_cid3+"%' AND Item_Name LIKE '%"+ order_iid3+"%' AND Date='"+d_date2+"' ";
                
             }
            else if(stat.equals("All")) {
                 sql2 = "SELECT * FROM orders WHERE Customer_ID LIKE '%"+ order_cid3+"%' AND Payment_Method = '"+ order_pm3+"'  AND Item_Name LIKE '%"+ order_iid3+"%'  AND Date='"+d_date2+"' ";
                
             }
            else if(order_pm3.equals("All")){
                sql2 = "SELECT * FROM orders WHERE Customer_ID LIKE '%"+ order_cid3+"%' AND Status='"+stat+"' AND  Item_Name LIKE '%"+ order_iid3+"%' AND Status='"+stat+"' AND Date='"+d_date2+"' ";
               
            }else{
                sql2 = "SELECT * FROM orders WHERE Customer_ID LIKE '%"+ order_cid3+"%' AND Status='"+stat+"' AND Payment_Method = '"+ order_pm3+"'  AND Item_Name LIKE '%"+ order_iid3+"%' AND Status='"+stat+"' AND Date='"+d_date2+"' ";
               
            } 
            
        }else{
                if(stat.equals("All") && order_pm3.equals("All")){
                    sql2 = "SELECT * FROM orders WHERE User_Name ='"+order_uid3+"' AND Customer_ID LIKE '%"+ order_cid3+"%' AND Item_Name LIKE '%"+ order_iid3+"%'  AND Date='"+d_date2+"' ";
                 
                }
                else if(stat.equals("All")){
                    sql2 = "SELECT * FROM orders WHERE Customer_ID LIKE '%"+ order_cid3+"%' AND Item_Name LIKE '%"+ order_iid3+"%' AND Payment_Method LIKE '"+ order_pm3+"'    AND Date='"+d_date2+"' ";
                      
                } else if(order_pm3.equals("All")){
                sql2 = "SELECT * FROM orders WHERE Customer_ID LIKE '%"+ order_cid3+"%' AND Status='"+stat+"' AND  Item_Name LIKE '%"+ order_iid3+"%' AND Status='"+stat+"' AND Date='"+d_date2+"' ";
           
            }
                
                
                else{
                    sql2 = "SELECT * FROM orders WHERE User_Name ='"+order_uid3+"' AND Customer_ID LIKE '%"+ order_cid3+"%'  AND Payment_Method LIKE '%"+ order_pm3+"%' AND Item_Name LIKE '%"+ order_iid3+"%' AND Status='"+stat+"'   AND Date='"+d_date2+"' ";
              
                }
        }
       
        try {
            
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            order_table.setModel(DbUtils.resultSetToTableModel(rs));
       
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String sql = "SELECT * FROM orders";

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            order_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void order_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_tableMouseClicked


    }//GEN-LAST:event_order_tableMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        login2 lgout = new login2();
        lgout.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        AboutUs ex1= new AboutUs();
        ex1.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void reportR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportR1ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        try {
            
            String report = "E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\item.jrxml";
            JasperReport jp = JasperCompileManager.compileReport(report);
            JasperPrint jd = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(jd,false);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed

        try {

            SimpleDateFormat dte1 = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
            String d_date1 = dte1.format(idate1.getDate());

            SimpleDateFormat dte2 = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
            String d_date2 = dte2.format(idate2.getDate());

            JasperDesign jd = JRXmlLoader.load("E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\indent.jrxml");
            String sql = "SELECT * FROM indent WHERE onDate between '"+d_date1+"' and '"+d_date2+"'" ;
            JRDesignQuery newquery = new JRDesignQuery();
            newquery.setText(sql);
            jd.setQuery(newquery);
            JasperReport jp = JasperCompileManager.compileReport(jd);
            JasperPrint js = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(js,false);

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed

        try {

            String report = "E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\indent.jrxml";
            JasperReport jp = JasperCompileManager.compileReport(report);
            JasperPrint jd = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(jd,false);

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
       try {
            
            String range1 =   reportR1.getText();
            String range2 = reportR2.getText();
              
            JasperDesign jd = JRXmlLoader.load("E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\item.jrxml");
            String sql = "SELECT * FROM item where Item_Price between '"+range1+"' and '"+range2+"' ";
            JRDesignQuery newquery = new JRDesignQuery();
            newquery.setText(sql);
            jd.setQuery(newquery);
            JasperReport jp = JasperCompileManager.compileReport(jd);
            JasperPrint js = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(js,false);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        try {

            SimpleDateFormat dte1 = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
            String d_date1 = dte1.format(jDateChooser3.getDate());

            SimpleDateFormat dte2 = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
            String d_date2 = dte2.format(jDateChooser4.getDate());

            JasperDesign jd = JRXmlLoader.load("E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\order.jrxml");
            String sql = "SELECT * FROM orders WHERE Date between '"+d_date1+"' and '"+d_date2+"'" ;
            JRDesignQuery newquery = new JRDesignQuery();
            newquery.setText(sql);
            jd.setQuery(newquery);
            JasperReport jp = JasperCompileManager.compileReport(jd);
            JasperPrint js = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(js,false);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed

        try {

            String report = "E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\order.jrxml";
            JasperReport jp = JasperCompileManager.compileReport(report);
            JasperPrint jd = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(jd,false);

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField cat_id;
    private javax.swing.JTextField cat_name;
    private javax.swing.JTable cat_table;
    private javax.swing.JComboBox i_cat;
    private javax.swing.JLabel i_id;
    private javax.swing.JTextField i_name;
    private javax.swing.JTextField i_price;
    private javax.swing.JTextField i_qty;
    private javax.swing.JComboBox i_stat;
    private com.toedter.calendar.JDateChooser idate1;
    private com.toedter.calendar.JDateChooser idate2;
    private com.toedter.calendar.JDateChooser in_date;
    private javax.swing.JTable indent_table;
    private com.toedter.calendar.JDateChooser indnt_cal;
    private javax.swing.JTextField indnt_qty;
    private javax.swing.JLabel indt_id;
    private javax.swing.JComboBox indt_status;
    private javax.swing.JComboBox item_cat;
    private javax.swing.JComboBox item_id;
    private javax.swing.JTable item_table;
    private javax.swing.JComboBox itemname;
    private javax.swing.JComboBox itemstat;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField order_cid2;
    private com.toedter.calendar.JDateChooser order_date2;
    private javax.swing.JTextField order_iid2;
    private javax.swing.JComboBox order_pm2;
    private javax.swing.JComboBox order_status2;
    private javax.swing.JTable order_table;
    private javax.swing.JComboBox order_uid2;
    private javax.swing.JTextField reportR1;
    private javax.swing.JTextField reportR2;
    private javax.swing.JComboBox s_id;
    private javax.swing.JComboBox st;
    private javax.swing.JComboBox sup_id;
    private javax.swing.JTextField sup_name;
    private javax.swing.JTextField supp_add;
    private javax.swing.JTextField supp_email;
    private javax.swing.JTextField supp_id;
    private javax.swing.JTextField supp_name;
    private javax.swing.JTable supp_table;
    private javax.swing.JTextField supp_tel;
    private javax.swing.JTextField to1;
    private javax.swing.JTextField to2;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
