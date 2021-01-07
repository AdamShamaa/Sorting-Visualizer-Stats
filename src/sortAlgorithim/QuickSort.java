package sortAlgorithim;

import java.util.Arrays;
import java.util.Random;

import GUIComponents.Array;

public class QuickSort extends SortingAlgorithim {

	public void sort(Array array) {
		int arrayLength = array.arrayLength();
		quickSort(array, 0, arrayLength - 1);
	}

	public int choosePivotNaive(Array array, int l, int r) {
		return r;
	}

	public int choosePivotOverkill(int[] array, int l, int r) {
		int[] copy = Arrays.copyOfRange(array, l, r);
		Arrays.sort(copy);
		return (int)((Math.floor((r - l) / 2)) + l);
	}

	public int choosePivotRandom(int[] array, int l, int r) {
		Random random = new Random();
		int rand = l + random.nextInt(r - l + 1);
		return rand;
	}

	public int chooseBestThree(Array array, int l, int r) {
		Comparable first = array.getVal(l);
		Comparable middle = array.getVal(((r - l) / 2 + l));
		Comparable last = array.getVal(r);

		if (first.compareTo(middle) != first.compareTo(last)) {
			return l;
		} else if (middle.compareTo(first) != middle.compareTo(last)) {
			return (r - l) / 2 + l;
		} else return r;
	}

	public void quickSort(Array array, int l, int r) {
		if (l >= r) return;

		// In this scenario, do not need to strategically pick a pivot considering the input is randomized, however good practice in general inputs
		array.switchVal(l, chooseBestThree(array, l, r));

		int p = partition(array, l, r);

		quickSort(array, l, p - 1);
		quickSort(array, p + 1, r);
	}

	public int partition(Array array, int l, int r) {
		int i = l + 1;
		for (int j = l + 1; j<= r; j++) {
			array.setRGB(255, 139, 0, l);
			if (array.less(j, l)) {
				array.switchVal(i++, j);
			}
			array.shallowArrayColorReset();
		}
		array.switchVal(i - 1, l);
		array.setRGB(99, 255, 0, i - 1);
		array.setPermanentColor(i - 1, true);
		return i - 1;
	}
}