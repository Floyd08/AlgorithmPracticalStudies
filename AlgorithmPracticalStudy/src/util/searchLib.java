package util;

public class searchLib {

	public static int binarySearch(int[] array, int target, int first, int last) {
		
		int mid = first + (last - first) / 2;
		
		if (first > last)
				return (-1 * mid) ;
		
		int index;
		
		if (target == array[mid])
			return mid;
		else if (target < array[mid])
			index = binarySearch(array, target, first, mid - 1);
		else
			index = binarySearch(array, target, mid + 1, last);
		
		return index;
	}
	
}
