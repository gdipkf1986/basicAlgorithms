package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jovi on 11/30/2014.
 */
public class BasicBS {

	public static void main(String[] args) {

		int[] array = BasicBS.random(7, 1, 30, true);

		System.out.println(Arrays.toString(array));

		System.out.println("\n==> index of 7 : " + BinarySearch.indexOf(array, 7));

		RotateArray.rotateArray(array, 3);
		System.out.println("\n==> rotated at 3: " + Arrays.toString(array));

		System.out.println("\n==> index of 7 in rotated: " + BinarySearchInRoatedArray.indexOfInRotatedArray(array, 7));

		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 3, 5, 9, 10 } };
		System.out.println("\nmatrix: [");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("\t" + Arrays.toString(matrix[i]));
		}
		System.out.println("]");

		System.out.println("\n==> index of 9 in matrix: " + Arrays.toString(BinarySearchInMatrix.indexOfMatix(matrix, 9)));

		int[] a1 = BasicBS.random(5, 1, 10, true);
		int[] a2 = BasicBS.random(5, 2, 15, true);
		System.out.println("\n\n " + Arrays.toString(a1) + "," + Arrays.toString(a2));
		int[] merged = MergeSortedArray.mergeSortedArray(a1, a2);
		System.out.println("\n==> merged: " + Arrays.toString(merged));

		RemoveDublpicate.removeDuplicatesInSorted(merged);
		System.out.println("\n==> removed duplicates: " + Arrays.toString(merged));
	}

	public static int[] random(int size, Integer min, Integer max, Boolean sorted) {

		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			Integer val = min + (int) Math.round(Math.random() * max);
			result[i] = val;
		}

		if (sorted) {
			Arrays.sort(result);
		}

		return result;

	}













}

