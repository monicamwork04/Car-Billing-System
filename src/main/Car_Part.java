package main;
import PS.JDBC;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Car_Part extends javax.swing.JFrame {

   

public Car_Part() {
    initComponents();
    setLocationRelativeTo(null);

    jButton1.setText("CANCEL");
    jButton5.setText("CLEAR");

    empid.removeAllItems();
    empid.addItem("--ID--");

    jLabel15.setText("GET");
    jLabel15.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            getPartImage();
        }
    });

    Load_emp();
    Load_Parts();
}


       
    
    
private void setImageColumnRenderer() {
    tbl.getColumnModel().getColumn(7).setCellRenderer(
        new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                JLabel label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);

                if (value instanceof ImageIcon) {
                    label.setIcon((ImageIcon) value);
                    label.setText("");
                } else {
                    label.setIcon(null);
                    label.setText("");
                }

                label.setOpaque(true);
                label.setBackground(
                    isSelected
                        ? table.getSelectionBackground()
                        : table.getBackground()
                );

                return label;
            }
        }
    );
}

   
private void Load_Parts() {
    Load_Parts(null); // Show all parts
}

private void Load_Parts(String employeeId) {
    String sql = "SELECT part_id, emp_id, part_name, part_detail, "
               + "part_mdate, part_price, part_stock, part_image "
               + "FROM tbl_part "
               + (employeeId == null ? "" : "WHERE emp_id = ? ")
               + "ORDER BY part_id";

    DefaultTableModel model = new DefaultTableModel(
        new String[]{
            "Part ID", "Employee ID", "Part Name", "Details",
            "Date", "Price", "Stock", "Image"
        }, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    try (Connection con = JDBC.Con();
         PreparedStatement ps = con.prepareStatement(sql)) {

        if (employeeId != null) {
            ps.setString(1, employeeId);
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String imagePath = rs.getString("part_image");
                ImageIcon thumbnail = createPartThumbnail(imagePath);

                model.addRow(new Object[]{
                    rs.getString("part_id"),
                    rs.getString("emp_id"),
                    rs.getString("part_name"),
                    rs.getString("part_detail"),
                    rs.getDate("part_mdate"),
                    rs.getBigDecimal("part_price"),
                    rs.getInt("part_stock"),
                    thumbnail != null ? thumbnail : imagePath
                });
            }
        }

     
tbl.setModel(model);
tbl.setRowHeight(65);
tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

int[] widths = {70, 85, 120, 150, 100, 80, 70, 100};

for (int i = 0; i < widths.length; i++) {
    tbl.getColumnModel().getColumn(i)
       .setPreferredWidth(widths[i]);
}

// Apply the renderer AFTER setting the table model
setImageColumnRenderer();


    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Unable to load parts: " + e.getMessage()
        );
    }
}

private ImageIcon createPartThumbnail(String imagePath) {
    if (imagePath == null || imagePath.trim().isEmpty()) {
        return null;
    }

    File file = new File(imagePath);

    if (!file.exists() || !file.isFile()) {
        return null;
    }

    ImageIcon original = new ImageIcon(imagePath);

    Image scaled = original.getImage().getScaledInstance(
        55, 55, Image.SCALE_SMOOTH
    );

    return new ImageIcon(scaled);
}

private void Load_emp() {
    String sql = "SELECT emp_id FROM tbl_emp ORDER BY emp_id";

    try (Connection con = JDBC.Con();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        empid.removeAllItems();
        empid.addItem("--ID--");

        while (rs.next()) {
            empid.addItem(rs.getString("emp_id"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Unable to load Employee IDs: " + e.getMessage()
        );
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        part_dt1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        empid = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        part_id = new javax.swing.JTextField();
        part_name = new javax.swing.JTextField();
        part_price = new javax.swing.JTextField();
        part_stock = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        part_full_image = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        emp_name_role = new javax.swing.JLabel();
        part_image = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("CAR PARTS PAGE");

        jLabel2.setText("EMP ID");

        jLabel3.setText("PART ID");

        jLabel4.setText("PART NAME");

        jLabel5.setText("PART PRICE");

        jLabel6.setText("PART STOCK");

        jLabel7.setText("PART DETAILS");

        part_dt1.setColumns(20);
        part_dt1.setRows(5);
        jScrollPane3.setViewportView(part_dt1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CLEAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        empid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        empid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empidActionPerformed(evt);
            }
        });

        jLabel8.setText("PART   DATE");

        part_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                part_idFocusLost(evt);
            }
        });
        part_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                part_idActionPerformed(evt);
            }
        });

        jLabel13.setText("PART IMAGE ");

        jLabel15.setText("GET");

        emp_name_role.setText("EMP NAME");

        part_image.setText("jLabel10");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(part_full_image, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(part_image, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 198, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(emp_name_role)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(part_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(part_price, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(part_id, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(part_name, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(emp_name_role)))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(part_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(part_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(part_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(part_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(part_full_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(part_image, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                        .addGap(144, 144, 144))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(221, 221, 221)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 


    String pid = part_id.getText().trim();

    if (pid.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter Part ID to delete");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete Part ID " + pid + "?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try (Connection con = JDBC.Con();
         CallableStatement stmt =
             con.prepareCall("{call sp_del_prod(?, ?)}")) {

        stmt.setString(1, pid);
        stmt.registerOutParameter(2, Types.VARCHAR);

        stmt.execute();

        String result = stmt.getString(2);

        JOptionPane.showMessageDialog(this, result);

       if (result != null &&
    result.toLowerCase().contains("deleted successfully")) {
    clearForm();
    Load_Parts();
}

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Delete failed: " + e.getMessage()
        );
    }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void part_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_part_idActionPerformed
        
    }//GEN-LAST:event_part_idActionPerformed

    private void empidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empidActionPerformed
    
    Object selected = empid.getSelectedItem();

    if (selected == null || "--ID--".equals(selected.toString())) {
        emp_name_role.setText("EMP NAME");
        return;
    }

    String eid = selected.toString();

    // Show employee name and role
    String empSql =
        "SELECT emp_name, emp_role FROM tbl_emp WHERE emp_id = ?";

    try (Connection con = JDBC.Con();
         PreparedStatement ps = con.prepareStatement(empSql)) {

        ps.setString(1, eid);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                emp_name_role.setText(
                    rs.getString("emp_name") + " - " +
                    rs.getString("emp_role")
                );
            }
        }

        // Load the selected employee's part into the left form
        String partSql =
            "SELECT TOP 1 part_id, part_name, part_detail, "
          + "part_mdate, part_price, part_stock, part_image "
          + "FROM tbl_part WHERE emp_id = ? ORDER BY part_id";

        try (PreparedStatement partPs = con.prepareStatement(partSql)) {
            partPs.setString(1, eid);

            try (ResultSet partRs = partPs.executeQuery()) {
                if (partRs.next()) {

                    part_id.setText(partRs.getString("part_id"));
                    part_name.setText(partRs.getString("part_name"));
                    part_dt1.setText(partRs.getString("part_detail"));
                    part_price.setText(partRs.getString("part_price"));
                    part_stock.setText(partRs.getString("part_stock"));

                    java.sql.Date date = partRs.getDate("part_mdate");
                    jDateChooser1.setDate(date);

                    String imagePath = partRs.getString("part_image");
                    part_full_image.setText(
                        imagePath == null ? "" : imagePath
                    );

                    // Display the image if the saved path exists
                    if (imagePath != null &&
                        new File(imagePath).isFile()) {

                        ImageIcon original = new ImageIcon(imagePath);
                        Image scaled = original.getImage().getScaledInstance(
                            119, 121, Image.SCALE_SMOOTH
                        );

                        part_image.setIcon(new ImageIcon(scaled));
                        part_image.setText("");
                    } else {
                        part_image.setIcon(null);
                        part_image.setText("Image unavailable");
                    }

                } else {
                    // No part is assigned to this employee
                    part_id.setText("");
                    part_name.setText("");
                    part_dt1.setText("");
                    part_price.setText("");
                    part_stock.setText("");
                    part_full_image.setText("");
                    jDateChooser1.setDate(null);
                    part_image.setIcon(null);
                    part_image.setText("No image");
                    
                    JOptionPane.showMessageDialog(
                        this, "No parts found for this employee."
                    );
                }
            }
        }

        // Keep the table updated too
        Load_Parts(eid);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this, "Unable to load details: " + e.getMessage()
        );
    }





    }//GEN-LAST:event_empidActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed


    String pid = part_id.getText().trim();
    String pname = part_name.getText().trim();
    String price = part_price.getText().trim();
    String stock = part_stock.getText().trim();
    String details = part_dt1.getText().trim();
    String pimage = part_full_image.getText().trim();

    // Check employee ID
    Object selected = empid.getSelectedItem();

    if (selected == null || "--ID--".equals(selected.toString())) {
        JOptionPane.showMessageDialog(this, "Please select Employee ID");
        return;
    }

    String eid = selected.toString();

    // Check date
    if (jDateChooser1.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Please select part date");
        return;
    }

    String pdate = new SimpleDateFormat("yyyy-MM-dd")
            .format(jDateChooser1.getDate());

    String idt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            .format(new Date());

    // Validate required fields
    if (pid.isEmpty() || pname.isEmpty() || price.isEmpty()
            || stock.isEmpty() || details.isEmpty() || pimage.isEmpty()) {

        JOptionPane.showMessageDialog(this, "Please enter all details");
        return;
    }

    
    // Insert into database
    try (Connection con = JDBC.Con();
         CallableStatement stmt =
             con.prepareCall("{call sp_insert_prod(?,?,?,?,?,?,?,?,?,?)}")) {

        stmt.setString(1, pid);
        stmt.setString(2, eid);
        stmt.setString(3, pname);
        stmt.setString(4, details);
        stmt.setString(5, pdate);
        stmt.setString(6, price);
        stmt.setString(7, stock);
        stmt.setString(8, pimage);
        stmt.setString(9, idt);

        // Register the 10th parameter as OUTPUT
        stmt.registerOutParameter(10, java.sql.Types.VARCHAR);

        stmt.execute();

        // Read the message returned by SQL Server
        String result = stmt.getString(10);

        JOptionPane.showMessageDialog(this, result);
        Load_Parts();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Insert failed: " + e.getMessage());
    }




    }//GEN-LAST:event_jButton2ActionPerformed

private void tblMouseClicked(java.awt.event.MouseEvent evt) {

    int row = tbl.getSelectedRow();

    if (row == -1) {
        return;
    }

    part_id.setText(tbl.getValueAt(row, 0).toString());
    empid.setSelectedItem(tbl.getValueAt(row, 1).toString());
    part_name.setText(tbl.getValueAt(row, 2).toString());
    part_dt1.setText(tbl.getValueAt(row, 3).toString());

    Object dateValue = tbl.getValueAt(row, 4);

    if (dateValue instanceof java.sql.Date) {
        jDateChooser1.setDate((java.sql.Date) dateValue);
    }

    part_price.setText(tbl.getValueAt(row, 5).toString());
    part_stock.setText(tbl.getValueAt(row, 6).toString());

    Object imageValue = tbl.getValueAt(row, 7);

    if (imageValue instanceof ImageIcon) {
        // The image is displayed in the table.
        // Keep the stored image path from the database separately
        // if you want to edit the image later.
    } else if (imageValue != null) {
        part_full_image.setText(imageValue.toString());
    }
}

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    String pid = part_id.getText().trim();
    String pname = part_name.getText().trim();
    String price = part_price.getText().trim();
    String stock = part_stock.getText().trim();
    String details = part_dt1.getText().trim();
    String pimage = part_full_image.getText().trim();
    
    
if (price.isEmpty() || stock.isEmpty()) {
    JOptionPane.showMessageDialog(
        this, "Please enter Part Price and Part Stock.");
    return;
}

try {
    new java.math.BigDecimal(price);
    int stockValue = Integer.parseInt(stock);

    if (stockValue < 0) {
        JOptionPane.showMessageDialog(
            this, "Stock cannot be negative.");
        return;
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(
        this, "Enter a valid numeric Price and whole-number Stock.");
    return;
}

 

    if (pid.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter Part ID");
        return;
    }

    if (empid.getSelectedItem() == null
            || "--ID--".equals(empid.getSelectedItem().toString())) {
        JOptionPane.showMessageDialog(this, "Select Employee ID");
        return;
    }

    if (jDateChooser1.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Select Part Date");
        return;
    }

    String eid = empid.getSelectedItem().toString();

    java.sql.Date pdate = new java.sql.Date(
            jDateChooser1.getDate().getTime()
    );

    String sql = "UPDATE [java_june_25].[dbo].[tbl_part] "
            + "SET emp_id = ?, part_name = ?, part_detail = ?, "
            + "part_mdate = ?, part_price = ?, part_stock = ?, "
            + "part_image = ? WHERE part_id = ?";


    try (Connection con = JDBC.Con();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, eid);
        ps.setString(2, pname);
        ps.setString(3, details);
        ps.setDate(4, pdate);
        ps.setBigDecimal(5, new java.math.BigDecimal(price));
        ps.setInt(6, Integer.parseInt(stock));
        ps.setString(7, pimage);
        ps.setString(8, pid);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(
                this, "Part updated successfully!"
            );

            Load_Parts();
            clearForm();

        } else {
            JOptionPane.showMessageDialog(
                this, "Part ID not found!"
            );
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            this,
            "Edit failed: " + e.getMessage()
        );
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       clearForm();
    }


private void clearForm() {
    empid.setSelectedIndex(0);
    part_id.setText("");
    part_name.setText("");
    part_price.setText("");
    part_stock.setText("");
    part_dt1.setText("");
    part_full_image.setText("");
    jDateChooser1.setDate(null);
    emp_name_role.setText("EMP NAME");
    part_image.setIcon(null);
    part_image.setText("Select Image");

   
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void part_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_part_idFocusLost
   
    String pid = part_id.getText().trim();

    if (pid.isEmpty()) {
        return;
    }

    String sql = "{call get_part(?)}";

    try (Connection con = JDBC.Con();
         CallableStatement cs = con.prepareCall(sql)) {

        cs.setString(1, pid);

        try (ResultSet rs = cs.executeQuery()) {
            if (rs.next()) {
                part_name.setText(rs.getString("part_name"));
                part_dt1.setText(rs.getString("part_detail"));
                part_price.setText(rs.getString("part_price"));
                part_stock.setText(rs.getString("part_stock"));

                empid.setSelectedItem(rs.getString("emp_id"));

                emp_name_role.setText(
                    rs.getString("emp_name") + " "
                    + rs.getString("emp_role")
                );

                java.sql.Date date = rs.getDate("part_mdate");
                jDateChooser1.setDate(date);

                String imageName = rs.getString("part_image");
                part_full_image.setText(
                    imageName == null ? "" : imageName
                );

            } else {
                JOptionPane.showMessageDialog(
                    this, "Part ID not found."
                );
            }
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this, "Unable to load part: " + e.getMessage()
        );
}

    }//GEN-LAST:event_part_idFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to cancel?",
        "Confirm Cancel",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        this.dispose();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

private void getPartImage() {
    JFileChooser chooser = new JFileChooser();

    chooser.setDialogTitle("Select Part Image");
    chooser.setFileFilter(
        new FileNameExtensionFilter(
            "Image Files", "jpg", "jpeg", "png"
        )
    );


    int result = chooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();

        // Display the selected image path
        part_full_image.setText(file.getAbsolutePath());

        // Load the image
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());

        // Resize the image to fit jLabel10
        Image image = icon.getImage().getScaledInstance(
            119, 121, Image.SCALE_SMOOTH
        );

        // Display the image
        part_image.setIcon(new ImageIcon(image));
        part_image.setText("");
        part_image.setHorizontalAlignment(SwingConstants.CENTER);
    }
}


public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Car_Part frame = new Car_Part();
            frame.setVisible(true);
        }
    });
}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emp_name_role;
    private javax.swing.JComboBox<String> empid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea part_dt1;
    private javax.swing.JTextField part_full_image;
    private javax.swing.JTextField part_id;
    private javax.swing.JLabel part_image;
    private javax.swing.JTextField part_name;
    private javax.swing.JTextField part_price;
    private javax.swing.JTextField part_stock;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
