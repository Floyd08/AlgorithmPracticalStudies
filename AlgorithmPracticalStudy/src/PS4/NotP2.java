package PS4;

import java.util.Arrays;

import util.tools;

public class NotP2 {

	/* lis() returns the length of the longest

    increasing subsequence in arr[] of size n */


	public static void main(String args[]) {

	int n = 8;
    int testV[] = tools.getTestSet(n, 1, 16);

    System.out.println("Integers: " + Arrays.toString(testV));
	System.out.println("n: " + n);
	
	int lis[] = new int[n];
    int i, j, max = 0;
    /* Initialize LIS values for all indexes */

    for (i = 0; i < n; i++)
        lis[i] = 1;


    /* Compute optimized LIS values in
       bottom up manner */

    for (i = 1; i < n; i++) {
        for (j = 0; j < i; j++) {

            if (testV[i] > testV[j] && lis[i] < lis[j] + 1)
                lis[i] = lis[j] + 1;
            
        }
    }


    /* Pick maximum of all LIS values */

    for (i = 0; i < n; i++) {
    	System.out.printf("i = %d, lis[i] = %d\n", i, lis[i]);
        if (max < lis[i])
            max = lis[i];
    }

    
    System.out.println("Length of LIS is " + max + "\n");

	}
}
