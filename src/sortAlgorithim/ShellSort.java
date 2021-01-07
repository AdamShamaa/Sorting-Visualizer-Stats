package sortAlgorithim;

import GUIComponents.Array;

public class ShellSort extends SortingAlgorithim {
	public void sort(Array array) {
		int gap = 1;
		int length = array.arrayLength();
		while (gap<length / 3) gap = gap * 3 + 1;
		while (gap >= 1) {
			for (int i = gap; i<length; i++) {
				for (int j = i; j >= gap && array.less(j, j - gap); j -= gap) {
					array.switchVal(j, j - gap);
					array.shallowArrayColorReset();;
				}
			}
			gap /= 3;
		}
	}
}