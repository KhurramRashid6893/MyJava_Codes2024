import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventsDemo extends JFrame {

    private JLabel label;

    public KeyEventsDemo() {
        setTitle("Key Events Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Type something...");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        add(label);

        // Add key listener using KeyAdapter
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                label.setText("Key typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("Key released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new KeyEventsDemo();
    }
}
