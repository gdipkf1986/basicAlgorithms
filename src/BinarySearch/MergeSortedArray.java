package BinarySearch;

public class MergeSortedArray {
	public static int[] mergeSortedArray(int[] a1, int[] a2) {
		int[] result = new int[a1.length + a2.length];

		int i = 0, j = 0;
		while (i < a1.length && j < a2.length) {
			int a1c = a1[i];
			int a2c = a2[j];

			if (a1c < a2c) {
				result[i + j] = a1c;
				i++;
			} else {
				result[i + j] = a2c;
				j++;
			}
		}

		for (int m = i; m < a1.length; m++) {
			result[j + m] = a1[m];
		}

		for (int m = j; m < a2.length; m++) {
			result[i + m] = a2[m];
		}

		return result;

	}
}
