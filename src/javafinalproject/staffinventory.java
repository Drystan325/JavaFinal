/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javafinalproject;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class staffinventory extends javax.swing.JFrame {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    public staffinventory() {
        initComponents();
        this.setLocationRelativeTo(null);
        date();
        time();
        table();

    }

    public void username(String user) {

        username.setText(user);

        try {
            Statement st = con.createStatement();
            con = connection.connectDB();
            String sql = "select * FROM user WHERE username = '" + user + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String u = rs.getString("user_id");
                userid.setText(u);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void date() {

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String day = sdf.format(d);
        dat.setText(day);

    }

    public void time() {
        new javax.swing.Timer(0, (ActionEvent e) -> {
            Date d = new Date();
            SimpleDateFormat f = new SimpleDateFormat("hh:mm:ss a");
            timer.setText(f.format(d));
        }).start();
    }

    private void lowstock() {
        con = connection.connectDB();
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }

        try {
            Statement st = con.createStatement();
            String sql;
            sql = "SELECT * FROM `items` WHERE `quantity`<11";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                String code = rs.getString("code");
                String item = rs.getString("item");
                String description = rs.getString("description");
                String quantity = rs.getString("quantity");
                String status = rs.getString("status");

                String tbData[] = {code, item, description, quantity, status};
                tblModel.addRow(tbData);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void code() {
        con = connection.connectDB();

        try {
            String text = Search.getText();
            ps = con.prepareStatement("SELECT * FROM `items` WHERE `code`=?");
            ps.setString(1, text);
            rs = ps.executeQuery();
            if (rs.next()) {
                DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
                while (tblModel.getRowCount() > 0) {
                    tblModel.removeRow(0);
                }
                String code = rs.getString("code");
                String item = rs.getString("item");
                String description = rs.getString("description");
                String quantity = rs.getString("quantity");
                String status = rs.getString("status");

                String tbData[] = {code, item, description, quantity, status};
                tblModel.addRow(tbData);

            } else {
                JOptionPane.showMessageDialog(null, "Code Not Found", "No Data Found!", JOptionPane.ERROR_MESSAGE);

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void filteritem() {

        con = connection.connectDB();
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }

        try {

            String sql;
            sql = "SELECT `code`, `item`, `description`, `quantity`, `status` FROM `items` WHERE  `item`='" + ifield.getText() + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                try {
                    String code = rs.getString("code");
                    String item = rs.getString("item");
                    String descript = rs.getString("description");
                    String quantity = rs.getString("quantity");
                    String status = rs.getString("status");

                    String tbData[] = {code, item, descript, quantity, status};
                    tblModel.addRow(tbData);

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Item Not Found", "Warning", JOptionPane.ERROR_MESSAGE);
                    table();
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void table() {
        con = connection.connectDB();
        DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
        while (tblModel.getRowCount() > 0) {
            tblModel.removeRow(0);
        }
        try {
            Statement st = con.createStatement();
            String sql;
            sql = "SELECT * FROM items";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                String code = rs.getString("code");
                String item = rs.getString("item");
                String description = rs.getString("description");
                String quantity = rs.getString("quantity");
                String status = rs.getString("status");

                String tbData[] = {code, item, description, quantity, status};
                tblModel.addRow(tbData);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

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

        jPanel1 = new javax.swing.JPanel();
        timer = new javax.swing.JLabel();
        dat = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        additem = new javax.swing.JButton();
        updateitem = new javax.swing.JButton();
        removeitem = new javax.swing.JButton();
        stockin = new javax.swing.JButton();
        stockout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lowstock = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        codefield = new javax.swing.JTextField();
        itemf = new javax.swing.JTextField();
        descripf = new javax.swing.JTextField();
        aquantf = new javax.swing.JTextField();
        mquantf = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        all = new javax.swing.JButton();
        userid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        codeb = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        itemb = new javax.swing.JButton();
        ifield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        timer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        timer.setText("time");

        dat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dat.setText("date");

        username.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        username.setText("user");

        additem.setBackground(new java.awt.Color(102, 255, 102));
        additem.setText("Add New Item");
        additem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additemActionPerformed(evt);
            }
        });

        updateitem.setBackground(new java.awt.Color(51, 102, 255));
        updateitem.setText("Update Item");
        updateitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateitemActionPerformed(evt);
            }
        });

        removeitem.setBackground(new java.awt.Color(255, 102, 153));
        removeitem.setText("Remove Item");
        removeitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeitemActionPerformed(evt);
            }
        });

        stockin.setBackground(new java.awt.Color(255, 204, 0));
        stockin.setText("Stock In");
        stockin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockinActionPerformed(evt);
            }
        });

        stockout.setBackground(new java.awt.Color(204, 51, 0));
        stockout.setText("Stock Out");
        stockout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockoutActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "code", "item", "description", "quantity", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        lowstock.setBackground(new java.awt.Color(255, 102, 51));
        lowstock.setText("Low Stock Item");
        lowstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lowstockActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(255, 51, 51));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setText("Item:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel6.setText("Code:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel7.setText("Description:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setText("Available Quantity:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setText("Manage Quantity:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel11.setText("Status:");

        codefield.setEditable(false);

        itemf.setEditable(false);
        itemf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemfActionPerformed(evt);
            }
        });

        descripf.setEditable(false);

        aquantf.setEditable(false);

        all.setBackground(new java.awt.Color(153, 255, 255));
        all.setText("All Items");
        all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allActionPerformed(evt);
            }
        });

        userid.setBackground(new java.awt.Color(102, 255, 255));
        userid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        userid.setText("id");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setText("User Id:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setText("Date:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setText("Time:");

        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                SearchKeyTyped(evt);
            }
        });

        codeb.setBackground(new java.awt.Color(255, 204, 102));
        codeb.setText("Search Code");
        codeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codebActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(255, 102, 102));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        itemb.setBackground(new java.awt.Color(255, 255, 102));
        itemb.setText("Search Item");
        itemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itembActionPerformed(evt);
            }
        });

        ifield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ifieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ifieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(all, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ifield)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(itemb, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(codeb, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stockout, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(372, 372, 372)
                                .addComponent(stockin, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(itemf)
                    .addComponent(codefield)
                    .addComponent(descripf)
                    .addComponent(aquantf)
                    .addComponent(mquantf))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeitem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateitem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(additem, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowstock, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userid)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(all)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeb)
                    .addComponent(itemb)
                    .addComponent(ifield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(additem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateitem)
                    .addComponent(itemf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeitem)
                    .addComponent(descripf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(aquantf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lowstock))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mquantf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stockin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stockout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(logout)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateitemActionPerformed
        // TODO add your handling code here:

        String item = itemf.getText();
        String description = descripf.getText();
        String available = aquantf.getText();
        String stat = status.getText();

        if (item.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select An Item In The Table That You Want To Update");
        } else {
            DefaultTableModel t = (DefaultTableModel) table.getModel();
            int selectIndex = table.getSelectedRow();
            String id2 = (String) t.getValueAt(selectIndex, 0);
            con = connection.connectDB();
            try {
                ps = con.prepareStatement("SELECT * FROM `items` WHERE `item`=?");
                ps.setString(1, item);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String newstat = rs.getString(6);
                    if (newstat.equals(stat)) {
                        JOptionPane.showMessageDialog(null, "No Update Made!");
                    } else {
                        try {
                            String sql = "UPDATE `items` SET item=? ,description=? ,quantity=? ,status=? WHERE code=?";
                            ps = con.prepareStatement(sql);

                            ps.setString(1, item);
                            ps.setString(2, description);
                            ps.setString(3, available);
                            ps.setString(4, stat);
                            ps.setString(5, id2);

                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Update Successful! ");
                            String users = username.getText();
                            String transaction = "updated the Item " + item + "";
                            String code = codefield.getText();
                            String dates = dat.getText();
                            String times = timer.getText();

                            ps = con.prepareStatement("INSERT INTO `transactions`(user,transaction,date,time,code,item,quantity) VALUES (?,?,?,?,?,?,?)");

                            ps.setString(1, users);
                            ps.setString(2, transaction);
                            ps.setString(3, dates);
                            ps.setString(4, times);
                            ps.setString(5, code);
                            ps.setString(6, item);
                            ps.setString(7, available);

                            ps.executeUpdate();
                            codefield.setText("");
                            itemf.setText("");
                            descripf.setText("");
                            aquantf.setText("");
                            status.setText("");
                            mquantf.setText("");

                        } catch (HeadlessException | SQLException e) {
                            JOptionPane.showMessageDialog(this, "ERROR!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                        table();

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "To Update Quantity, Choose Wether To Stock In Or Stock Out Quantity!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

            }

        }


    }//GEN-LAST:event_updateitemActionPerformed

    private void removeitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeitemActionPerformed
        // TODO add your handling code here:

        int row = table.getSelectedRow();
        String i = itemf.getText();
        if (i.equals("")) {
            JOptionPane.showConfirmDialog(this, "Please Select An Item In The Table That You Want To Remove!", "WARNING!", JOptionPane.WARNING_MESSAGE);
        } else {
            int x = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Remove This Product?", "WARNING!", JOptionPane.WARNING_MESSAGE);

            if (x == 0) {

                try {
                    String cell = table.getModel().getValueAt(row, 0).toString();
                    String sql = "DELETE FROM `items` WHERE code='" + cell + "'";
                    ps = con.prepareStatement(sql);
                    ps.execute();

                    JOptionPane.showMessageDialog(this, "You Deleted The Item  " + i + " ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    String users = username.getText();
                    String transaction = "Removed the Item " + i + "";
                    String code = codefield.getText();
                    String dates = dat.getText();
                    String times = timer.getText();
                    String available = aquantf.getText();

                    ps = con.prepareStatement("INSERT INTO `transactions`(user,transaction,date,time,code,item,quantity) VALUES (?,?,?,?,?,?,?)");

                    ps.setString(1, users);
                    ps.setString(2, transaction);
                    ps.setString(3, dates);
                    ps.setString(4, times);
                    ps.setString(5, code);
                    ps.setString(6, i);
                    ps.setString(7, available);

                    ps.executeUpdate();
                    codefield.setText("");
                    itemf.setText("");
                    descripf.setText("");
                    aquantf.setText("");
                    status.setText("");
                    mquantf.setText("");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

                }
                table();
                codefield.setText("");
                itemf.setText("");
                descripf.setText("");
                aquantf.setText("");
                status.setText("");
                mquantf.setText("");

            } else {

            }
        }


    }//GEN-LAST:event_removeitemActionPerformed

    private void additemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additemActionPerformed
        // TODO add your handling code here:
        String users = username.getText();
        String id = userid.getText();
        addnewitem ad = new addnewitem();
        ad.show();
        dispose();
        ad.username(users);
        ad.userid(id);


    }//GEN-LAST:event_additemActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        try {
            int row = table.getSelectedRow();
            String Tclick = (table.getModel().getValueAt(row, 0).toString());
            String cat = (table.getModel().getValueAt(row, 3).toString());
            Integer cate = Integer.valueOf(cat);
            String sql = "select * from items where code = '" + Tclick + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                String codes = rs.getString("code");
                codefield.setText(codes);
                String items = rs.getString("item");
                itemf.setText(items);
                String descriptions = rs.getString("description");
                descripf.setText(descriptions);
                String avails = rs.getString("quantity");
                aquantf.setText(avails);
                String stats = rs.getString("status");
                status.setText(stats);
            }
            if (cate <= 10 && cate >= 1) {
                JOptionPane.showMessageDialog(null, "Your Stock Quantity On This Product Is Running Low! Please Add Your Stock Now!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            if (cate == 0) {
                JOptionPane.showMessageDialog(null, "You Don't Have Any Stock Available In This Product! Please Add Your Stock Now!", "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_tableMouseClicked

    private void lowstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lowstockActionPerformed
        // TODO add your handling code here:
        lowstock();

    }//GEN-LAST:event_lowstockActionPerformed

    private void allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allActionPerformed
        // TODO add your handling code here:
        table();
    }//GEN-LAST:event_allActionPerformed

    private void stockinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockinActionPerformed
        // TODO add your handling code here:
        con = connection.connectDB();
        String c = mquantf.getText();
        String d = codefield.getText();

        if (d.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select An Item In The Table That You Want To Add Quantity");
        } else if (c.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Quantity You Want To Add In Your Current Stock! ");
        } else {
            try {
                Integer a = Integer.parseInt(aquantf.getText());
                Integer b = Integer.parseInt(mquantf.getText());
                int total = a + b;
                String ans = Integer.toString(total);

                int id = rs.getInt(1);

                ps = con.prepareStatement("UPDATE `items` SET  quantity=? where id=?");
                int x = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Stock In " + c + " Quantity In Your Stocks?", "WARNING!", JOptionPane.WARNING_MESSAGE);
                if (x == 0) {
                    ps.setString(1, ans);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "You Have Succesfully Stock In " + c + " Quantity In Your Stocks", "WARNING!", JOptionPane.PLAIN_MESSAGE);

                    String users = username.getText();
                    String transaction = "Stock In " + c + " Quantity";
                    String code = codefield.getText();
                    String item = itemf.getText();
                    String available = ans;
                    String dates = dat.getText();
                    String times = timer.getText();

                    ps = con.prepareStatement("INSERT INTO `transactions`(user,transaction,date,time,code,item,quantity) VALUES (?,?,?,?,?,?,?)");

                    ps.setString(1, users);
                    ps.setString(2, transaction);
                    ps.setString(3, dates);
                    ps.setString(4, times);
                    ps.setString(5, code);
                    ps.setString(6, item);
                    ps.setString(7, available);

                    ps.executeUpdate();
                    codefield.setText("");
                    itemf.setText("");
                    descripf.setText("");
                    aquantf.setText("");
                    status.setText("");
                    mquantf.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Cancelled!");
                    codefield.setText("");
                    itemf.setText("");
                    descripf.setText("");
                    aquantf.setText("");
                    status.setText("");
                    mquantf.setText("");

                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            table();
            codefield.setText("");
            itemf.setText("");
            descripf.setText("");
            aquantf.setText("");
            status.setText("");
            mquantf.setText("");

        }

    }//GEN-LAST:event_stockinActionPerformed

    private void stockoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockoutActionPerformed
        // TODO add your handling code here:
        con = connection.connectDB();
        String c = mquantf.getText();
        String d = codefield.getText();

        if (d.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Please Select An Item You Want To Stock Out");
        } else if (c.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Quantity You Want To Deduct In Your Current Stock! ");
        } else {
            try {
                Integer a = Integer.parseInt(aquantf.getText());
                Integer b = Integer.parseInt(mquantf.getText());
                int total = a - b;
                String ans = Integer.toString(total);
//              

                int id = rs.getInt(1);

                ps = con.prepareStatement("UPDATE `items` SET  quantity=? where id=?");
                int x = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Stock Out " + c + " Quantity In Your Stocks?", "WARNING!", JOptionPane.WARNING_MESSAGE);
                if (x == 0) {
                    ps.setString(1, ans);
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "You Have Succesfully Stock Out " + c + " Quantity In Your Stocks", "WARNING!", JOptionPane.PLAIN_MESSAGE);

                    String users = username.getText();
                    String transaction = "Stock Out " + c + " Quantity";
                    String code = codefield.getText();
                    String item = itemf.getText();
                    String available = ans;
                    String dates = dat.getText();
                    String times = timer.getText();

                    ps = con.prepareStatement("INSERT INTO `transactions`(user,transaction,date,time,code,item,quantity) VALUES (?,?,?,?,?,?,?)");

                    ps.setString(1, users);
                    ps.setString(2, transaction);
                    ps.setString(3, dates);
                    ps.setString(4, times);
                    ps.setString(5, code);
                    ps.setString(6, item);
                    ps.setString(7, available);

                    ps.executeUpdate();
                    codefield.setText("");
                    itemf.setText("");
                    descripf.setText("");
                    aquantf.setText("");
                    status.setText("");
                    mquantf.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Cancelled!");
                    codefield.setText("");
                    itemf.setText("");
                    descripf.setText("");
                    aquantf.setText("");
                    status.setText("");
                    mquantf.setText("");

                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            table();
            codefield.setText("");
            itemf.setText("");
            descripf.setText("");
            aquantf.setText("");
            status.setText("");
            mquantf.setText("");

        }

    }//GEN-LAST:event_stockoutActionPerformed

    private void codebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codebActionPerformed
        // TODO add your handling code here:
        String s = Search.getText();
        if (s.equals("")) {
            JOptionPane.showMessageDialog(this, "Please Input Code!", "WARNING!", JOptionPane.ERROR_MESSAGE);

        } else {
            code();
        }

    }//GEN-LAST:event_codebActionPerformed

    private void itemfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemfActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Leave This Page?", "WARNING!", JOptionPane.WARNING_MESSAGE);
        if (x == 0) {
            LOGIN li = new LOGIN();
            li.show();
            dispose();
        } else {

        }
    }//GEN-LAST:event_logoutActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        String check = codefield.getText();

        if (check.equals("")) {

        } else {
            int x = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Cancel?", "WARNING!", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showConfirmDialog(this, "Cancelled!", "WARNING!", JOptionPane.WARNING_MESSAGE);
            if (x == 0) {
                codefield.setText("");
                itemf.setText("");
                descripf.setText("");
                aquantf.setText("");
                status.setText("");
                mquantf.setText("");
            } else {

            }
        }


    }//GEN-LAST:event_cancelActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

    private void itembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itembActionPerformed
        // TODO add your handling code here:
        String s = ifield.getText();
        try {
            String sql;
            sql = "SELECT `code`, `item`, `description`, `quantity`, `status` FROM `items` WHERE  `item`='" + ifield.getText() + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                filteritem();
            } else if (s.equals("")) {
                JOptionPane.showMessageDialog(this, "Please Input Item Name!", "WARNING!", JOptionPane.ERROR_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Item Not Found", "No Data Found!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(staffinventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itembActionPerformed

    private void ifieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ifieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ifieldKeyPressed

    private void ifieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ifieldKeyTyped
        // TODO add your handling code here:
        Search.setText("");
    }//GEN-LAST:event_ifieldKeyTyped

    private void SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyTyped
        // TODO add your handling code here:
        ifield.setText("");
    }//GEN-LAST:event_SearchKeyTyped

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
            java.util.logging.Logger.getLogger(staffinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(staffinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(staffinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(staffinventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new staffinventory().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JButton additem;
    private javax.swing.JButton all;
    private javax.swing.JTextField aquantf;
    private javax.swing.JButton cancel;
    private javax.swing.JButton codeb;
    private javax.swing.JTextField codefield;
    private javax.swing.JLabel dat;
    private javax.swing.JTextField descripf;
    private javax.swing.JTextField ifield;
    private javax.swing.JButton itemb;
    private javax.swing.JTextField itemf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logout;
    private javax.swing.JButton lowstock;
    private javax.swing.JTextField mquantf;
    private javax.swing.JButton removeitem;
    private javax.swing.JTextField status;
    private javax.swing.JButton stockin;
    private javax.swing.JButton stockout;
    private javax.swing.JTable table;
    private javax.swing.JLabel timer;
    private javax.swing.JButton updateitem;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
