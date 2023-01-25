package Misc;

import util.tools;

//A simple class to create objects with weight and value

public class Ingot implements Comparable<Ingot>{

	int weight, value;
	
	//default contructor
	public Ingot() {
		this.weight = 0;
		this.weight = 0;
	}
	
	public Ingot(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	//returns an array of Ingots, to test knapSack.java
	public static Ingot[] getTestIngots(int length) {
		
		int minA = 0, maxA = 20;		//Weight constants
		int minB = 0, maxB = 40;		//Value constants
		
		int[] A = tools.getTestSet(length, minA, maxA);
		int[] B = tools.getTestSet(length, minB, maxB);
		Ingot[] testV = new Ingot[length];
		
		while (length > 0) {
			
			--length;
			testV[length] = new Ingot(A[length], B[length]);
		}
		
		return testV;
	}
	@Override
	public String toString() {
		
		return new String("(" + this.weight + ", " + this.value + ")");
	}
	
	@Override
	public int compareTo(Ingot i) {
		
		if (this.weight == i.weight)
			return 0;
		else if (this.weight > i.weight)
			return 1;
		else
			return -1;
	}
	
}
