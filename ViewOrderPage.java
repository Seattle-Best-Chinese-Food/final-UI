import javax.swing.*;
import java.awt.*;

public class ViewOrderPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("View Order");
        frame.setSize(800, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel orderLabel = new JLabel("Full Order", SwingConstants.CENTER);
        orderLabel .setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(orderLabel, BorderLayout.NORTH);

        // 订单列表面板
        JPanel orderListPanel = new JPanel();
        orderListPanel.setLayout(new GridBagLayout()); // 使用 GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // 设置内边距
        // 设置全局的默认权重
        gbc.weightx = 1; // 水平方向权重
        gbc.weighty = 1; // 垂直方向权重
        gbc.insets = new Insets(10, 10, 10, 10); // 设置内边距

        // 表头：菜品名称、数量、价格
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        orderListPanel.add(new JLabel("Dish Name", SwingConstants.CENTER), gbc);


        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        orderListPanel.add(new JLabel("Quantity", SwingConstants.CENTER), gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        orderListPanel.add(new JLabel("Price", SwingConstants.CENTER), gbc);

        // 示例订单项
        for (int i = 0; i < 8; i++) {
            // 每个订单项的布局
            gbc.gridx = 1;
            gbc.gridy = i + 1; // 从第二行开始
            gbc.gridwidth = 2;
            orderListPanel.add(new JLabel("Item " + (i + 1), SwingConstants.CENTER), gbc);

            // 数量部分（带有➕和➖按钮）
            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0)); // 居中布局
            JButton minusButton = new JButton("-");
            minusButton.setForeground(new Color(130, 213, 184));

            JLabel quantityLabel = new JLabel("1");

            JButton plusButton = new JButton("+");
            plusButton.setForeground(new Color(87, 154, 242));

            quantityPanel.add(minusButton);
            quantityPanel.add(quantityLabel);
            quantityPanel.add(plusButton);

            gbc.gridx = 3;
            gbc.gridy = i + 1;
            gbc.gridwidth = 2;
            orderListPanel.add(quantityPanel, gbc);

            // 价格
            gbc.gridx = 5;
            gbc.gridy = i + 1;
            gbc.gridwidth = 2;
            orderListPanel.add(new JLabel("$10.00", SwingConstants.CENTER), gbc);
        }

        // 将订单列表面板放入滚动面板中
        JScrollPane scrollPane = new JScrollPane(orderListPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // 底部按钮面板
        JPanel bottomPanel = new JPanel();
        JButton submitButton = new JButton("Submit Order");
        bottomPanel.add(submitButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}