package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;
import GraphLib.Graph;
import GraphLib.Vertex;

public class tools {

	// Ain't nobody instantiatin' this here class. 
	private tools() {}
	
	
	//It swaps, yo. Whatchu think it would do?
	public static void swap(int array[], int a, int b) {
		
		int basket = array[a];
		array[a] = array[b];
		array[b] = basket;
	}
	
	/*
		Generates a test set of random integers, given the length, min value, and max value of that set
	*/
	public static int[] getTestSet(int length, int min, int max) {
		
		Random geny = new Random();
		IntStream pop = geny.ints(length, min, max);
		
		return pop.toArray();
	}
	
	public static int[] getUniqueTestSet(int length, int min, int max) {
		
		Random geny = new Random();
		IntStream pop = geny.ints(length, min, max).distinct();
		
		return pop.toArray();
	}
	
	/*
	 * Validates a sorted array. For now we assume sorted refers to non-decreasing order
	 */
	public static boolean validate(int[] array) {
		
		boolean b = true;
		
		for (int i = 0; i < array.length - 1; ++i) {
			b = b && (array[i] <= array[i + 1]);
		}
			
		return b;
	}
	
	public static int partition (int[] array, int first, int pivot) {
		
		int j = first, i = j - 1;
		
		while (j < array.length) {
			
			if (array[j] < array[pivot]) {
				++i;
				tools.swap(array, i, j);
			}
			++j;
		}
		++i; 
		tools.swap(array, i, pivot);
		
		return i;
	}
	
	public static Graph[] buildTestGraphs() {
		
		//Graph Generator: https://www.khanacademy.org/computer-programming/generate-random-graph/5061540786995200
		
		Graph[] gSet = new Graph[4];
		
		Graph z = new Graph();
		
		ArrayList<Vertex> connected = new ArrayList<Vertex>();
		
		//Construct a graph0	
		Vertex a = new Vertex("A");
		z.addVertex(a);
		connected.add(a);
		Vertex b = new Vertex("B");
		z.addVertex(b);
		connected.add(b);
		Vertex c = new Vertex("C");
		z.addVertex(c);
		connected.add(c);
		
		Vertex s = new Vertex("S");
		z.addVertex(s, connected);
		
		connected.clear();
		
		Vertex d = new Vertex("D");
		z.addVertex(d);
		connected.add(d);
		Vertex e = new Vertex("E");
		z.addVertex(e);
		connected.add(e);
		Vertex f = new Vertex("F");
		z.addVertex(f);
		connected.add(f);
		
		Vertex g = new Vertex("G");
		z.addVertex(g, connected);
		
		z.addEdge(a, d);
		z.addEdge(b, e);
		z.addEdge(c, f);
		
		gSet[0] = z;
		
		//Construct a graph1	
		z = new Graph();
		connected.clear();
		
		b = new Vertex("B");
		z.addVertex(b);
		
		d = new Vertex("D");
		z.addVertex(d);
		z.addEdge(b, d);
		
		c = new Vertex("C");
		z.addVertex(c);
		z.addEdge(b, c);
		
		connected.add(d);
		connected.add(b);
		connected.add(c);
		
		e = new Vertex("E");
		z.addVertex(e, connected);
		
		connected.remove(c);
		a = new Vertex("A");
		z.addVertex(a, connected);
		
		s = new Vertex("S");
		z.addVertex(s);
		z.addEdge(a, s);
		z.addEdge(s,  c);
		
		gSet[1] = z;
		
		//Construct a graph2
		z = new Graph();
		connected.clear();
		
		d = new Vertex("D");
		z.addVertex(d);
		connected.add(d);
		e = new Vertex("E");
		z.addVertex(e);
		connected.add(e);
		c = new Vertex("C");
		z.addVertex(c);
		connected.add(c);
		
		f = new Vertex("F");
		z.addVertex(f, connected);
		
		connected.clear();
		
		g = new Vertex("G");
		z.addVertex(g);
		connected.add(g);
		a = new Vertex("A");
		z.addVertex(a);
		connected.add(a);
		connected.add(e);
		
		b = new Vertex("B");
		z.addVertex(b, connected);
		z.addEdge(a, c);
		
		gSet[2] = z;
		
		//Construct a graph3
		z = new Graph();
		connected.clear();
		
		b = new Vertex("B");
		z.addVertex(b);
		connected.add(b);
		d = new Vertex("D");
		z.addVertex(d);
		connected.add(d);
		e = new Vertex("E");
		z.addVertex(e);
		connected.add(e);
		c = new Vertex("C");
		z.addVertex(c);
		connected.add(c);
		
		a = new Vertex("A");
		z.addVertex(a, connected);
		f = new Vertex("F");
		z.addVertex(f, connected);
		
		z.addEdge(b, d);
		z.addEdge(d, e);
		z.addEdge(d, c);
		
		gSet[3] = z;
		
		return gSet;
	}

	public static Graph[] buildWeightedTestGraphs() {
		
		Graph[] gSet = new Graph[4];
		
		Graph z = new Graph();
		
		Vertex s = new Vertex("S");
		z.addVertex(s);
		Vertex a = new Vertex("A");
		z.addVertex(a);
		Vertex b = new Vertex("B");
		z.addVertex(b);
		Vertex c = new Vertex("C");
		z.addVertex(c);
		Vertex d = new Vertex("D");
		z.addVertex(d);
		Vertex e = new Vertex("E");
		z.addVertex(e);
		Vertex f = new Vertex("F");
		z.addVertex(f);
		Vertex g = new Vertex("G");
		z.addVertex(g);
		
		z.addEdge(s, a, 3);
		z.addEdge(s, b, 2);
		z.addEdge(s, c, 6);
		z.addEdge(a, d, 7);
		z.addEdge(b, e, 10);
		z.addEdge(c, f, 1);
		z.addEdge(d, g, 2);
		z.addEdge(e, g, 3);
		z.addEdge(f, g, 5);
		
		gSet[0] = z;
		
		z = new Graph();
		
		s = new Vertex("S");
		z.addVertex(s);
		a = new Vertex("A");
		z.addVertex(a);
		b = new Vertex("B");
		z.addVertex(b);
		c = new Vertex("C");
		z.addVertex(c);
		d = new Vertex("D");
		z.addVertex(d);
		e = new Vertex("E");
		z.addVertex(e);
		
		z.addEdge(s, a, 2);
		z.addEdge(s, c, 1);
		z.addEdge(a, b, 6);
		z.addEdge(a, d, 9);
		z.addEdge(b, c, 2);
		z.addEdge(b, d, 1);
		z.addEdge(b, e, 5);
		z.addEdge(c, e, 8);
		z.addEdge(d, e, 5);
		
		gSet[1] = z;
		
		z = new Graph();
		
		a = new Vertex("A");
		z.addVertex(a);
		b = new Vertex("B");
		z.addVertex(b);
		c = new Vertex("C");
		z.addVertex(c);
		d = new Vertex("D");
		z.addVertex(d);
		e = new Vertex("E");
		z.addVertex(e);
		f = new Vertex("F");
		z.addVertex(f);
		g = new Vertex("G");
		z.addVertex(g);
		
		z.addEdge(g, b, 1);
		z.addEdge(b, a, 3);
		z.addEdge(a, c, 8);
		z.addEdge(c, f, 3);
		z.addEdge(b, e, 2);
		z.addEdge(e, f, 2);
		z.addEdge(f, d, 4);
		
		gSet[2] = z;
		
		z = new Graph();
		
		a = new Vertex("A");
		z.addVertex(a);
		b = new Vertex("B");
		z.addVertex(b);
		c = new Vertex("C");
		z.addVertex(c);
		d = new Vertex("D");
		z.addVertex(d);
		e = new Vertex("E");
		z.addVertex(e);
		f = new Vertex("F");
		z.addVertex(f);
		
		z.addEdge(a, b, 8);
		z.addEdge(a, d, 5);
		z.addEdge(a, e, 4);
		z.addEdge(a, c, 8);
		z.addEdge(b, f, 4);
		z.addEdge(b, d, 7);
		z.addEdge(d, c, 10);
		z.addEdge(d, f, 2);
		z.addEdge(d, e, 5);
		z.addEdge(c, f, 3);
		z.addEdge(e, f, 10);
		
		gSet[3] = z;
		
		return gSet;
	}
	
public static Graph[] buildNegWeightTestGraphs() {
		
		Graph[] gSet = new Graph[4];
		
		Graph z = new Graph();
		
		Vertex s = new Vertex("S");
		z.addVertex(s);
		Vertex a = new Vertex("A");
		z.addVertex(a);
		Vertex b = new Vertex("B");
		z.addVertex(b);
		Vertex c = new Vertex("C");
		z.addVertex(c);
		Vertex d = new Vertex("D");
		z.addVertex(d);
		Vertex e = new Vertex("E");
		z.addVertex(e);
		Vertex f = new Vertex("F");
		z.addVertex(f);
		Vertex g = new Vertex("G");
		z.addVertex(g);
		
		z.addEdge(s, a, -3);
		z.addEdge(s, b, 5);
		z.addEdge(s, c, 3);
		z.addEdge(a, d, 7);
		z.addEdge(b, e, -4);
		z.addEdge(c, f, -2);
		z.addEdge(d, g, 6);
		z.addEdge(e, g, 2);
		z.addEdge(f, g, -1);
		
		gSet[0] = z;
		
//		z = new Graph();
//		
//		s = new Vertex("S");
//		z.addVertex(s);
//		a = new Vertex("A");
//		z.addVertex(a);
//		b = new Vertex("B");
//		z.addVertex(b);
//		c = new Vertex("C");
//		z.addVertex(c);
//		d = new Vertex("D");
//		z.addVertex(d);
//		e = new Vertex("E");
//		z.addVertex(e);
//		
//		z.addEdge(s, a, 2);
//		z.addEdge(s, c, 1);
//		z.addEdge(a, b, 6);
//		z.addEdge(a, d, 9);
//		z.addEdge(b, c, 2);
//		z.addEdge(b, d, 1);
//		z.addEdge(b, e, 5);
//		z.addEdge(c, e, 8);
//		z.addEdge(d, e, 5);
//		
//		gSet[1] = z;
//		
//		z = new Graph();
//		
//		a = new Vertex("A");
//		z.addVertex(a);
//		b = new Vertex("B");
//		z.addVertex(b);
//		c = new Vertex("C");
//		z.addVertex(c);
//		d = new Vertex("D");
//		z.addVertex(d);
//		e = new Vertex("E");
//		z.addVertex(e);
//		f = new Vertex("F");
//		z.addVertex(f);
//		g = new Vertex("G");
//		z.addVertex(g);
//		
//		z.addEdge(g, b, 1);
//		z.addEdge(b, a, 3);
//		z.addEdge(a, c, 8);
//		z.addEdge(c, f, 3);
//		z.addEdge(b, e, 2);
//		z.addEdge(e, f, 2);
//		z.addEdge(f, d, 4);
//		
//		gSet[2] = z;
//		
//		z = new Graph();
//		
//		a = new Vertex("A");
//		z.addVertex(a);
//		b = new Vertex("B");
//		z.addVertex(b);
//		c = new Vertex("C");
//		z.addVertex(c);
//		d = new Vertex("D");
//		z.addVertex(d);
//		e = new Vertex("E");
//		z.addVertex(e);
//		f = new Vertex("F");
//		z.addVertex(f);
//		
//		z.addEdge(a, b, 8);
//		z.addEdge(a, d, 5);
//		z.addEdge(a, e, 4);
//		z.addEdge(a, c, 8);
//		z.addEdge(b, f, 4);
//		z.addEdge(b, d, 7);
//		z.addEdge(d, c, 10);
//		z.addEdge(d, f, 2);
//		z.addEdge(d, e, 5);
//		z.addEdge(c, f, 3);
//		z.addEdge(e, f, 10);
//		
//		gSet[3] = z;
		
		return gSet;
	}
	
	public static Graph generateGraph(int nodes) {
		
		Random geny = new Random();
		
		if (nodes < 0)
			nodes = geny.nextInt(1, nodes);
		
		Graph g = new Graph();
		
		for (int i = 0; i < nodes; ++i) {
			Vertex v = new Vertex(new String("" + (i + "A")));
		}
		
		for (int i = 0; i < nodes; ++i) {
			//generate the edges or some shit
		}
		
		return g;
		
	}
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
