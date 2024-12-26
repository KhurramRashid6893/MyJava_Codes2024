import javax.swing.*;
import java.awt.*;

public class SimpleMessageSwing {
    public static void main(String[] args) {
        // Create the main application window
        JFrame frame = new JFrame("Simple Message Application");
        frame.setSize(400, 300); // Set the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when closed

        // Create a custom panel to display the message
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Ensure proper rendering

                // Set the message to be displayed
                String message = "Hello, welcome to the application!";
                
                // Set font style and size
                Font font = new Font("Arial", Font.BOLD, 20);
                g.setFont(font);

                // Calculate the position to center the text
                int x = (getWidth() - g.getFontMetrics().stringWidth(message)) / 2;
                int y = getHeight() / 2;

                // Draw the message
                g.drawString(message, x, y);
            }
        };

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
