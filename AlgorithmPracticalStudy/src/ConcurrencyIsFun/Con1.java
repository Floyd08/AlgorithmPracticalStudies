package ConcurrencyIsFun;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Con1 {

	public static void main(String[] args) {
		
		//Executor executor = Executors.newSingleThreadExecutor();
		//executor.execute(() -> System.out.println("Hello World"));
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(() -> "Hello World");		//THIS LINE HAS IT ALL
		//The line above submits a task to the thread pool, and assigns whatever value is returned to the String future
		
		try {
			String result = future.get();
			System.out.println(result);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		executorService.shutdown();

	}

}
