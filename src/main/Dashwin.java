package main;
import PS.JDBC;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;

public final class Dashwin extends JFrame {

    private JLabel customerCountLabel;
    private JLabel partCountLabel;
    private JPanel main;

    private final Color backgroundColor =
            new Color(245, 247, 250);
    private final Color blueColor =
            new Color(15, 82, 155);
    private final Color textColor =
            new Color(35, 45, 65);

    public Dashwin() {
    initComponents();
    buildDashboard();
    Load();
}

    // ================= DASHBOARD DESIGN =================

    private void buildDashboard() {

        setTitle("DASH WIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        main = new JPanel(null);
        main.setBackground(backgroundColor);
        setContentPane(main);

        // Dashboard title
        JLabel title = new JLabel("DASH PAGE");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(textColor);
        title.setBounds(35, 20, 300, 45);
        main.add(title);

        // Exit button
        JButton exitButton = new JButton();
        exitButton.setBounds(915, 20, 40, 40);
        exitButton.setBackground(new Color(230, 40, 40));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        exitButton.setText("X");
        exitButton.setFocusPainted(false);
        exitButton.setBorderPainted(false);

        setButtonImage(exitButton, "/img/turn-off.png", 25, 25);

        // Retain the X if the image is unavailable.
        if (exitButton.getIcon() != null) {
            exitButton.setText("");
        }

        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        });

        main.add(exitButton);

        // Reset employee heading
        JLabel resetLabel = new JLabel("RESET EMPLOYEE");
        resetLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        resetLabel.setForeground(textColor);
        resetLabel.setBounds(790, 75, 150, 22);
        main.add(resetLabel);

        // Reset button
        JButton resetButton = new JButton("RESET");
        resetButton.setBounds(835, 100, 100, 30);
        resetButton.setBackground(new Color(255, 230, 230));
        resetButton.setFocusPainted(false);
resetButton.addActionListener(e -> {
    Reset r = new Reset();
    r.setVisible(true);
});
     

        main.add(resetButton);

        // ================= DASHBOARD CARDS =================

       // ================= DASHBOARD CARDS =================

JPanel customerCard = createCard(35, 150, 205, 145);
JPanel partCard = createCard(265, 150, 205, 145);
JPanel cartCard = createCard(495, 150, 205, 145);
JPanel billingCard = createCard(725, 150, 205, 145);

main.add(customerCard);
main.add(partCard);
main.add(cartCard);
main.add(billingCard);

       

        // Customer button
        JButton customerButton = new JButton();
        customerButton.setBounds(70, 15, 65, 65);
        setButtonImage(
                customerButton, "/img/customer.jpg", 55, 55);
        styleButton(customerButton);
        customerButton.setToolTipText("Open Customer");

        
customerButton.addActionListener(e -> {
    cust_page c = new cust_page();
    c.setLocationRelativeTo(null);
    c.setVisible(true);
    dispose();
});


        customerCard.add(customerButton);

        JLabel customerTitle = new JLabel("CUSTOMER");
        customerTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        customerTitle.setForeground(textColor);
        customerTitle.setBounds(20, 88, 165, 22);
        customerCard.add(customerTitle);

        customerCountLabel = new JLabel("0");
        customerCountLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 24));
        customerCountLabel.setForeground(blueColor);
        customerCountLabel.setBounds(20, 112, 165, 28);
        customerCard.add(customerCountLabel);

        // Part button
        JButton partButton = new JButton();
        partButton.setBounds(70, 15, 65, 65);
        setButtonImage(partButton, "/img/part.png", 55, 55);
        styleButton(partButton);
        partButton.setToolTipText("Open Parts");
      
partButton.addActionListener(e -> {
    Car_Part p = new Car_Part();
    p.setLocationRelativeTo(null);
    p.setVisible(true);
    this.dispose();
});


        

        partCard.add(partButton);

        JLabel partTitle = new JLabel("PART");
        partTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        partTitle.setForeground(textColor);
        partTitle.setBounds(20, 88, 165, 22);
        partCard.add(partTitle);

        partCountLabel = new JLabel("0");
        partCountLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 24));
        partCountLabel.setForeground(blueColor);
        partCountLabel.setBounds(20, 112, 165, 28);
        partCard.add(partCountLabel);
        
        
        
        // ================= BILLING BUTTON =================
        JButton billingButton = new JButton("BILLING");
        billingButton.setBounds(40, 25, 125, 50);
        billingButton.setBackground(blueColor);
        billingButton.setForeground(Color.WHITE);
        billingButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        billingButton.setFocusPainted(false);

        billingButton.addActionListener(e -> {
            bill_page b = new bill_page();
            b.setLocationRelativeTo(null);
            b.setVisible(true);
            this.dispose();
        });

        billingCard.add(billingButton);

        JLabel billingTitle = new JLabel("BILLING");
        billingTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        billingTitle.setForeground(textColor);
        billingTitle.setBounds(20, 95, 165, 25);
        billingCard.add(billingTitle);


        // ALL CART button
JButton allCartButton = new JButton("ALL CART");
allCartButton.setBounds(40, 25, 125, 50);
allCartButton.setBackground(blueColor);
allCartButton.setForeground(Color.WHITE);
allCartButton.setFont(
        new Font("Segoe UI", Font.BOLD, 14)
);
allCartButton.setFocusPainted(false);

allCartButton.addActionListener(e -> {
    All_Car_Parts cart = new All_Car_Parts();
    cart.setLocationRelativeTo(null);
    cart.setVisible(true);
    this.dispose();
});

cartCard.add(allCartButton);

JLabel cartTitle = new JLabel("ALL CAR PARTS");
cartTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
cartTitle.setForeground(textColor);
cartTitle.setBounds(20, 95, 165, 25);
cartCard.add(cartTitle);
        
        
        
        
        

       

        // Employee role table
        tbl = new JTable();
        tbl.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Role", "Count"}
        ));

        tbl.setRowHeight(30);
        tbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tbl.setForeground(textColor);
        tbl.setBackground(Color.WHITE);
        tbl.setGridColor(new Color(225, 230, 238));
        tbl.setSelectionBackground(new Color(210, 228, 248));
        tbl.setSelectionForeground(textColor);

        tbl.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14));
        tbl.getTableHeader().setBackground(
                new Color(225, 235, 248));
        tbl.getTableHeader().setForeground(textColor);
        tbl.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(tbl);
        scrollPane.setBounds(35, 420, 895, 180);
        scrollPane.setBorder(
                BorderFactory.createLineBorder(
                        new Color(210, 220, 235)));

        main.add(scrollPane);
    }

    // ================= CARD DESIGN =================

    private JPanel createCard(int x, int y, int width, int height) {

        JPanel card = new JPanel(null);
        card.setBounds(x, y, width, height);
        card.setBackground(Color.WHITE);

        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(220, 228, 238)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        return card;
    }

    // ================= BUTTON DESIGN =================

    private void styleButton(JButton button) {

        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
    }

    // ================= IMAGE LOADING =================

    private void setButtonImage(
            JButton button,
            String path,
            int width,
            int height) {

        URL imageURL = getClass().getResource(path);

        if (imageURL != null) {

            ImageIcon icon = new ImageIcon(imageURL);

            Image image = icon.getImage().getScaledInstance(
                    width,
                    height,
                    Image.SCALE_SMOOTH
            );

            button.setIcon(new ImageIcon(image));

        } else {
            System.out.println("Image not found: " + path);
        }
    }

    // ================= DATABASE LOADING =================

    public void Load() {

        String query1 = "SELECT COUNT(*) FROM tbl_part";
        String query2 = "SELECT COUNT(*) FROM tbl_cus";

        String query3 =
                "SELECT emp_role AS role, COUNT(*) AS total "
                + "FROM tbl_emp GROUP BY emp_role";

        try (Connection con = JDBC.Con()) {

            if (con == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Database connection failed."
                );
                return;
            }

            // Count parts
            try (PreparedStatement pst =
                         con.prepareStatement(query1);
                 ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    partCountLabel.setText(
                            String.valueOf(rs.getInt(1)));
                }
            }

            // Count customers
            try (PreparedStatement pst =
                         con.prepareStatement(query2);
                 ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    customerCountLabel.setText(
                            String.valueOf(rs.getInt(1)));
                }
            }

            // Employee counts by role
            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"Role", "Count"}, 0) {

                @Override
                public boolean isCellEditable(
                        int row, int column) {
                    return false;
                }
            };

            int totalEmployees = 0;

            try (PreparedStatement pst =
                         con.prepareStatement(query3);
                 ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {

                    String role = rs.getString("role");
                    int count = rs.getInt("total");

                    model.addRow(new Object[]{role, count});
                    totalEmployees += count;
                }
            }

            tbl.setModel(model);

            // Update the total employee heading
            for (java.awt.Component component :
                    main.getComponents()) {

                if (component instanceof JLabel) {

                    JLabel label = (JLabel) component;

                    if (label.getText().startsWith(
                            "TOTAL EMPLOYEE")) {

                        label.setText(
                                "TOTAL EMPLOYEE: "
                                + totalEmployees);
                        break;
                    }
                }
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database error: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }

    
public static void main(String[] args) {

    try {
        for (javax.swing.UIManager.LookAndFeelInfo info
                : javax.swing.UIManager.getInstalledLookAndFeels()) {

            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(
                        info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Dashwin window = new Dashwin();
            window.setVisible(true);
        }
    });
}

 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
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

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DASH PAGE");

        jLabel3.setText("CUSTOMER");

        jLabel4.setText("ALL CART");

        jLabel5.setText("PART");

        jLabel6.setText("BILLING");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL EMPLOYEE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    cust_page c = new cust_page();
    c.setLocationRelativeTo(null);
    c.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to exit?",
        "Confirm Exit",
        javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (choice == javax.swing.JOptionPane.YES_OPTION) {
        this.dispose();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      bill_page b = new bill_page();
    b.setLocationRelativeTo(null);
    b.setVisible(true);
    this.dispose();


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       Car_Part p = new  Car_Part();
    p.setLocationRelativeTo(null);
    p.setVisible(true);
    this.dispose();
    
    }//GEN-LAST:event_jButton4ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables

}