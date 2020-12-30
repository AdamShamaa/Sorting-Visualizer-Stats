package GUIComponents;

import java.util.Arrays;
import java.util.Random;

public class Array {
	
	// DATA 
	private ArrayEntry[] primaryArray;		// Primary array used to perform all operations provided by the API.
	private ArrayEntry[] primaryArrayCOPY;	// DEEP copy of the primary array, not used in any operations. Only used to restart without re-shuffling.
	private int maxArrayEntryValue;			// Absolute maximum value that a array entry can be initialized to when randomized (essential to ensure when entries are drawn, that they fit within the JPanel).
	
	//Access to counters to increment data
	private ArrayComparesJTextField ArrayComparesJTextField;  //compares counter
    private ArrayAccessesJTextField ArrayAccessesJTextField;    //accesses counter
    
    //Access to JPanel to call repaint
    private sortingJPanel sortingJPanel;
	
	/** --------- ENTIRE Array Attributes --------- **/
	// CONSTRUCTOR
	public Array(int arrayLength, int maxValue, ArrayComparesJTextField ArrayComparesJTextField, ArrayAccessesJTextField ArrayAccessesJTextField, sortingJPanel sortingJPanel) {
		primaryArray = new ArrayEntry[arrayLength];					//initialize the new primary array
		primaryArrayCOPY = new ArrayEntry[arrayLength];				//initialize a copy of the primary array, used for restarts without re-shuffling
		this.ArrayComparesJTextField = ArrayComparesJTextField;		//store array compares & accesses text fields for local access to increment their respective attribute
		this.ArrayAccessesJTextField = ArrayAccessesJTextField;
		this.sortingJPanel = sortingJPanel;							//store the sortingJPanel locally for access to its graphic repaint() methods which is forcefully rerendered on each array modification

		shuffleArray(maxValue);										//initialize the primary array & perform a deep copy to the primaryArrayCOPY
		sortingJPanel.repaint();									//paint the shuffled array to the user
	}
	
	// GET ARRAY ATTRIBUTES
	public int arrayLength() { return primaryArray.length; }	// Get the current length of the array
	public int range() { return maxArrayEntryValue; }			// Get the range of possible array entry values between 0 to maxArrayEntryValue
	
	/** --------- ENTIRE Array Operations --------- **/
	public void shuffleArray(int maxValue) {
		Random random = new Random();
		for (int index = 0; index < arrayLength(); index++) {			// Initialize each ArrayEntry in the primaryArray to a random value in the range of 0 to maxValue
			primaryArray[index] = new ArrayEntry(random.nextInt(maxValue));
		}
		primaryArrayCOPY = Arrays.copyOf(primaryArray, arrayLength());	// Create a DEEP copy of the shuffled array
	}
	
	public void restartSameArray() {
		primaryArray = Arrays.copyOf(primaryArrayCOPY, primaryArrayCOPY.length);	// Reset the primary array to its original order WITHOUT re-shuffling
		deepArrayColorReset();
	}
	
	public void checkArrayIsSorted() {
		setRGB(0, 255, 0, 0);	// Set the first entry to green as the for loop will skip setting the color of the first entry
		for (int index = 1; index < primaryArray.length; index++) {
			if (primaryArray[index-1].getValue() > primaryArray[index].getValue()) throwUnsortedArrayAssertionError("checkArrayIsSorted()");	// Assertion Error -> Array is NOT sorted
			setRGB(0, 255, 0, index);																											// Set the entry at index to GREEN
			sortingJPanel.sleep(5);
		}
	}
	
	/** --------- Array Entries ATTRIBUTES  --------- **/
	//SET ARRAY ENTRY ATTRIBUTES
	/*  Cosmetic Attributes  */
	public void setRGB(int redValue, int greenValue, int blueValue, int... index) {
		for (int currentIndex : index) {
			checkBounds("setRGB()", currentIndex);													// Bound Checking - Throw an illegal argument exception and terminate the program if out of bounds
			primaryArray[currentIndex].setRGB(redValue, greenValue, blueValue);						// Update RGB values of the array entry at index
		}
	}
	
	public void setPermanentColor(int index, boolean isPermanentColor) {
		checkBounds("setPermanentColor()", index);													// Bound Checking - Throw an illegal argument exception and terminate the program if out of bounds
		primaryArray[index].setPermanentRGB(isPermanentColor);										// set the PermanentColor attribute of the entry at index to isPermanentColor
	}
	
	public void shallowArrayColorReset() {
		for (int index = 0; index < arrayLength(); index++) {
			if (!(primaryArray[index].isRGBPermanent())) primaryArray[index].setRGB(0, 0, 0);		// Reset all entries marked as non color permanent to their default color - rgb(0, 0, 0)
		}
	}
	
	public void deepArrayColorReset() {	
		for (int index = 0; index < arrayLength(); index++) {
			primaryArray[index].setPermanentRGB(false); 			// Reset all entries to the non permanent color marker
			primaryArray[index].setRGB(0, 0, 0);					// Reset all entries to their default color rgb(0, 0, 0) regardless of their permanent marker 
		}
	}
	
	//GET ARRAY ENTRY ATTRIBUTES
	/*  Cosmetic Attributes  */
	public int[] getRGB(int indexA) {
		checkBounds("getRGB()", indexA);						// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		return primaryArray[indexA].getRGB();					// Get a SHALLOW copy of the RGB color representation of the array entry at index
	}
	
	/** --------- INTERNAL Array Entries OPERATIONS  --------- **/
	//SET - ARRAY ENTRY OPERATIONS
	public void switchVal(int indexA, int indexB) {
		checkBounds("switchVal() - INTERNAL", indexA, indexB);																// Bound Checking - Throw an illegal argument exception and terminate the program if out of bounds
		ArrayEntry TEMP = primaryArray[indexA]; primaryArray[indexA] = primaryArray[indexB]; primaryArray[indexB] = TEMP; 	// Switch entry values at indexA and indexB
		setRGB(255, 0, 0, indexA, indexB);																					// Update colors of entries at indexA and indexB to RED
		ArrayAccessesJTextField.incrementCount();																			// Update Array Accesses Counter by 1
		sortingJPanel.sleep();																								// Initiate a delay in the sort algorithim by the current speed slider value
	}
	
	public void setVal(int indexA, int newValue) {
		checkBounds("setVal() - INTERNAL", indexA);	 				// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		primaryArray[indexA].setValue(newValue);					// Set the value of the entry at indexA to newValue
		setRGB(252, 136, 3, indexA);								// Update color of the entry at indexA to ORANGE
		ArrayAccessesJTextField.incrementCount();					// Update Array Accesses Counter by 1
		sortingJPanel.sleep();										// Initiate a delay in the sort algorithim by the current speed slider value
	}
	
	//GET - ARRAY ENTRY OPERATIONS
	public boolean less(int indexA, int indexB) {						
		checkBounds("less() - INTERNAL", indexA, indexB);			// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		ArrayComparesJTextField.incrementCount();					// Increment Array Compares Counter by 1
		return compareTo(getVal(indexA), getVal(indexB)) < 0;		// Return true if the entry at indexA is strictly less then the entry at indexB
	}
	
	public int getVal(int indexA) {
		checkBounds("getVal() - INTERAL", indexA);					// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		ArrayAccessesJTextField.incrementCount();					// Update Array Accesses Counter by 1
		return primaryArray[indexA].getValue();						// Get the value of the entry at indexA
	}
	
	/** --------- EXTERNAL Array Entries OPERATIONS  --------- **/
	//SET ARRAY ENTRY OPERATIONS
	public void switchVal(int array[], int indexA, int indexB) {
		checkBounds("switchVal() - EXTERNAL", array, indexA, indexB);					// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		int TEMP = array[indexA]; array[indexA] = array[indexB]; array[indexB] = TEMP;	// Switch entry values at indexA and indexB
		ArrayAccessesJTextField.incrementCount();										// Update Array Accesses Counter by 1

	}
	
	public void setVal(int array[], int indexA, int newValue) {
		checkBounds("setVal() - EXTERNAL", array, indexA);	 			// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		array[indexA] = newValue;										// Set the value of the array entry at indexA to newValue
		ArrayAccessesJTextField.incrementCount();						// Update Array Accesses Counter by 1
	}
	
	//GET - ARRAY ENTRY OPERATIONS
	public boolean less(int array[], int indexA, int indexB) {						
		checkBounds("less() - EXTERNAL", array, indexA, indexB);			// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		ArrayComparesJTextField.incrementCount();							// Increment Array Compares Counter by 1
		return compareTo(getVal(array, indexA), getVal(array, indexB)) < 0;	// Return true if the entry at indexA is strictly less then the entry at indexB
	}
	
	public int getVal(int array[], int indexA) {
		checkBounds("getVal() - INTERAL", arrayLength(), indexA);		// Bound Checking - Throw an illegal argument exception and terminate the program if the is out of bounds
		ArrayAccessesJTextField.incrementCount();						// Update Array Accesses Counter by 1
		return array[indexA];											// Get the value of the entry at indexA
	}

	/** --------- NON-Array Entries OPERATIONS  --------- **/
	//GET - NON-Array ENTRY OPERATIONS
	public int compareTo(int valA, int valB) {
		ArrayComparesJTextField.incrementCount();						// Update Array Compares Counter by 1
		return Integer.compare(valA, valB);
	}
	
	/** --------- ERROR HANDLING & DELAYS --------- **/
	private void checkBounds(String functionName, int... index) { // Ensure the array index is within the INTERNAL array bounds. Example of output: "setRGB() // INDEX OUT OF BOUNDS: -1"
		sortingJPanel.repaint();
		for (int arrayIndex : index) if (arrayIndex < 0 || arrayIndex > arrayLength()) throw new IllegalArgumentException(functionName + " // INDEX OUT OF BOUNDS: " + arrayIndex);	
	}
	
	private void checkBounds(String functionName, int[] array, int... index) { // Ensure the array index is within the EXTERNAL array bounds. Example of output: "setRGB() // INDEX OUT OF BOUNDS: -1"
		for (int arrayIndex : index) if (arrayIndex < 0 || arrayIndex >= array.length) throw new IllegalArgumentException(functionName + " // INDEX OUT OF BOUNDS: " + arrayIndex);	
	}
	
	private void throwUnsortedArrayAssertionError(String functionName) {	// Throw an assertion error indicating that the array is not sorted. I.e. this function is called when an array is re-verified to be sorted.
		throw new AssertionError(functionName + " // ARRAY UNSORTED: Check Sorting Algorithim");
	}
	
	/** --------- HELPER METHODS FOR GRAPHIC COMPONENT - NOT FOR USE IN API --------- **/
	public int graphicComponentGetValue(int indexA) {
		return primaryArray[indexA].getValue();
	}
}

