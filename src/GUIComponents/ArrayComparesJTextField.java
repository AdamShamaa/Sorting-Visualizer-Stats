package GUIComponents;

import javax.swing.JFormattedTextField;

//	JTextField maintaining the number of array compares
public class ArrayComparesJTextField extends JFormattedTextField {
	private int numOfCompares;

	//increment the number of array accesses
	public void incrementCount() {
		this.setText("" + numOfCompares++);
	}

	//resets the number of array compares to its default (zero)
	public void reset() {
		numOfCompares = 0;
	}
}