package ConcurrencyIsFun;

import java.util.Arrays;

import util.sortLib;

public class TaskQS implements Runnable{
	
	int[] array;
	int first, last;
	
	public TaskQS(int[] array, int first, int last) {
		
		this.array = array;
		this.first = first;
		this.last = last;
	}
	
	@Override
	public void run() {
		
		sortLib.quickSort(array, first, last);
		System.out.println("sorted: " + Arrays.toString(array));
	}
}