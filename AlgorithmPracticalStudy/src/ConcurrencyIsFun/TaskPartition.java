package ConcurrencyIsFun;

public class TaskPartition implements Runnable {

	int[] array;
	int first, last;
	
	public TaskPartition(int[] unsorted, int first, int last) {
		
		this.array = unsorted;
		this.first = first;
		this.last = last;
	}
	
	@Override
	public void run() {
		
		
	}
	
}
