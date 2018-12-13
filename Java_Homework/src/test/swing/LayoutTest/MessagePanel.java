package test.swing.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class MessagePanel extends JPanel {
    private JLabel label;

    public MessagePanel(String msg) {
        setLayout(new GridLayout(1, 1));
        label = new JLabel(msg);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("宋体", Font.BOLD, 20));
        add(label);
    }
}
