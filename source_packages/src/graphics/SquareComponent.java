package graphics;

import javax.swing.*;
import java.awt.*;

public class SquareComponent extends JComponent {
    private Color colour;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.colour);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public SquareComponent(int size, Color colour) {
        this.setPreferredSize(new Dimension(size, size));
        this.colour = colour;
    }
}
