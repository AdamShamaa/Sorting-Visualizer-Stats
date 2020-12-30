package GUIComponents;

import javax.swing.JFormattedTextField;

/*
 * JTextField maintaining the number of array compares
 */

public class ArrayComparesJTextField extends JFormattedTextField{
    
	private int numOfCompares;
    
    public void updateCount() { //increment the number of array accesses
        this.setText(""+numOfCompares++);
    }
    
    public void reset() { //resets the number of array compares to its default (zero)
        numOfCompares = 0;
    }
}
