package GUIComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;

import sortAlgorithim.InsertionSort;
import sortAlgorithim.KeyIndexedCounting;
import sortAlgorithim.MergeSort;
import sortAlgorithim.QuickSort;
import sortAlgorithim.SelectionSort;
import sortAlgorithim.ShellSort;
import sortAlgorithim.ThreeWayQuickSort;
import sortAlgorithim.MergeInsertionSort;

/**
 * 
 * @author AdamShamaa
 *
 */
public class sortingJPanel extends JPanel{
    Random rand =  new Random();

    private int numOfValues; //array size i.e. number of elements to sort

    //graph attributes
    private int horizontalSize;
    private int verticalSize;
    private int BARSIZE; 
    private Integer[] a;    
    private Integer[] copy; //copy of unsorted array - used to restart without re-shuffling 

    private ArrayComparesJTextField ArrayComparesJTextField;  //compares counter
    private ArrayAccessesJTextField ArrayAccessesJTextField;    //accesses counter

    private double speed;   //speed of sort

    private int[][] colorIndexRG;   //color values of each element in array
    private boolean[] permanentColor;   //used for algorithms which correctly place elements after each iteration  ex. quick-sort & selection-sort

    public void initialize(int horizontalSize, int verticalSize, int numOfValues,ArrayComparesJTextField ArrayComparesJTextField, ArrayAccessesJTextField ArrayAccessesJField) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.ArrayComparesJTextField = ArrayComparesJTextField;
        this.ArrayAccessesJTextField = ArrayAccessesJField;
        setSize(numOfValues);
    }

    public int arrayLength() {
        return a.length;
    }
    
    public int range() {	//range of possible array values
    	return verticalSize;
    }

    //Counters
    public void incrementComparesCount() {
    	ArrayComparesJTextField.updateCount();
    }

    public void incrementArrayAccessesCount() {
    	ArrayAccessesJTextField.updateCount();
    }

    public void incrementComparesCount(int i) {
        for (int x = 0; x < i; x++) {
            incrementComparesCount();
        }
    }

    public void incrementArrayAccessesCount(int i) {
        for (int x = 0; x < i; x++) {
            incrementArrayAccessesCount();
        }
    }

    public void resetCounts() {
        if (ArrayComparesJTextField != null && ArrayAccessesJTextField != null) {
        	ArrayComparesJTextField.reset();
        	ArrayAccessesJTextField.reset();
        }
    }

    //Sorting
    public void runMergeSort(sortingJPanel input) {
        new MergeSort().sort(input);
        sortFinished();
    }

    public void runInsertionSort(sortingJPanel input) {
        new InsertionSort().sort(input);
        sortFinished();
    }

    public void runSelectionSort(sortingJPanel input) {
        new SelectionSort().sort(input);
        sortFinished();
    }

    public void runQuickSort(sortingJPanel input) {
        new QuickSort().sort(input);
        sortFinished();
    }

    public void runShellSort(sortingJPanel input) {
        new ShellSort().sort(input);
        sortFinished();
    }
    
    public void runOptimizedMergeInsertionSort(sortingJPanel input) {
        new MergeInsertionSort().sort(input);
        sortFinished();
    }
    
    public void runKeyIndexedSort(sortingJPanel input) {
        new KeyIndexedCounting().sort(input);
        sortFinished();
    }
    
    public void runThreeWayQuickSort(sortingJPanel input) {
        new ThreeWayQuickSort().sort(input);
        sortFinished();
    }

    private void sortFinished() {   
        deepResetArrayColor();
        checkArray(a,1);
    }

    private void checkArray(Comparable[] array, int index) {    //verify array is sorted
        if (index >= array.length || array[index-1].compareTo(array[index]) > 0) {
            return;
        }
        setColor(index-1,99,255);
        setColor(index,99,255);
        repaint();
        sleep(1.5);
        checkArray(array,index+1);
    }

    //setters
    public void setSize(int numOfValues) {
        if (numOfValues > 0) {
            this.numOfValues = numOfValues;
            a = new Integer[numOfValues];
            colorIndexRG = new int[numOfValues][2];
            permanentColor = new boolean[numOfValues];
            BARSIZE = (int) Math.ceil(horizontalSize/numOfValues);
            for (int x = 0; x < numOfValues; x++) {
                a[x] = rand.nextInt(verticalSize);
            } 
            copy = Arrays.copyOf(a, a.length);
        }
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setColor(int index, int valX, int valY) {
        colorIndexRG[index][0] = valX;
        colorIndexRG[index][1] = valY;

    }

    public boolean isPermanentColor(int index) {
        return permanentColor[index];
    }

    public void setPermanentColor(int index, boolean val) {
        permanentColor[index] = val;
    }

    public void resetArrayColor() {
        for (int x = 0; x < numOfValues; x++) {
            if (!isPermanentColor(x)) { 
                setColor(x,0,0);
            }
        } 
    }

    public void deepResetArrayColor() {
        for (int x = 0; x < numOfValues; x++) {
            setColor(x,0,0);
            setPermanentColor(x,false);
        }
    }

    public void restartSameArray() {
        a = Arrays.copyOf(copy, copy.length);
        deepResetArrayColor();
    }

    //External access to array used by the sorting algorithms
    public void switchVal(int i, int j) {
        switchVal(a,i,j);
    }
    
    public void switchVal(Comparable[] array, int i, int j) {
        Comparable temp = array[i]; array[i] = array[j]; array[j] = (Integer) temp;
        setColor(i,255,0);
        setColor(j,255,0);
        repaint();
        sleep(speed);
    }

    public void changeVal(int i, Comparable k) {
        changeVal(a, i, k);
    }

    public void changeVal(Comparable[] array, int i, Comparable k) {
        incrementArrayAccessesCount();
        array[i] = (Integer) k;
        if (array == a) {
        	setColor(i,255,0);
        	 repaint();
             sleep(speed);
        }
    }
    
    public int compareTo(Comparable a, Comparable b) {
    	ArrayComparesJTextField.updateCount();
    	return a.compareTo(b);
    }

    public boolean less(Comparable a, Comparable b) {
    	ArrayComparesJTextField.updateCount();
        return a.compareTo(b) < 0;
    }

    public Comparable getValue(Comparable[] array, int i) {
    	ArrayAccessesJTextField.updateCount();
        return array[i];
    }

    public Comparable getValue(int i) {
        return getValue(a,i);
    }

    public static void sleep(double microsecond) { 
        long timeElapsed = 0;
        long startTime = System.currentTimeMillis();
        while (timeElapsed < microsecond) {
            timeElapsed = System.currentTimeMillis() - startTime;
        }
        return;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < numOfValues; x++) {
            g.setColor(new Color(colorIndexRG[x][0],colorIndexRG[x][1],0));
            g.fillRect((x)*(BARSIZE) + (horizontalSize-(numOfValues*BARSIZE))/2, verticalSize-a[x], BARSIZE, a[x]);
        }
    }
}
