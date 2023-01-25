package DynamicProgamming;

import java.util.Arrays;
import java.util.Random;

public class Fibonacci {
		
	public static void main(String[] args) {
		
		Random geny = new Random();
		int n = geny.nextInt(25);
		int[] solutions = new int[n];
		Arrays.fill(solutions, -1);
		solutions[0] = 1;
		solutions[1] = 1;
		
		for (int i = 2; i < n; ++i)
			solutions[i] = solutions[i - 1] + solutions[i - 2];
		
		System.out.printf("Fibonacci sequence up to %d: %s\n", n, Arrays.toString(solutions));
			
	}
		
}
