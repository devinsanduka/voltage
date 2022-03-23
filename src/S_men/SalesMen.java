/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package S_men;

/**
 *
 * @author chathura93
 */
import Admin.Administrator;
import about_us.AboutUs;
import connections.DB_Connect;
import homes.Home_Ad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import login.login2;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class SalesMen extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    /**
     * Creates new form SalesMen
     */
    
    
    public SalesMen() {
        initComponents();
        con = DB_Connect.getConnection();
        
        
        cus_tableload();
        groupButton();
        
         try {
            itemNameBox();
            itemCatBox();
            //comuserid();
            item_indnt();
            comcusid();
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        item_tableload();
        order_tableload();
    }
    
     public void item_indnt()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Item_Name FROM item";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
          
           
           order_iid.addItem(rs1.getString(1));
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
    
      public void comcusid()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Cust_ID FROM customer";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
          
           order_cid.addItem(rs1.getString(1));
         
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
    
    public void item_tableload(){
   
       String sql = "SELECT * from item";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(SalesMen.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    public void itemNameBox() throws SQLException{
        
        Statement cs = null;
             
        String sql = "SELECT Item_Name FROM item";
        cs = con.createStatement();
        ResultSet rs1 = cs.executeQuery(sql);
        
        while(rs1.next()){
           
            itemname.addItem(rs1.getString(1));
        }
         
    }
    
    public void itemCatBox()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Category_Name FROM category";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            item_cat.addItem(rs1.getString(1));
           
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
        jButton47 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
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
        order_cid = new javax.swing.JComboBox();
        order_iid = new javax.swing.JComboBox();
        order_tot = new javax.swing.JLabel();
        order_pm = new javax.swing.JComboBox();
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
        jLabel40 = new javax.swing.JLabel();
        reportR2 = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        item_table = new javax.swing.JTable();
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
                    .addComponent(jButton7)
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
                .addComponent(jButton7)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        cus_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Telephone", "Address", "Gender", "City", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
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

        cus_id.setText("a");

        jLabel1.setText("Total Purchase");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
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
                            .addComponent(jLabel36)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(37, 37, 37)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jButton19)))
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cus_city)
                    .addComponent(cus_country)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(cus_m)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(cus_f)))
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tot_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel34)
                    .addComponent(cus_m)
                    .addComponent(cus_f)
                    .addComponent(cus_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cus_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(cus_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cus_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(cus_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tot_purchase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(cus_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
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

        order_uid2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Sales Manager" }));

        order_pm2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

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
                        .addGap(116, 116, 116)
                        .addComponent(jButton42))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(order_status2, 0, 150, Short.MAX_VALUE)
                            .addComponent(order_pm2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton47)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton47))
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton27))
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
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jButton26)
                            .addComponent(order_pm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(order_status2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(order_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton42))))
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
                .addComponent(jScrollPane8)
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

        jLabel69.setText("User Name");

        jLabel70.setText("Customer ID");

        jLabel71.setText("Item Name");

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

        order_cid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        order_iid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        order_tot.setText("0");

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
                    .addComponent(order_cid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_iid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jButton43)
                        .addGap(18, 18, 18)
                        .addComponent(jButton44)
                        .addGap(18, 18, 18)
                        .addComponent(jButton45))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton46))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(jLabel72)
                            .addComponent(order_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(order_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(jLabel73)
                            .addComponent(order_uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(order_tot))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jLabel74)
                            .addComponent(order_cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(order_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(jLabel19)
                            .addComponent(order_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(order_iid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton43)
                            .addComponent(jButton44)
                            .addComponent(jButton45))
                        .addGap(18, 18, 18)
                        .addComponent(jButton46)))
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
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order Manager", jPanel29);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel12.setText("Item Name");

        jLabel13.setText("Category ID");

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

        jLabel40.setText("between");

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
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(item_cat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemname, 0, 156, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemstat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jButton16))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(reportR1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reportR2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton32))
                    .addComponent(jButton29))
                .addGap(31, 31, 31))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(itemstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16)
                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(item_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)
                            .addComponent(reportR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap(26, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
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
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Items Manager", jPanel3);

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
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1097, 849));
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
            Logger.getLogger(SalesMen.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SalesMen.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalesMen.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SalesMen.class.getName()).log(Level.SEVERE, null, ex);
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

    private void item_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_tableMouseClicked
   
    }//GEN-LAST:event_item_tableMouseClicked

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

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String sql = "SELECT * FROM item";

        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            item_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(SalesMen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void itemstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemstatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemstatActionPerformed

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

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed

        try {

            String report = "E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\order.jrxml";
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

    private void reportR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportR1ActionPerformed

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
            java.util.logging.Logger.getLogger(SalesMen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesMen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesMen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesMen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesMen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JComboBox item_cat;
    private javax.swing.JTable item_table;
    private javax.swing.JComboBox itemname;
    private javax.swing.JComboBox itemstat;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel40;
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
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
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
    private javax.swing.JTextField reportR1;
    private javax.swing.JTextField reportR2;
    private javax.swing.JTextField to1;
    private javax.swing.JTextField to2;
    private javax.swing.JLabel tot_purchase;
    // End of variables declaration//GEN-END:variables
}
