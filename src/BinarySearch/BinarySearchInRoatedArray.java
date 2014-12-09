package BinarySearch;

public class BinarySearchInRoatedArray {
	/***
	 * treat rotated array as two line segments in top-left(2nd) and
	 * bottom-right(4th) quadrant
	 * http://lintcode.com/en/problem/search-in-rotated-sorted-array/
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static int indexOfInRotatedArray(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;

		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;

			if (array[mid] == target) {
				start = mid;
				break;
			}

			if (array[start] < array[mid]) {
				if (array[start] <= target && target <= array[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (array[mid] <= target && target <= array[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		if (array[start] == target) {
			return start;
		}
		if (array[end] == target) {
			return end;
		}

		return -1;
	}

}
