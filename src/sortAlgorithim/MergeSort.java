package sortAlgorithim;

import GUI.sortingJPanel;

public class MergeSort {

    public void sort(sortingJPanel input) {
        int arrayLength = input.arrayLength();
        Comparable[] aux = new Comparable[arrayLength];
        mergesort(input,aux,0,arrayLength-1);
    }

    private void mergesort(sortingJPanel input, Comparable[] aux, int low, int hi) {
        if (low >= hi) return;
        int mid = low + (hi-low)/2;
        mergesort(input,aux,low,mid);
        mergesort(input,aux,mid+1,hi);
        merge(input,aux,low,mid,hi); 
    }

    private void merge(sortingJPanel input, Comparable[] aux, int low, int mid ,int hi) {
        int i = low;
        int j = mid + 1;
        for (int index = low; index <= hi; index++) {
            input.changeVal(aux, index, input.getValue(index)); 
        }
        for (int index = low; index <= hi; index++) {
            if (i > mid) input.changeVal(index, aux[j++]);
            else if (j > hi) input.changeVal(index, aux[i++]);
            else if (input.less(input.getValue(aux, i), input.getValue(aux, j))) input.changeVal(index, aux[i++]);
            else input.changeVal(index, aux[j++]);
        }
        input.resetArrayColor();
    }
}
