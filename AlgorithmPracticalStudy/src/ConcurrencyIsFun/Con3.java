package ConcurrencyIsFun;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import util.tools;

public class Con3 {

	//A toy example to workout AsyncQuickSort
	
	
	public static void main(String[] args) {
		
		int[] unsorted = tools.getTestSet(60, 0, 60);
		int i = unsorted.length - 1;
		
		System.out.println("pre-partition: " + Arrays.toString(unsorted) );
		
		ExecutorService eServ = Executors.newFixedThreadPool(20);
		Phaser ph = new Phaser(1);
		
		Runnable task = new AsyncQuickSort(unsorted, 0, i, eServ, ph);
		eServ.submit(task);
		
		while (ph.getRegisteredParties() != 1) {
			System.out.printf("registered tasks: %d\n", ph.getRegisteredParties());
			System.out.printf("Phase number is: %d\n", ph.getPhase());
			ph.arriveAndAwaitAdvance();
			System.out.println("sorted: " + Arrays.toString(unsorted));
		}
		
		ph.arriveAndDeregister();
		eServ.shutdown();
	}
}
