/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OOPAssignment.Gui;

import OOPAssignment.model.Appointment;
import OOPAssignment.model.Student;
import OOPAssignment.util.Validator;

public class MyAppointmentHistoryPanel extends javax.swing.JPanel {

    private Student student;

    public MyAppointmentHistoryPanel(Student student) {
        initComponents();
        this.student = student;

        historyArea.setEditable(false);
        refreshData();
    }

    private void refreshData() {
        java.util.List<Appointment> myAppointments = Appointment.findByStudent(student.getUsername());

        String result = "=== Appointment History ===\n";
        if (myAppointments.isEmpty()) {
            result += "No appointments yet.\n";
        } else {
            for (Appointment a : myAppointments) {
                result += a.getAppointmentId() + " - " + a.getDate() + " " + a.getTime()
                        + " with " + a.getCounselorUsername() + " (" + a.getStatus() + ")\n";
            }
        }
        historyArea.setText(result);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        historyArea = new javax.swing.JTextArea();
        appointmentIdTf = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        historyArea.setBackground(new java.awt.Color(0, 0, 0));
        historyArea.setColumns(20);
        historyArea.setForeground(new java.awt.Color(255, 255, 255));
        historyArea.setRows(5);
        jScrollPane1.setViewportView(historyArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 480, 360));

        appointmentIdTf.addActionListener(this::appointmentIdTfActionPerformed);
        add(appointmentIdTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 140, 40));

        cancelBtn.setBackground(new java.awt.Color(71, 102, 138));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancel");
        cancelBtn.setBorder(null);
        cancelBtn.addActionListener(this::cancelBtnActionPerformed);
        add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 100, 40));

        refreshBtn.setBackground(new java.awt.Color(71, 102, 138));
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setText("Refresh");
        refreshBtn.setBorder(null);
        refreshBtn.addActionListener(this::refreshBtnActionPerformed);
        add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OOPAssignment/Gui/studentblank.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-350, 0, 1660, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void appointmentIdTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentIdTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentIdTfActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        String appointmentId = appointmentIdTf.getText();

        if (Validator.isEmpty(appointmentId)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the appointment ID to cancel!");
            return;
        }

        boolean success = Appointment.cancelById(appointmentId);

        if (success) {
            javax.swing.JOptionPane.showMessageDialog(this, "Appointment cancelled successfully!");
            appointmentIdTf.setText("");
            refreshData();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Appointment not found!");
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
            refreshData();
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appointmentIdTf;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextArea historyArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}
