package BinarySearch;

public class BinarySearchInMatrix {
	/***
	 * assume each row are sorted and each col is incremental [ [1, 3, 5, 7],
	 * [2, 4, 7, 8], [3, 5, 9, 10] ]
	 * http://www.lintcode.com/en/problem/search-a-2d-matrix/
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static int[] indexOfMatix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int start = 0;
		int end = rows * cols - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			// Tricks to treat it as a 1-D array
			int digital = matrix[mid / cols][mid % cols];

			if (digital == target) {
				return new int[] { mid / cols, mid % cols };
			} else if (digital > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return null;
	}
}
