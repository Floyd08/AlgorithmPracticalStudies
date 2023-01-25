package PS4;

import java.util.Arrays;
import java.util.Random;

public class P4 {

	public static void main(String[] args) {
		
		Random geny = new Random();
		//int n = 6; 
		int n = geny.nextInt(1, 127);
		
		int[] coins = {1, 5, 10, 25, 50};
		//int[] coins = {1, 5, 6, 23, 35, 46, 50};
		//int[] coins = {2, 5, 10, 25, 50};
		int k = coins.length;
		int fudge = 0;
		
		int[] A = new int[n];
		int[] B = new int[n];
		
		Arrays.fill(A, coins[0]);
		Arrays.fill(B, -1);
		
		System.out.println("Coins are: " + Arrays.toString(coins));
		System.out.println("n: " + n);
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j < k; ++j) {
				
				if (i - fudge < coins[0]) {
					A[i - 1] = 0;
					break;
				}
				else if (i - fudge == coins[j - 1]) {
					A[i - 1] = coins[j - 1];
					B[i - 1] = -1;
					//System.out.printf("Case1 ---- i: %d, j: %d, coin: %d \n", i, j, coins[j - 1]);
					break;
				}
				else if (i - fudge > coins[j - 1] && i - fudge < coins[j]) {
					A[i - 1] = A[i - coins[j - 1] - 1];
					B[i - 1] = B[i - coins[j - 1] - 1] + 1;
					//System.out.printf("Case2 ---- i: %d, j: %d, coin: %d \n", i, j, coins[j - 1]);
					break;
				}
				else if (i - fudge == coins[j]){
					A[i - 1] = coins[j];
					B[i - 1] = -1;
					//System.out.printf("Case3 ---- i: %d, j: %d, coin: %d\n", i, j, coins[j - 1]);
					break;
				}
				else if (j == k - 1 && i > fudge) {
					
					fudge += coins[k - 1];				//mmmmmm, fudge!
				}
				
			}
		}
		
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
		
		int value = n;
		k = 0;
		int[] C = new int[n];
		
		while (value > 0) {
			//System.out.printf("value: %d\n", value);
			if (B[value - 1] > -2) {
				C[k++] = A[value - 1];
				value -= A[value - 1];
			}
			else {
				System.out.println("No solution\n");
				break;
			}
		}

		System.out.println("C: " + Arrays.toString(C));
	}

}
