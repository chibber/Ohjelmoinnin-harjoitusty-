package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Ikkuna extends JFrame {

    public Ikkuna() {
        setSize(370,500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container sisalto = getContentPane();
        sisalto.add(new PeliLauta(), BorderLayout.CENTER);
        sisalto.add(new JButton("OK"), BorderLayout.SOUTH); 
        setVisible(true);
    }

}
