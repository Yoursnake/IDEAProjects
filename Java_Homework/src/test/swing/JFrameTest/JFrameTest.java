package test.swing.JFrameTest;

import javax.swing.*;

public class JFrameTest extends JFrame {
    public JFrameTest(String title) {
        super(title);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
