package sortAlgorithim;

import GUIComponents.Array;

public class MergeSort extends SortingAlgorithim {
	public void sort(Array array) {
		int arrayLength = array.arrayLength();
		int[] aux = new int[arrayLength];
		mergesort(array, aux, 0, arrayLength - 1);
	}

	private void mergesort(Array array, int[] aux, int low, int hi) {
		if (low >= hi) return;
		int mid = low + (hi - low) / 2;
		mergesort(array, aux, low, mid);
		mergesort(array, aux, mid + 1, hi);
		merge(array, aux, low, mid, hi);
	}

	private void merge(Array array, int[] aux, int low, int mid, int hi) {
		int i = low;
		int j = mid + 1;
		for (int index = low; index<= hi; index++) {
			array.setVal(aux, index, array.getVal(index));
		}
		for (int index = low; index<= hi; index++) {
			if (i > mid) array.setVal(index, aux[j++]);
			else if (j > hi) array.setVal(index, aux[i++]);
			else if (array.less(aux, i, j)) array.setVal(index, aux[i++]);
			else array.setVal(index, aux[j++]);
			array.shallowArrayColorReset();
		}
		array.shallowArrayColorReset();
	}
}