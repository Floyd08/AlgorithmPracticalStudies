package PS4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.tools;

public class P3N {

	public static void main(String[] args) {
		
		int n = 8;
	    int testV[] = tools.getUniqueTestSet(n, 1, 16);
	    n = testV.length;
	    
	    System.out.println("Integers: " + Arrays.toString(testV));
		System.out.println("n: " + n);
	    
	    int fup = 0, fown = 0, length = 0;
	    int A[] = new int[n];
	    //int[] solution = new int[n];
	    List<Integer> solution = new ArrayList<Integer>();
	    
	    for (int i = 0; i < n; ++i) {
	    	
	    	if (solution.isEmpty()) {
	    		solution.add(testV[i]);
	    		++length;
	    	}
	    	else if (solution.get(solution.size() - 1) == testV[i]) {
	    		continue;
	    	}
	    	else if (solution.size() == 1) {
	    		solution.add(testV[i]);
	    		++length;
	    	}
	    	else if ( (testV[i] - solution.get(solution.size() - 1) ) * (solution.get(solution.size() - 1)) - (solution.get(solution.size() - 2) )  < 0) {
	    		solution.add(testV[i]);
	    		++length;
	    	}
	    	else {
	    		solution.remove(solution.size() - 1);
	    		solution.add(testV[i]);
	    	}	
	    }
	    
	    System.out.printf("Length: %d\n", length);
	    System.out.println("Solution: " + solution.toString());
	}

}
