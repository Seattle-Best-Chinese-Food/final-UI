import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class AdminMenuPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Menu");
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // 设置边界距离

        // 添加菜品的输入框
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 添加间距

        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField detailsField = new JTextField();
        JTextField imageURLField = new JTextField();

        inputPanel.add(new JLabel("Dish Name"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Price"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Details"));
        inputPanel.add(detailsField);
        inputPanel.add(new JLabel("Image URL"));
        inputPanel.add(imageURLField);

        JButton addButton = new JButton("Add");
        inputPanel.add(new JLabel()); // 占位
        inputPanel.add(addButton);

        panel.add(inputPanel, BorderLayout.NORTH);

        // 菜品管理表格
        String[] columnNames = {"Dish", "Price", "Details", "Image", "Action"};
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{
            {"Dish 1", "$10", "Details 1", "Image URL 1", ""},
            {"Dish 2", "$15", "Details 2", "Image URL 2", ""}
        }, columnNames);

        JTable table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // 仅允许编辑 Action 列
            }
        };

        // 设置每行的行高为 35px
        table.setRowHeight(35);

        // 自定义 Action 列渲染器和编辑器
        table.getColumnModel().getColumn(4).setCellRenderer(new ActionCellRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ActionCellEditor());

        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    // 自定义渲染器：显示按钮
    static class ActionCellRenderer extends JPanel implements TableCellRenderer {
        private final JButton deleteButton;
        private final JButton editButton;

        public ActionCellRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            deleteButton = new JButton("Delete");
            editButton = new JButton("Edit");

            // 设置按钮大小
            deleteButton.setPreferredSize(new Dimension(65, 25)); // 宽65px，高25px
            editButton.setPreferredSize(new Dimension(65, 25));

            // 设置按钮字体颜色
            deleteButton.setForeground(new Color(242, 88, 53));
            editButton.setForeground(new Color(87, 154, 242));   

            add(deleteButton);
            add(editButton);

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // 自定义编辑器：处理按钮点击事件
    static class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
        private final JPanel panel;
        private final JButton deleteButton;
        private final JButton editButton;

        public ActionCellEditor() {
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            deleteButton = new JButton("Delete");
            editButton = new JButton("Edit");

            // 设置按钮大小
            deleteButton.setPreferredSize(new Dimension(65, 25)); // 宽65px，高25px
            editButton.setPreferredSize(new Dimension(65, 25));


            // 绑定按钮事件
            deleteButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Delete clicked");
                fireEditingStopped(); // 结束编辑状态
            });

            editButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(null, "Edit clicked");
                fireEditingStopped(); // 结束编辑状态
            });

            panel.add(deleteButton);
            panel.add(editButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }
}