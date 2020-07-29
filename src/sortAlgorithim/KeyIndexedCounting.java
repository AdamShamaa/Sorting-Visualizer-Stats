package sortAlgorithim;

import GUI.sortingJPanel;

public class KeyIndexedCounting {

	public void sort(sortingJPanel input) {
		keyIndexedCounting(input, input.range());
	}

	private void keyIndexedCounting(sortingJPanel input, int radix) {
		int count[] = new int[radix+1];
		
		int N = input.arrayLength();
		Comparable<Integer>[] aux = (Comparable<Integer>[]) new Comparable[N];

		for (int i = 0; i < N; i++) {	//frequency count
			count[(int) input.getValue(i) + 1]++;
			input.incrementArrayAccessesCount();
		}

		for (int r = 0; r < radix; r++) {	//convert frequency to indices
			count[r+1] += count[r];
			input.incrementArrayAccessesCount(2);
		}

		for (int i = 0; i < N; i++) {	//distribute to aux
			aux[count[(int) input.getValue(i)]++] = input.getValue(i);
			input.incrementArrayAccessesCount(2);
		}

		for (int i = 0; i < N; i++) {	//copy to original array
			input.changeVal(i, input.getValue(aux, i));
		}
	}

}