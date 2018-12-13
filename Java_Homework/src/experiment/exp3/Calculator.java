package experiment.exp3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JButton[] numButton;
    private JButton[] operateButton;
    private JButton equalButton;
    private JButton clearButton;
    private JPanel resultPanel;
    private JPanel numPanel;
    private JPanel operatePanel;
    private JTextField resultText;
    private String currentText = "";
    private double operateNum1, operateNum2;
    private String currentOperate;
    private boolean isShowResult = false;

    public Calculator() {
        super("计算器");

        operateNum1 = 0;
        operateNum2 = 0;
        clearButton = new JButton("C");
        numButton = new JButton[10];
        operateButton = new JButton[4];
        for (int i = 0; i < numButton.length-1; i++) {
            numButton[i] = new JButton(String.valueOf(i+1));
        }
        numButton[9] = new JButton("0");
        operateButton[0] = new JButton("+");
        operateButton[1] = new JButton("-");
        operateButton[2] = new JButton("×");
        operateButton[3] = new JButton("÷");
        equalButton = new JButton("=");
        resultText = new JTextField("0", 18);
        resultText.setBorder(null);
        resultText.setPreferredSize(new Dimension (220,60));

        resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setSize(232, 60);
        resultPanel.add(resultText);

        numPanel = new JPanel(new GridLayout(4, 4));
        numPanel.setSize(232, 240);
        for (int i = 0; i < numButton.length; i++) {
            int finalI = i;
            numPanel.add(numButton[i]);
            numButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isShowResult) {
                        currentText = "";
                        resultText.setText(currentText);
                        isShowResult = false;
                    }

                    currentText += String.valueOf(numButton[finalI].getText());
                    resultText.setText(currentText);
                }
            });
        }
        numPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operateNum1 = 0;
                operateNum2 = 0;
                currentText = "";
                resultText.setText("0");
            }
        });
        numPanel.add(equalButton);
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operateNum2 = Double.parseDouble(resultText.getText());
                double result = 0;
                switch (currentOperate) {
                    case "+":
                        result = operateNum1 + operateNum2;
                        break;
                    case "-":
                        result = operateNum1 - operateNum2;
                        break;
                    case "×":
                        result = operateNum1 * operateNum2;
                        break;
                    case "÷":
                        result = operateNum1 / operateNum2;
                        break;
                }
                currentText = String.valueOf(result);
                resultText.setText(currentText);
                isShowResult = true;
            }
        });

        operatePanel = new JPanel(new GridLayout(1, 5));
        for (int i = 0; i < operateButton.length; i++) {
            operatePanel.add(operateButton[i]);
            int finalI = i;
            operateButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    operateNum1 = Double.parseDouble(resultText.getText());
                    currentOperate = operateButton[finalI].getText();
                    currentText = "";
                    resultText.setText(currentText);
                }
            });
        }

        Container c = getContentPane();
        c.add(resultPanel, BorderLayout.NORTH);
        c.add(numPanel, BorderLayout.CENTER);
        c.add(operatePanel, BorderLayout.SOUTH);

        setVisible(true);
        setSize(232, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
