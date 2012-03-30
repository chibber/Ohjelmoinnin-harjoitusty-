package kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PeliLauta extends JPanel {

    public PeliLauta() {
        setBackground(Color.GRAY);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.YELLOW);
        g.fillRect(200, 200, 100, 100);

    }

}
