package GUIComponents;

import java.awt.Color;
import java.awt.Graphics;

import sortAlgorithim.MasterSortingFile;
import sortAlgorithim.SortingAlgorithim;

import javax.swing.JPanel;
/**
 * 
 * @author AdamShamaa
 *
 */
public class sortingJPanel extends JPanel {

	/* DATA */
	//compares & accesses counters used to maintain the performance statistics
	public ArrayComparesJTextField ArrayComparesJTextField;
	public ArrayAccessesJTextField ArrayAccessesJTextField;

	//collection of sorting algorithim defined in the sortAlgorithim package used to initiate a sorting algorithim
	public MasterSortingFile sortingFiles = new MasterSortingFile();

	// Custom Array Class used for tracking modifications and reprinting to the JPanel
	public Array array;

	// Delay in MS between each operation such as switchVal() or setVal()
	private double delayMS;

	// Width of each array entry graphic rectangle representation printed to the user
	private int BARSIZE;

	public void initialize(int lengthOfArray, ArrayComparesJTextField ArrayComparesJTextField, ArrayAccessesJTextField ArrayAccessesJTextField) {
		this.ArrayComparesJTextField = ArrayComparesJTextField;
		this.ArrayAccessesJTextField = ArrayAccessesJTextField;
		setSize(lengthOfArray);
	}

	//reset each performance statistic to their default value - 0
	public void resetJTextFieldCounts() {
		if (ArrayComparesJTextField != null && ArrayAccessesJTextField != null) {
			ArrayComparesJTextField.reset();
			ArrayAccessesJTextField.reset();
		}
	}

	// Setters
	//Recompute the width of the rectangle representation of an array entry - Computed by dividing the panel width by the number of array entries. 
	public void setSize(int numOfValues) {
		if (numOfValues<= 0) throw new IllegalArgumentException("setSize() // size must be positive: " + numOfValues);
		BARSIZE = (int) Math.ceil(this.getWidth() / numOfValues);

		//Reinitialize the array representation with the new number of values
		array = new Array(numOfValues, this.getHeight(), this.ArrayComparesJTextField, this.ArrayAccessesJTextField, this);
	}

	public void setSpeed(double speed) {
		delayMS = speed;
	}

	// Start Sort
	public void startSort(String algorithimName) {
		SortingAlgorithim sortAlgorithim = sortingFiles.getSortingAlgorithim(algorithimName);
		sortAlgorithim.sort(array);
		array.checkArrayIsSorted();
	}

	/* Time Delay */
	//perform a delay of duration set by the user by the speedSlider
	public void sleep() {
		sleep(delayMS);
	}
	//perform a custom delay of duration delayMS (the defined duration set by the user is NOT used when verifying that the final array is sorted)
	public void sleep(double delayMS) {
		long timeElapsed = 0;
		long startTime = System.currentTimeMillis();
		while (timeElapsed<delayMS) {
			timeElapsed = System.currentTimeMillis() - startTime;
		}
	}

	// Print array to panel
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//retrieve the size of the array
		int arrayLength = array.arrayLength();

		//iterates through each array entry and performs a print operation
		for (int x = 0; x<arrayLength; x++) {
			int currentRGB[] = array.getRGB(x);
			g.setColor(new Color(currentRGB[0], currentRGB[1], currentRGB[2])); //set the color of the currently printed array entry to its defined RGB value

			// g.fillrect() - Paints the xth array entry using a rectangle representation
			// First argument defines the starting x position: Computed by multiplying the preceding number of entries by their widths. This ensures that overlapping does not occur.
			// Second argument defines the starting y position. Note that Java has paints with an increasing y value downwards NOT upwards 
			// Third argument defines the width, BARSIZE is pre-computed and is computed by dividing the total number of array entries by the total width of the jpanel
			// Fourth argument defines the height, this is simply the value of the array entry.
			g.fillRect((x) * (BARSIZE) + (this.getWidth() - (arrayLength * BARSIZE)) / 2, this.getHeight() - array.graphicComponentGetValue(x), BARSIZE, array.graphicComponentGetValue(x));
		}
	}
}