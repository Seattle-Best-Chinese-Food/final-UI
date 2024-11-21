import javax.swing.*;
import java.awt.*;

public class CustomerMenuPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Customer Menu");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 主面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 菜单标题
        JLabel menuLabel = new JLabel("Menu", SwingConstants.CENTER);
        menuLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(menuLabel, BorderLayout.NORTH);

        // 菜品卡片面板
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridBagLayout()); // 使用 GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 设置全局的默认权重
        gbc.weightx = 1; // 水平方向权重
        gbc.weighty = 1; // 垂直方向权重
        gbc.insets = new Insets(1, 1, 1, 1); // 设置内边距

        // 示例菜品卡片
        for (int i = 0; i < 8; i++) {
            // 每个菜品的卡片面板
            JPanel card = new JPanel();
            card.setLayout(new GridBagLayout()); // 使用 GridBagLayout 实现灵活布局

            // 设置菜品的图片区域 (占1-3列，跨2行)
            JLabel imageLabel = new JLabel("Item " + (i + 1) + " Image", SwingConstants.CENTER);
            imageLabel.setPreferredSize(new Dimension(150, 150)); // 固定大小确保是正方形
            imageLabel.setBackground(new Color(242, 224, 208));  // 设置背景色
            imageLabel.setOpaque(true); // 确保背景色显示出来
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3; // 占1-3列
            gbc.gridheight = 2; // 跨两行
            gbc.insets = new Insets(10, 10, 10, 10); // 设置内边距
            card.add(imageLabel, gbc);

            // 菜品价格区域 (占第5列)
            JLabel priceLabel = new JLabel("$10.00", SwingConstants.CENTER);
            gbc.gridx = 3;
            gbc.gridy = 0; // 第一行
            gbc.gridwidth = 1; // 占1列
            gbc.gridheight = 1; // 占1行
            card.add(priceLabel, gbc);

            // 订单按钮 (占第6列)
            JButton orderButton = new JButton("Order");
            gbc.gridx = 5;
            gbc.gridy = 0; // 第一行
            gbc.gridwidth = 1; // 占1列
            gbc.gridheight = 1; // 占1行
            card.add(orderButton, gbc);
            orderButton.setOpaque(true); // 确保按钮的背景不透明
            orderButton.setBorderPainted(false); // 去掉按钮边框
            orderButton.setBackground(new Color(87, 154, 242)); //背景色

            // 菜品详情区域 (横跨5-6列，位于第二行)
            JLabel detailsLabel = new JLabel("Item " + (i + 1) + " details", SwingConstants.CENTER);
            gbc.gridx = 3;
            gbc.gridy = 1; // 第二行开始
            gbc.gridwidth = 2; // 横跨5-6列
            card.add(detailsLabel, gbc);

            // 将卡片添加到卡片面板
            gbc.gridx = 0;
            gbc.gridy = i; // 将每个卡片放在不同的行
            gbc.gridwidth = 8; // 每个卡片占用整个行
            gbc.gridheight = 1; // 高度为1行
            cardPanel.add(card, gbc);
        }

        // 将卡片面板放入滚动面板中
        JScrollPane scrollPane = new JScrollPane(cardPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // 底部按钮面板
        JPanel bottomPanel = new JPanel();
        JButton viewOrderButton = new JButton("View Order");
        bottomPanel.add(viewOrderButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        // 将面板添加到窗口
        frame.add(panel);
        frame.setVisible(true);
    }
}