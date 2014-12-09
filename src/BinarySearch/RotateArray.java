package BinarySearch;

public class RotateArray {
	public static void roateArray_helper(int[] array, int start, int end) {

		if (array.length < 2)
			return;

		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * rotate 3 times.
	 * 
	 * @param array
	 * @param pivotPoint
	 */
	public static void rotateArray(int[] array, int pivotPoint) {

		roateArray_helper(array, 0, pivotPoint - 1);

		roateArray_helper(array, pivotPoint, array.length - 1);

		roateArray_helper(array, 0, array.length - 1);
	}
}
