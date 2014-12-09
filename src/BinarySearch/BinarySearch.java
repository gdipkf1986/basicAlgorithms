package BinarySearch;

public class BinarySearch {
	public static int indexOf(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;

			if (array[mid] == target) {
				end = mid;
			} else if (array[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (array[end] == target) {
			return end;
		}
		if (array[start] == target) {
			return start;
		}

		return -1;

	}
}
