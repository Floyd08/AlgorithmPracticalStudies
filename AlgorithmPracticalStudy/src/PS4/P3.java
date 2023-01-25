package PS4;

import java.util.Arrays;

import util.tools;

public class P3 {

	public static void main(String[] args) {

		int n = 8;
	    int testV[] = tools.getUniqueTestSet(n, 1, 16);
	    n = testV.length;
	    
	    System.out.println("Integers: " + Arrays.toString(testV));
		System.out.println("n: " + n);
		
		int A[] = new int[n];									// If the current element is less than it's preceding element, mark a 1 under the preceeding element
		Arrays.fill(A, -1);										// If the current element is greater than it's preceding element, mark a 0 under the preceding element;
		
		int i;
		for (i = 1; i < n; ++i) {
			
			if (testV[i] < testV[i - 1])
				A[i - 1] = 1;
			else
				A[i - 1] = 0;				
		}
		--i;
		if (testV[i] < testV[i - 1])
			A[i] = 0;
		else
			A[i] = 1;
		
		
		System.out.println("A: " + Arrays.toString(A));
		
		// Construct the solution from A
		int C[] = new int[n];
		int target = A[0], k = 0;
		C[k++] = testV[0]; 
		
		for (i = 1; i < n; ++i) {
			
			if (A[i] != target) {
				
				C[k++] = testV[i];
				target ^= 1;
			}	
		}
		
		System.out.println("C: " + Arrays.toString(C));
	}

}
