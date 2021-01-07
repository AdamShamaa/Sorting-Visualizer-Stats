package GUIComponents;

import java.util.Arrays;
import java.util.Random;

public class Array {
	/* DATA */
	// Primary array used to perform all operations provided by the API.
	private ArrayEntry[] primaryArray;

	// DEEP copy of the primary array, not used in any operations. Only used to restart without re-shuffling.
	private ArrayEntry[] primaryArrayCOPY;

	// Absolute maximum value that a array entry can be initialized to when randomized (essential to ensure when entries are drawn, that they fit within the JPanel).
	private int maxArrayEntryValue;

	//Access to counters to increment data
	//array compares counter
	private ArrayComparesJTextField ArrayComparesJTextField;
	//array accesses counter
	private ArrayAccessesJTextField ArrayAccessesJTextField;

	//Access to JPanel to call repaint
	private sortingJPanel sortingJPanel;

	/** --------- ENTIRE Array Attributes --------- **/
	// CONSTRUCTOR
	public Array(int arrayLength, int maxValue, ArrayComparesJTextField ArrayComparesJTextField, ArrayAccessesJTextField ArrayAccessesJTextField, sortingJPanel sortingJPanel) {
		//initialize the new primary array
		primaryArray = new ArrayEntry[arrayLength];
		//initialize a copy of the primary array, used for restarts without re-shuffling
		primaryArrayCOPY = new ArrayEntry[arrayLength];
		//store array compares & accesses text fields for local access to increment their respective attribute
		this.ArrayComparesJTextField = ArrayComparesJTextField;
		this.ArrayAccessesJTextField = ArrayAccessesJTextField;
		//store the sortingJPanel locally for access to its graphic repaint() methods which is forcefully re-rendered on each array modification
		this.sortingJPanel = sortingJPanel;

		//initialize the primary array & perform a deep copy to the primaryArrayCOPY
		shuffleArray(maxValue);
		//paint the shuffled array to the user
		sortingJPanel.repaint();
	}

	// GET ARRAY ATTRIBUTES
	// Get the current length of the array
	public int arrayLength() {
		return primaryArray.length;
	}
	// Get the range of possible array entry values between 0 to maxArrayEntryValue
	public int range() {
		return maxArrayEntryValue;
	}

	/** --------- ENTIRE Array Operations --------- **/
	public void shuffleArray(int maxValue) {
		Random random = new Random();

		// Initialize each ArrayEntry in the primaryArray to a random value in the range of 0 to maxValue
		for (int index = 0; index<arrayLength(); index++) {
			primaryArray[index] = new ArrayEntry(random.nextInt(maxValue));
		}

		// Create a DEEP copy of the shuffled array
		primaryArrayCOPY = Arrays.copyOf(primaryArray, arrayLength());
	}

	// Reset the primary array to its original order WITHOUT re-shuffling
	public void restartSameArray() {
		primaryArray = Arrays.copyOf(primaryArrayCOPY, primaryArrayCOPY.length);
		deepArrayColorReset();
	}

	// Set the first entry to green as the for loop will skip setting the color of the first entry
	public void checkArrayIsSorted() {
		setRGB(0, 255, 0, 0);
		for (int index = 1; index<primaryArray.length; index++) {
			if (primaryArray[index - 1].getValue() > primaryArray[index].getValue()) throwUnsortedArrayAssertionError("checkArrayIsSorted()"); // Assertion Error -> Array is NOT sorted
			setRGB(0, 255, 0, index); // Set the entry at index to GREEN
			sortingJPanel.sleep(5);
		}
	}

	/** --------- Array Entries ATTRIBUTES  --------- **/
	//SET ARRAY ENTRY ATTRIBUTES
	/*  Cosmetic Attributes  */
	public void setRGB(int redValue, int greenValue, int blueValue, int...index) {
		for (int currentIndex: index) {
			checkBounds("setRGB()", currentIndex);
			// Update RGB values of the array entry at index
			primaryArray[currentIndex].setRGB(redValue, greenValue, blueValue);
		}
	}

	public void setPermanentColor(int index, boolean isPermanentColor) {
		checkBounds("setPermanentColor()", index);
		// set the PermanentColor attribute of the entry at index to isPermanentColor
		primaryArray[index].setPermanentRGB(isPermanentColor);
	}

	public void shallowArrayColorReset() {
		for (int index = 0; index<arrayLength(); index++) {
			// Reset all entries marked as non color permanent to their default color - rgb(0, 0, 0)
			if (!(primaryArray[index].isRGBPermanent())) primaryArray[index].setRGB(0, 0, 0);
		}
	}

	public void deepArrayColorReset() {
		for (int index = 0; index<arrayLength(); index++) {
			// Reset all entries to the non permanent color marker
			primaryArray[index].setPermanentRGB(false);
			// Reset all entries to their default color rgb(0, 0, 0) regardless of their permanent marker 
			primaryArray[index].setRGB(0, 0, 0);
		}
	}

	//GET ARRAY ENTRY ATTRIBUTES
	/*  Cosmetic Attributes  */

	// Get a SHALLOW copy of the RGB color representation of the array entry at index
	public int[] getRGB(int indexA) {
		checkBounds("getRGB()", indexA);
		return primaryArray[indexA].getRGB();
	}

	/** --------- INTERNAL Array Entries OPERATIONS  --------- **/
	//SET - ARRAY ENTRY OPERATIONS
	public void switchVal(int indexA, int indexB) {
		checkBounds("switchVal() - INTERNAL", indexA, indexB);
		// Switch entry values at indexA and indexB
		ArrayEntry TEMP = primaryArray[indexA];
		primaryArray[indexA] = primaryArray[indexB];
		primaryArray[indexB] = TEMP;
		// Update colors of entries at indexA and indexB to RED
		setRGB(255, 0, 0, indexA, indexB);
		ArrayAccessesJTextField.incrementCount();
		// Initiate a delay in the sort algorithim by the current speed slider value
		sortingJPanel.sleep();
	}

	public void setVal(int indexA, int newValue) {
		checkBounds("setVal() - INTERNAL", indexA);
		primaryArray[indexA].setValue(newValue);
		// Update color of the entry at indexA to ORANGE
		setRGB(252, 136, 3, indexA);
		ArrayAccessesJTextField.incrementCount();
		// Initiate a delay in the sort algorithim by the current speed slider value
		sortingJPanel.sleep();
	}

	//GET - ARRAY ENTRY OPERATIONS

	// Return true if the entry at indexA is strictly less then the entry at indexB
	public boolean less(int indexA, int indexB) {
		checkBounds("less() - INTERNAL", indexA, indexB);
		ArrayComparesJTextField.incrementCount();
		return compareTo(getVal(indexA), getVal(indexB))<0;
	}

	// Get the value of the entry at indexA
	public int getVal(int indexA) {
		checkBounds("getVal() - INTERAL", indexA);
		ArrayAccessesJTextField.incrementCount();
		return primaryArray[indexA].getValue();
	}

	/** --------- EXTERNAL Array Entries OPERATIONS  --------- **/
	//SET ARRAY ENTRY OPERATIONS
	public void switchVal(int array[], int indexA, int indexB) {
		checkBounds("switchVal() - EXTERNAL", array, indexA, indexB);
		// Switch entry values at indexA and indexB
		int TEMP = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = TEMP;
		ArrayAccessesJTextField.incrementCount();
	}

	public void setVal(int array[], int indexA, int newValue) {
		checkBounds("setVal() - EXTERNAL", array, indexA);
		array[indexA] = newValue;
		ArrayAccessesJTextField.incrementCount();
	}

	//GET - ARRAY ENTRY OPERATIONS
	// Return true if the entry at indexA is strictly less then the entry at indexB
	public boolean less(int array[], int indexA, int indexB) {
		checkBounds("less() - EXTERNAL", array, indexA, indexB);
		ArrayComparesJTextField.incrementCount();
		return compareTo(getVal(array, indexA), getVal(array, indexB))<0;
	}

	// Get the value of the entry at indexA
	public int getVal(int array[], int indexA) {
		checkBounds("getVal() - INTERAL", arrayLength(), indexA);
		ArrayAccessesJTextField.incrementCount();
		return array[indexA];
	}

	/** --------- NON-Array Entries OPERATIONS  --------- **/
	//GET - NON-Array ENTRY OPERATIONS
	public int compareTo(int valA, int valB) {
		ArrayComparesJTextField.incrementCount();
		return Integer.compare(valA, valB);
	}

	/** --------- ERROR HANDLING & DELAYS --------- **/
	// Ensure the array index is within the INTERNAL array bounds. Example of output: "setRGB() // INDEX OUT OF BOUNDS: -1"
	private void checkBounds(String functionName, int...index) {
		sortingJPanel.repaint(); // IMPORTANT: Each function which modifies the array will call this function, hence instead of calling the repaint method in each function called here instead
		for (int arrayIndex: index)
			if (arrayIndex<0 || arrayIndex > arrayLength()) throw new IllegalArgumentException(functionName + " // INDEX OUT OF BOUNDS: " + arrayIndex);
	}

	// Ensure the array index is within the EXTERNAL array bounds. Example of output: "setRGB() // INDEX OUT OF BOUNDS: -1"
	private void checkBounds(String functionName, int[] array, int...index) {
		for (int arrayIndex: index)
			if (arrayIndex<0 || arrayIndex >= array.length) throw new IllegalArgumentException(functionName + " // INDEX OUT OF BOUNDS: " + arrayIndex);
	}

	// Throw an assertion error indicating that the array is not sorted. I.e. this function is called when an array is re-verified to be sorted.
	private void throwUnsortedArrayAssertionError(String functionName) {
		throw new AssertionError(functionName + " // ARRAY UNSORTED: Check Sorting Algorithim");
	}

	/** --------- HELPER METHODS FOR GRAPHIC COMPONENT - NOT FOR USE IN API --------- **/
	public int graphicComponentGetValue(int indexA) {
		return primaryArray[indexA].getValue();
	}
}