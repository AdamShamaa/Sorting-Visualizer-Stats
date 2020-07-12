package GUI;

import java.awt.Graphics;
import javax.swing.JFormattedTextField;

public class ComparesJTextField extends JFormattedTextField{
    private int numOfCompares;
    
    public void updateCount() {
        this.setText(""+numOfCompares++);
        repaint();
    }
    
    public void reset() {
        numOfCompares = 0;
    }
}
