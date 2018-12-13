package experiment.exp3;

import javax.swing.*;
import java.awt.*;

public class Password extends JFrame {
    private JPasswordField inputText;
    private JPanel panel;
    private JLabel label;

    public Password() {
        super("密码输入");

        panel = new JPanel();

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(panel, BorderLayout.CENTER);

        label = new JLabel("Password:");
        panel.add(label);

        inputText = new JPasswordField(10);
        inputText.setEchoChar('*');
        inputText.setEnabled(true);
        inputText.setOpaque(false);
        panel.add(inputText);

        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Password frame = new Password();
    }
}
