/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package S_manager;

/**
 *
 * @author chathura93
 */

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
import login.login2;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class SalesManager extends javax.swing.JFrame {

    /**
     * Creates new form SalesManager
     */
    
     Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    
    public SalesManager() {
        initComponents();
        
        
        con = DB_Connect.getConnection();
        cus_tableload();
        order_tableload();
        indent_tableload();
        
         try {
             indntBox();
             //comuserid();
               comcusid();
               item_indnt();
         } catch (SQLException ex) {
             Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    
    
    public void item_indnt()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Item_Name FROM item";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            item_id.addItem(rs1.getString(1));
           
          
        }
    }
    
    public void comcusid()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Cust_ID FROM customer";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
          
           order_cid.addItem(rs1.getString(1));
         
        }
    }
    
    
    
    /* public void comuserid()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT User_Type_Name FROM user_type";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
           order_uid2.addItem(rs1.getString(1));
           order_uid.addItem(rs1.getString(1));
         
        }
    }*/
    
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
    
    
    
    private void groupButton(){
        ButtonGroup bg1 = new ButtonGroup();
        
        bg1.add(cus_m);
        bg1.add(cus_f);
    }
    
    public void cus_tableload(){
        try {
            
            String sql = "SELECT * FROM customer";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            cus_table.setModel(DbUtils.resultSetToTableModel(rs));
            
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
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        customer_name = new javax.swing.JTextField();
        customer_add = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        customer_city = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        customer_country = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        cus_table = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cus_name = new javax.swing.JTextField();
        cus_tel = new javax.swing.JTextField();
        cus_add = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cus_city = new javax.swing.JTextField();
        cus_country = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        cus_m = new javax.swing.JRadioButton();
        cus_f = new javax.swing.JRadioButton();
        cus_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tot_purchase = new javax.swing.JLabel();
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
        jButton27 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton47 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        order_table = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        order_qty = new javax.swing.JTextField();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        order_status = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        order_date = new com.toedter.calendar.JDateChooser();
        order_id = new javax.swing.JLabel();
        order_uid = new javax.swing.JComboBox();
        order_iid = new javax.swing.JComboBox();
        order_cid = new javax.swing.JComboBox();
        order_tot = new javax.swing.JLabel();
        order_pm = new javax.swing.JComboBox();
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
        jButton28 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
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
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel17.setText("Name");

        jLabel18.setText("Address");

        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel20.setText("City");

        jLabel21.setText("Country");

        jButton17.setText("Display All");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Devin\\Downloads\\t8Xx4sNu2.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(24, 24, 24)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customer_name, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(customer_add))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customer_city)
                            .addComponent(customer_country, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton17)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(customer_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(customer_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(customer_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(customer_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        cus_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Telephone", "Address", "Gender", "Purchase Count", "City", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cus_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cus_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(cus_table);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel22.setText("Customer ID");

        jLabel31.setText("Name");

        jLabel32.setText("Telephone");

        jLabel33.setText("Address");

        jLabel34.setText("Gender");

        jLabel35.setText("City");

        jLabel36.setText("Country");

        cus_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_cityActionPerformed(evt);
            }
        });

        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton19.setText("Clear");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        cus_m.setText("Male");

        cus_f.setText("Female");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Total purchase");

        tot_purchase.setText("jLabel3");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cus_add, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(cus_tel)
                            .addComponent(cus_name)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(cus_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(99, 99, 99)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cus_city)
                    .addComponent(cus_country)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(cus_m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(cus_f)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10))
                    .addComponent(jButton19)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tot_purchase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel34)
                    .addComponent(cus_m)
                    .addComponent(cus_f)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(cus_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cus_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(cus_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cus_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(cus_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cus_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tot_purchase))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer Manager", jPanel12);

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel63.setText("User Name");

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

        jButton27.setText("iReport");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton47.setText("pReport");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
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
                        .addGap(108, 108, 108)
                        .addComponent(jButton42))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(order_status2, 0, 150, Short.MAX_VALUE)
                            .addComponent(order_pm2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton47)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(order_iid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30))
                            .addComponent(jLabel65)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel66)
                                    .addComponent(jButton26)
                                    .addComponent(order_pm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(order_status2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton47))
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(order_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton42)
                                .addComponent(jButton27)))))
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel68.setText("Order ID");

        jLabel69.setText("User ID");

        jLabel70.setText("Customer ID");

        jLabel71.setText("Item ID");

        jLabel72.setText("Quantity");

        jButton43.setText("Add");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setText("Update");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton45.setText("Delete");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setText("Clear");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jLabel73.setText("Total");

        jLabel74.setText("Payment Method");

        jLabel19.setText("Status");

        order_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "Confirmed", "Canceled" }));

        jLabel29.setText("Date");

        order_uid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>", "Sales Manager", "Salesmen" }));

        order_iid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        order_cid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        order_tot.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        order_pm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cash", "cheque", "credit card" }));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70)
                    .addComponent(jLabel71)
                    .addComponent(jLabel68))
                .addGap(40, 40, 40)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(order_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_uid, 0, 130, Short.MAX_VALUE)
                    .addComponent(order_iid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_cid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel74))))
                .addGap(43, 43, 43)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(order_qty)
                    .addComponent(order_status, 0, 120, Short.MAX_VALUE)
                    .addComponent(order_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_pm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jButton43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton45))
                    .addComponent(jButton46))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel68)
                        .addComponent(jLabel72)
                        .addComponent(order_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)
                        .addComponent(order_id))
                    .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69)
                            .addComponent(order_uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(order_tot)
                                .addComponent(jLabel73)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jLabel74)
                            .addComponent(order_cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(order_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton43)
                            .addComponent(jButton44)
                            .addComponent(jButton45))
                        .addGap(16, 16, 16)))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71)
                        .addComponent(jLabel19)
                        .addComponent(order_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton46))
                    .addComponent(order_iid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order Manager", jPanel29);

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

        jButton28.setText("iReport");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton31.setText("pReport");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
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
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(in_date, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton31, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(idate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(idate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(169, 169, 169))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jButton25)
                    .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel50)
                    .addComponent(in_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton24)
                        .addGap(28, 28, 28))))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jButton28)
                .addGap(18, 18, 18)
                .addComponent(jButton31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1023, Short.MAX_VALUE)
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
                .addContainerGap(587, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel54)
                        .addComponent(item_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(indnt_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(total))
                .addGap(37, 37, 37)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(jButton34)
                    .addComponent(jButton35)
                    .addComponent(jButton36)))
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
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Indent Manager", jPanel19);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

         String name = customer_name.getText();
        String addr = customer_add.getText();
        String city= customer_city.getText();
        String country = customer_country.getText();
        
         //and Type_ID = '"+auth+"'
        try {
            String sql = "SELECT * from customer where Cust_Name LIKE  '%"+name+"%' AND Address LIKE '%"+addr+"%' AND City LIKE '%"+city+"%' AND Country LIKE '%"+country+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            cus_table.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        String sql = "SELECT * FROM customer";

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            cus_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void cus_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cus_tableMouseClicked
 int r = cus_table.getSelectedRow();
        String customerid= cus_table.getValueAt(r, 0).toString();
        String customername = cus_table.getValueAt(r, 1).toString();
        String telephone= cus_table.getValueAt(r, 2).toString();
        String address = cus_table.getValueAt(r, 3).toString();
        String city= cus_table.getValueAt(r, 5).toString();
        String country= cus_table.getValueAt(r, 6).toString();
        String gender=cus_table.getValueAt(r, 4).toString();
        
        
          
            
        
            String cusid = "SELECT SUM(o.Total) as tot12 FROM orders o,customer c WHERE c.Cust_ID = '"+customerid+"' and c.Cust_ID=o.Customer_ID group by o.Customer_ID ";
          
            
        try {
            Statement st12 = con.createStatement();
            ResultSet rs1 = st12.executeQuery(cusid);
            String ptot=null;
            while(rs1.next()){
                ptot = rs1.getString("tot12");
            }
         
            tot_purchase.setText(ptot);
          
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
            
       
            
        
        
        
        cus_id.setText(customerid);
        cus_name.setText(customername);
        cus_tel.setText(telephone);
        cus_add.setText(address);
        cus_city.setText(city);
        cus_country.setText(country);
        if (gender.equals("M"))
        {
            cus_m.setSelected(true);
        }
        if (gender.equals("F")){
            cus_f.setSelected(true);
        }

    }//GEN-LAST:event_cus_tableMouseClicked

    private void cus_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cus_cityActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String customername = cus_name.getText();
        String telephone = cus_tel.getText();
        String address = cus_add.getText();
        String radioText = "";
        if (cus_m.isSelected()){
            radioText="M";
        }
        if (cus_f.isSelected()){
            radioText="F";
        }

        String city = cus_city.getText();
        String country = cus_country.getText();

        try{
            
          
            
            
            
            
            
            
            
            String q = "INSERT INTO customer (Cust_Name,Telephone,Address,Gender,City,Country) values('"+customername+"','"+telephone+"','"+address+"','"+radioText+"','"+city+"','"+country+"')";
            pst = con.prepareStatement(q);
            pst.execute();

            cus_tableload();
           

        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         JOptionPane.showConfirmDialog(null, "Do you really want to update this field? ");

        String customerid = cus_id.getText();
        String customername = cus_name.getText();
        String telephone = cus_tel.getText();
        String address = cus_add.getText();
        
        String gender= "";
        if (cus_m.isSelected()){
            gender="M";
        }
        if (cus_f.isSelected()){
            gender="F";
        }
        String city = cus_city.getText();
        String country = cus_country.getText();

        String sql = "UPDATE customer set Cust_Name = '"+ customername+"',Telephone = '"+ telephone+"',Address = '"+address+"',City = '"+city+"',Country = '"+ country+"',Gender = '"+gender+"' WHERE Cust_ID = '"+customerid+"' ";
        try {
            pst= con.prepareStatement(sql);
            pst.execute();
            cus_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");

        if(x==0){
            String cust_id = cus_id.getText();

            String sql = "DELETE FROM customer where Cust_ID = '"+ cust_id+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                cus_tableload();
            } catch (SQLException ex) {
                Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        cus_id.setText(null);
        cus_name.setText(null);
        cus_tel.setText(null);
        cus_add.setText(null);
        cus_city.setText(null);
        cus_country.setText(null);
        cus_m.setSelected(true);
    }//GEN-LAST:event_jButton19ActionPerformed

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
            Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

     private Date parseDate(String date, String format) throws ParseException
        {
             SimpleDateFormat formatter = new SimpleDateFormat(format);
              return formatter.parse(date);
        }
    
    private void order_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_tableMouseClicked

         
        int r = order_table.getSelectedRow();
        String order_id1= order_table.getValueAt(r, 0).toString();
        String order_uid1 = order_table.getValueAt(r, 1).toString();
        String order_cid1= order_table.getValueAt(r, 2).toString();
        String order_iid1 = order_table.getValueAt(r, 3).toString();
        String order_qty1= order_table.getValueAt(r, 4).toString();
        String order_date1= order_table.getValueAt(r, 5).toString();
        Date date = new Date();
         try {
             date = parseDate(order_date1, "yyyy-MM-dd");
        } catch (ParseException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        String order_tot1= order_table.getValueAt(r, 7).toString();
        String order_pm1= order_table.getValueAt(r, 6).toString();
        String order_stat1= order_table.getValueAt(r, 8).toString();
      
        
        order_id.setText(order_id1);
        order_uid.setSelectedItem(order_uid1);
        order_cid.setSelectedItem(order_cid1);
        order_iid.setSelectedItem(order_iid1);
        order_qty.setText(order_qty1);
        order_date.setDate(date);
        order_tot.setText(order_tot1);
        order_pm.setSelectedItem(order_pm1);
        order_status.setSelectedItem(order_stat1);

    }//GEN-LAST:event_order_tableMouseClicked

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        
        String order_uid1 = order_uid.getSelectedItem().toString();
        String order_cid1 = order_cid.getSelectedItem().toString();
        String order_iid1 = order_iid.getSelectedItem().toString();
        String order_pm1 = order_pm.getSelectedItem().toString();
        
        SimpleDateFormat dte = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
        String d_date = dte.format(order_date.getDate());
        
        String order_stat1 = order_status.getSelectedItem().toString();
       
        int order_qty1 = Integer.parseInt(order_qty.getText());
        
       
      
        try {
            String uprice = "SELECT * FROM item WHERE Item_Name='"+order_iid1 +"'";
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(uprice);
             
             float u_price=0;
            
            while(rs1.next()){
                u_price = rs1.getFloat("Item_Price");
            }
            float order_tot1 = order_qty1*u_price;
            
            String sql = "INSERT INTO orders (User_Name,Customer_ID,Item_Name,Qty,Date,Payment_Method,Total,Status) values ('"+order_uid1+"','"+order_cid1+"','"+order_iid1+"','"+order_qty1+"','"+d_date+"','"+order_pm1+"','"+order_tot1+"','"+order_stat1+"')";
            pst = con.prepareStatement(sql);
            pst.execute();
            order_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you really want to update this record? ");
        
        String order_id1 = order_id.getText();
        String order_uid1 = order_uid.getSelectedItem().toString();
        String order_cid1 = order_cid.getSelectedItem().toString();
        String order_iid1 = order_iid.getSelectedItem().toString();
        String order_pm1 = order_pm.getSelectedItem().toString(); 
        
        SimpleDateFormat dte = new SimpleDateFormat("YYY-MM-dd",Locale.getDefault());
        String d_date = dte.format(order_date.getDate());
        
        String order_stat1 = order_status.getSelectedItem().toString();
       
        int order_qty1 = Integer.parseInt(order_qty.getText());
        
        try {
             String uprice = "SELECT * FROM item WHERE Item_Name='"+order_iid1 +"'";
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery(uprice);
             
             float u_price=0;
            
            while(rs1.next()){
                u_price = rs1.getFloat("Item_Price");
            }
            float order_tot1 = order_qty1*u_price;
            
            String sql = "UPDATE orders SET User_Name='"+order_uid1+"',Customer_ID='"+order_cid1+"',Item_Name='"+order_iid1+"',Qty='"+order_qty1+"',Date='"+d_date+"',Payment_Method='"+order_pm1+"',Status='"+order_stat1+"',Total = '"+order_tot1+"' WHERE Order_ID='"+order_id1+"'"; 
            pst= con.prepareStatement(sql);
            pst.execute();
            order_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");

        if(x==0){
            String orderid = order_id.getText();

            String sql = "DELETE FROM orders where Order_ID = '"+ orderid+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                order_tableload();
            } catch (SQLException ex) {
                Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        order_id.setText(null);
        order_uid.setSelectedItem(null);
        order_cid.setSelectedItem(null);
        order_iid.setSelectedItem(null);
        order_qty.setText(null);
        order_tot.setText(null);
        order_pm.setSelectedItem(null);
        order_status.setSelectedItem("Pending");
    }//GEN-LAST:event_jButton46ActionPerformed

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
            Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton25ActionPerformed

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
                Logger.getLogger(SalesManager.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
       indt_id.setText(null);
       sup_id.setSelectedItem(null);
       item_id.setSelectedItem(null);
       total.setText(null);
       indnt_qty.setText(null);
       indt_status.setSelectedItem("Confirmed");
    }//GEN-LAST:event_jButton36ActionPerformed

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

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed

        try {

            String report = "E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\order.jrxml";
            JasperReport jp = JasperCompileManager.compileReport(report);
            JasperPrint jd = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(jd,false);

        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_jButton28ActionPerformed

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
            java.util.logging.Logger.getLogger(SalesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField cus_add;
    private javax.swing.JTextField cus_city;
    private javax.swing.JTextField cus_country;
    private javax.swing.JRadioButton cus_f;
    private javax.swing.JLabel cus_id;
    private javax.swing.JRadioButton cus_m;
    private javax.swing.JTextField cus_name;
    private javax.swing.JTable cus_table;
    private javax.swing.JTextField cus_tel;
    private javax.swing.JTextField customer_add;
    private javax.swing.JTextField customer_city;
    private javax.swing.JTextField customer_country;
    private javax.swing.JTextField customer_name;
    private com.toedter.calendar.JDateChooser idate1;
    private com.toedter.calendar.JDateChooser idate2;
    private com.toedter.calendar.JDateChooser in_date;
    private javax.swing.JTable indent_table;
    private com.toedter.calendar.JDateChooser indnt_cal;
    private javax.swing.JTextField indnt_qty;
    private javax.swing.JLabel indt_id;
    private javax.swing.JComboBox indt_status;
    private javax.swing.JComboBox item_id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox order_cid;
    private javax.swing.JTextField order_cid2;
    private com.toedter.calendar.JDateChooser order_date;
    private com.toedter.calendar.JDateChooser order_date2;
    private javax.swing.JLabel order_id;
    private javax.swing.JComboBox order_iid;
    private javax.swing.JTextField order_iid2;
    private javax.swing.JComboBox order_pm;
    private javax.swing.JComboBox order_pm2;
    private javax.swing.JTextField order_qty;
    private javax.swing.JComboBox order_status;
    private javax.swing.JComboBox order_status2;
    private javax.swing.JTable order_table;
    private javax.swing.JLabel order_tot;
    private javax.swing.JComboBox order_uid;
    private javax.swing.JComboBox order_uid2;
    private javax.swing.JComboBox s_id;
    private javax.swing.JComboBox st;
    private javax.swing.JComboBox sup_id;
    private javax.swing.JLabel tot_purchase;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
