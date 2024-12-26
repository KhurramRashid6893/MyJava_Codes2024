import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShapeDrawer extends JFrame {
    private String currentShape = "Line"; // Default shape
    private Color currentColor = Color.BLUE; // Default color
    private int startX, startY, endX, endY;

    public ShapeDrawer() {
        setTitle("Shape Drawer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create toolbar with shape and color selection
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Shape selection combo box
        String[] shapes = {"Line", "Rectangle", "Oval"};
        JComboBox<String> shapeSelector = new JComboBox<>(shapes);
        shapeSelector.addActionListener(e -> currentShape = (String) shapeSelector.getSelectedItem());
        toolbar.add(new JLabel("Shape:"));
        toolbar.add(shapeSelector);

        // Color selection button
        JButton colorButton = new JButton("Select Color");
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a Color", currentColor);
            if (selectedColor != null) {
                currentColor = selectedColor;
            }
        });
        toolbar.add(new JLabel("Color:"));
        toolbar.add(colorButton);

        // Add toolbar to the frame
        add(toolbar, BorderLayout.NORTH);

        // Drawing panel
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(currentColor);

                if (startX != endX || startY != endY) { // Prevent accidental empty drawings
                    switch (currentShape) {
                        case "Line":
                            g.drawLine(startX, startY, endX, endY);
                            break;
                        case "Rectangle":
                            g.drawRect(Math.min(startX, endX), Math.min(startY, endY),
                                    Math.abs(endX - startX), Math.abs(endY - startY));
                            break;
                        case "Oval":
                            g.drawOval(Math.min(startX, endX), Math.min(startY, endY),
                                    Math.abs(endX - startX), Math.abs(endY - startY));
                            break;
                    }
                }
            }
        };

        drawingPanel.setBackground(Color.WHITE);

        // Add mouse listeners for drawing
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawingPanel.repaint(); // Trigger repaint after drawing is complete
            }
        });

        drawingPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                drawingPanel.repaint(); // Update preview dynamically while dragging
            }
        });

        add(drawingPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ShapeDrawer();
    }
}
