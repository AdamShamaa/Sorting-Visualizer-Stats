package sortAlgorithim;

import GUI.sortingJPanel;

public class InsertionSort {
    public void sort(sortingJPanel sort) {
        int arrayLength = sort.arrayLength();
        for(int i = 0; i < arrayLength; i++) {
            for(int j = i; j > 0 && sort.less(sort.getValue(j),sort.getValue(j-1)); j-- ) {
                sort.switchVal(j, j-1);
                sort.resetArrayColor();
            }
        }
    }
}
