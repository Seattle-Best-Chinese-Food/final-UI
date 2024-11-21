import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOrderManagementPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order Management");
        frame.setSize(800, 600);
        
        // 设置内容与边缘的间距
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // 设置边缘间距
        
        // 订单管理表格
        String[] columnNames = {"Customer", "Dish", "Order Time", "Status", "Action"};
        Object[][] data = {
            {"Customer1", "Dish1", "2024-11-17 10:00", "Pending", "Update"},
            {"Customer2", "Dish2", "2024-11-17 10:30", "Completed", "Update"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 仅允许编辑状态和操作列
                return column == 3 || column == 4;
            }
        };
        
        JTable table = new JTable(tableModel);
        table.setRowHeight(35); // 设置行高为35px

        // 设置Status列宽度宽一点
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        
        // 自定义状态列渲染器和编辑器
        table.getColumnModel().getColumn(3).setCellRenderer(new StatusCellRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new StatusCellEditor());

        // 自定义操作列渲染器和编辑器
        table.getColumnModel().getColumn(4).setCellRenderer(new ActionCellRenderer());
        table.getColumnModel().getColumn(4).setCellEditor(new ActionCellEditor());

        JScrollPane tableScrollPane = new JScrollPane(table);
        panel.add(tableScrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    // 自定义状态列渲染器：显示单选框
    static class StatusCellRenderer extends JPanel implements TableCellRenderer {
        private final JRadioButton pendingButton;
        private final JRadioButton completedButton;
        private final ButtonGroup buttonGroup;

        public StatusCellRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            buttonGroup = new ButtonGroup();

            pendingButton = new JRadioButton("Pending");
            completedButton = new JRadioButton("Completed");

            // 将两个按钮添加到按钮组中
            buttonGroup.add(pendingButton);
            buttonGroup.add(completedButton);

            add(pendingButton);
            add(completedButton);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if ("Pending".equals(value)) {
                pendingButton.setSelected(true);
            } else if ("Completed".equals(value)) {
                completedButton.setSelected(true);
            }
            return this;
        }
    }

    // 自定义状态列编辑器：处理单选框点击事件
    static class StatusCellEditor extends AbstractCellEditor implements TableCellEditor {
        private final JRadioButton pendingButton;
        private final JRadioButton completedButton;
        private final ButtonGroup buttonGroup;

        public StatusCellEditor() {
            buttonGroup = new ButtonGroup();
            pendingButton = new JRadioButton("Pending");
            completedButton = new JRadioButton("Completed");

            // 将按钮添加到按钮组
            buttonGroup.add(pendingButton);
            buttonGroup.add(completedButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if ("Pending".equals(value)) {
                pendingButton.setSelected(true);
            } else if ("Completed".equals(value)) {
                completedButton.setSelected(true);
            }
            return new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0)) {{
                add(pendingButton);
                add(completedButton);
            }};
        }

        @Override
        public Object getCellEditorValue() {
            return pendingButton.isSelected() ? "Pending" : "Completed";
        }
    }

    // 自定义操作列渲染器：显示Update按钮
    static class ActionCellRenderer extends JPanel implements TableCellRenderer {
        private final JButton updateButton;

        public ActionCellRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            updateButton = new JButton("Update");
            updateButton.setPreferredSize(new Dimension(80, 25)); // 设置按钮大小
            add(updateButton);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // 自定义操作列编辑器：处理Update按钮点击事件
    static class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
        private final JPanel panel;
        private final JButton updateButton;

        public ActionCellEditor() {
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
            updateButton = new JButton("Update");
            updateButton.setPreferredSize(new Dimension(80, 25)); // 设置按钮大小
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Update clicked");
                    fireEditingStopped(); // 结束编辑状态
                }
            });

            panel.add(updateButton);
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