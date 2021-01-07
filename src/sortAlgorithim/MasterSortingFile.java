package sortAlgorithim;

public class MasterSortingFile {

	class SortAlgorithimData {
		String algorithimName;
		SortingAlgorithim sortAlgorithim;

		public SortAlgorithimData(String algorithimName, SortingAlgorithim sortAlgorithim) {
			this.algorithimName = algorithimName;
			this.sortAlgorithim = sortAlgorithim;
		}
	}

	/** -------- Adding a new sorting algorithm -------- */
	/**
	 * Be sure to extends the sort algorithm class to be a child of "SortingAlgorithim"
	 * Use the following template: 
	 * 								new SortAlgorithimData("NAME_OF_SORT_ALGORITHIM", new NAME_OF_CLASS())
	 * Append the template to the start or end of the "ArrayOfSortingAlgorithims" array located on line 24
	 * Done!
	 */

	// DATA
	public SortAlgorithimData ArrayOfSortingAlgorithims[] = {
		new SortAlgorithimData("InsertionSort", new InsertionSort()),
		new SortAlgorithimData("MergeInsertionSort", new MergeInsertionSort()),
		new SortAlgorithimData("MergeSort", new MergeSort()),
		new SortAlgorithimData("QuickSort", new QuickSort()),
		new SortAlgorithimData("SelectionSort", new SelectionSort()),
		new SortAlgorithimData("ShellSort", new ShellSort()),
		new SortAlgorithimData("ThreeWayQuickSort", new ThreeWayQuickSort()),
		new SortAlgorithimData("KeyIndexedCounting", new KeyIndexedCounting())
	};

	public String[] getArrayOfSortingAlgorithimNames() {
		String[] names = new String[ArrayOfSortingAlgorithims.length];
		for (int index = 0; index<ArrayOfSortingAlgorithims.length; index++) {
			names[index] = ArrayOfSortingAlgorithims[index].algorithimName;
		}
		return names;
	}

	// Initiate Sorting Algorithim
	public SortingAlgorithim getSortingAlgorithim(String algorithimName) {
		for (SortAlgorithimData singleSortAlgorithim: ArrayOfSortingAlgorithims) {
			if (singleSortAlgorithim.algorithimName == algorithimName) return singleSortAlgorithim.sortAlgorithim;
		}

		throw new IllegalArgumentException("getClass() // INVALID ALGORITHIM NAME: " + algorithimName);
	}
}