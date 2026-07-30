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
        contentPanel.add(new MyRosterPanel(admin, loggedInCounselor), "roster");
        contentPanel.add(new MyAppointmentsPanel(loggedInCounselor), "appointments");
        contentPanel.add(new ConsultationRecordsPanel(loggedInCounselor), "records");

        innerCardLayout.show(contentPanel, "dashboard");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        appointmentsBtn = new javax.swing.JButton();
        recordsBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        rosterBtn = new javax.swing.JButton();

        jLabel1.setText("Counselor");

        dashboardBtn.setText("Dashboard");
        dashboardBtn.addActionListener(this::dashboardBtnActionPerformed);

        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(this::logoutBtnActionPerformed);

        contentPanel.setLayout(new java.awt.CardLayout());

        appointmentsBtn.setText("Appointments");
        appointmentsBtn.addActionListener(this::appointmentsBtnActionPerformed);

        recordsBtn.setText("Records");
        recordsBtn.addActionListener(this::recordsBtnActionPerformed);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        rosterBtn.setText("Roster");
        rosterBtn.addActionListener(this::rosterBtnActionPerformed);

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
                        .addComponent(logoutBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rosterBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appointmentsBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dashboardBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(recordsBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 815, Short.MAX_VALUE)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(783, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(dashboardBtn)
                .addGap(43, 43, 43)
                .addComponent(appointmentsBtn)
                .addGap(43, 43, 43)
                .addComponent(rosterBtn)
                .addGap(65, 65, 65)
                .addComponent(recordsBtn)
                .addGap(115, 115, 115)
                .addComponent(logoutBtn)
                .addGap(32, 32, 32))
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator1)
                    .addGap(2, 2, 2)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        innerCardLayout.show(contentPanel, "dashboard");
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        mainFrame.showPanel("menu");
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void appointmentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentsBtnActionPerformed
        innerCardLayout.show(contentPanel, "appointments");
    }//GEN-LAST:event_appointmentsBtnActionPerformed

    private void recordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordsBtnActionPerformed
        innerCardLayout.show(contentPanel, "records");
    }//GEN-LAST:event_recordsBtnActionPerformed

    private void rosterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rosterBtnActionPerformed
        innerCardLayout.show(contentPanel, "roster");
    }//GEN-LAST:event_rosterBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appointmentsBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton recordsBtn;
    private javax.swing.JButton rosterBtn;
    // End of variables declaration//GEN-END:variables
}
