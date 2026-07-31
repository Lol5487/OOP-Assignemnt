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

        dashboardBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();
        appointmentsBtn = new javax.swing.JButton();
        recordsBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        rosterBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        dashboardBtn.setContentAreaFilled(false);
        dashboardBtn.addActionListener(this::dashboardBtnActionPerformed);
        add(dashboardBtn);
        dashboardBtn.setBounds(20, 70, 180, 40);

        logoutBtn.setContentAreaFilled(false);
        logoutBtn.addActionListener(this::logoutBtnActionPerformed);
        add(logoutBtn);
        logoutBtn.setBounds(20, 430, 180, 50);

        contentPanel.setLayout(new java.awt.CardLayout());
        add(contentPanel);
        contentPanel.setBounds(927, 0, 0, 506);

        appointmentsBtn.setContentAreaFilled(false);
        appointmentsBtn.addActionListener(this::appointmentsBtnActionPerformed);
        add(appointmentsBtn);
        appointmentsBtn.setBounds(20, 120, 180, 50);

        recordsBtn.setContentAreaFilled(false);
        recordsBtn.addActionListener(this::recordsBtnActionPerformed);
        add(recordsBtn);
        recordsBtn.setBounds(20, 240, 180, 40);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1);
        jSeparator1.setBounds(147, 2, 3, 502);

        rosterBtn.setContentAreaFilled(false);
        rosterBtn.addActionListener(this::rosterBtnActionPerformed);
        add(rosterBtn);
        rosterBtn.setBounds(20, 180, 180, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OOPAssignment/Gui/counselor_dashboard_preview.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 940, 510);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton recordsBtn;
    private javax.swing.JButton rosterBtn;
    // End of variables declaration//GEN-END:variables
}
