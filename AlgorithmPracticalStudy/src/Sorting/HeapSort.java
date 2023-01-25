package Sorting;

import java.util.Arrays;

import util.tools;

public class HeapSort {

	public static void main(String[] args) {
		
		int[] testV = tools.getTestSet(10, 0, 40);
		
		//Heap tests
		System.out.println("pre-heaping: " + Arrays.toString(testV) );
		buildHeap(testV);
		System.out.println("post-heaping: " + Arrays.toString(testV) );
		
		heapSort(testV);
		System.out.println("post-sorting: " + Arrays.toString(testV) );
	}
	
	public static void heapSort(int[] A) {
		
		int i = A.length - 1;
		System.out.println("Begin HeapSort -------------------------------");
		while (i > 0) {
			
			tools.swap(A, 0, i);
			--i;
			heapify(A, 0, i);
			System.out.printf("i = %d Array: %s\n", i, Arrays.toString(A));
		}
	}
	
	public static void heapify(int[] A, int parentNode, int length) {
		
		int largestNode = findLargestNode(A, parentNode, length);
					
		while (largestNode != parentNode ) {
			
			tools.swap(A, parentNode, largestNode);
			parentNode = largestNode;
			largestNode = findLargestNode(A, parentNode, length);
		}
	}
	
	//finds the largest of a parent node and it's two children. Should an error occur, returns -1;
	public static int findLargestNode(int[] A, int parentIndex, int length) {
		
		int left = getLeft(parentIndex, A);
		int right = getRight(parentIndex, A);
		
		if (left >= length)
			left = -1;
		if (right >= length)
			right = -1;
		
		if (right == -1 && left == -1)
			return parentIndex;
		else if (right == -1) {
			
			if (A[left] > A[parentIndex])
				return left;
			else 
				return parentIndex;
		}
		else if (left == -1) {						//This case SHOULD be impossible
			
			if (A[right] > A[parentIndex])
				return right;
			else 
				return parentIndex;
		}
		else {
			
			if (A[left] > A[right] && A[left] > A[parentIndex])
				return left;
			
			if (A[right] > A[left] && A[right] > A[parentIndex])
				return right;
			
			return parentIndex;
		}
	}
	
	
	// Takes an unsorted array, and arranges it into a max heap
	public static void buildHeap(int[] A) {
		
		int lastParent = A.length / 2 - 1;
		
		for (int i = lastParent; i >= 0; --i) 
			heapify(A, i, A.length);
	}
	
	
	//Tree navigation methods.
	//These work because a heap is a COMPLETE binary tree, so we may assume that all levels are full, save the lowest level
	//the child snatchers will return -1 if no child node exists
	//getParent will return -1 if no parent node exists
	
	public static int getLeft(int nodeIndex, int[] A) {
		
		if (2 * nodeIndex + 1 >= A.length)
			return -1;
		
		return 2 * nodeIndex + 1;
	}
	
	public static int getRight(int nodeIndex, int[] A) {
		
		if (2 * nodeIndex + 2 >= A.length)
			return -1;
		
		return 2 * nodeIndex + 2;
	}
	
	public static int getParent(int nodeIndex, int[] A) {
		
		if ((nodeIndex - 1) / 2 < 0)
			return -1;
		
		return (nodeIndex - 1) / 2;
	}
	
	

}
