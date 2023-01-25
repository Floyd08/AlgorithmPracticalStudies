package GraphLib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Graph {

	Map<Vertex, ArrayList<Edge> > graph = new HashMap<Vertex, ArrayList<Edge> >();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	//Default constructor
	public Graph() {}
	
	public boolean isEmpty() {
		
		if (graph.isEmpty())
			return true;
		
		return false;
	}
	
	public int getSize() {
		
		return graph.size();
	}
	
	public void addVertex(Vertex a) {
		
		graph.put(a, new ArrayList<Edge>());
	} 
	
	public void addVertex(Vertex a, ArrayList<Vertex> connected) {			//adds a vertex to the graph, and connects it to the vertices of connected
		
		graph.put(a, new ArrayList<Edge>());
		
		Iterator<Vertex> verts = connected.iterator();
		while (verts.hasNext()) {
			
			Vertex v = verts.next();
			this.addEdge(a, v);
		}
	}
	
	public void addEdge(Vertex a, Vertex b) {				//creates two edges, a -> b, and b -> a
		
		Edge AtoB = new Edge(a, b);
		Edge BtoA = new Edge(b, a);
				
		graph.get(a).add(AtoB);
		if ( !edges.contains(AtoB) ) 
			edges.add(AtoB);
		
		graph.get(b).add(BtoA);
		if ( !edges.contains(BtoA) ) 
			edges.add(BtoA);
	}
	
	public void addEdge(Vertex a, Vertex b, int weight) {
		
		Edge AtoB = new Edge(a, b, weight);
		Edge BtoA = new Edge(b, a, weight);
				
		graph.get(a).add(AtoB);
		if ( !edges.contains(AtoB) ) 
			edges.add(AtoB);
		
		graph.get(b).add(BtoA);
		if ( !edges.contains(BtoA) ) 
			edges.add(BtoA);
	}
	
	public void addDirectedEdge(Vertex a, Vertex b) {	//creates one edge, a -> b
		
		Edge AtoB = new Edge(a, b);
		
		graph.get(a).add(AtoB);
		if ( !edges.contains(AtoB) ) 
			edges.add(AtoB);
	}
	
	public void addDirectedEdge(Vertex a, Vertex b, int weight) {
		
		Edge AtoB = new Edge(a, b, weight);
		
		graph.get(a).add(AtoB);
		if ( !edges.contains(AtoB) ) 
			edges.add(AtoB);
	}
	
	public Vertex getVertex(String label) {
		
		Iterator<Vertex> labels = graph.keySet().iterator();
		while (labels.hasNext()) {
			
			Vertex v = labels.next();
			if (v.label.equals(label) )
				return v;
		}
		return null;
	}
	
	public ArrayList<Vertex> getVertices() {
		
		return new ArrayList<Vertex>(graph.keySet());
	}
	
	public ArrayList<Edge> getEdges() {
		
		return edges;
	}
	
	public ArrayList<Edge> getUniqueEdges() {
		
		ArrayList<Edge> allEdges = edges;
		for (int i = allEdges.size() - 1; i >= 0; --i) {
			
			Edge e = allEdges.get(i);
			for (int j = allEdges.size() - 1; j >= 0; --j) {
				
				Edge f = allEdges.get(j);
				if (f.source == e.destination && f.destination == e.source)
					allEdges.remove(f);
			}
		}
		return allEdges;
	}
	
	public ArrayList<Edge> getAdjacent(Vertex a) {
		
		return graph.get(a);
	}
	
	@Override
	public String toString() {
		
		String result = "";
		
		ArrayList<Vertex> vertices = this.getVertices();
		for (int i = 0; i < vertices.size(); ++i) {
			
			result += vertices.get(i).toString() + " ";
			result += "Leads to: " + graph.get(vertices.get(i)).toString() + "\n";
		}
		
		return result;
	}
	
}






