import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    // Components
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[5]; // +, -, *, %, =
    private JButton addButton, subButton, mulButton, modButton, equalButton;
    private JButton clearButton;
    private JPanel panel;

    // Variables for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public SimpleCalculator() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text field for displaying results
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        // Buttons for numbers and operations
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        modButton = new JButton("%");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = modButton;
        functionButtons[4] = equalButton;

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        for (JButton button : functionButtons) {
            button.addActionListener(this);
        }
        clearButton.addActionListener(this);

        // Panel for arranging buttons in a grid
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        
        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(modButton);

        add(panel, BorderLayout.CENTER);

        // Make frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(textField.getText() + " + ");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(textField.getText() + " - ");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText(textField.getText() + " * ");
        }
        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText(textField.getText() + " % ");
        }
        if (e.getSource() == equalButton) {
            String[] parts = textField.getText().split(" ");
            if (parts.length == 3) {
                num2 = Double.parseDouble(parts[2]);
            }
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
