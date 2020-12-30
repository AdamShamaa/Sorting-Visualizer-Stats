package sortAlgorithim;

import GUIComponents.Array;

public class SelectionSort extends SortingAlgorithim {
    public void sort(Array array) {
        int arrayLength = array.arrayLength();
        for (int i = 0; i < arrayLength; i++) {
            int indexMin = i;
            for (int j = i+1; j < arrayLength; j++) {
            	if(array.less(j, indexMin)) indexMin = j;
            }
            array.switchVal(i, indexMin);
            array.setRGB(99, 255, 0, i);
            array.setPermanentColor(i, true);
            array.shallowArrayColorReset();
        }   
    }
}
