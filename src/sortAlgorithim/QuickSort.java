package sortAlgorithim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import GUI.sortingJPanel;

public class QuickSort {
    
    public void sort(sortingJPanel input) {
        int arrayLength = input.arrayLength();
        quickSort(input, 0, arrayLength);
    }
    
    public int choosePivotNaive(sortingJPanel a, int l, int r) {
        return r;
    }

    public int choosePivotOverkill(int[] a, int l, int r) {
        int[] copy = Arrays.copyOfRange(a, l, r);
        Arrays.sort(copy);
        return (int) ((Math.floor((r-l)/2)) + l);
    }

    public int choosePivotRandom(int[] a, int l, int r) {
        Random random = new Random();
        int rand =  l + random.nextInt(r - l + 1);
        return rand;
    }

    public int chooseBestThree(sortingJPanel panel, int l, int r) {
        Comparable first =  panel.getValue(l);
        Comparable middle = panel.getValue(((r-l)/2 + l));
        Comparable last = panel.getValue(r);
        
        if (first.compareTo(middle) != first.compareTo(last)) {
            panel.incrementComparesCount(2);
            return l;
        } else if (middle.compareTo(first) != middle.compareTo(last)) {
            panel.incrementComparesCount(4);
            return (r-l)/2 + l;
        }else return r;
    }

    public void quickSort(sortingJPanel a, int l, int r) {
        if (l >= r) return;
        a.switchVal(l, chooseBestThree(a,l,r));
        
        int p = partition(a,l, r);
        
        quickSort(a,l,p-1);
        quickSort(a,p+1,r);
    }

    public int partition(sortingJPanel a, int l, int r) {
        Comparable key = a.getValue(l);
        int i = l+1;    
        for (int j = l + 1; j <= r; j++) {
            a.setColor(l, 255, 139);
            if (a.less(a.getValue(j),key)) {
                a.switchVal(i++ ,j); 
            }
            a.resetArrayColor();
        }
        a.switchVal(i-1,l);
        a.setColor(i-1, 99, 255);
        a.setPermanentColor(i-1, true);
        return i-1;
    }
}



