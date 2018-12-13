package test.swing.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class ArithPanel extends JPanel {
    private JLabel[] labels;
    private JTextField result;

    public ArithPanel() {
        setLayout(new GridLayout(1, 5, 1, 1));
        labels = new JLabel[4];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            labels[i].setOpaque(true);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setBackground(Color.WHITE);
            add(labels[i]);
        }
        labels[0].setText("12");
        labels[1].setText("+");
        labels[2].setText("88");
        labels[3].setText("=");
        result = new JTextField();
        add(result);
    }
}
