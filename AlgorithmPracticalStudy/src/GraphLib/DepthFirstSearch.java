package GraphLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import util.tools;

public class DepthFirstSearch {

	public static void main(String[] args) {

		Graph[] gSet = tools.buildTestGraphs();
		
		Graph z = gSet[0];
		Vertex s = z.getVertex("S");
		Vertex a = z.getVertex("A");
		
		HashMap<Vertex, Vertex> dfsTree = getdfsTree(z, s);
		System.out.println("dfsTree0: " + dfsTree.toString());
		LinkedList<Vertex> path = getPath(dfsTree, s, a);
		System.out.println("Path from S to G is:" + path.toString());
		
		z = gSet[1];		
		s = z.getVertex("S");
		Vertex d = z.getVertex("D");
		
		dfsTree = getdfsTree(z, s);
		System.out.println("dfsTree1: " + dfsTree.toString());
		path = getPath(dfsTree, s, d);
		System.out.println("Path from S to D is:" + path.toString());
		
		z = gSet[2];		
		d = z.getVertex("D");
		Vertex g = z.getVertex("G");
		
		dfsTree = getdfsTree(z, g);
		System.out.println("dfsTree2: " + dfsTree.toString());
		
		path = getPath(dfsTree, g, d);
		System.out.println("Path from G to D is:" + path.toString());
		
		z = gSet[3];	
		//System.out.println("Graph z: \n" + z.toString());
		d = z.getVertex("D");
		Vertex f = z.getVertex("F");
		
		dfsTree = getdfsTree(z, d);
		System.out.println("dfsTree3: " + dfsTree.toString());
		
		path = getPath(dfsTree, d, f);
		System.out.println("Path from D to F is:" + path.toString());
	}
	
	public static HashMap<Vertex, Vertex> getdfsTree(Graph g, Vertex u) {
		
		LinkedList<Vertex> Q = new LinkedList<Vertex>();
		HashMap<Vertex, Vertex> tree = new HashMap<Vertex, Vertex>();
		
		u.explored = true;
		Q.addFirst(u);
		while ( !Q.isEmpty() ) {
			
			Vertex v = Q.getLast();
			ArrayList<Edge> neighbors = g.getAdjacent(v);
			
			for (int i = neighbors.size() - 1; i >= 0; --i) {
				
				Vertex w = neighbors.get(i).destination;
				//System.out.printf("v: %s w: %s\n", v.label, w.label);
				System.out.println(Q.toString());
				/*if(w.equals(u))
					System.out.println("Cycle detected");*/
				
				if (w.explored == false) {
					
					w.explored = true;
					Q.addLast(w);
					tree.put(w, v);
					
					break;
				}
				
				if (i == 0)
					Q.removeLast();
			}
		}
		return tree;
	}
	
	public static LinkedList<Vertex> getPath(HashMap<Vertex, Vertex> bfsTree, Vertex root, Vertex destination) {
		
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		
		path.add(destination);
		Vertex parent = bfsTree.get(destination);
		while ( !parent.equals(root) ) {
			
			path.addFirst(parent);
			parent = bfsTree.get(parent);
		}
		path.addFirst(root);
		
		return path;
	}

}
