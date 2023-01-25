package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import util.tools;

public class knapSack {

	public static void main(String[] args) {
		
		int length = 3;
		int sackCapacity = 8;					// The maximum weight the knapsack can hold
		
		//Ingot[] testV = Ingot.getTestIngots(length);
		int weights[] = tools.getTestSet(length, 0, 10);
		int values[] = tools.getTestSet(length, 0, 10);
		
		System.out.println("Weights are: " + Arrays.toString(weights) );
		System.out.println("Values are:  " + Arrays.toString(values) );
		
		int[][] results = new int[length][length];
		
		int i = 0;
		for (; i < length; ++i)
			results[0][i] = 0;
		
		for (i = 0; i < length; ++i)
			results[i][0] = 0;
		
		for(int n = 1; n < length; ++n) {
			for (int w = 1; w < length; ++w) {
				
				
				if (weights[n - 1] > w)
					results[n][w] = results[n - 1][w];
				else
					results[n][w] = Math.max(results[n - 1][w], + values[i - 1] + results[n - 1][w - weights[i - 1] ] );
					
							//m[i][j] = Math.max( m[i - 1][j],   v[i - 1] + m[i - 1][j - w[i - 1]] );
			}
		}
		
		System.out.println("Result is: " + results[length - 1][length - 1]);
		
	}

}

	//List<Ingot> testList = new ArrayList<Ingot>(Arrays.asList(Ingot.getTestIngots(length)));

		//System.out.println("Test Vector (Unsorted) is: " + testList.toString());
		//Collections.sort(testList);
		//System.out.println("Test Vector (Sorted) is: " + testList.toString());
		
		//Ingot[] testV = new Ingot[length];
		//System.out.println("TV as an array: " + Arrays.toString(testV));
		
		//testV = testList.toArray(testV);
