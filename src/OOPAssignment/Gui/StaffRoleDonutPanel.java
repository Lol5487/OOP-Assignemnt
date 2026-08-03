/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAssignment.Gui;

import OOPAssignment.model.Admin;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Area;
import java.awt.geom.Arc2D;

public class StaffRoleDonutPanel extends JPanel {
    private Admin admin;
    private int counselorCount;
    private int receptionistCount;

    public StaffRoleDonutPanel(Admin admin) {
        this.admin = admin;
        setOpaque(false);
        refreshData();
    }

    public void refreshData() {
        counselorCount = admin.countByRole("Counselor");
        receptionistCount = admin.countByRole("Receptionist");
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int total = counselorCount + receptionistCount;
        if (total == 0) {
            total = 1;
        }

        int diameter = 120;
        int thickness = 20;
        int cx = 30;
        int cy = (getHeight() - diameter) / 2 + 40;

        Color purple = new Color(91, 63, 196);
        Color teal = new Color(20, 184, 166);

        double counselorAngle = 360.0 * counselorCount / total;

        Ellipse2D innerHole = new Ellipse2D.Double(cx + thickness, cy + thickness, diameter - thickness * 2, diameter - thickness * 2);

        Arc2D purplePie = new Arc2D.Double(cx, cy, diameter, diameter, 90, -counselorAngle, Arc2D.PIE);
        Area purpleRing = new Area(purplePie);
        purpleRing.subtract(new Area(innerHole));

        Arc2D tealPie = new Arc2D.Double(cx, cy, diameter, diameter, 90 - counselorAngle, -(360 - counselorAngle), Arc2D.PIE);
        Area tealRing = new Area(tealPie);
        tealRing.subtract(new Area(innerHole));

        g2.setColor(purple);
        g2.fill(purpleRing);

        g2.setColor(teal);
        g2.fill(tealRing);

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Segoe UI", Font.BOLD, 28));
        String totalText = String.valueOf(counselorCount + receptionistCount);
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(totalText);
        g2.drawString(totalText, cx + diameter / 2 - textWidth / 2, cy + diameter / 2);

        g2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        g2.setColor(Color.LIGHT_GRAY);
        String label = "total staff";
        int labelWidth = g2.getFontMetrics().stringWidth(label);
        g2.drawString(label, cx + diameter / 2 - labelWidth / 2, cy + diameter / 2 + 18);

        int legendX = cx + diameter + 40;
        int legendY = cy + 20;

        g2.setColor(purple);
        g2.fillRoundRect(legendX, legendY, 14, 14, 3, 3);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        int counselorPercent = (int) (100.0 * counselorCount / total);
        g2.drawString("Counselor — " + counselorCount + " (" + counselorPercent + "%)", legendX + 22, legendY + 12);

        g2.setColor(teal);
        g2.fillRoundRect(legendX, legendY + 40, 14, 14, 3, 3);
        g2.setColor(Color.WHITE);
        int receptionistPercent = (int) (100.0 * receptionistCount / total);
        g2.drawString("Receptionist — " + receptionistCount + " (" + receptionistPercent + "%)", legendX + 22, legendY + 52);

        g2.dispose();
    }
}