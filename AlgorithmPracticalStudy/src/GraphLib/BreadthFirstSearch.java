package GraphLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import TreeLib.treeNode;
import util.tools;

public class BreadthFirstSearch {

	public static void main(String[] args) {
				
		Graph[] gSet = tools.buildTestGraphs();
		Graph z = gSet[0];
		//System.out.println("Graph z: \n" + z.toString());
		Vertex s = z.getVertex("S");
		Vertex g = z.getVertex("G");
		
		HashMap<Vertex, Vertex> bfsTree = getbfsTree(z, s);
		System.out.println("bfsTree0: " + bfsTree.toString());
		
		LinkedList<Vertex> shortest = shortestPath(bfsTree, s, g);
		System.out.println("Shortest path from S to G is:" + shortest.toString());
		
		z = gSet[1];		
		//System.out.println("Graph z: \n" + z.toString());
		s = z.getVertex("S");
		Vertex e = z.getVertex("E");
		
		bfsTree = getbfsTree(z, s);
		System.out.println("bfsTree1: " + bfsTree.toString());
		
		shortest = shortestPath(bfsTree, s, e);
		System.out.println("Shortest path from S to E is:" + shortest.toString());
		
		z = gSet[2];		
		//System.out.println("Graph z: \n" + z.toString());
		Vertex d = z.getVertex("D");
		g = z.getVertex("G");
		
		bfsTree = getbfsTree(z, g);
		System.out.println("bfsTree2: " + bfsTree.toString());
		
		shortest = shortestPath(bfsTree, g, d);
		System.out.println("Shortest path from G to D is:" + shortest.toString());
		
		z = gSet[3];	
		//System.out.println("Graph z: \n" + z.toString());
		d = z.getVertex("D");
		Vertex f = z.getVertex("F");
		
		bfsTree = getbfsTree(z, d);
		System.out.println("bfsTree3: " + bfsTree.toString());
		
		shortest = shortestPath(bfsTree, d, f);
		System.out.println("Shortest path from D to F is:" + shortest.toString());
		
	}
	
	public static HashMap<Vertex, Vertex> getbfsTree(Graph g, Vertex u) {
		
		LinkedList<Vertex> Q = new LinkedList<Vertex>();
		HashMap<Vertex, Vertex> tree = new HashMap<Vertex, Vertex>();
		
		u.explored = true;
		Q.addFirst(u);
		while ( !Q.isEmpty() ) {
			
			Vertex v = Q.removeLast();
			
			ArrayList<Edge> neighbors = g.getAdjacent(v);
			for (int i = neighbors.size() - 1; i >= 0; --i) {
				
				Vertex w = neighbors.get(i).destination;
				if (w.explored == false) {
					
					w.explored = true;
					Q.addFirst(w);
					tree.put(w, v);
				}
			}	
		}
		return tree;	
	}
	
	public static LinkedList<Vertex> shortestPath(HashMap<Vertex, Vertex> bfsTree, Vertex root, Vertex destination) {
		
		LinkedList<Vertex> shortestPath = new LinkedList<Vertex>();
		
		shortestPath.add(destination);
		Vertex parent = bfsTree.get(destination);
		while ( !parent.equals(root) ) {
			
			shortestPath.addFirst(parent);
			parent = bfsTree.get(parent);
		}
		shortestPath.addFirst(root);
		
		return shortestPath;
	}

	
	
	
	
	
	
	
	
	
	
	
}
