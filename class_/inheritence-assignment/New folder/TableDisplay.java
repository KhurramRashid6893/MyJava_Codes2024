import javax.swing.*;
import java.io.*;
import java.util.*;

public class TableDisplay {
    public static void main(String[] args) {
        String filePath = "Table.txt"; // Path to your text file

        // Read data from the text file
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert data to 2D array for JTable
        String[][] tableData = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            tableData[i] = data.get(i);
        }

        // Get column names (from first row in data)
        String[] columnNames = tableData[0]; // Assuming first row is header

        // Create JTable and JFrame for display
        JTable table = new JTable(tableData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Table Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
