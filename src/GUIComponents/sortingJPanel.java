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
public class sortingJPanel extends JPanel{

    //DATA
	public ArrayComparesJTextField ArrayComparesJTextField;  	//compares * accesses counters, used to maintain the performance statistics
	public ArrayAccessesJTextField ArrayAccessesJTextField;    
	
    public MasterSortingFile sortingFiles = new MasterSortingFile();	//collection of sorting algorithim defined in the sortAlgorithim package used to initiate a sorting algorithim
    public Array array;						// Custom Array Class used for tracking modifications and reprinting to the JPanel
	private double delayMS;					// Delay in MS between each operation such as switchVal() or setVal()
    private int BARSIZE; 					// Width of each array entry graphic rectangle representation printed to the user

    public void initialize(int lengthOfArray, ArrayComparesJTextField ArrayComparesJTextField, ArrayAccessesJTextField ArrayAccessesJTextField) {
        this.ArrayComparesJTextField = ArrayComparesJTextField;
        this.ArrayAccessesJTextField = ArrayAccessesJTextField;
        setSize(lengthOfArray);
    }

    // Counters
    public void resetJTextFieldCounts() {	//reset each performance statistic to their default value - 0
        if (ArrayComparesJTextField != null && ArrayAccessesJTextField != null) {
        	ArrayComparesJTextField.reset();
        	ArrayAccessesJTextField.reset();
        }
    }

    // Setters
    public void setSize(int numOfValues) {
    	 if (numOfValues <= 0) throw new IllegalArgumentException("setSize() // size must be positive: " + numOfValues);
         BARSIZE = (int) Math.ceil(this.getWidth()/numOfValues);																//Recompute the width of the rectangle representation of an array entry - Computed by dividing the panel width by the number of array entries. 
         array = new Array(numOfValues, this.getHeight(), this.ArrayComparesJTextField, this.ArrayAccessesJTextField, this);	//Reinitialize the array representation with the new number of values
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
    
    //Time Delay
    public void sleep() { 	//perform a delay of duration set by the user by the speedSlider
        sleep(delayMS);
    }
    public void sleep(double delayMS ) { 	//perform a custom delay of duration delayMS (the defined duration set by the user is NOT used when verifying that the final array is sorted)
        long timeElapsed = 0;
        long startTime = System.currentTimeMillis();
        while (timeElapsed < delayMS) {
            timeElapsed = System.currentTimeMillis() - startTime;
        }
    }

    // Print array to panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int arrayLength = array.arrayLength();		//retrieve the size of the array
        for (int x = 0; x < arrayLength; x++) {		//iterates through each array entry and performs a print operation
        	int currentRGB[] = array.getRGB(x);		
        	g.setColor(new Color(currentRGB[0],currentRGB[1], currentRGB[2]));	//set the color of the currently printed array entry to its defined RGB value
        	
        	// g.fillrect() - Paints the xth array entry using a rectangle representation
        	// First argument defines the starting x position: Computed by multiplying the preceding number of entries by their widths. This ensures that overlapping does not occur.
        	// Second argument defines the starting y position. Note that Java has paints with an increasing y value downwards NOT upwards 
        	// Third argument defines the width, BARSIZE is pre-computed and is computed by dividing the total number of array entries by the total width of the jpanel
        	// Fourth argument defines the height, this is simply the value of the array entry.
        	g.fillRect((x)*(BARSIZE) + (this.getWidth()-(arrayLength*BARSIZE))/2, this.getHeight()-array.graphicComponentGetValue(x), BARSIZE, array.graphicComponentGetValue(x));	
        }
    }
}
