package GraphLib;

import java.util.ArrayList;
import java.util.Arrays;

import util.tools;

public class Floyd_Warshall {

	public static void main(String[] args) {
		
		//Graph[] gSet = tools.buildNegWeightTestGraphs();
		Graph[] gSet = tools.buildWeightedTestGraphs();
		FW_Result fW;
		ArrayList<String> path;
		
		Graph z = gSet[0];
		//System.out.println("Graph z: \n" + z.toString());
		String source = "E";
		String destination = "C";
		
		System.out.printf("Graph 0");
		fW = getAllPairsShortestPath(z);
		path = getPath(fW, source, destination);
		System.out.printf("\nShortest path from %s to %s is: %s\n", source, destination, path.toString());
		
		z = gSet[1];
		//System.out.println("Graph z: \n" + z.toString());
		source = "A";
		destination = "E";
		
		System.out.printf("Graph 1");
		fW = getAllPairsShortestPath(z);
		path = getPath(fW, source, destination);
		System.out.printf("\nShortest path from %s to %s is: %s\n", source, destination, path.toString());
		
		z = gSet[2];
		//System.out.println("Graph z: \n" + z.toString());
		source = "D";
		destination = "A";
		
		System.out.printf("Graph 2");
		fW = getAllPairsShortestPath(z);
		path = getPath(fW, source, destination);
		System.out.printf("\nShortest path from %s to %s is: %s\n", source, destination, path.toString());
		
		z = gSet[3];
		//System.out.println("Graph z: \n" + z.toString());
		source = "A";
		destination = "F";
		
		System.out.printf("Graph 3");
		fW = getAllPairsShortestPath(z);
		path = getPath(fW, source, destination);
		System.out.printf("\nShortest path from %s to %s is: %s\n", source, destination, path.toString());
		
	}
	
	public static FW_Result getAllPairsShortestPath(Graph g) {
		
		ArrayList<Vertex> Q = g.getVertices();
		ArrayList<Edge> edges = g.getEdges();
		int n = g.getSize();
		FW_Result fW = new FW_Result(n);
		
		for (int i = 0; i < n; ++i) {
			fW.labelToIndex.put(Q.get(i).label, i);
		}
		
		for (int i = 0; i < n; ++i) {
			fW.indexToLabel.put(i, Q.get(i).label);
		}
		
		//add all direct paths to scores table, and
		//add all direct paths to successors table
		for (int i = 0; i < edges.size(); ++i) {
			
			Edge e = edges.get(i);
			int j = fW.labelToIndex.get(e.source.label);
			int k = fW.labelToIndex.get(e.destination.label);
			fW.scores[j][k] = e.value;
			fW.successors[j][k] = e.destination;
		}
		//printFWTables(fW, n);
		
		for (int k = 0; k < n; ++k) {
			for (int  i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					
					//int scoreThruK = 0;
					//if (i != j)
					int scoreThruK = addCosts(fW.scores[i][k], fW.scores[k][j]);
					
					//System.out.println("scoreThruK:" + scoreThruK);
					if (scoreThruK < fW.scores[i][j]) {
						fW.scores[i][j] = scoreThruK;
						fW.successors[i][j] = fW.successors[i][k];
					}
				}
			}
			//System.out.printf("Iteration %d\n\n", k);
			//printFWTables(fW, n);
		}
		printFWTables(fW, n);
		
		return fW;
	}
	
	private static int addCosts(int a, int b) {
		  
		//System.out.printf("a: %d --- b: %d\n", a, b);
		
		if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return a + b;
	}
	
	private static void printFWTables(FW_Result fW, int n) {
		
		int i;
		//Scores
		System.out.printf(" \t ");
		for (i = 0; i < n; ++i)
			System.out.printf("%s  ", fW.indexToLabel.get(i));
		System.out.printf("\n");
		for (i = 0; i < n; ++i)
			System.out.printf("%s\t%s\n", fW.indexToLabel.get(i), Arrays.toString(fW.scores[i]));
		//Successors
		System.out.printf(" \t ");
		for (i = 0; i < n; ++i)
			System.out.printf("%s  ", fW.indexToLabel.get(i));
		System.out.printf("\n");
		for (i = 0; i < n; ++i)
			System.out.printf("%s\t%s\n", fW.indexToLabel.get(i), Arrays.toString(fW.successors[i]));
	}
	
	private static ArrayList<String> getPath(FW_Result fW, String source, String destination) {
		
		int i = fW.labelToIndex.get(source);
		int j = fW.labelToIndex.get(destination);
		
		if (fW.successors[i][j] == null)
			return null;
		
		ArrayList<String> path = new ArrayList<String>();
		path.add(source);
		
		while (i != j) {
			
			i = fW.labelToIndex.get(fW.successors[i][j].label);
			path.add(fW.indexToLabel.get(i));
		}
		
		return path;
	}
}






