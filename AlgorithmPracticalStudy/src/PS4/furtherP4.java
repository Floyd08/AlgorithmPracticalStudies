package PS4;

import java.util.Arrays;
import java.util.Random;

public class furtherP4 {

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

	}

}
