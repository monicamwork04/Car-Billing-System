package main;

import PS.JDBC;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author acer
 */

public class bill_page extends javax.swing.JFrame {

    public bill_page() {
        initComponents();
        Load();
    }

    public void Load() {
        try (Connection Con = JDBC.Con()) {

            String sql =
                    "SELECT emp_id FROM tbl_emp WHERE emp_role = 'Admin'";

            try (PreparedStatement ps = Con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                emp_id.removeAllItems();
                emp_id.addItem("-ID-");

                while (rs.next()) {
                    emp_id.addItem(rs.getString("emp_id"));
                }
            }

            LoadPart();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, "Error loading employees: " + e.getMessage()
            );
        }
    }

    public void LoadPart() {
        try (Connection con = JDBC.Con();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT part_id FROM tbl_part");
             ResultSet rs = ps.executeQuery()) {

            part_id.removeAllItems();
            part_id.addItem("-ID-");

            while (rs.next()) {
                part_id.addItem(rs.getString("part_id"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this, "Error loading parts: " + e.getMessage()
            );
        }
    }

    // Keep initComponents() and all event handlers here.

  

        



     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        emp_id = new javax.swing.JComboBox<>();
        part_id = new javax.swing.JComboBox<>();
        p_qty = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        c_cell = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        c_name = new javax.swing.JLabel();
        c_id = new javax.swing.JLabel();
        p_name = new javax.swing.JLabel();
        p_price = new javax.swing.JLabel();
        p_stock = new javax.swing.JLabel();
        p_total = new javax.swing.JLabel();
        g_total = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("BILL PAGE");

        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("EMP ID");

        jLabel4.setText("PART_ID");

        jLabel5.setText("P_NAME");

        jLabel6.setText("P PRICE");

        jLabel7.setText("P STOCK");

        jLabel8.setText("C CELL");

        jLabel9.setText("P QTY");

        jLabel10.setText("P TOTAL");

        jLabel11.setText("G TOTAL");

        emp_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        part_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        part_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                part_idActionPerformed(evt);
            }
        });

        p_qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p_qtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                p_qtyFocusLost(evt);
            }
        });

        jButton2.setText("BILL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("GET");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        c_cell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                c_cellFocusLost(evt);
            }
        });

        jLabel12.setText("C NAME");

        jLabel13.setText("C ID");

        c_name.setText("c_name");

        c_id.setText("c_id");

        p_name.setText("p_name");

        p_price.setText("p_price");

        p_stock.setText("p_stock");

        p_total.setText("p_total");

        g_total.setText("g_total");

        jButton5.setText("PDF");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("RESET");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("CANCEL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p_total)
                                    .addComponent(p_stock)
                                    .addComponent(g_total)
                                    .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p_price)
                                    .addComponent(p_name)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(part_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(jButton5)
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2)
                                .addComponent(jLabel2)
                                .addComponent(jButton3)
                                .addComponent(jButton4))
                            .addGap(166, 166, 166)
                            .addComponent(jButton6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(c_id))
                                .addComponent(c_name)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(42, 42, 42)
                            .addComponent(c_cell, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton6))))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_cell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(part_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(c_name))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(p_name))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(c_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(p_price))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton2)))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(p_stock)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jButton3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(p_total)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(g_total))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton5))
                        .addGap(56, 56, 56))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   // Reset employee and part selections
    emp_id.setSelectedIndex(0);
    part_id.setSelectedIndex(0);

    // Clear quantity and customer phone
    p_qty.setText("");
    c_cell.setText("");

    // Reset customer details
    c_name.setText("c_name");
    c_id.setText("c_id");

    // Reset product details
    p_name.setText("");
    p_price.setText("");
    p_stock.setText("");
    p_total.setText("");

    // Reset grand total
    g_total.setText("0.00");

    // Clear bill table
    tbl.setModel(new DefaultTableModel(
        new String[]{
            "S.No.", "Product Name", "Quantity", "Price", "Total"
        }, 0
    ));

    JOptionPane.showMessageDialog(this, "Bill form reset successfully.");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void part_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_part_idActionPerformed
      
   

    Object selected = part_id.getSelectedItem();

    if (selected == null || "-ID-".equals(selected.toString())) {
        p_name.setText("");
        p_price.setText("");
        p_stock.setText("");
        p_total.setText("");
        return;
    }

    String pid = selected.toString();

    String sql = "SELECT part_name, part_price, part_stock "
               + "FROM tbl_part WHERE part_id = ?";

    try (Connection con = JDBC.Con();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, pid);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                p_name.setText(rs.getString("part_name"));
                p_price.setText(rs.getString("part_price"));
                p_stock.setText(rs.getString("part_stock"));

            } else {

                p_name.setText("");
                p_price.setText("");
                p_stock.setText("");
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this, e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_part_idActionPerformed

    private void p_qtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p_qtyFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_p_qtyFocusGained

    private void p_qtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p_qtyFocusLost
   
    String qtyText = p_qty.getText().trim();
    String priceText = p_price.getText().trim();

    if (qtyText.isEmpty()) {
        p_total.setText("");
        return;
    }

    try {
        int qty = Integer.parseInt(qtyText);
        double price = Double.parseDouble(priceText);

        if (qty <= 0) {
            JOptionPane.showMessageDialog(
                    this, "Quantity must be greater than zero."
            );
            return;
        }

        int stock = Integer.parseInt(p_stock.getText().trim());

        if (qty > stock) {
            JOptionPane.showMessageDialog(
                    this, "Insufficient stock."
            );
            p_total.setText("");
            return;
        }

        double total = qty * price;
        p_total.setText(String.format("%.2f", total));

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this, "Select a product and enter a valid quantity."
        );
        p_total.setText("");
    }

   


    }//GEN-LAST:event_p_qtyFocusLost

    private void c_cellFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c_cellFocusLost
     
    String cell = c_cell.getText().trim();

    if (cell.isEmpty()) {
        c_name.setText("c_name");
        c_id.setText("c_id");
        return;
    }

    String sql =
            "SELECT cus_name, cus_id FROM tbl_cus WHERE cus_phone = ?";

    try (Connection con = JDBC.Con();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, cell);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                c_name.setText(rs.getString("cus_name"));
                c_id.setText(rs.getString("cus_id"));
            } else {
                c_name.setText("Customer not found");
                c_id.setText("");

                JOptionPane.showMessageDialog(
                        this, "Customer not found."
                );
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
        e.printStackTrace();
    }

   

    }//GEN-LAST:event_c_cellFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
    Object selectedPart = part_id.getSelectedItem();
    Object selectedEmp = emp_id.getSelectedItem();

    if (selectedPart == null || selectedEmp == null
            || "-ID-".equals(selectedPart.toString())
            || "-ID-".equals(selectedEmp.toString())) {
        JOptionPane.showMessageDialog(
                this, "Please select Employee ID and Part ID."
        );
        return;
    }

    String pid = selectedPart.toString();
    String eid = selectedEmp.toString();
    String cid = c_id.getText().trim();
    String qtyText = p_qty.getText().trim();

    if (cid.isEmpty() || cid.equals("c_id")
            || cid.equals("Customer not found") || qtyText.isEmpty()) {
        JOptionPane.showMessageDialog(
                this, "Enter a valid customer phone number and quantity."
        );
        return;
    }

    try {
        int qty = Integer.parseInt(qtyText);
        int stock = Integer.parseInt(p_stock.getText().trim());
        double price = Double.parseDouble(p_price.getText().trim());

        if (qty <= 0 || qty > stock) {
            JOptionPane.showMessageDialog(
                    this, "Quantity must be within available stock."
            );
            return;
        }

        double total = qty * price;

        String billDate = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss"
        ).format(new Date());

        try (Connection con = JDBC.Con();
             CallableStatement cs = con.prepareCall(
                     "{call dbo.sp_bill_insert(?,?,?,?,?,?,?)}")) {

            cs.setString(1, eid);
            cs.setString(2, pid);
            cs.setString(3, cid);
            cs.setString(4, String.valueOf(qty));
            cs.setString(5, String.format(java.util.Locale.US, "%.2f", total));
            cs.setString(6, billDate);
            cs.registerOutParameter(7, Types.VARCHAR);

            cs.execute();

            String result = cs.getString(7);

           if (result != null
        && result.toLowerCase().contains("successfully")) {

    JOptionPane.showMessageDialog(this, result);

} else {
    JOptionPane.showMessageDialog(
            this, "Bill insertion failed: " + result
    );
    return;
}
        }

        // Reload the bill table and grand total.
        jButton3ActionPerformed(null);

        // Refresh the selected product's current stock.
        part_idActionPerformed(null);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this, "Please enter valid quantity, price, and stock."
        );
    } catch (Exception e) {
        JOptionPane.showMessageDialog(
                this, "Bill insertion error: " + e.getMessage()
        );
        e.printStackTrace();
    }
  
     
    
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
 
    String cid = c_id.getText().trim();

    if (cid.isEmpty() || cid.equals("c_id")) {
        JOptionPane.showMessageDialog(
                this, "Please enter a valid customer phone number."
        );
        return;
    }

    DefaultTableModel model = new DefaultTableModel(
            new String[]{
                "S.No.", "Product Name", "Quantity", "Price", "Total"
            }, 0
    );

    try (Connection con = JDBC.Con()) {

        String sql = "{call dbo.sp_get_bill_details(?,?)}";

        try (CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, cid);
            cs.registerOutParameter(2, Types.VARCHAR);

            boolean hasResultSet = cs.execute();

            if (hasResultSet) {
                try (ResultSet rs = cs.getResultSet()) {

                    int serialNo = 1;

                    while (rs.next()) {
                        model.addRow(new Object[]{
                            serialNo++,
                            rs.getString("ProductName"),
                            rs.getString("Quantity"),
                            rs.getString("Price"),
                            rs.getString("Total")
                        });
                    }
                }
            }

            tbl.setModel(model);

            String result = cs.getString(2);

            if (result != null) {
                JOptionPane.showMessageDialog(this, result);
            }
        }

        String totalSql = "{call dbo.sp_bill_grand_total(?)}";

        try (CallableStatement cs = con.prepareCall(totalSql)) {

            cs.setString(1, cid);

            try (ResultSet rs = cs.executeQuery()) {

                if (rs.next()) {
                    g_total.setText(
                            String.valueOf(rs.getDouble("GrandTotal"))
                    );
                } else {
                    g_total.setText("0.00");
                }
            }
        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this, "Error retrieving bill: " + e.getMessage()
        );
        e.printStackTrace();
    }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    try {
        MessageFormat header = new MessageFormat("JKM COMPANY - BILL COPY");

        String gtotal = this.g_total.getText();
        String name = this.c_name.getText();
        String cell = this.c_cell.getText();

        MessageFormat footer = new MessageFormat(
            "Grand Total: " + gtotal
            + " NAME: " + name
            + " Cell: " + cell
        );

        PrinterJob tbl1 = PrinterJob.getPrinterJob();

        tbl1.setPrintable(
            tbl.getPrintable(
                JTable.PrintMode.FIT_WIDTH,
                header,
                footer
            )
        );

        if (tbl1.printDialog()) {
            tbl1.print();
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
        System.err.println(e);
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
  

    String customerName = c_name.getText();
    String customerPhone = c_cell.getText().trim();
    String grandTotal = g_total.getText();

    if (customerPhone.isEmpty()) {
        JOptionPane.showMessageDialog(
                this, "Enter customer phone number."
        );
        return;
    }

    // Save PDF directly to the user's home folder.
    String userHome = System.getProperty("user.home");

    String safePhone = customerPhone.replaceAll(
            "[\\\\/:*?\"<>|]", "_"
    );

    File pdfFile = new File(
            userHome, "Bill_" + safePhone + ".pdf"
    );

    Document document = new Document(PageSize.A4);

    try {
        PdfWriter.getInstance(
                document, new FileOutputStream(pdfFile)
        );

        document.open();

        document.add(new Paragraph("KAASHI COMPANY"));
        document.add(new Paragraph("BILL COPY"));
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Customer Name: " + customerName));
        document.add(new Paragraph("Customer Phone: " + customerPhone));
        document.add(new Paragraph("Date: " +
                new SimpleDateFormat("dd-MM-yyyy HH:mm")
                        .format(new Date())));
        document.add(new Paragraph("Grand Total: " + grandTotal));
        document.add(new Paragraph(" "));

        PdfPTable pdfTable = new PdfPTable(tbl.getColumnCount());
        pdfTable.setWidthPercentage(100);

        // Table headings
        for (int col = 0; col < tbl.getColumnCount(); col++) {
            pdfTable.addCell(tbl.getColumnName(col));
        }

        // Table data
        for (int row = 0; row < tbl.getRowCount(); row++) {
            for (int col = 0; col < tbl.getColumnCount(); col++) {
                Object value = tbl.getValueAt(row, col);

                pdfTable.addCell(
                        value == null ? "" : value.toString()
                );
            }
        }

        document.add(pdfTable);
        document.close();

        JOptionPane.showMessageDialog(
                this,
                "PDF saved successfully!\n\nLocation:\n"
                + pdfFile.getAbsolutePath()
        );

        

    } catch (Exception e) {
        if (document.isOpen()) {
            document.close();
        }

        JOptionPane.showMessageDialog(
                this, "PDF error: " + e.getMessage()
        );
        e.printStackTrace();
    }



    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     // Reset employee and part selections
    emp_id.setSelectedIndex(0);
    part_id.setSelectedIndex(0);

    // Clear quantity and customer phone
    p_qty.setText("");
    c_cell.setText("");

    // Reset customer details
    c_name.setText("c_name");
    c_id.setText("c_id");

    // Reset product details
    p_name.setText("");
    p_price.setText("");
    p_stock.setText("");
    p_total.setText("");

    // Reset grand total
    g_total.setText("0.00");

    // Clear bill table
    tbl.setModel(new DefaultTableModel(
        new String[]{
            "S.No.", "Product Name", "Quantity", "Price", "Total"
        }, 0
    ));

    JOptionPane.showMessageDialog(
        this, "Bill form reset successfully."
    );
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
          this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(bill_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c_cell;
    private javax.swing.JLabel c_id;
    private javax.swing.JLabel c_name;
    private javax.swing.JComboBox<String> emp_id;
    private javax.swing.JLabel g_total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel p_name;
    private javax.swing.JLabel p_price;
    private javax.swing.JTextField p_qty;
    private javax.swing.JLabel p_stock;
    private javax.swing.JLabel p_total;
    private javax.swing.JComboBox<String> part_id;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
