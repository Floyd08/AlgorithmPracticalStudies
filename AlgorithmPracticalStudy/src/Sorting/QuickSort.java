package Sorting;

import java.util.Arrays;

import util.sortLib;
import util.tools;

public class QuickSort {

	public static void main(String[] args) {
		
		
		int[] unsorted = tools.getTestSet(12, 0, 40);
		System.out.println("pre-partition: " + Arrays.toString(unsorted) );
		
		int i = unsorted.length - 1;
		System.out.printf("chosen pivot is: %d\n", unsorted[i]);
		
		partition(unsorted, 0, i);
		System.out.println("partitioned: " + Arrays.toString(unsorted));
		
		//quickSortin'
		sortLib.quickSort(unsorted, 0, unsorted.length - 1);
		System.out.println("sorted: " + Arrays.toString(unsorted));
		
		System.out.println("Begin Test Phase");
		int exp = 0;
		for(int j = 0, max = 100; j < max; ++j) {
			
			unsorted = tools.getTestSet(12, 0, 40);
			sortLib.quickSort(unsorted, 0, unsorted.length - 1);
			if (tools.validate(unsorted))
				++exp;
		}
		System.out.println("exp = " + exp);
	}
	
	private static void quickSort(int[] array, int first, int last) {
		
		if (first >= last)
			return;
		
		int pivot = tools.partition(array, first, last);
		
		quickSort(array, first, pivot - 1);
		quickSort(array, pivot + 1, last);
	}
	
	private static int partition (int[] array, int first, int pivot) {
		
		int j = first, i = j - 1;
		
		while (j < array.length) {
			
			if (array[j] < array[pivot]) {
				++i;
				tools.swap(array, i, j);
			}
			++j;
		}
		++i; 
		tools.swap(array, i, pivot);
		
		return i;
	}
	
	
	// The easier to read, less fancy version
	/*if (array[j] > array[pivot])
		++j;
	else if (array[j] < array[pivot]) {
		++i;
		tools.swap(array, i, j);
		++j;
	}
	else
		continue;*/
	

}

