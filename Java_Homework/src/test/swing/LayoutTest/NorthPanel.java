package test.swing.LayoutTest;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    private MessagePanel msg;
    private ArithPanel arith;

    public NorthPanel() {
        msg = new MessagePanel("好好学习！");
        arith = new ArithPanel();
        setLayout(new GridLayout(2, 1));
        add(msg);
        add(arith);
    }
}
