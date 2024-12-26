import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventsDemo extends JFrame implements MouseListener {

    private JLabel label;

    public MouseEventsDemo() {
        setTitle("Mouse Events Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Interact with the window using the mouse.");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label);

        // Add mouse listener to the frame
        addMouseListener(this);

        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse clicked at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setText("Mouse pressed at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setText("Mouse released at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("Mouse entered the window.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setText("Mouse exited the window.");
    }

    public static void main(String[] args) {
        new MouseEventsDemo();
    }
}
