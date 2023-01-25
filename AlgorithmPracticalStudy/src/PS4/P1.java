package PS4;

import java.util.Arrays;
import java.util.Random;

import util.tools;

public class P1 {

	public static void main(String[] args) {
		
		Random geny = new Random();
		int n= 4;
		int[] testV = tools.getTestSet(n, 1, 12);
		int s = geny.nextInt(6, 18);
		
		int[][] A = new int[n + 1][s + 1];
		
		System.out.println("Integers: " + Arrays.toString(testV));
		System.out.println("s: " + s);
		
		for (int j = 0; j <= s; ++j)
	        A[0][j] = 0;
		
		for (int i = 0; i <= n; ++i)
	        A[i][0] = 0;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= s; ++j) {
				
				if (testV[i - 1] > j)				//Case 1
					A[i][j] = A[i - 1][j];
				else {
													//Case 2
					A[i][j] = Math.max( A[i - 1][j], testV[i - 1] + A[i - 1][ j - testV[i - 1] ]);
				}
			}
		}
		
		System.out.printf(" \t ");
		for (int i = 0; i <= s; ++i)
			System.out.printf("%d  ", i);
		
		System.out.printf("\n");
		
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d\t%s\n", i, Arrays.toString(A[i]));
		
		if (A[n][s] != s)
			System.out.println("No solution");
		else {
		
			int[] solution = new int[n];
			
			int i = n; int j = s, k = 0;
			int result = A[n][s];							// result is the optimal value of the test Vector. We count down from here as we construct the optimal solution
			
			while (i > 0 && result > 0) {
							
				if (A[i][j] == A[i - 1][j])					// if this is the case, we didn't add anything to the subset Sum, so the element ins't included in the solution
					--i;
				else {
															// This is the case in which we include an element in the solution
					solution[k++] = testV[i - 1];			// advancing the index in our solution array
					result -= testV[i - 1];					//subtracting the value of the current element from the subset Sum.
					j -= testV[i - 1];						//Jump back in the array
					--i;									//We've added an item, so we need to consider fewer in the next iteration
				}
			}
			
			System.out.println("\nResult is: " + A[n][s] );
			System.out.println("Solution is: " + Arrays.toString(solution));
		}

	}
	

}
