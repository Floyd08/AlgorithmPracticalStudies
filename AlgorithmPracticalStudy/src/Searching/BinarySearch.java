package Searching;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import util.sortLib;
import util.tools;

public class BinarySearch {

	public static void main(String[] args) {
		
		int size = 24;
		
		int[] testV = tools.getTestSet(size, 0, 20);
		sortLib.quickSort(testV, 0, size - 1);
		
		Random geny = new Random();
		int index = geny.nextInt(0, size - 1);
		int target = geny.nextInt(-5, size + 5);		//testV[index];
		
		System.out.println("Sorted string: " + Arrays.toString(testV));
		//System.out.printf("Random index = %d, element at that index = %d\n", index, target);
		System.out.printf("Search target: %d\n", target);
		
		int result = binarySearch(testV, target, 0, size - 1);
		
		if (result < 0)
			System.out.printf("Target: %d not present, insertion index would be: %d\n", target, result * -1);
		else
			System.out.printf("Index of target = %d\n", result);
		
		System.out.println("Probin' Probin' Probin'");
		int[] partition = probe(testV, result);
		System.out.printf("i = %d, j = %d\n", partition[0], partition[1]);
		
	}
	
	private static int binarySearch(int[] array, int target, int first, int last) {
		
		int mid = first + (last - first) / 2;
		
		if (first > last)
				return (-1 * mid) ;
		
		int index;
		
		if (target == array[mid])
			return mid;
		else if (target < array[mid])
			index = binarySearch(array, target, first, mid - 1);
		else
			index = binarySearch(array, target, mid + 1, last);
		
		return index;
	}
	
	private static int[] probe(int[] array, int target) {
		
		int[] partition = {target, target};
		int len = array.length; 
		int i = target, j = target;
		boolean lFlag = true, rFlag = true;
		
		while (i > 0 && j < len - 1 && rFlag) {
			
			if (lFlag) {
				
				--i;
				if (array[i] == array[target])
					partition[0] = i;
				else
					lFlag = false;
			}
			else {
				++j;
				if (array[j] == array[target])
					partition[1] = j;
				else
					rFlag = false;
			}	
		}
		return partition;
	}
	
}






