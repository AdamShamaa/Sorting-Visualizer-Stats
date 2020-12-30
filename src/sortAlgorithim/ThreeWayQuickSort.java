package sortAlgorithim;

import java.util.Random;
import GUIComponents.Array;

public class ThreeWayQuickSort extends SortingAlgorithim {
	
	Random random;
	
	public void sort(Array array) {
		random = new Random();
		ThreeWayQuickSort(array, 0, array.arrayLength()-1);
	}
	
	private void ThreeWayQuickSort(Array array, int low, int hi) {
		if (hi <= low) return;

		int leftPointer = low; int rightPointer = hi;	//initialize pointers
		int index = low+1;
		
		int randomKey = random.nextInt(hi-low) + low;		//pick a random key to use as index (Note- performance will not vary widely in this scenario if a random key is not selected  as input is known to be already be random)
		array.switchVal(low, randomKey);					//place random key at beginning of partition
        array.setRGB(255, 139, 0, low);
		
		int key = array.getVal(low);
		
		while (index <= rightPointer) {
			int currentKey = array.getVal(index);
			if (array.compareTo(key, currentKey) > 0) array.switchVal(leftPointer++, index++);		//current key is less than selected key, put selected key in front of current key
			else if (array.compareTo(key, currentKey) < 0) array.switchVal(rightPointer--, index);	//current key is greater than selected key, put current key in front of selected key
			else index++;																			//current key is equal to selected key, leave current key in place
			array.shallowArrayColorReset();
		}
				
		ThreeWayQuickSort(array, low, leftPointer-1);	//sort keys less than selected key
		//ThreeWayQuickSort(sort, leftPointer, rightPointer);	//sort keys equal to selected key (use for string character keys)
		ThreeWayQuickSort(array, rightPointer+1, hi);	//sort keys equal to selected key
		
	}
}