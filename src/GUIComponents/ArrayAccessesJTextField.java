package GUIComponents;

import javax.swing.JFormattedTextField;

// JTextField maintaining the number of array accesses
public class ArrayAccessesJTextField extends JFormattedTextField {
	private int numOfArrayAccesses;

	//increment the number of array accesses
	public void incrementCount() {
		this.setText("" + numOfArrayAccesses++);
	}

	//resets the number of array accesses to its default (zero)
	public void reset() {
		numOfArrayAccesses = 0;
	}
}