package PS4;

import java.util.Arrays;

import util.tools;

public class P2 {

	public static void main(String[] args) {
		
		int n = 8;
		//int[] testV = tools.getUniqueTestSet(n, 1, 16);
		int[] testV = {5, 3, 6, 8, 4, 6, 2, 7, 9, 5};
		n = testV.length;
		int[][] A = new int[n + 1][n + 1];
		
		System.out.println("Integers: " + Arrays.toString(testV));
		System.out.println("n: " + n);
		
		for (int j = 0; j <= n; ++j)
	        A[0][j] = 0;
		
		for (int i = 0; i <= n; ++i)
	        A[i][0] = 0;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = i; j <= n; ++j) {
				
				if (testV[i - 1] >= testV[j - 1])			//Case 1
					A[i][j] = 0;
				else {
					
					A[i][j] = 1 + A[i][j - 1];				//Case 2
				}
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
