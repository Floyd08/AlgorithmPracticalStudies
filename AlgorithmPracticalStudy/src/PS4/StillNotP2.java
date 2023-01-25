package PS4;

import java.util.Arrays;

import util.sortLib;
import util.tools;

public class StillNotP2 {

	public static void main(String[] args) {
		
		int n = 8;
	    int testV[] = tools.getUniqueTestSet(n, 1, 16);
	    n = testV.length;
	    int sortedV[] = testV.clone();
	    sortLib.quickSort(sortedV, 0, sortedV.length - 1);

	    System.out.println("Integers: " + Arrays.toString(testV));
	    System.out.println("Integers (Sorted): " + Arrays.toString(sortedV));
		System.out.println("n: " + n);
		
		int[][] A = new int[n + 1][n + 1];
		
		for (int j = 0; j <= n; ++j)
	        A[0][j] = 0;
		
		for (int i = 0; i <= n; ++i)
	        A[i][0] = 0;
		
		for (int i = 0; i < n + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
            	
                if (i == 0 || j == 0)
                    A[i][j] = 0;
                else if (testV[j - 1] == sortedV[i - 1]) 
                    A[i][j] = 1 + A[i - 1][j - 1];
                else
                    A[i][j] = Math.max(A[i - 1][j], A[i][j - 1]);

            }
		}
		
		System.out.printf(" \t ");
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d  ", i);
		
		System.out.printf("\n");
		
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d\t%s\n", i, Arrays.toString(A[i]));

	}
}
