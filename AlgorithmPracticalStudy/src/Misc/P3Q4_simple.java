package Misc;

import java.util.Arrays;
import java.util.Random;

import util.searchLib;
import util.sortLib;
import util.tools;

public class P3Q4_simple {

	public static void main(String[] args) {
		
		int maxInt = 20, length = 6;
		
		Random geny = new Random();
		int k = geny.nextInt(1, 2*length - 1);
		int i, j = geny.nextInt(0, 2*length - 1);
		
		int[] C = tools.getTestSet(length*2, 0, maxInt);
		
		int[] A = Arrays.copyOfRange(C, 0, j);
		int[] B = Arrays.copyOfRange(C, j, length*2);
		
		System.out.println("Test Vector C: \t" + Arrays.toString(C));
		System.out.println("j: " + j);
		sortLib.quickSort(C, 0, C.length - 1);
		System.out.println("Sorted C: \t" + Arrays.toString(C));
		
		sortLib.quickSort(A, 0, A.length - 1);
		sortLib.quickSort(B, 0, B.length - 1);
		
		System.out.println("Test Vector A: " + Arrays.toString(A));
		System.out.println("Test Vector B: " + Arrays.toString(B));
		System.out.println("k: " + k);
		
		i = kthSmallest(A, B, 0, A.length, 0, B.length, k - 1);
		
		System.out.println("Sorted C: " + Arrays.toString(C));
		System.out.printf("%dth smallest element is: %d \n", k, i);
		
	}
	
	private static int kthSmallest(int[] A, int [] B, int a0, int aLast, int b0, int bLast, int k) {
		
		System.out.print("\nA: [");
		for (int i = a0; i < aLast; ++i)
			System.out.print(A[i] + ", ");
		System.out.printf("]\na0 = %d, aLast = %d\n", a0, aLast);
		
		System.out.print("B: [");
		for (int i = b0; i < bLast; ++i)
			System.out.print(B[i] + ", ");
		System.out.printf("]\nb0 = %d, bLast = %d\n", b0, bLast);
		
		int midA = a0 + ((aLast - a0) / 2);				//A.length/2; 
		int midB = b0 + ((bLast - b0) / 2);				//B.length/2;
		
		System.out.printf("midA: %d, midB: %d k:%d\n", midA, midB, k);
		
		if (a0 == aLast) {
			if (B.length < k)
				return B[B.length - 1];
			else
				return B[k];
		}
			
		if (b0 == bLast){
			if (A.length < k)
				return A[A.length - 1];
			else
				return A[k];
		}
		
		if ((midA - a0) + (midB - b0) < k) {
			
			if (A[midA] > B[midB])
				return kthSmallest(A, B, a0, aLast, midB + 1, bLast, k - midB - 1);
			else
				return kthSmallest(A, B, midA + 1, aLast, b0, bLast, k - midA - 1);
		}
		else {
			
			if (A[midA] > B[midB])
				return kthSmallest(A, B, a0, midA, b0, bLast, k);
			else
				return kthSmallest(A, B, a0, aLast, b0, midB, k);
		}
		
		
		/*
		if  (aLast > k) 
			aLast = k;
		
		if (bLast > k)
			bLast = k;
		
		if (A[k/2] < B[k/2])
			bLast = k/2;
		else
			aLast = k/2;
		
		return k;*/
	}
	
	/*Test1 ()
	//Find at most the k largest elements of A
			if (k < B.length) {
				System.out.printf("B[k] = %d\n", B[k]);
				i = searchLib.binarySearch(A, B[k], 0, A.length - 1);
			}
			else {
				System.out.printf("A[A.length] = %d\n", A[A.length - 1]);
				i = searchLib.binarySearch(A, B[B.length - 1], 0, A.length - 1);
			}
			System.out.println("i = " + i);
				
			
			//find at most the k largest elements of B
			if (k < A.length) {
				System.out.printf("A[k] = %d\n", A[k]);
				j = searchLib.binarySearch(B, A[k], 0, B.length - 1);
			}
			else {
				System.out.printf("B[B.length] = %d\n", B[B.length - 1]);
				j = searchLib.binarySearch(B, A[A.length - 1], 0, B.length - 1);
			}
			
			System.out.println("j = " + i);*/

}
