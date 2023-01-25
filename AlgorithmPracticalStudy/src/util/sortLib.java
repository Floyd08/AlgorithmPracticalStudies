package util;

public class sortLib {

	
	public static void BubbleSort(int[] array) {
		
		int k = 1, arrayLen = array.length;
		boolean didSwap = true;
		
		while (didSwap == true ) {
			
			didSwap = false;
			for (int i = 0; i < arrayLen - k; ++i) {
				
				if (array[i] > array[i + 1]) {
					
					tools.swap(array, i, i + 1);
					didSwap = true;
				}		
			}
			++k;
		}
	}
	
	public static void quickSort(int[] array, int first, int last) {
		
		if (first >= last)
			return;
		
		int pivot = tools.partition(array, first, last);
		
		quickSort(array, first, pivot - 1);
		quickSort(array, pivot + 1, last);
	}
}
