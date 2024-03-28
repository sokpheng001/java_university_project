package view.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Table {
    public static void main(String[] args) {
        // Data for the table
        Object[][] data = {
                {"John", 25},
                {"Alice", 30},
                {"Bob", 40}
        };

        // Column names
        String[] columnNames = {"Name", "Age"};

        // Create a table model with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the table model
        JTable table = new JTable(model);
        table.setBorder(new EmptyBorder(5,5,0, 0));

        // Optionally, you can customize the table appearance or behavior here
        // For example:
        // table.setPreferredScrollableViewportSize(new Dimension(500, 200));

        // Create a JScrollPane to contain the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JFrame to display the table
        JFrame frame = new JFrame("Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane); // Add the scroll pane with the table to the frame
        frame.pack(); // Size
        frame.setVisible(true);
    }
}
