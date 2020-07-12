package GUI;

import javax.swing.JFormattedTextField;

public class ArrayAccessesJTextField extends JFormattedTextField{
    private int numOfArrayAccesses;

    public void updateCount() {
        this.setText(""+numOfArrayAccesses++);
        repaint();
    }

    public void reset() {
        numOfArrayAccesses = 0;
    }
}