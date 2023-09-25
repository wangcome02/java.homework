import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sim_calc extends JFrame {
    private JTextField aField, bField, cField, root1Field, root2Field;

    public sim_calc() {
        // 设置窗口标题
        setTitle("一元二次方程求根");

        // 创建输入框和标签
        JLabel numLable = new JLabel("输入系数a,b,c:");
        aField = new JTextField(3);
        bField = new JTextField(3);
        cField = new JTextField(3);

        // 创建求根按钮
        JButton calculateButton = new JButton("求根");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateRoots();
            }
        });

        // 创建文本框用于显示结果
        JLabel display = new JLabel("两个根：");
        root1Field = new JTextField(5);
        root1Field.setEditable(false);
        root2Field = new JTextField(5);
        root2Field.setEditable(false);

        //创建退出按钮
        JButton exitButton = new JButton("退出");
        exitButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));

        // 创建面板并设置布局
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(numLable);
        inputPanel.add(aField);
        inputPanel.add(bField);
        inputPanel.add(cField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        JPanel resultPanel =new JPanel();
        resultPanel.add(display);
        resultPanel.add(root1Field);
        resultPanel.add(root2Field);

        // 添加组件到窗口
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.add(resultPanel, BorderLayout.CENTER);

        // 设置窗口属性
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateRoots() {
        try {
            // 从输入框获取a、b和c的值
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());

            if(a!=0) {
                // 计算一元二次方程的根
                double delta = b * b - 4 * a * c;

                if (delta > 0) {
                    double root1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double root2 = (-b - Math.sqrt(delta)) / (2 * a);
                    root1Field.setText(Double.toString(root1));
                    root2Field.setText(Double.toString(root2));
                } else if (delta == 0) {
                    double root = -b / (2 * a);
                    root1Field.setText(Double.toString(root));
                    root2Field.setText("");
                } else {
                    root1Field.setText("无实根");
                    root2Field.setText("");
                }
            }else{
                //创建红色警告信息
                UIManager.put("OptionPane.messageForeground",Color.RED);
                JOptionPane.showMessageDialog(this,"警告！系数a不能为0！");
                UIManager.put("OptionPane.messageForeground",null);
                return;
            }

        } catch (NumberFormatException e) {
            root1Field.setText("请输入有效的数字");
            root2Field.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new sim_calc();
            }
        });
    }
}

