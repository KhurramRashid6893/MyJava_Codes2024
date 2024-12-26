import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JPanel lightPanel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create radio buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group radio buttons to ensure only one can be selected
        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(yellowButton);
        group.add(greenButton);

        // Add action listeners to buttons
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Create a panel for the radio buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        // Create a panel for the traffic light
        lightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(150, 50, 100, 300); // Traffic light box

                // Draw the lights
                g.setColor(redButton.isSelected() ? Color.RED : Color.GRAY);
                g.fillOval(175, 60, 50, 50);

                g.setColor(yellowButton.isSelected() ? Color.YELLOW : Color.GRAY);
                g.fillOval(175, 150, 50, 50);

                g.setColor(greenButton.isSelected() ? Color.GREEN : Color.GRAY);
                g.fillOval(175, 240, 50, 50);
            }
        };

        add(buttonPanel, BorderLayout.SOUTH);
        add(lightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lightPanel.repaint(); // Repaint the panel when a button is selected
    }

    public static void main(String[] args) {
        new TrafficLightSimulator();
    }
}
