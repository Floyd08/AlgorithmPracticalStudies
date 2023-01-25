package PS4;

import java.util.Arrays;
import java.util.Random;

public class YetAnotherP4 {

	public static void main(String[] args) {

		Random geny = new Random();
		//int n = 12; 
		int n = geny.nextInt(1, 27);
		
		int[] coins = {1, 5, 10, 25, 50};
		//int[] coins = {1, 5, 6, 23, 35, 46, 50};
		//int[] coins = {2, 5, 10, 25, 50};					//coinValueList
		int k = coins.length, coinCount = 0, newCoin = 1;
		
		int[] A = new int[n];					//minCoins
		int[] B = new int[n];					//coinsUsed
		
		//Arrays.fill(A, coins[0]);
		//Arrays.fill(B, -1);
		
		for (int i = 0; i < n; ++i) {
			
			coinCount = i;
			newCoin = 0;
			for (int j = 0; j < k; ++j) {
				System.out.printf("i: %d, j: %d, coin: %d\n", i, j, coins[j]);
				if (coins[j] <= i) {
					System.out.println("Case 1");
					if (A[i - j] + 1 < coinCount) {
						System.out.println("Case 2");
						coinCount = A[i - j] + 1;				//Take the max of......
						newCoin = j;
					}
				}
			}
			A[i] = coinCount;
			B[i] = newCoin;
			
			System.out.printf("coinCount: %d, newCoin: %d\n", coinCount, newCoin);
		}
		
		System.out.println("A: " + Arrays.toString(A));
		System.out.println("B: " + Arrays.toString(B));
		
		int value = n;
		k = 0;
		int[] C = new int[n];
		
		while (value > 0) {
			System.out.println("value: " + value);
			C[k++] = B[value - 1];
			value -= B[value - 1];
		}
		
		System.out.println("C: " + Arrays.toString(C));

	}

}
