package PS4;

import java.util.Arrays;

import util.tools;

public class MaybeP3 {

	public static void main(String[] args) {
		
		int n = 8;
	    int testV[] = tools.getUniqueTestSet(n, 1, 16);
	    n = testV.length;
	    
	    //First find the length of the LAS
	    int[] A = new int[n];
	    int[] B = new int[n];
	    
	    Arrays.fill(A, 1);
	    Arrays.fill(B, 1);
	    
	    System.out.println("Integers: " + Arrays.toString(testV));
		System.out.println("n: " + n);
	    
	    for (int i = 0; i < n; ++i) {
	        for (int j = 0; j < i; ++j) {
	        	
	        	if (testV[i] > testV[j])
	        		A[i] = Math.max(A[i],  B[j] + 1);
	        	else if (testV[i] < testV[j])
	        		B[i] = Math.max(B[i], A[j] + 1);
	        }
	    }
	    
	    int ans = 0;
	    int ansIndex = 0;
	    
	    for (int i = 0; i < n; i++) {
	    	
	    	int lMax = Math.max(A[i], B[i]);
	    	
	    	if (lMax > ans) {
	    		ans = lMax;
	    		ansIndex  = i;
	    	}
	    }
	    int lasLength = ans;
	    
	    int f_up = 0, f_down = 0;
	    int[] C = new int[n];
	    int k = 0;
	    
	    if (ans == A[ansIndex])
	    	f_up = 1;
	    else
	    	f_down = 1;
	    
	    C[k++] = testV[ansIndex];
	    for (int i = ansIndex - 1; i >= 0; --i) {
	    	
	    	if (ans == 1)
	    		break;
	    	
	    	if (f_down == 1) {
	    		if (A[i] + 1 == ans) {
	    			C[k++] = testV[i];
	    			ans = A[i];
	    			f_down = 0;
	    			f_up = 1;
	    		}
	    	}
	    	else if (f_up == 1) {
	    		if (B[i] + 1 == ans) {
	    			C[k++] = testV[i];
	    			ans = B[i];
	    			f_down = 1;
	    			f_up = 0;
	    		}
	    	}
	    }

	    System.out.printf("LAS length: %d\n", lasLength);
	    System.out.println("Solution is: " + Arrays.toString(C));
	    
	}

}
