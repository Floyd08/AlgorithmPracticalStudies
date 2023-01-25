package DynamicProgamming;

import java.util.Arrays;

import util.sortLib;
import util.tools;

public class RodCut {

	public static void main(String[] args) {

		int[] rodPrice = tools.getTestSet(11, 1, 14);			//index is the length of the rod, the element is the sell price
		int n = rodPrice.length;
		sortLib.quickSort(rodPrice, 0, n - 1);
		
		rodPrice[0] = 0;
		
		int[] maxValue = rodPrice.clone();
		int[] firstCut = new int[n];
		
		for (int i = 1; i < n; ++i) {
			
			int q = Integer.MIN_VALUE;
			for (int j = 0; j < i; ++j) {
				
				if (q < rodPrice[j] + maxValue[i - j])
					q = Math.max(q, rodPrice[j] + maxValue[i - j] );
					firstCut[i] = j;
			}
			maxValue[i] = q;
		}
		int i;
		System.out.printf("Rod Lengths: \t[");
		for(i = 0; i < n - 1; ++i)
			System.out.printf("%d, ", i);
		System.out.printf("%d]\n", i);
		
		System.out.println("Rod Prices: \t" + Arrays.toString(rodPrice));
		System.out.println("\nmaxValue: \t" + Arrays.toString(maxValue));
		
	}

}
