package GraphLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import util.tools;

public class Bellman_Ford {

	public static void main(String[] args) {
		
		Graph[] gSet = tools.buildNegWeightTestGraphs();
		
		Graph z = gSet[0];
		//System.out.println("Graph z: \n" + z.toString());
		Vertex s = z.getVertex("S");
		Vertex g = z.getVertex("G");
		
		HashMap<Vertex, Vertex> spTree = shortestPathTree(z, s);
		System.out.println("SPTree0:" + spTree.toString());
		System.out.printf("Map says the best way from %s to %s is: %s\n\n", s.label, g.label, shortestPath(spTree, s, g) );
	}
	
	public static HashMap<Vertex, Vertex> shortestPathTree(Graph g, Vertex u) {
		
		ArrayList<Vertex> Q = g.getVertices();
		HashMap<Vertex, Vertex> spTree = new HashMap<Vertex, Vertex>();
		
		//initialize the scores of each Vertex
		HashMap<Vertex, Integer> scores = new HashMap<Vertex, Integer>();
		u.explored = true;
		Q.remove(u);
		
		ArrayList<Vertex> verts = g.getVertices();
		Iterator<Vertex> vIterator = verts.iterator();
		while (vIterator.hasNext())
			scores.put(vIterator.next(), Integer.MAX_VALUE);
		scores.put(u, 0);
		
		ArrayList<Edge> edges = g.getEdges();
		
		int numV = verts.size(), numE = edges.size();
		for (int i = 1; i < numV; ++i) {
			for (int j = 0; j < numE; ++j) {
				
				if ( !Q.contains(edges.get(j).destination))
					continue;
				
				System.out.println("Examining Edge: " + edges.get(j));
				Vertex v = edges.get(j).source;
				Vertex w = edges.get(j).destination;
				int weight = edges.get(j).value;
				int alt = scores.get(v) + weight;
				
				if (scores.get(v) != Integer.MAX_VALUE && alt < scores.get(w) ) {
					
					scores.put(w, alt);
					spTree.put(w, v);
					Q.remove(v);
				}
				System.out.println("New scores: " + scores.toString());
				System.out.println("spTree so far: " + spTree.toString()  + "\n");
			}
		}
		
		return spTree;
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
