package sortAlgorithim;

import GUI.sortingJPanel;

public class ShellSort {
    public void sort(sortingJPanel sort) {     
        int gap = 1;
        int length = sort.arrayLength();
        while (gap < length/3) gap = gap*3 + 1;
        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && sort.less(sort.getValue(j),sort.getValue(j-gap)); j-=gap) {
                    sort.switchVal(j, j-gap);
                    sort.resetArrayColor();
                }
            }
            gap /= 3; 
        }  
    }
}
