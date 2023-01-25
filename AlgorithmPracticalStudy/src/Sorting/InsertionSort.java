package Sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class InsertionSort {

	public static void main(String[] args) {
		
		int arrayLen = 20, min = 0, max = 50;
		
		Random geny = new Random();
		IntStream pop = geny.ints(arrayLen, min, max);
		
		int array[] = pop.toArray();
		
		System.out.println("Pre Sort: " + Arrays.toString(array));

	}

}
