import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeDrawer extends JFrame {
    private String currentShape = "Line"; // Default shape
    private int startX, startY, endX, endY; // Coordinates for drawing
    private JPanel canvasPanel; // Panel to draw shapes

    public ShapeDrawer() {
        // Set up the frame
        setTitle("Shape Drawer");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Canvas for drawing
        canvasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);

                // Draw the selected shape based on coordinates
                if (currentShape.equals("Line")) {
                    g.drawLine(startX, startY, endX, endY);
                } else if (currentShape.equals("Rectangle")) {
                    g.drawRect(Math.min(startX, endX), Math.min(startY, endY),
                               Math.abs(endX - startX), Math.abs(endY - startY));
                } else if (currentShape.equals("Oval")) {
                    g.drawOval(Math.min(startX, endX), Math.min(startY, endY),
                               Math.abs(endX - startX), Math.abs(endY - startY));
                }
            }
        };

        canvasPanel.setBackground(Color.WHITE);
        canvasPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                canvasPanel.repaint(); // Repaint the canvas to draw the shape
            }
        });

        canvasPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                canvasPanel.repaint(); // Repaint during drag for dynamic drawing
            }
        });

        add(canvasPanel, BorderLayout.CENTER);

        // Control panel for shape selection
        JPanel controlPanel = new JPanel();
        JButton lineButton = new JButton("Line");
        JButton rectangleButton = new JButton("Rectangle");
        JButton ovalButton = new JButton("Oval");

        // Add action listeners to buttons
        lineButton.addActionListener(e -> currentShape = "Line");
        rectangleButton.addActionListener(e -> currentShape = "Rectangle");
        ovalButton.addActionListener(e -> currentShape = "Oval");

        // Add buttons to control panel
        controlPanel.add(lineButton);
        controlPanel.add(rectangleButton);
        controlPanel.add(ovalButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Set frame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShapeDrawer::new);
    }
}
