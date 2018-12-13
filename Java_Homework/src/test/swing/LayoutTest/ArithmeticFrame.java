package test.swing.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class ArithmeticFrame extends JFrame {
    private JTextArea area;

    public ArithmeticFrame() {
        NorthPanel north = new NorthPanel();
        area = new JTextArea();
        ButtonsPanel south = new ButtonsPanel();
        Container c = this.getContentPane();
        c.add(north, BorderLayout.NORTH);
        c.add(new JScrollPane(area), BorderLayout.CENTER);
        c.add(south, BorderLayout.SOUTH);
        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ArithmeticFrame();
    }
}
