import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;

/*
<applet code="SimpleMessageApplet" width="400" height="300">
</applet>
*/

public class SimpleMessageApplet extends Applet {
    private String message = "Hello, welcome to the applet!";
    
    @Override
    public void paint(Graphics g) {
        // Set a custom font for the message
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        
        // Calculate the position to center the text
        int x = (getWidth() - g.getFontMetrics().stringWidth(message)) / 2;
        int y = getHeight() / 2;

        // Draw the message
        g.drawString(message, x, y);
    }
}
