package GUIComponents;

import javax.swing.JFormattedTextField;

/*
 * JTextField maintaining the number of array accesses
 */

public class ArrayAccessesJTextField extends JFormattedTextField{
    
	private int numOfArrayAccesses;
   
    public void incrementCount() { //increment the number of array accesses
        this.setText(""+numOfArrayAccesses++);
    }

    public void reset() {	//resets the number of array accesses to its default (zero)
        numOfArrayAccesses = 0;
    }
}