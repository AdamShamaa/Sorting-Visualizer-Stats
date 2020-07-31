package sortAlgorithim;

import java.util.Random;

import GUI.sortingJPanel;

public class ThreeWayQuickSort {
	
	Random rand;
	
	public void sort(sortingJPanel sort) {
		rand = new Random();
		ThreeWayQuickSort(sort, 0, sort.arrayLength()-1);
	}
	
	private void ThreeWayQuickSort(sortingJPanel sort, int low, int hi) {
		if (hi <= low) return;
		
		int leftPointer = low; int rightPointer = hi;	//initialize pointers
		int index = low+1;
		
		int randomKey = rand.nextInt(hi-low) + low;		//pick a random key to use as index (Note- performance will not vary widely in this scenario if a random key is not selected  as input is known to be already be random)
		sort.switchVal(low, randomKey);					//place random key at beginning of partition
		
		Comparable key = sort.getValue(low);
		while (index <= rightPointer) {
			Comparable currentKey = sort.getValue(index);
			
			if (sort.compareTo(key, currentKey) > 0) sort.switchVal(leftPointer++, index++);		//current key is less than selected key, put selected key in front of current key
			else if (sort.compareTo(key, currentKey) < 0) sort.switchVal(rightPointer--, index);	//current key is greater than selected key, put current key in front of selected key
			else index++;																			//current key is equal to selected key, leave current key in place
		}
		
		ThreeWayQuickSort(sort, low, leftPointer-1);	//sort keys less than selected key
		//ThreeWayQuickSort(sort, leftPointer, rightPointer);	//sort keys equal to selected key (use for string character keys)
		ThreeWayQuickSort(sort, rightPointer+1, hi);	//sort keys equal to selected key
		
	}
}