package main;
import PS.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class All_Car_Parts extends javax.swing.JFrame {

    public All_Car_Parts() {
        initComponents();
         LoadParts();
    }

    public void LoadParts() {

    DefaultTableModel model = new DefaultTableModel(
        new String[]{
            "Part ID",
            "Employee ID",
            "Part Name",
            "Part Detail",
            "Manufacture Date",
            "Price",
            "Stock",
            "Image",
            "IDT"
        }, 0
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    
    
    

    String sql = "SELECT part_id, emp_id, part_name, part_detail, "
               + "part_mdate, part_price, part_stock, part_image, idt "
               + "FROM dbo.tbl_part";

    try (Connection con = JDBC.Con();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getObject("part_id"),
                rs.getObject("emp_id"),
                rs.getString("part_name"),
                rs.getString("part_detail"),
                rs.getObject("part_mdate"),
                rs.getObject("part_price"),
                rs.getObject("part_stock"),
                createPartThumbnail(rs.getString("part_image")),
                rs.getObject("idt")
            });
        }
jTable1.setModel(model);

jTable1.setRowHeight(70);
jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

int[] widths = {70, 85, 120, 150, 110, 80, 70, 90, 70};

for (int i = 0; i < widths.length; i++) {
    jTable1.getColumnModel()
           .getColumn(i)
           .setPreferredWidth(widths[i]);
}

setImageColumnRenderer();


    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Unable to load car parts: " + e.getMessage()
        );
        e.printStackTrace();
    }
}
    
    
private ImageIcon createPartThumbnail(String imagePath) {
    if (imagePath == null || imagePath.trim().isEmpty()) {
        return null;
    }

    File file = new File(imagePath);

    if (!file.isFile()) {
        System.out.println("Image file not found: " + imagePath);
        return null;
    }

    ImageIcon original = new ImageIcon(imagePath);

    if (original.getIconWidth() <= 0) {
        return null;
    }

    Image scaled = original.getImage().getScaledInstance(
        60, 60, Image.SCALE_SMOOTH
    );

    return new ImageIcon(scaled);
}

private void setImageColumnRenderer() {
    jTable1.getColumnModel().getColumn(7).setCellRenderer(
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
                } else {
                    label.setIcon(null);
                }

                label.setText("");
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

    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ALL CAR PART");

        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(166, 166, 166)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(All_Car_Parts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(All_Car_Parts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(All_Car_Parts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(All_Car_Parts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new All_Car_Parts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
