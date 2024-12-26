import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

public class DisplayTable {
    public static void main(String[] args) {
        // File to be read
        String fileName = "Table.txt";

        // Lists to store table data
        List<String[]> tableData = new ArrayList<>();
        String[] columnNames = null;

        // Read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (isFirstLine) {
                    columnNames = values; // First line is the header
                    isFirstLine = false;
                } else {
                    tableData.add(values); // Remaining lines are table rows
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Convert list to array for JTable
        String[][] rowData = tableData.toArray(new String[0][]);

        // Create JTable
        JTable table = new JTable(new DefaultTableModel(rowData, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);

        // Create JFrame to display table
        JFrame frame = new JFrame("Table Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
