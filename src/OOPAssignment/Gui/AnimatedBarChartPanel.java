/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAssignment.Gui;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;

public class AnimatedBarChartPanel extends JPanel {

    private String[] labels = {"Confirmed", "Pending", "Cancelled"};
    private int[] targetValues = {4, 2, 1};
    private Color[] barColors = {
        new Color(87, 161, 91),
        new Color(217, 154, 62),
        new Color(181, 85, 92)
    };

    private double[] currentHeights = new double[3];
    private Timer animationTimer;

    public AnimatedBarChartPanel() {
        setOpaque(false);
    }

    public void startAnimation() {
        for (int i = 0; i < currentHeights.length; i++) {
            currentHeights[i] = 0;
        }

        animationTimer = new Timer(50, e -> {
            boolean stillAnimating = false;

            for (int i = 0; i < targetValues.length; i++) {
                if (currentHeights[i] < targetValues[i]) {
                    currentHeights[i] += 0.03;
                    if (currentHeights[i] > targetValues[i]) {
                        currentHeights[i] = targetValues[i];
                    }
                    stillAnimating = true;
                }
            }

            repaint();

            if (!stillAnimating) {
                animationTimer.stop();
            }
        });

        animationTimer.start();
    }
    
    public void setData(int confirmed, int pending, int cancelled) {
    targetValues[0] = confirmed;
    targetValues[1] = pending;
    targetValues[2] = cancelled;
    }
    
    private int getMaxValue() {
    int max = 1;
    for (int v : targetValues) {
        if (v > max) max = v;
    }
    return max + 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int baselineY = panelHeight - 30;
        int maxBarHeight = panelHeight - 60;
        int maxValue = getMaxValue(); 

        int barWidth = 40;
        int gap = 40;
        int totalWidth = (barWidth * 3) + (gap * 2);
        int startX = (panelWidth - totalWidth) / 2;

        for (int i = 0; i < targetValues.length; i++) {
            int barHeight = (int) ((currentHeights[i] / maxValue) * maxBarHeight);
            int x = startX + i * (barWidth + gap);
            int y = baselineY - barHeight;

            g2.setColor(barColors[i]);
            g2.fillRoundRect(x, y, barWidth, barHeight, 6, 6);

            g2.setColor(Color.WHITE);
            g2.drawString(String.valueOf((int) currentHeights[i]), x + barWidth / 2 - 5, y - 8);

            g2.drawString(labels[i], x - 5, baselineY + 20);
        }

        g2.setColor(Color.LIGHT_GRAY);
        g2.drawLine(startX - 20, baselineY, startX + totalWidth + 20, baselineY);
    }
}