package main;
import PS.AES;
import PS.JDBC;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class All_emp extends javax.swing.JFrame {

    private boolean is_upd = false;

    public All_emp() {
        initComponents();
        Insert_emp();
    }



public void Insert_emp() {
    
   

    is_upd = true;
DefaultTableModel mod = new DefaultTableModel(
    new String[]{"ID", "NAME", "PHONE", "EMAIL", "PW", "ROLE"}, 0
) {
    @Override
    public boolean isCellEditable(int row, int column) {
        // ID (column 0) and ROLE (column 5) cannot be edited
        return column != 0 && column != 5;
    }
};

    try (Connection con = JDBC.Con()) {

        if (con == null) {
            JOptionPane.showMessageDialog(
                this, "Database connection failed."
            );
            return;
        }

        try (CallableStatement cs =
                con.prepareCall("{call dbo.sp_temp_all}");
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {

                String encryptedPassword = rs.getString("emp_pass");
                String decryptedPassword = AES.decrypt(encryptedPassword);

                mod.addRow(new Object[]{
                    rs.getString("emp_id"),
                    rs.getString("emp_name"),
                    rs.getString("emp_phone"),
                    rs.getString("emp_email"),
                    decryptedPassword,
                    rs.getString("emp_role")
                });
            }
        }

        jTable1.setModel(mod);

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
            this, "Unable to load employees: " + e.getMessage()
        );
        e.printStackTrace();

    } finally {
        is_upd = false;
    }
}


   
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            All_emp window = new All_emp();
            window.setVisible(true);
        }
    });
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("RESET");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("ALL EMPLOYEE");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(111, 111, 111)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int choice = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to exit?",
        "Confirm Exit",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    );

    if (choice == JOptionPane.YES_OPTION) {
        this.dispose();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
      
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
