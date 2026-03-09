package ConcurrencyIsFun;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Phaser;

import util.sortLib;
import util.tools;

public class AsyncQuickSort implements Runnable {

	int[] array;
	int first, last;
	ExecutorService tPool;
	Phaser tPH;
	
	public AsyncQuickSort(int[] array, int first, int last, ExecutorService eServ, Phaser ph) {
		
		this.array = array;
		this.first = first;
		this.last = last;
		this.tPool = eServ;
		this.tPH = ph;
		tPH.register();
	}
	
	@Override
	public void run() {
		
		if (first >= last) {
			tPH.arriveAndDeregister();
			return;
		}
		
		int pivot = tools.partition(array, first, last);
		tPH.arriveAndDeregister();													//Necessary to decrement the number of registered parties, otherwise they'd carry over into the 
																					//next phase
		Runnable task = new AsyncQuickSort(array, first, pivot - 1, tPool, tPH);	
		tPool.submit(task);															//Exactly as QuickSort, only we're parceling the work into runnables so we can then hand
		task = new AsyncQuickSort(array, pivot + 1, last, tPool, tPH);				// off to the thread pool
		tPool.submit(task);
	
	}

}
