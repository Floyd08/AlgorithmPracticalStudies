package util;

import java.util.Arrays;

public class toolTesting {

	public static void main(String[] args) {
		
		int max = 10000000, ex = 0;
		int[] a, c;
		
		for (int i = 0; i < max; ++i) {
			
			a = tools.getTestSet(12, 0, 40);
			c = a.clone();
			sortLib.BubbleSort(c);
			
			if (tools.validate(a) == false && tools.validate(c) == true)
				++ex;
		}
		
		System.out.println("Successes: " + ex);
	}
}
