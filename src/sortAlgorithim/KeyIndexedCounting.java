package sortAlgorithim;

import GUIComponents.Array;

public class KeyIndexedCounting extends SortingAlgorithim {

	public void sort(Array array) {
		keyIndexedCounting(array, array.range());
	}

	private void keyIndexedCounting(Array array, int radix) {
		int count[] = new int[radix+1];
		
		int length = array.arrayLength();
		int[] aux = new int[length];

		for (int i = 0; i < length; i++) {	//frequency count
			array.setVal(count, array.getVal(i) + 1, array.getVal(i) + 1);
		}

		for (int r = 0; r < radix; r++) {	//convert frequency to indices
			array.setVal(count, array.getVal(count, r + 1), array.getVal(count, r));
		}

		for (int i = 0; i < length; i++) {	//distribute to aux
			array.setVal(aux, array.getVal(count, array.getVal(i)), array.getVal(i));
			array.setVal(count, array.getVal(i), array.getVal(count, array.getVal(i) + 1));
		}

		for (int i = 0; i < length; i++) {	//copy to original array
			array.setVal(i, array.getVal(aux, i));
		}
	}
}