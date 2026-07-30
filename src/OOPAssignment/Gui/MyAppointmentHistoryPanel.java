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

        historyArea.setColumns(20);
        historyArea.setRows(5);
        jScrollPane1.setViewportView(historyArea);

        appointmentIdTf.addActionListener(this::appointmentIdTfActionPerformed);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(this::cancelBtnActionPerformed);

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(this::refreshBtnActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(appointmentIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelBtn)))
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(appointmentIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addGap(22, 22, 22)
                .addComponent(refreshBtn)
                .addContainerGap(193, Short.MAX_VALUE))
        );
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    // End of variables declaration//GEN-END:variables
}
