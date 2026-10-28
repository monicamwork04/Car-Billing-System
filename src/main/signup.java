package main;
import PS.*;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import javax.swing.*;

public class signup extends javax.swing.JFrame {

    
public signup() {
    initComponents();
    IDT();
jButton1.addActionListener(evt -> signupActionPerformed(evt));
    // LOGIN button
    jButton2.addActionListener(evt -> {
        new login().setVisible(true);
        this.dispose();
    });

    // CLEAR button
    jButton3.addActionListener(evt -> clr());

    // Close button icon
    java.net.URL iconURL = getClass().getResource("/img/turn-off.png");

    if (iconURL != null) {
        ImageIcon icon2 = new ImageIcon(iconURL);
        Image img2 = icon2.getImage().getScaledInstance(
            30, 30, Image.SCALE_SMOOTH
        );
        jButton4.setIcon(new ImageIcon(img2));
    }
}
 
 



   


public final void IDT() {
    Date dt = new Date();

    SimpleDateFormat fmt =
        new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

    idt.setText(fmt.format(dt));
}

public void clr() {
    emp_id.setText("");
    emp_name.setText("");
    emp_phone.setText("");
    emp_pass.setText("");
    emp_email.setText("");
}

private void signupActionPerformed(
        java.awt.event.ActionEvent evt) {

    String id = emp_id.getText().trim();
    String name = emp_name.getText().trim();
    String phone = emp_phone.getText().trim();
    String password = emp_pass.getText().trim();
    String email = emp_email.getText().trim();

    String createdAt = new SimpleDateFormat(
        "yyyy-MM-dd hh:mm:ss a"
    ).format(new Date());

    if (id.isEmpty() || name.isEmpty() ||
        phone.isEmpty() || password.isEmpty() ||
        email.isEmpty()) {

        JOptionPane.showMessageDialog(
            this, "Please enter all details."
        );
        return;
    }

    if (!REGEX.is_phone_valid(phone)) {
        JOptionPane.showMessageDialog(
            this, "Phone number is not valid."
        );
        return;
    }

    if (!REGEX.is_email_valid(email)) {
        JOptionPane.showMessageDialog(
            this, "Email is not valid."
        );
        return;
    }

    if (!REGEX.is_pass_valid(password)) {
        JOptionPane.showMessageDialog(
            this,
            "Password must contain at least:\n" +
            "- 1 digit\n" +
            "- 1 lowercase letter\n" +
            "- 1 uppercase letter\n" +
            "- 1 special character\n" +
            "- Minimum 4 characters"
        );
        return;
    }

    String role;

    // Replace these suffixes with your actual email rules.
    if (email.endsWith(".a@kasshi.com")) {
        role = "admin";
    } else if (email.endsWith(".e@kasshi.com")) {
        role = "employee";
    } else {
        JOptionPane.showMessageDialog(
            this, "Email domain is not allowed."
        );
        return;
    }

  // mo.e@kasshi.com

try (Connection Con = JDBC.Con()) {

    String sql = "{call dbo.sp_emp_ins(?,?,?,?,?,?,?,?)}";

    String en_pass = AES.encrypt(password);

    try (CallableStatement cs = Con.prepareCall(sql)) {

        cs.setString(1, id);        // @emp_id
        cs.setString(2, name);      // @emp_name
        cs.setString(3, phone);     // @emp_phone
        cs.setString(4, email);     // @emp_email
        cs.setString(5, en_pass);   // @emp_pass
        cs.setString(6, role);      // @emp_role
        cs.setString(7, createdAt); // @idt

        cs.registerOutParameter(8, Types.VARCHAR); // @res

        cs.execute();

        String res = cs.getString(8);

        JOptionPane.showMessageDialog(this, res);
        System.out.println(res);

        // Clear only if insertion succeeded.
        if ("emp data inserted in db----".equals(res)) {
            clr();
            IDT();
        }
    }


} catch (Exception e) {
    e.printStackTrace();

    JOptionPane.showMessageDialog(
        this,
        e.getMessage(),
        "Signup Error",
        JOptionPane.ERROR_MESSAGE
    );
}

} // closes signupActionPerformed()

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    login log = new login();
    log.setVisible(true);
    this.dispose();
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        emp_id = new javax.swing.JTextField();
        emp_name = new javax.swing.JTextField();
        emp_phone = new javax.swing.JTextField();
        emp_email = new javax.swing.JTextField();
        emp_pass = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("EMP ID");

        jLabel2.setText("EMP NAME");

        jLabel3.setText("EMP PHONE");

        jLabel4.setText("EMP EMAIL");

        jLabel5.setText("EMP PASS");

        jLabel6.setText("IDT");

        idt.setText("idt");

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setText("SIGNUP");

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setText("LOGIN");

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setText("CLEAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        emp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_idActionPerformed(evt);
            }
        });

        emp_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_emailActionPerformed(evt);
            }
        });

        emp_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_passActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("SIGN UP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(idt))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emp_email, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emp_pass))))
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(emp_phone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(emp_name, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emp_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emp_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emp_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       clr();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
       
    dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void emp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_idActionPerformed

    private void emp_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_emailActionPerformed

    private void emp_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_passActionPerformed

    
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
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signup().setVisible(true);
            }
        });
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_id;
    private javax.swing.JTextField emp_name;
    private javax.swing.JTextField emp_pass;
    private javax.swing.JTextField emp_phone;
    private javax.swing.JLabel idt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
