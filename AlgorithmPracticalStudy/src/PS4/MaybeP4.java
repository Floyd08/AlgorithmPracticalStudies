package PS4;

import java.util.Arrays;
import java.util.Random;

import util.tools;

public class MaybeP4 {

	public static void main(String[] args) {
		
		Random geny = new Random();
		int n = geny.nextInt(1, 16);
		
		int bigNumber = -1;
		
		int[] coins = {1, 5, 10, 25, 50};
		
		int[][] A = new int[n + 1][n + 1];
		
		System.out.println("Coins are: " + Arrays.toString(coins));
		System.out.println("n: " + n);
		
		for (int j = 0; j <= n; ++j)
	        A[0][j] = 0;
		
		for (int i = 0; i <= coins.length; ++i)
	        A[i][0] = 0;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = i; j <= n; ++j) {
				
				if (i == 1 && j < coins[i])
					A[i][j] = bigNumber;
				else if (i == 1)
					A[i][j] = 1 + A[1][j - coins[1]];
				else if (j < coins[i])
					A[i][j] = A[i - 1][j];
				else
					A[i][j] = Math.min(A[i - 1][j], 1 + A[i][j - coins[i]]);
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
