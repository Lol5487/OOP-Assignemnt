/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OOPAssignment.Gui;

import OOPAssignment.model.User;

public class CounselorDashboardPanel extends javax.swing.JPanel {

    private User counselor;

    public CounselorDashboardPanel(User counselor) {
        initComponents();
        this.counselor = counselor;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcome = new javax.swing.JLabel();

        setLayout(null);

        welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OOPAssignment/Gui/counselor_dashboard_preview.png"))); // NOI18N
        add(welcome);
        welcome.setBounds(-220, 0, 930, 510);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
