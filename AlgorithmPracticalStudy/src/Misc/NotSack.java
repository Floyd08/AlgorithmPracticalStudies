package Misc;

import java.util.Arrays;

import util.tools;

public class NotSack {

	public static void main(String[] args) {
		
		int n = 3;
		int W = 6;
		
		int[] w = tools.getTestSet(n, 0, W);
		int[] v = tools.getTestSet(n, 0, W);
		int[][] A = new int[n + 1][W + 1];

		System.out.println("Weights are: " + Arrays.toString(w) );
		System.out.println("Values are:  " + Arrays.toString(v) );
		System.out.println("Sack capacity: " + W + "\n");
		
		for (int j = 0; j <= W; ++j)
	        A[0][j] = 0;
		
		for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= W; j++) {
	        	
	            if (w[i - 1] > j) {											//Case 1
	                A[i][j] = A[i - 1][j];
	                //System.out.printf("%d, %d---Case 1: The current cell is filled with was replaced with A[i - 1, j] \n", i, j);
	            }
	            else {														//Case 2
	            	A[i][j] = Math.max( A[i - 1][j], v[i - 1] + A[i - 1][j - w[i - 1]]);
	            	//System.out.printf("%d, %d---Case 2: The current cell is filled with the larger of the cell above it, or the cell above and shifted to the left by the weight of the current object plus the wieght of the current object ", i , j);
	            	//System.out.printf("A[i][j] is %d\n", A[i][j]);
	            }
	            
	        }
	    }
		
		System.out.printf(" \t ");
		for (int i = 0; i <= W; ++i)
			System.out.printf("%d  ", i);
		
		System.out.printf("\n");
		
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d\t%s\n", i, Arrays.toString(A[i]));
		
		//Construct the solution
		int[] solution = new int[n];
		
		int i = n; int j = W, k = 0;
		int result = A[n][W];				// result is the optimal value of the knapsack. We count down from here as we construct the optimal solution
		
		while (i > 0 && result > 0) {
						
			if (A[i][j] == A[i - 1][j])		// if this is the case, we didn't add anything to the optimal value, so the item isn't include in the sack
				--i;
			else {
											// This is the case in which we include an item in our knapsack, and record the item number in the solution array
				solution[k++] = i;			// advancing the index in our solution array
				//A[i][j] = Math.max( A[i - 1][j], v[i - 1] + A[i - 1][j - w[i - 1]]);
				result -= v[i - 1];			//subtracting the value of the current item from the optimal value. Why -1? it's an imdex dumby, and i was assigned n, the numer of items
				j -= w[i - 1];				//subtracting the weight of the current object from the capacity of the sack. This is what jumps us back in teh table. By back, I mean to the left
				--i;						//We've added an item, so we need to consider fewer in the next iteration
			}
		}
		
	    
		System.out.println("\nResult is: " + A[n][W] );
		System.out.println("Sack contains items numbered: " + Arrays.toString(solution));
	}

}
