package PS4;

import java.util.Arrays;
import java.util.Random;

public class CanYouBelieveAnotherP4 {

	public static void main(String[] args) {
		
		Random geny = new Random();
		//int n = 12; 
		int n = geny.nextInt(1, 27);
		
		int[] coins = {1, 5, 10, 25, 50};
		//int[] coins = {1, 5, 6, 23, 35, 46, 50};
		//int[] coins = {2, 5, 10, 25, 50};					//coinValueList
		int k = coins.length;
		
		System.out.println("Coins: " + Arrays.toString(coins));
		System.out.println("n: " + n);
		
		int[][] A = new int[k + 1][n + 1];				
		
		/*for (int j = 0; j <= n; ++j)
	        A[0][j] = 0;*/
		
		for (int i = 0; i <= k; ++i)
	        A[i][0] = 1;
		
		for (int i = 1; i < k + 1; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				
				if (j - coins[i - 1] < 0)
					A[i][j] = A[i - 1][j];
				else
					A[i][j] = 					A[i - 1][j] + A[i][j - coins[i - 1]];
					//dpTable[coinIndex][dpSum]  = dpTable[coinIndex-1][dpSum]+dpTable[coinIndex][dpSum-coins[coinIndex-1]];
			}
		}
		
		System.out.printf(" \t ");
		for (int i = 0; i <= n; ++i)
			System.out.printf("%d  ", i);
		
		System.out.printf("\n");
		
		for (int i = 0; i <= k; ++i)
			System.out.printf("%d\t%s\n", i, Arrays.toString(A[i]));


	}

}
