package PS4;

import java.util.Arrays;

import util.tools;

public class ActuallyP2 {

	public static void main(String[] args) {
		
		int n = 8;
	    int testV[] = tools.getUniqueTestSet(n, 1, 16);
		//int[] testV = {5, 3, 6, 8, 4, 6, 2, 7, 9, 5};
		//int[] testV = {12, 42, 66, 73, 234, 7, 543, 16};
	    n = testV.length;
	    int[] A = new int[n];
	    int[] B = new int[n];
	    Arrays.fill(A, 1);
	    Arrays.fill(B, -1);

	    System.out.println("Integers: " + Arrays.toString(testV));
		System.out.println("n: " + n);
		
		for (int i = 0; i < n; ++i) {
	        for (int j = 0; j < i; ++j) {
	            
	        	//System.out.printf("i: %d, j: %d ----- ", i, j);
	        	if (testV[j] < testV[i] && A[i] < A[j] + 1) {
	        		//System.out.printf("A[%d] assigned A[%d] + 1 ---- ", i, j);
	        		//System.out.printf("B[%d] assigned %d", i, j);
	        		A[i] = A[j] + 1;
	        		B[i] = j;
	            }
	        	//System.out.println("");
	        }
	    }

		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
		
	    int ans = A[0], ansIndex = -1;
	    for (int i = 1; i < n; ++i) {
	    	
	    	if (ans < A[i]) {
	    		ans = A[i];
	    		ansIndex = i;
	    	}
	    }
	    
	    int[] C = new int[n];
	    int k = 0;
	    
	    while (ansIndex != -1) {
	    	
	    	//System.out.printf("testV[%d] (%d) added to solution ---- ansIndex assigned B[%d](%d)\n", ansIndex, testV[ansIndex], ansIndex, B[ansIndex]);
	    	C[k++] = testV[ansIndex];
	    	ansIndex = B[ansIndex];
	    }
	    
	    System.out.printf("LIS length: %d\n", ans);
	    System.out.println("Solution is: " + Arrays.toString(C));

	}

}
