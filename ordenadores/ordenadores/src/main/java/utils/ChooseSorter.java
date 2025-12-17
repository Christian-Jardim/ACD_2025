package utils;

import java.util.ArrayList;
import java.util.List;

public class ChooseSorter {
	public static void sorter(Integer[] array, int algoritmo, int r) {
		double[] times = null;
		List<String> csvList = new ArrayList<>();

		switch(algoritmo) {
		case 1:
			times = SortersStopwatch.timeBubbleSort("BubbleSort", array, r, csvList);
			break;
		case 2:
			times = SortersStopwatch.timeInsertionSort("InsertionSort", array, r, csvList);
			break;
		case 3:
			times = SortersStopwatch.timeSelectionSort("SelectionSort", array, r, csvList);
			break;
		case 4:
			times = SortersStopwatch.timeMergeSort("MergeSort", array, r, csvList);
		case 5:
			times = SortersStopwatch.timeShellSort("ShellSort", array, r, csvList);
			break;
		case 6:
			times = SortersStopwatch.timeHeapSort("HeapSort", array, r, csvList);
			break;
		case 7:
			times = SortersStopwatch.timeQuickSort("QuickSort", array, r, csvList);
			break;
		case 8:
			times = SortersStopwatch.timeCountingSort("CountingSort", array, r, csvList);
			break;
		case 9:
			times = SortersStopwatch.timeRadixSort("RadixSort", array, r, csvList);
			break;
		}
	}
}
