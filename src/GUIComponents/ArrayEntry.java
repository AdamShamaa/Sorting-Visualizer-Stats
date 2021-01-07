package GUIComponents;

public class ArrayEntry {
	// value of the array entry
	private int entryValue;

	// color representation of the array entry: RED = rgbValue[0], GREEN = rgbValue[1], BLUE = rgbValue[2].
	private int rgbValue[];

	// determines whether the RGB values should be reset to their default value on shallow array resets (used by the array class).
	private boolean isRGBPermanent;

	//constructor
	public ArrayEntry(int entryValue) {
		this.entryValue = entryValue;
		this.rgbValue = new int[3];
		isRGBPermanent = false;
	}

	/* SET ArrayEntry attributes */
	//set the value of entryValue to newEntryValue
	public void setValue(int newEntryValue) {
		entryValue = newEntryValue;
	}

	//set the red, green and blue color representation to rgb(redValue, greenValue, blueValue)
	public void setRGB(int redValue, int greenValue, int blueValue) {
		rgbValue[0] = redValue;
		rgbValue[1] = greenValue;
		rgbValue[2] = blueValue;
	}

	//set the permanent color attribute to newIsRGBPermanent
	public void setPermanentRGB(boolean newIsRGBPermanent) {
		isRGBPermanent = newIsRGBPermanent;
	}

	/* GET ArrayEntry attributes */
	//get the current value of the array entry
	public int getValue() {
		return entryValue;
	}

	//get a SHALLOW representation of the current RGB values
	public int[] getRGB() {
		return rgbValue;
	}

	//is the RGB value permanent?
	public boolean isRGBPermanent() {
		return isRGBPermanent;
	}
}