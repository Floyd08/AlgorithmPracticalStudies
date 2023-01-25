package GraphLib;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	String label;
	boolean explored;
	
	//Default constructor
	public Vertex(String name) {								//initializes an unconnected Vertex
		
		this.label = name;
		explored = false;
	}
	
	@Override
	public String toString() {
		
		return "" + this.label;
	}
	
	// returns the edge connection a to b
	/*public Edge getEdge(Vertex a, Vertex b) {
		
		
	}*/
	
}
