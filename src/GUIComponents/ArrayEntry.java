package GUIComponents;

public class ArrayEntry {
	private int entryValue;			// value of the array entry
	private int rgbValue[];			// color representation of the array entry: RED = rgbValue[0], GREEN = rgbValue[1], BLUE = rgbValue[2].
	private boolean isRGBPermanent;	// determines whether the RGB values should be reset to their default value on shallow array resets (used by the array class).
	
	public ArrayEntry(int entryValue) {	//constructor
		this.entryValue = entryValue;
		this.rgbValue = new int[3];
		isRGBPermanent = false;
	}
	
	//SET ArrayEntry attributes
	public void setValue(int newEntryValue) {  	//set the value of entryValue to newEntryValue
		entryValue = newEntryValue; 
	}
	public void setRGB(int redValue, int greenValue, int blueValue) {	//set the red, green and blue color representation to rgb(redValue, greenValue, blueValue)
		rgbValue[0] = redValue; rgbValue[1] = greenValue; rgbValue[2] = blueValue;
	}
	public void setPermanentRGB(boolean newIsRGBPermanent) { 	//set the permanent color attribute to newIsRGBPermanent
		isRGBPermanent = newIsRGBPermanent;
	}
	
	//GET ArrayEntry attributes
	public int getValue() { return entryValue; }				//get the current value of the array entry
	public int[] getRGB() { return rgbValue; }					//get a SHALLOW representation of the current RGB values
	public boolean isRGBPermanent() { return isRGBPermanent; }	//is the RGB value permanent?
}
