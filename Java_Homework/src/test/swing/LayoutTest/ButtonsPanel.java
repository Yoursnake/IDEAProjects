package test.swing.LayoutTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    private JButton start;
    private JButton show;
    private JButton exit;

    public ButtonsPanel() {
        start = new JButton("开始");
        show = new JButton("显示");
        exit = new JButton("退出");
        show.setEnabled(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(start);
        add(show);
        add(exit);
    }
}
