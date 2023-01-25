package Sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import util.sortLib;
import util.tools;

public class BubbleSort {

	//Simple implementation that sorts integers into ascending order
	public static void main(String[] args) {
		
		int arrayLen = 20, min = 0, max = 50;		
		int array[] = tools.getTestSet(arrayLen, min, max);
		
		System.out.println("Pre Sort: " + Arrays.toString(array));
		
		sortLib.BubbleSort(array);
		
		System.out.println("Post Sort:" + Arrays.toString(array));
	}
	
	public static void BubbleSort(int[] array) {
		
		int k = 1, arrayLen = array.length;
		boolean didSwap = true;
		
		while (didSwap == true ) {
			
			didSwap = false;
			for (int i = 0; i < arrayLen - k; ++i) {
				//System.out.println("i = " + i);
				//System.out.printf("a = %d, b = %d\n", array[i], array[i + 1]);
				if (array[i] > array[i + 1]) {
					//System.out.println("Swapped");
					tools.swap(array, i, i + 1);
					didSwap = true;
				}		
			}
			++k;
		}
	}
}
