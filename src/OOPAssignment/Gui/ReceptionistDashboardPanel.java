/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OOPAssignment.Gui;

import OOPAssignment.model.Receptionist;
import OOPAssignment.model.User;

public class ReceptionistDashboardPanel extends javax.swing.JPanel {

    private Receptionist receptionist;

    public ReceptionistDashboardPanel(User loggedInReceptionistUser) {
        initComponents();       
        
        System.out.println("--- DASHBOARD DEBUG START ---");
        System.out.println("User type received: " + loggedInReceptionistUser.getClass().getSimpleName());
        System.out.println("Is it a Receptionist? " + (loggedInReceptionistUser instanceof Receptionist));

        if (loggedInReceptionistUser instanceof Receptionist) {
            this.receptionist = (Receptionist) loggedInReceptionistUser;
            System.out.println("Successfully cast to Receptionist!");
            
            DashBoardLbl1.setText("Welcome, " + this.receptionist.getName() + "!");
            refreshStats();
        } else {
            System.out.println("WARNING: Not a Receptionist object! Showing default 0s.");
            DashBoardLbl1.setText("Welcome, " + loggedInReceptionistUser.getName() + "!");
            TotalStudentLbl.setText("0");
            TotalAppointment.setText("0");
        }
        System.out.println("--- DASHBOARD DEBUG END ---");
    }
    public void refreshStats() {
        int studentCount = 0;
        int apptCount = 0;
        
        try {
            String[] students = OOPAssignment.util.FileHandler.readAllLines("students.txt");
            for (String line : students) {
                if (line != null && !line.trim().isEmpty()) {
                    studentCount++;
                }
            }            
            String[] appts = OOPAssignment.util.FileHandler.readAllLines("appointments.txt");
            for (String line : appts) {
                if (line != null && !line.trim().isEmpty()) {
                    apptCount++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading files: " + e.getMessage());
        }

        TotalStudentLbl.setText(String.valueOf(studentCount));
        TotalAppointment.setText(String.valueOf(apptCount));

        TotalStudentLbl.revalidate();
        TotalStudentLbl.repaint();
        TotalAppointment.revalidate();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashBoardLbl1 = new javax.swing.JLabel();
        TotalStudentLbl = new javax.swing.JLabel();
        TotalAppointment = new javax.swing.JLabel();
        Dashboardlbl = new javax.swing.JLabel();

        setLayout(null);

        DashBoardLbl1.setText("jLabel1");
        add(DashBoardLbl1);
        DashBoardLbl1.setBounds(50, 240, 180, 16);

        TotalStudentLbl.setText("jLabel1");
        add(TotalStudentLbl);
        TotalStudentLbl.setBounds(80, 150, 90, 16);

        TotalAppointment.setText("jLabel1");
        add(TotalAppointment);
        TotalAppointment.setBounds(350, 150, 110, 16);

        Dashboardlbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OOPAssignment/Gui/ReceptionistDashboard1.png"))); // NOI18N
        add(Dashboardlbl);
        Dashboardlbl.setBounds(-250, 0, 933, 506);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DashBoardLbl1;
    private javax.swing.JLabel Dashboardlbl;
    private javax.swing.JLabel TotalAppointment;
    private javax.swing.JLabel TotalStudentLbl;
    // End of variables declaration//GEN-END:variables
}
