/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OOPAssignment.Gui;
import OOPAssignment.model.Admin;

/**
 *
 * @author Asus
 */
public class AdminDashboardPanel extends javax.swing.JPanel {
        private Admin admin;

        public AdminDashboardPanel(Admin admin) {
            initComponents();
            this.admin = admin;
            refreshData();   // 一打开Dashboard,就先显示一次资料
        }

        private void refreshData() {
            totalStaffLbl.setText(String.valueOf(admin.getStaffCount()));
            staffListArea.setText(admin.viewAllStaff());

            totalAppointmentsLbl.setText(OOPAssignment.model.Appointment.getTotalCount()
                + " (Pending: " + OOPAssignment.model.Appointment.getCountByStatus("Pending") + ")");
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshBtn = new javax.swing.JButton();
        totalStaffLbl = new javax.swing.JLabel();
        totalAppointmentsLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffListArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        refreshBtn.setContentAreaFilled(false);
        refreshBtn.addActionListener(this::refreshBtnActionPerformed);
        add(refreshBtn);
        refreshBtn.setBounds(622, 190, 90, 30);

        totalStaffLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalStaffLbl.setForeground(new java.awt.Color(51, 204, 255));
        totalStaffLbl.setText("Total");
        add(totalStaffLbl);
        totalStaffLbl.setBounds(70, 120, 80, 30);

        totalAppointmentsLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalAppointmentsLbl.setForeground(new java.awt.Color(102, 255, 153));
        totalAppointmentsLbl.setText("Total Appointment:");
        add(totalAppointmentsLbl);
        totalAppointmentsLbl.setBounds(300, 120, 180, 30);

        staffListArea.setEditable(false);
        staffListArea.setBackground(new java.awt.Color(20, 20, 22));
        staffListArea.setColumns(20);
        staffListArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        staffListArea.setForeground(new java.awt.Color(204, 204, 204));
        staffListArea.setRows(5);
        staffListArea.setText("sdasdwadsad");
        staffListArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        staffListArea.setFocusTraversalPolicyProvider(true);
        staffListArea.setName(""); // NOI18N
        staffListArea.setOpaque(false);
        staffListArea.setRequestFocusEnabled(false);
        staffListArea.setSelectionColor(new java.awt.Color(20, 20, 22));
        jScrollPane1.setViewportView(staffListArea);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 220, 670, 250);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("3");
        add(jLabel2);
        jLabel2.setBounds(530, 120, 20, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OOPAssignment/Gui/AdminDashboard（1）.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(-170, -70, 950, 640);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        refreshData();
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTextArea staffListArea;
    private javax.swing.JLabel totalAppointmentsLbl;
    private javax.swing.JLabel totalStaffLbl;
    // End of variables declaration//GEN-END:variables
}
