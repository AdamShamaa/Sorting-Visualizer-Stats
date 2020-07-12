package sortAlgorithim;

import GUI.sortingJPanel;

public class SelectionSort {
    public void sort(sortingJPanel sort) {
        int arrayLength = sort.arrayLength();
        for (int i = 0; i < arrayLength; i++) {
            int indexMin = i;
            for (int j = i+1; j < arrayLength; j++) {
               if(sort.less(sort.getValue(j),sort.getValue(indexMin))) indexMin = j;
            }
            sort.switchVal(i, indexMin);
            sort.setColor(i, 99, 255);
            sort.setPermanentColor(i, true);
            sort.resetArrayColor();
        }   
    }
}
