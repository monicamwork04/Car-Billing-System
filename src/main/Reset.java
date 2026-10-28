package main;
import PS.JDBC;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import javax.swing.JOptionPane;

public class Reset extends javax.swing.JFrame {

    
    public Reset() {
        initComponents();
        jButton1.setText("EDIT");
        jButton3.setText("CLEAR");
          jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        deleteActionPerformed = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emp_pass = new javax.swing.JTextField();
        emp_email = new javax.swing.JTextField();
        emp_id = new javax.swing.JTextField();
        emp_name = new javax.swing.JTextField();
        emp_phone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(153, 255, 153));
        jButton1.setText("EDIT");

        deleteActionPerformed.setBackground(new java.awt.Color(255, 255, 51));
        deleteActionPerformed.setText("DELETE");
        deleteActionPerformed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                deleteActionPerformedFocusLost(evt);
            }
        });
        deleteActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformedActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setText("CLEAR");

        jLabel1.setText("EMP ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("RESET");

        jLabel4.setText("EMP NAME");

        jLabel5.setText("EMP PHONE");

        jLabel6.setText("EMP EMAIL");

        jLabel7.setText("EMP PASS");

        emp_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_passActionPerformed(evt);
            }
        });

        emp_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emp_idFocusLost(evt);
            }
        });

        jLabel8.setText("emp_role");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteActionPerformed)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(emp_pass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(emp_email, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emp_phone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emp_name)
                            .addComponent(emp_id))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emp_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emp_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emp_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteActionPerformed)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void jButton1ActionPerformed(
        java.awt.event.ActionEvent evt) {

    String id = emp_id.getText().trim();

    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter Employee ID");
        return;
    }

    String sql = "UPDATE tbl_emp SET emp_name=?, emp_phone=?, "
               + "emp_email=?, emp_pass=? WHERE emp_id=?";

    try (Connection con = JDBC.Con();
         java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, emp_name.getText().trim());
        ps.setString(2, emp_phone.getText().trim());
        ps.setString(3, emp_email.getText().trim());
        ps.setString(4, emp_pass.getText().trim());
        ps.setString(5, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Employee updated successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Employee ID not found");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
    private void deleteActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformedActionPerformed
 String id = emp_id.getText().trim();

    if (id.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Enter Employee ID");
        return;
    }

    String sql = "{call sp_temp_del(?, ?)}";

    try (Connection con = JDBC.Con();
         CallableStatement cs = con.prepareCall(sql)) {

        cs.setString(1, id);
        cs.registerOutParameter(2, Types.VARCHAR);
        cs.execute();

        String result = cs.getString(2);
        JOptionPane.showMessageDialog(this, result);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }     




    }//GEN-LAST:event_deleteActionPerformedActionPerformed
private void jButton3ActionPerformed(
        java.awt.event.ActionEvent evt) {

    emp_id.setText("");
    emp_name.setText("");
    emp_phone.setText("");
    emp_email.setText("");
    emp_pass.setText("");

    emp_id.requestFocus();
}
    private void emp_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_passActionPerformed
       
    }//GEN-LAST:event_emp_passActionPerformed

    private void emp_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emp_idFocusLost

    String id = emp_id.getText().trim();

    if (id.isEmpty()) {
        return;
    }

    try (Connection con = JDBC.Con()) {

        String sql = "{call sp_temp_id(?, ?)}";

        try (CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, id);
            cs.registerOutParameter(2, Types.VARCHAR);

            boolean hasResult = cs.execute();

            if (hasResult) {
                try (ResultSet rs = cs.getResultSet()) {

                    if (rs.next()) {
                        emp_name.setText(rs.getString("emp_name"));
                        emp_phone.setText(rs.getString("emp_phone"));
                        emp_email.setText(rs.getString("emp_email"));
                        emp_pass.setText(rs.getString("emp_pass"));

                        JOptionPane.showMessageDialog(
                            this, "Employee found"
                        );
                    }
                }
            } else {
                JOptionPane.showMessageDialog(
                    this, "No such ID in database"
                );
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage());
    }



    }//GEN-LAST:event_emp_idFocusLost

    private void deleteActionPerformedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deleteActionPerformedFocusLost


   
    
    }//GEN-LAST:event_deleteActionPerformedFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteActionPerformed;
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_id;
    private javax.swing.JTextField emp_name;
    private javax.swing.JTextField emp_pass;
    private javax.swing.JTextField emp_phone;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
