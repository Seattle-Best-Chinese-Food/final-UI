import javax.swing.*;
import java.awt.*;

public class LoginPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurant Backend System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout()); // 使用 GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // 布局约束对象

        // 设置全局的默认权重
        gbc.weightx = 1 / 2; // 水平方向权重
        gbc.weighty = 1 / 2; // 垂直方向权重
        gbc.insets = new Insets(10, 10, 10, 10); // 设置内边距

        // 背景面板
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new GridBagLayout());
        frame.setContentPane(backgroundPanel); // 将背景面板作为内容面板

        // 登录标题
        JLabel loginLabel = new JLabel("Login", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0; // 列索引为0
        gbc.gridy = 0; // 行索引为0
        gbc.gridwidth = 6; // 跨6列
        gbc.gridheight = 1; // 跨1行
        gbc.anchor = GridBagConstraints.CENTER; // 居中
        frame.add(loginLabel, gbc);

        // Admin 和 Customer 选择
        JPanel rolePanel = new JPanel();
        // rolePanel.setBackground(Color(223, 242, 242));
        JRadioButton adminRadio = new JRadioButton("Admin");
        JRadioButton customerRadio = new JRadioButton("Customer");
        ButtonGroup group = new ButtonGroup();
        group.add(adminRadio);
        group.add(customerRadio);
        rolePanel.add(adminRadio);
        rolePanel.add(customerRadio);
        gbc.gridx = 0; // 列索引为0
        gbc.gridy = 1; // 行索引为1
        gbc.gridwidth = 6; // 跨6列
        gbc.gridheight = 1; // 跨1行
        frame.add(rolePanel, gbc);

        // Username 标签
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 2; // 列索引为2
        gbc.gridy = 2; // 行索引为2
        gbc.gridwidth = 1; // 跨1列
        gbc.gridheight = 1; // 跨1行
        gbc.anchor = GridBagConstraints.EAST; // 向右对齐
        frame.add(usernameLabel, gbc);

        // Username 输入框
        JTextField usernameField = new JTextField(15);
        gbc.gridx = 3; // 列索引为3
        gbc.gridy = 2; // 行索引为2
        gbc.gridwidth = 3; // 跨3列
        gbc.gridheight = 1; // 跨1行
        gbc.anchor = GridBagConstraints.WEST; // 向左对齐
        frame.add(usernameField, gbc);

        // Password 标签
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 2; // 列索引为2
        gbc.gridy = 3; // 行索引为3
        gbc.gridwidth = 1; // 跨1列
        gbc.gridheight = 1; // 跨1行
        gbc.anchor = GridBagConstraints.EAST; // 向右对齐
        frame.add(passwordLabel, gbc);

        // Password 输入框
        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 3; // 列索引为3
        gbc.gridy = 3; // 行索引为3
        gbc.gridwidth = 3; // 跨3列
        gbc.gridheight = 1; // 跨1行
        gbc.anchor = GridBagConstraints.WEST; // 向左对齐
        frame.add(passwordField, gbc);

        // Sign In 和 Sign Up 按钮
        JPanel buttonPanel = new JPanel();
        JButton signInButton = new JButton("Sign In");
        signInButton.setOpaque(true); // 确保按钮的背景不透明
        signInButton.setBorderPainted(false); // 去掉按钮边框
        signInButton.setBackground(new Color(130, 213, 184)); //背景色
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setOpaque(true); // 确保按钮的背景不透明
        signUpButton.setBorderPainted(false); // 去掉按钮边框
        signUpButton.setBackground(new Color(87, 154, 242)); //背景色
        buttonPanel.add(signInButton);
        buttonPanel.add(signUpButton);
        gbc.gridx = 0; // 列索引为0
        gbc.gridy = 4; // 行索引为4
        gbc.gridwidth = 6; // 跨6列
        gbc.gridheight = 1; // 跨1行
        gbc.anchor = GridBagConstraints.CENTER; // 居中
        frame.add(buttonPanel, gbc);
        frame.setVisible(true);
    }
}