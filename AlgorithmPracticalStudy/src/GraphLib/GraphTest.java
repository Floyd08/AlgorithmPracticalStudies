package GraphLib;

import java.util.ArrayList;

public class GraphTest {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		
		System.out.println("Is g empty?");
		System.out.println(g.isEmpty());
		
		Vertex v = new Vertex("A");
		g.addVertex(v);
		
		System.out.println("Is g empty?");
		System.out.println(g.isEmpty());
		
		System.out.println(g.toString());
		
		v = new Vertex("B");
		g.addVertex(v);
		v = new Vertex("C");
		g.addVertex(v);
		
		System.out.println(g.toString());
		
		g.addEdge(g.getVertex("A"), g.getVertex("B"));
		g.addEdge(g.getVertex("B"), g.getVertex("C"));
		g.addEdge(g.getVertex("C"), g.getVertex("A"));
		
		System.out.println(g.toString());
		
		System.out.println("Vertices in g: " + g.getVertices().toString());
		System.out.println("Size of g: " + g.getSize());
		
		ArrayList<Vertex> verts = g.getVertices();
		v = new Vertex("D");
		g.addVertex(v, verts);
		
		System.out.println("Vertices in g: " + g.getVertices().toString());
		System.out.println("Size of g: " + g.getSize());
		
		System.out.println(g.toString());
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		
		Edge e1 = new Edge(a, b);
		Edge e2 = new Edge(a, b);
		
		boolean bool = e1.equals(e2);
		System.out.println("Are e1 and e2 equal: " + bool);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(e1);
		System.out.println("Does edges contain e1: " + edges.contains(e1));
		
		System.out.println("Edges of the graph are: " + g.edges.toString() );
		System.out.println("Unique Edges of the graph are: " + g.getUniqueEdges());
	}

}
