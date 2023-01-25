package PS4;

import java.util.Arrays;
import java.util.Random;

public class AnotherP4 {

	public static void main(String[] args) {
		
		Random geny = new Random();
		//int n = 6; 
		int n = geny.nextInt(1, 127);
		
		int bigNumber = -1;
		
		int[] coins = {1, 5, 10, 25, 50};
		//int[] coins = {1, 5, 6, 23, 35, 46, 50};
		int k = coins.length;
		
		int[][] A = new int[coins.length + 1][n + 1];
		
		System.out.println("Coins are: " + Arrays.toString(coins));
		System.out.println("n: " + n);
		
		int[] M = new int[n + 1];			//holds the minimum number of coins needed for the value of this index
		M[0] = 0;

	    int[] S = new int[n + 1];			//holds the first coin of each value		
	    S[0] = 0;

	    for(int i = 1; i <= n; i++) {
	        
			int minimum = 1000;
			int coin = 0;
			    
			for(int j = 1; j < k; j++) {
			      
				if(i >= coins[j]) {
					if( (1 + M[i - coins[j]]) < minimum) {
						minimum = 1 + M[i - coins[j] ];
				    	coin = j;
					}
				}
			}
			
			M[i] = minimum;
			S[i] = coin;
	    }

	    System.out.println("M: " + Arrays.toString(M));
		System.out.println("S: " + Arrays.toString(S));

	    int l = n;
	    while(l > 0) {
	    	
	    	System.out.println(coins[S[l]]);
	    	l = l - coins[S[l]];
	    }

	    System.out.println("result: " + M[n]);
	}
}
