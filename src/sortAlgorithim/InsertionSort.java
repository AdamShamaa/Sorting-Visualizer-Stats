package sortAlgorithim;

import GUI.sortingJPanel;

public class InsertionSort {
	
    public void sort(sortingJPanel sort) {	//sort entire array
        sort(sort, 0, sort.arrayLength());
    }
    
    public void sort(sortingJPanel sort, int low, int hi) {	//sort overload - sort a specific partition of the array
    	for(int i = low; i < hi; i++) {
            for(int j = i; j > low && sort.less(sort.getValue(j),sort.getValue(j-1)); j-- ) {
                sort.switchVal(j, j-1);
                //sort.resetArrayColor();
            }
        }
    }
}
