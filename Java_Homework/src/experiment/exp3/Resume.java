package experiment.exp3;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Resume extends JFrame {
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private JLabel nameLabel = null;//姓名
    private JTextField nameEdit = null;
    private JLabel nativeLabel = null;//籍贯
    private JTextField nativeEdit = null;
    private ButtonGroup bg = null;
    private JRadioButton manRadioButton = null;//性别
    private JRadioButton womanRadioButton = null;//性别
    private JLabel sexLabel = null;
    private JLabel eduLabel = null;//教育程度
    private JComboBox eduComboBox = null;
    private JLabel briefLabel = null;
    private JTextArea briefEditArea = null;//简历
    private JButton submitButton = null;//提交按钮
    private JPanel resumePanel = null;
    //输入输出流
    private BufferedReader buf = null;
    private PrintWriter out = null;

    public Resume() {
        super("我的个人简历");
        this.setSize(500,500);
        this.setResizable(false);
        this.setLocation((width-500)/2, (height-500)/2);

        Container con = this.getContentPane();

        resumePanel = new JPanel();
        resumePanel.setLayout(null);
        con.add(resumePanel,BorderLayout.CENTER);
        nameLabel = new JLabel("姓 名 : ");
        nameLabel.setBounds(180,30,50,20);
        nameEdit = new JTextField(15);
        nameEdit.setBounds(220,30,100,20);
        resumePanel.add(nameLabel);
        resumePanel.add(nameEdit);
        nativeLabel = new JLabel("籍 贯 : ");
        nativeLabel.setBounds(180,60,50,20);
        nativeEdit = new JTextField(15);
        nativeEdit.setBounds(220,60,100,20);
        resumePanel.add(nativeLabel);
        resumePanel.add(nativeEdit);
        sexLabel = new JLabel("性 别 ：");
        sexLabel.setBounds(180,80,50,20);
        resumePanel.add(sexLabel);
        manRadioButton = new JRadioButton("男");
        womanRadioButton = new JRadioButton("女");
        bg = new ButtonGroup();
        bg.add(manRadioButton);
        bg.add(womanRadioButton);
        manRadioButton.setBounds(220,80,50,20);
        womanRadioButton.setBounds(270,80,50,20);
        resumePanel.add(manRadioButton);
        resumePanel.add(womanRadioButton);
        //教育程度
        eduLabel = new JLabel("学 历 : ");
        eduLabel.setBounds(180,100,50,20);
        resumePanel.add(eduLabel);
        eduComboBox = new JComboBox();
        eduComboBox.addItem("专科");
        eduComboBox.addItem("本科");
        eduComboBox.addItem("硕士");
        eduComboBox.addItem("博士");
        eduComboBox.setBounds(220,100,100,20);
        resumePanel.add(eduComboBox);
        briefLabel = new JLabel("个人简述：");
        briefLabel.setBounds(180,130,100,20);
        resumePanel.add(briefLabel);
        briefEditArea = new JTextArea();
        briefEditArea.setBounds(180,150,250,250);
        resumePanel.add(briefEditArea);
        submitButton = new JButton("提交");
        submitButton.setBounds(260,400,70,30);
        resumePanel.add(submitButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Resume();
    }
}
