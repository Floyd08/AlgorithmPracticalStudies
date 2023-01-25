package GraphLib;

public class Edge implements Comparable<Edge> {

	Vertex source, destination;			//For undirected graphs, it will be neccesary to double up
	int value;							//for unweighted graph, all edges have value 0
	
	//Default constructor
	
	public Edge(Vertex a, Vertex b) {				//creates and edge leading to the Vertex a
		
		source = a;
		destination = b;
		value = 0;
	}
	
	public Edge(Vertex a, Vertex b, int weight) {
		
		source = a;
		destination = b;
		value = weight;
	}
	
	@Override
	public String toString() {
		
		String result = this.source + "," + this.destination;
		if (value != 0)
			result += "(" + value + ")";
		
		return result;
	}
	@Override
	public boolean equals(Object edge) {
		
		Edge e2 = (Edge) edge;
		
		if (this.source.label == e2.source.label && this.destination.label == e2.destination.label)
			return true;
		
		return false;
	}
	
	//A limited override of compareTo. It merely checks equivalence of e1(this) and e2
	//Returns 0 on equivalence, -1 otherwise
	//Now made redundant by the overriden equals method above. Perhaps useful in future
	@Override
	public int compareTo(Edge e2) {
		
		int i = -1;
		
		if (this.source.label == e2.source.label && this.destination.label == e2.destination.label)
			i = 0;
		
		return i;
	}
	
}
