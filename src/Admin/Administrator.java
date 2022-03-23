/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Admin;

import I_manager.InventoryManager;
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
import javax.swing.table.TableModel;
import login.login2;
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



/**
 *
 * @author chathura93
 */
public class Administrator extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    
 

     
    
    
    public Administrator()   {
        initComponents();
        
        con = DB_Connect.getConnection();
        
        tableload();
       cus_tableload();
        groupButton();
       cat_tableload();
        indent_tableload();
        supp_tableload();
        item_tableload();
        order_tableload();
        try {
            
            itemCatBox();
            indntBox();
            item_indnt();
            sitem_manager();
           // comuserid();
           comcusid();
            u_manager();
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                   
    }
    
    
     public void u_manager()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT User_Type_Name FROM user_type";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            auth.addItem(rs1.getString(1));
            s_auth.addItem(rs1.getString(1));
           
           
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
   
    
    
    
    
    
    private void groupButton(){
        ButtonGroup bg1 = new ButtonGroup();
        
        bg1.add(cus_m);
        bg1.add(cus_f);
    }
    
   public void supp_tableload(){
       
       String sql = "SELECT * from supplier";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            supp_table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
   }
   
   public void item_tableload(){
   
       String sql = "SELECT * from item";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
    
    public void tableload(){
        try {
            
            String sql = "SELECT * FROM user";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            u_info.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void cus_tableload(){
        try {
            
            String sql = "SELECT * FROM customer";
            
            String cusid = "SELECT count(o.Customer_ID) as tot12 FROM orders o,customer c WHERE  c.Cust_ID=o.Customer_ID group by o.Customer_ID ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            cus_table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        } catch (Exception e) {
            System.out.println(e);
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
    
    
   
    
    public void itemCatBox()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Category_Name FROM category";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            item_cat.addItem(rs1.getString(1));
            i_cat.addItem(rs1.getString(1));
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
    
    public void item_indnt()throws SQLException{
         Statement cs1 = null;
             
        String sql1 = "SELECT Item_Name FROM item";
        cs1 = con.createStatement();
        ResultSet rs1 = cs1.executeQuery(sql1);
        
        while(rs1.next()){
            item_id.addItem(rs1.getString(1));
           
           order_iid.addItem(rs1.getString(1));
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
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jScrollPane9 = new javax.swing.JScrollPane();
        u_panel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        s_name = new javax.swing.JTextField();
        s_auth = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        u_info = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        u_name1 = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        add = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        u_id = new javax.swing.JLabel();
        auth = new javax.swing.JComboBox();
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
        itemname = new javax.swing.JComboBox();
        item_cat = new javax.swing.JComboBox();
        jButton29 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        reportR1 = new javax.swing.JTextField();
        reportR2 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        i_price = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        i_qty = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        i_stat = new javax.swing.JComboBox();
        i_cat = new javax.swing.JComboBox();
        i_id = new javax.swing.JLabel();
        i_name = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        item_table = new javax.swing.JTable();
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
        jLabel39 = new javax.swing.JLabel();
        tot_purchase = new javax.swing.JLabel();
        cus_id = new javax.swing.JLabel();
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
        total = new javax.swing.JLabel();
        sup_id = new javax.swing.JComboBox();
        item_id = new javax.swing.JComboBox();
        indt_id = new javax.swing.JLabel();
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
        supp_name = new javax.swing.JTextField();
        supp_add = new javax.swing.JTextField();
        supp_tel = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        supp_email = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        supp_id = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        order_date2 = new com.toedter.calendar.JDateChooser();
        order_status2 = new javax.swing.JComboBox();
        jButton26 = new javax.swing.JButton();
        order_uid2 = new javax.swing.JComboBox();
        order_pm2 = new javax.swing.JComboBox();
        order_cid2 = new javax.swing.JTextField();
        order_iid2 = new javax.swing.JTextField();
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
        order_cid = new javax.swing.JComboBox();
        order_iid = new javax.swing.JComboBox();
        order_pm = new javax.swing.JComboBox();
        order_uid = new javax.swing.JComboBox();
        order_tot = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel1.setText("Name");

        jLabel3.setText("Authorization");

        s_auth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_authActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton15.setText("Display All");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton30.setText("iReport");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(s_name)
                    .addComponent(s_auth, 0, 159, Short.MAX_VALUE))
                .addGap(136, 136, 136)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addGap(98, 98, 98)
                        .addComponent(jButton30))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(s_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15)
                            .addComponent(jButton30))))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s_auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Table View"));

        u_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "User ID", "Authorization", "User Name", "Password", "Name", "Address", "Telephone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        u_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u_infoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(u_info);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel4.setText("User ID");

        jLabel5.setText("Authorization");

        jLabel6.setText("User Name");

        jLabel7.setText("Password");

        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });

        jLabel8.setText("Name");

        jLabel9.setText("Address");

        jLabel10.setText("Telephone");

        jLabel11.setText("Email");

        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        auth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(auth, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(u_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(u_name1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(78, 78, 78)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(33, 33, 33)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tel)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(73, 73, 73)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(u_id)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(u_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        u_panel.addTab("User Manager", jPanel2);

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

        itemname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        item_cat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        jButton29.setText("iReport");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton32.setText("pReport");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        reportR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportR1ActionPerformed(evt);
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
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(itemname, 0, 159, Short.MAX_VALUE)
                            .addComponent(item_cat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel16))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(itemstat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(reportR1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reportR2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton32))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(314, 314, 314)
                        .addComponent(jButton29)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(itemstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(reportR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(item_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(to1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(to2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16)
                            .addComponent(jButton29))
                        .addGap(2, 2, 2)
                        .addComponent(jButton6)
                        .addGap(30, 30, 30))))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Record Details"));

        jLabel23.setText("Item ID");

        jLabel24.setText("Category");

        jLabel25.setText("Item Name");

        jLabel26.setText("Item Price");

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
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23))
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(i_price, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(i_cat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(i_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(i_name))
                .addGap(18, 191, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(i_stat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(i_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton11)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(93, 93, 93)
                        .addComponent(jButton14)))
                .addGap(154, 154, 154))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(23, 23, 23))
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
                "Item ID", "Category Name", "Item Name", "Price", "Item Qty", "Item Status"
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
        item_table.getTableHeader().setReorderingAllowed(false);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );

        u_panel.addTab("Items Manager", jPanel3);

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
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

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Total Purchase");

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
                .addGap(55, 55, 55)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addComponent(tot_purchase, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(cus_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(tot_purchase))
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cus_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(cus_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(216, Short.MAX_VALUE))
        );

        u_panel.addTab("Customer Manager", jPanel12);

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
                .addContainerGap(440, Short.MAX_VALUE))
        );

        u_panel.addTab("Category Manager", jPanel16);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel49.setText("Supplier");

        jLabel50.setText("On Date");

        jLabel51.setText("Status");

        st.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Confirmed", "Pending" }));

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
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(idate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(idate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(in_date, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jButton25)
                            .addComponent(s_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50)
                            .addComponent(in_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jButton28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton24)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                "Indent ID", "Supplier Name", "Item Name", "Quantity", "On Date", "Total", "Status"
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
        indent_table.getTableHeader().setReorderingAllowed(false);
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
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

        jLabel2.setText("Item Name");

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
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(sup_id, 0, 120, Short.MAX_VALUE)
                            .addComponent(item_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(indt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(502, Short.MAX_VALUE))
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
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(Quantity)
                    .addComponent(indnt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sup_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
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
                    .addComponent(jButton36))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );

        u_panel.addTab("Indent Manager", jPanel19);

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
                            .addComponent(supp_name, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(supp_add)
                            .addComponent(supp_tel)
                            .addComponent(supp_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(392, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel62)
                    .addComponent(supp_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supp_id))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        u_panel.addTab("Supplier Manager", jPanel25);

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        jLabel63.setText("User Name");

        jLabel64.setText("Customer ID");

        jLabel65.setText("Item Name");

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
                    .addComponent(order_uid2, 0, 159, Short.MAX_VALUE)
                    .addComponent(order_cid2)
                    .addComponent(order_iid2))
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel30))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(order_status2, 0, 150, Short.MAX_VALUE)
                        .addComponent(order_pm2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(order_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton26)
                            .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel67))
                                    .addGroup(jPanel30Layout.createSequentialGroup()
                                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel63)
                                            .addComponent(order_uid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(11, 11, 11)
                                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel64)
                                            .addComponent(order_cid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jButton27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel65)
                                .addComponent(order_iid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(order_pm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel66))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(order_status2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(order_date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton42))
                            .addComponent(jButton47)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        order_cid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        order_iid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>" }));

        order_pm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cash", "cheque", "credit card" }));

        order_uid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<select>", "Sales Manager", "Salesmen" }));

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
                    .addComponent(order_cid, 0, 130, Short.MAX_VALUE)
                    .addComponent(order_iid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_uid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(order_pm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(order_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(order_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jButton43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton45))
                    .addComponent(jButton46))
                .addContainerGap(165, Short.MAX_VALUE))
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
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(234, Short.MAX_VALUE))
        );

        u_panel.addTab("Order Manager", jPanel29);

        jScrollPane9.setViewportView(u_panel);

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
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1013, 790));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null, "Do you want to delete this? ");
                
        if(x==0){
             String userid = u_id.getText();
             
             String sql = "DELETE FROM user where User_ID = '"+ userid+"'";
            try {
                pst = con.prepareStatement(sql);
                pst.execute();
                tableload();
            } catch (SQLException ex) {
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton13ActionPerformed

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
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void itemstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemstatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemstatActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

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

    private void supp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supp_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supp_nameActionPerformed

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
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }        
    }//GEN-LAST:event_jButton40ActionPerformed

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
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        }        
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
      
        
        
        String athr = auth.getSelectedItem().toString();
        String username = u_name1.getText();
        String password = pwd.getText();
        String u_name = name.getText();
        String address = add.getText();
        String telephone = tel.getText();
        String eml = email.getText();
        
       
        
        
        try{
           
            String q = "INSERT INTO user (User_Type_Name,Username,Password,Name,Address,Phone,Email) values('"+athr+"','"+username+"','"+password+"','"+u_name+"','"+address+"','"+telephone+"','"+eml+"')";
            pst = con.prepareStatement(q);
            pst.execute();
            
            tableload();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdActionPerformed

    private void u_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_u_infoMouseClicked
        
        int r = u_info.getSelectedRow();
        String userid= u_info.getValueAt(r, 0).toString();
        String athr = u_info.getValueAt(r, 1).toString();
        String username= u_info.getValueAt(r, 2).toString();
        String password = u_info.getValueAt(r, 3).toString();
        String u_name= u_info.getValueAt(r, 4).toString();
        String address= u_info.getValueAt(r, 5).toString();
        String telephone = u_info.getValueAt(r, 6).toString();
        String eml = u_info.getValueAt(r, 7).toString();
        
        u_id.setText(userid);
        auth.setSelectedItem(athr);
        u_name1.setText(username);
        pwd.setText(password);
        name.setText(u_name);
        add.setText(address);
        tel.setText(telephone);
        email.setText(eml);
        
        
        
    }//GEN-LAST:event_u_infoMouseClicked

    private void s_authActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_authActionPerformed
        
    }//GEN-LAST:event_s_authActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showConfirmDialog(null, "Do you really want to update this field? ");
        
        String userid = u_id.getText();
        String athr = auth.getSelectedItem().toString();
        String username = u_name1.getText();
        String password = pwd.getText();
        String u_name = name.getText();
        String address = add.getText();
        String telephone = tel.getText();
        String eml = email.getText();
        
        String sql = "UPDATE user set User_TYPE_Name = '"+athr+"', Username = '"+ username+"',Password = '"+ password+"',Name = '"+u_name +"',Address = '"+address+"',Phone = '"+telephone +"',Email = '"+ eml+"' WHERE User_ID = '"+userid+"' ";
        try {
            pst= con.prepareStatement(sql);
            pst.execute();
            tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        
        String name3 = s_name.getText();
        String auth3 = s_auth.getSelectedItem().toString();
        
        
      
        
        if(auth3.equals("Salesmen")){
        
             
        String sql = "SELECT * from user where Username LIKE  '%"+name3+"%'AND User_Type_Name='"+auth3+"' "; 
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            u_info.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        }else if(auth3.equals("Sales Manager")){
            
              String sql = "SELECT * from user where Username LIKE  '%"+name3+"%'AND User_Type_Name='"+auth3+"'"; 
             try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            u_info.setModel(DbUtils.resultSetToTableModel(rs));
        
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        }else if(auth3.equals("Administrator")){
        
             String sql = "SELECT * from user where Username LIKE  '%"+name3+"%'AND User_Type_Name='"+auth3+"'"; 
             try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            u_info.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        }else if(auth3.equals("Inventory Manager")){
            
             String sql = "SELECT * from user where Username LIKE  '%"+name3+"%'AND User_Type_Name='"+auth3+"' "; 
             try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            u_info.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        }else{
                
            String sql = "SELECT * from user where Username LIKE  '%"+name3+"%'"; 
             try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            u_info.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        String name = customer_name.getText();
        String addr = customer_add.getText();
        String city= customer_city.getText();
        String country = customer_country.getText();
        
     
        try {
            String sql = "SELECT * from customer where Cust_Name LIKE  '%"+name+"%' AND Address LIKE '%"+addr+"%' AND City LIKE '%"+city+"%' AND Country LIKE '%"+country+"%'";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            cus_table.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void cat_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cat_tableMouseClicked
        int r = cat_table.getSelectedRow();
        String catid= cat_table.getValueAt(r, 0).toString();
        String catname = cat_table.getValueAt(r, 1).toString();
                
        cat_id.setText(catid);
        cat_name.setText(catname);
        
    }//GEN-LAST:event_cat_tableMouseClicked

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
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton25ActionPerformed

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
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton10ActionPerformed

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

    private void cus_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cus_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cus_cityActionPerformed

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

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
       
        
          String supp_name = sup_name.getText();
       
        
        String sql = "SELECT * from supplier where Supplier_Name LIKE  '%"+supp_name+"%'"; 
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            supp_table.setModel(DbUtils.resultSetToTableModel(rs));
         
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
   
        String categoryid = i_cat.getSelectedItem().toString();
        String itemname = i_name.getText();
        float itemprice = Float.parseFloat(i_price.getText());
        int itemqty = Integer.parseInt(i_qty.getText());
        String itemstat = i_stat.getSelectedItem().toString();

        

        try{
           
            String q = "INSERT INTO item (Category_Name,Item_Name,Item_Price,Item_Qty,Item_Status) values('"+categoryid+"','"+itemname+"','"+itemprice+"','"+itemqty+"','"+itemstat+"')";
            pst = con.prepareStatement(q);
            pst.execute();

            item_tableload();

        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_jButton11ActionPerformed

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
           tableload();
        
            } else{ 
            
            
            String sql = "SELECT * FROM item WHERE Item_Name ='"+i_name1 +"'  AND Item_Status='"+i_stat1+"' AND Item_Price between '"+to_1 +"' and '"+ to_2+"'" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
           tableload();
        
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
             tableload();
        
            }else{ 
            
            
            String sql = "SELECT * FROM item WHERE Item_Name ='"+i_name1+"' AND Category_Name = '"+categoryid+"' AND Item_Status='"+i_stat1+"' AND Item_Price between '"+to_1 +"' and '"+ to_2+"'" ;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            item_table.setModel(DbUtils.resultSetToTableModel(rs));
             tableload();
        
            }
           
           
           
           }  
          
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        u_id.setText(null);
        auth.setSelectedItem(null);
        u_name1.setText(null);
        pwd.setText(null);
        name.setText(null);
        add.setText(null);
        tel.setText(null);
        email.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String sql = "SELECT * FROM user";
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
       String sql = "SELECT * FROM item";
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            item_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        String sql = "SELECT * FROM customer";
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            cus_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String sql = "SELECT * FROM supplier";
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            supp_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String sql = "SELECT * FROM orders";
        
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
            order_tableload();
        } catch (SQLException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
       cus_id.setText(null);
       cus_name.setText(null);
       cus_tel.setText(null);
       cus_add.setText(null);
       cus_city.setText(null);
       cus_country.setText(null);
       cus_m.setSelected(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        cat_id.setText(null);
        cat_name.setText(null);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
       indt_id.setText(null);
       sup_id.setSelectedItem(null);
       item_id.setSelectedItem(null);
       total.setText(null);
       indnt_qty.setText(null);
       indt_status.setSelectedItem("Confirmed");
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        supp_id.setText(null);
        supp_name.setText(null);
        supp_add.setText(null);
        supp_tel.setText(null);
        supp_email.setText(null);
    }//GEN-LAST:event_jButton41ActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Login lgout = new Login();
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

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
         try {
            
            String report = "E:\\SLIIT\\Project\\ST2\\project\\Inventory Control System\\src\\Admin\\user.jrxml";
            JasperReport jp = JasperCompileManager.compileReport(report);
            JasperPrint jd = JasperFillManager.fillReport(jp, null,con);
            JasperViewer.viewReport(jd,false);
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

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
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
           
                    new Administrator().setVisible(true);
         
               
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Quantity;
    private javax.swing.JTextField add;
    private javax.swing.JComboBox auth;
    private javax.swing.JTextField cat_id;
    private javax.swing.JTextField cat_name;
    private javax.swing.JTable cat_table;
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
    private javax.swing.JTextField email;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField name;
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
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField reportR1;
    private javax.swing.JTextField reportR2;
    private javax.swing.JComboBox s_auth;
    private javax.swing.JComboBox s_id;
    private javax.swing.JTextField s_name;
    private javax.swing.JComboBox st;
    private javax.swing.JComboBox sup_id;
    private javax.swing.JTextField sup_name;
    private javax.swing.JTextField supp_add;
    private javax.swing.JTextField supp_email;
    private javax.swing.JLabel supp_id;
    private javax.swing.JTextField supp_name;
    private javax.swing.JTable supp_table;
    private javax.swing.JTextField supp_tel;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField to1;
    private javax.swing.JTextField to2;
    private javax.swing.JLabel tot_purchase;
    private javax.swing.JLabel total;
    private javax.swing.JLabel u_id;
    private javax.swing.JTable u_info;
    private javax.swing.JTextField u_name1;
    private javax.swing.JTabbedPane u_panel;
    // End of variables declaration//GEN-END:variables
}
