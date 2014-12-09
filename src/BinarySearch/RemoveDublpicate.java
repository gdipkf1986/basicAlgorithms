package BinarySearch;

public class RemoveDublpicate {
	
	public static int removeDuplicatesInSorted(int[] array) {
		if (array.length == 0 || array == null) {
			return 0;
		}

		int uniquePointer = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array[uniquePointer]) {
				array[++uniquePointer] = array[i];
			}
		}

		for (int i = uniquePointer + 1; i < array.length; i++) {
			array[i] = Integer.MIN_VALUE;
		}

		return uniquePointer + 1;
	}
}
