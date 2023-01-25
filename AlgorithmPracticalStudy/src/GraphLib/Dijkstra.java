package GraphLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import util.tools;

public class Dijkstra {

	public static void main(String[] args) {
		
		Graph[] gSet = tools.buildWeightedTestGraphs();
		
		Graph z = gSet[0];
		//System.out.println("Graph z: \n" + z.toString());
		Vertex s = z.getVertex("S");
		Vertex g = z.getVertex("G");
		
		HashMap<Vertex, Vertex> spTree = shortestPathTree(z, s);
		System.out.println("SPTree0:" + spTree.toString());
		System.out.printf("Map says the best way from %s to %s is: %s\n\n", s.label, g.label, shortestPath(spTree, s, g) );
		
		z = gSet[1];
		//System.out.println("Graph z: \n" + z.toString());
		s = z.getVertex("S");
		Vertex e = z.getVertex("E");
		
		spTree = shortestPathTree(z, s);
		System.out.println("SPTree1:" + spTree.toString());
		System.out.printf("Map says the best way from %s to %s is: %s\n\n", s.label, e.label, shortestPath(spTree, s, e) );
		
		z = gSet[2];
		//System.out.println("Graph z: \n" + z.toString());
		g = z.getVertex("G");
		Vertex d = z.getVertex("D");
		
		spTree = shortestPathTree(z, g);
		System.out.println("SPTree2:" + spTree.toString());
		System.out.printf("Map says the best way from %s to %s is: %s\n\n", g.label, d.label, shortestPath(spTree, g, d) );
		
		z = gSet[3];
		//System.out.println("Graph z: \n" + z.toString());
		Vertex a = z.getVertex("A");
		Vertex f = z.getVertex("F");
		
		spTree = shortestPathTree(z, a);
		System.out.println("SPTree3:" + spTree.toString());
		System.out.printf("Map says the best way from %s to %s is: %s\n\n", a.label, f.label, shortestPath(spTree, a, f) );
	}
	
	public static HashMap<Vertex, Vertex> shortestPathTree(Graph g, Vertex u) {
		
		ArrayList<Vertex> Q = g.getVertices();
		HashMap<Vertex, Vertex> spTree = new HashMap<Vertex, Vertex>();
		
		//initialize the scores of each Vertex
		HashMap<Vertex, Integer> scores = new HashMap<Vertex, Integer>();
		
		ArrayList<Vertex> verts = g.getVertices();
		Iterator<Vertex> vIterator = verts.iterator();
		while (vIterator.hasNext())
			scores.put(vIterator.next(), Integer.MAX_VALUE);
		scores.put(u, 0);
		
		while ( !Q.isEmpty() ) {
			
			Vertex v = getMinScore(scores, Q);
			v.explored = true;
			Q.remove(v);
			
			ArrayList<Edge> neighbors = g.getAdjacent(v);
			for (int i = neighbors.size() - 1; i >= 0; --i) {
				
				Vertex w = neighbors.get(i).destination;
				//System.out.printf("Checking edge running from %s to %s, whose weight is: %d \n", v.label, w.label, neighbors.get(i).value );
				Integer alt = scores.get(v) + neighbors.get(i).value;
				
				if (alt < scores.get(w)) {
					
					scores.put(w, alt);
					spTree.put(w, v);
				}
				//System.out.println("New scores: " + scores.toString() + "\n");
				//System.out.println("spTree so far: " + spTree.toString());
			}
		}
		//System.out.println("Final scores: " + scores.toString());
		
		return spTree;
	}
	
	public static Vertex getMinScore(HashMap<Vertex, Integer> scores, ArrayList<Vertex> Q) {
		
		Iterator<Vertex> vI = Q.iterator();
		Vertex min = null;
		
		while (vI.hasNext()) {
			
			Vertex v = vI.next();
			if (min == null || scores.get(min) > scores.get(v))
				min = v;
		}
		return min;
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
