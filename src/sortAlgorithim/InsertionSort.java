package sortAlgorithim;

import GUIComponents.Array;

public class InsertionSort extends SortingAlgorithim {
	
    public void sort(Array array) {	//sort entire array
        sort(array, 0, array.arrayLength());
    }
    
    public void sort(Array array, int low, int hi) {	//sort overload - sort a specific partition of the array
    	for(int i = low; i < hi; i++) {
            for(int j = i; j > low && array.less(j, j-1); j-- ) {
            	array.switchVal(j, j-1);
            	array.shallowArrayColorReset();
            }
        }
    }
}
