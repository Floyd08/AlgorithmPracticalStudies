package GraphLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import util.tools;

public class Prim {

	public static void main(String[] args) {
		
		Graph[] gSet = tools.buildWeightedTestGraphs();
		
		Graph z = gSet[0];
		Vertex s = z.getVertex("S");
		
		HashMap<Vertex, Vertex> MST = MST(z, s);
		System.out.println("MST0:" + MST.toString());
		
		z = gSet[1];
		s = z.getVertex("S");
		
		MST = MST(z, s);
		System.out.println("MST1:" + MST.toString());
		
		z = gSet[2];
		Vertex g = z.getVertex("G");
		
		MST = MST(z, g);
		System.out.println("MST2:" + MST.toString());
		
		z = gSet[3];
		Vertex a = z.getVertex("A");
		
		MST = MST(z, a);
		System.out.println("MST3:" + MST.toString());
	}
	
	public static HashMap<Vertex, Vertex> MST(Graph g, Vertex u) {
		
		ArrayList<Vertex> Q = g.getVertices();
		ArrayList<Vertex> S = new ArrayList<Vertex>();
		
		HashMap<Vertex, Vertex> MST = new HashMap<Vertex, Vertex>();
		u.explored = true;
		Q.remove(u);
		S.add(u);
		HashSet<Edge> AllNeighbors = new HashSet<Edge>(g.getAdjacent(u));
		
		while ( !Q.isEmpty() ) {
			
			Edge e = getLightest(AllNeighbors);
			u = e.source;
			Vertex v = e.destination;
			//System.out.println("u: " + u.toString() + " v: " + v.toString());
			//System.out.println("CurrentNeighbors: " + AllNeighbors.toString())
			if (v.explored == false) {
				
				AllNeighbors.addAll( getNewNeighbors(Q, g, v) );
				v.explored = true;
				Q.remove(v);
				S.add(v);
				MST.put(v, u);
			}
			AllNeighbors.remove(e);		
			///System.out.println("NewNeighbors: " + AllNeighbors.toString() + "\n");
		}
		
		return MST;
	}
	
	public static Edge getLightest(HashSet<Edge> AllNeighbors) {
		
		Iterator<Edge> eI = AllNeighbors.iterator();
		Edge min = null;
		
		while (eI.hasNext()) {
			
			Edge e = eI.next();
			if (min == null || min.value > e.value)
				min = e;
		}
		return min;
	}
	
	public static ArrayList<Edge> getNewNeighbors(ArrayList<Vertex> Q, Graph g, Vertex v) {
		
		ArrayList<Edge> neighbors = g.getAdjacent(v);
		for (int i = neighbors.size() - 1; i >= 0; --i) {
			
			Edge e = neighbors.get(i);
			if ( !Q.contains(e.destination) ) {
				
				neighbors.remove(e);
			}
		}
		return neighbors;
	}

}
