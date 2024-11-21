import javax.swing.*;
import java.awt.*;

public class OrderStatusPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order Status");
        frame.setSize(800, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 设置订单状态标签，并调整字体和对齐
        JLabel orderStatusLabel = new JLabel("Order Status", SwingConstants.CENTER);
        orderStatusLabel.setFont(new Font("Arial", Font.BOLD, 24)); // 设置字体加粗并放大
        panel.add(orderStatusLabel, BorderLayout.NORTH);

        // 菜品状态面板
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridBagLayout()); // 使用 GridBagLayout 以适应动态布局

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // 设置内边距
        // 设置全局的默认权重
        gbc.weightx = 1; // 水平方向权重
        gbc.weighty = 1; // 垂直方向权重
        gbc.insets = new Insets(10, 10, 10, 10); // 设置内边距

        // 表头：菜品名称、状态
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        statusPanel.add(new JLabel("Dish Name", SwingConstants.CENTER), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        statusPanel.add(new JLabel("Status", SwingConstants.CENTER), gbc);

        // 定义自定义的颜色
        Color pendingColor = new Color(87, 154, 242); 
        Color completedColor = new Color(130, 213, 184); 

        // 示例菜品状态
        for (int i = 0; i < 8; i++) {
            // 每个菜品状态项的布局
            gbc.gridx = 1;
            gbc.gridy = i + 1; // 从第二行开始
            gbc.gridwidth = 2;
            statusPanel.add(new JLabel("Item " + (i + 1), SwingConstants.CENTER), gbc);

            // 根据状态设置背景色
            String status = (i % 2 == 0) ? "Pending" : "Completed";  // 假设状态交替
            JLabel statusLabel = new JLabel(status, SwingConstants.CENTER);

            // 设置背景色
            if (status.equals("Pending")) {
                statusLabel.setBackground(pendingColor); // 设置橙色背景
            } else if (status.equals("Completed")) {
                statusLabel.setBackground(completedColor); // 设置绿色背景
            }

            // 设置标签为不透明，才能显示背景色
            statusLabel.setOpaque(true);

            gbc.gridx = 3;
            gbc.gridy = i + 1;
            gbc.gridwidth = 2;
            statusPanel.add(statusLabel, gbc);
        }

        // 将菜品状态面板放入滚动面板中
        JScrollPane scrollPane = new JScrollPane(statusPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        // 底部按钮面板
        JPanel bottomPanel = new JPanel();
        JButton refreshButton = new JButton("Refresh Status");
        bottomPanel.add(refreshButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}