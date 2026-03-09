package ConcurrencyIsFun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import util.tools;

public class Con2 {

	public static void main(String[] args) {
		
		int numThreads = 10;
		
		ExecutorService eServ = Executors.newFixedThreadPool(20);
		
		for (int i = 0; i < numThreads * 2; ++i) {
			
			int[] unsorted = tools.getTestSet(20, -300, 600);
			Runnable task = new TaskQS(unsorted, 0, unsorted.length - 1);
			eServ.submit(task);
			
			//The Program doesn't terminate. What's that about?
		}

	}

}
