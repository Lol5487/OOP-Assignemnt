/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OOPAssignment.Gui;

import OOPAssignment.model.Admin;
import OOPAssignment.model.User;
import java.awt.CardLayout;

public class CounselorPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private Admin admin;
    private User loggedInCounselor;
    private CardLayout innerCardLayout;

    public CounselorPanel(MainFrame mainFrame, Admin admin, User loggedInCounselor) {
        initComponents();
        this.mainFrame = mainFrame;
        this.admin = admin;
        this.loggedInCounselor = loggedInCounselor;

        innerCardLayout = new CardLayout();
        contentPanel.setLayout(innerCardLayout);

        contentPanel.add(new CounselorDashboardPanel(loggedInCounselor), "dashboard");
        // 之后要加更多功能,一样加进来:
        // contentPanel.add(new MyRosterPanel(admin, loggedInCounselor), "roster");
        // contentPanel.add(new ConsultationRecordsPanel(...), "records");

        innerCardLayout.show(contentPanel, "dashboard");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        jLabel1.setText("Counselor");

        dashboardBtn.setText("Dashboard");
        dashboardBtn.addActionListener(this::dashboardBtnActionPerformed);

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(this::logoutBtnActionPerformed);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logoutBtn)
                            .addComponent(dashboardBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 429, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(dashboardBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(logoutBtn)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        innerCardLayout.show(contentPanel, "dashboard");
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        mainFrame.showPanel("menu");
    }//GEN-LAST:event_logoutBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    // End of variables declaration//GEN-END:variables
}
