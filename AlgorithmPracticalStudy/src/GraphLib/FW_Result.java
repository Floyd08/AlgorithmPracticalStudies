package GraphLib;

import java.util.Arrays;
import java.util.HashMap;

public class FW_Result {

	int[][] scores;
	Vertex[][] successors;
	HashMap<String, Integer> labelToIndex;
	HashMap<Integer, String> indexToLabel;
	
	public FW_Result(int n) {
		
		scores = new int[n][n];
		for (int i = 0; i < n; ++i) {
			
			Arrays.fill(scores[i], Integer.MAX_VALUE);
			scores[i][i] = 0;
		}
			
		
		successors = new Vertex[n][n];
		for (int i = 0; i < n; ++i)
			Arrays.fill(successors[i], null);
		
		labelToIndex = new HashMap<String, Integer>();
		indexToLabel = new HashMap<Integer, String>();
	}
}
