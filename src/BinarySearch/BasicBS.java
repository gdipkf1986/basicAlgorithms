package BinarySearch;

import java.util.Arrays;

/**
 * Created by jovi on 11/30/2014.
 */
public class BasicBS {

	public static void main(String[] args){

		int[] array = BasicBS.random(7, 1, 30, true);
		
		System.out.println(Arrays.toString(array));

		System.out.println("\n==> index of 7 : " + BasicBS.indexOf(array, 7));

		BasicBS.rotateArray(array, 3);
		System.out.println("\n==> rotated at 3: "+Arrays.toString(array));

		System.out.println("\n==> index of 7 in rotated: "+ BasicBS.indexOfInRotatedArray(array, 7));
	
		int[][] matrix = new int[][]{
			{1, 3, 5, 7}
			,{2, 4, 6, 8}
			,{3, 5, 9, 10}
		};
		System.out.println("\nmatrix: [");
		for(int i=0; i<matrix.length;i++){
			System.out.println("\t"+Arrays.toString(matrix[i]));
		}
		System.out.println("]");
		
		System.out.println("\n==> index of 9 in matrix: "+ Arrays.toString(BasicBS.indexOfMatix(matrix, 9) )) ;
		
		
		
		
		int[] a1 = BasicBS.random(5, 1, 10, true);
		int[] a2 = BasicBS.random(5, 2, 15, true);
		System.out.println("\n\n "+Arrays.toString(a1)+","+Arrays.toString(a2));
		int[] merged = BasicBS.mergeSortedArray(a1, a2);
		System.out.println("\n==> merged: " + Arrays.toString(merged) );
		
		BasicBS.removeDuplicatesInSorted(merged);
		System.out.println("\n==> removed duplicates: " + Arrays.toString(merged));
	}
	
	
	public static int[] random(int size, Integer min, Integer max, Boolean sorted){
		
		int[] result = new int[size];
		for(int i=0;i<size;i++){
			Integer val =  min + (int)Math.round(Math.random()*max);
			result[i] = val;
		}
		
		if(sorted){
			Arrays.sort(result);
		}
		
		return result;
		
	}
	

	private static int indexOf(int[] array, int target) {
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

	private static void roateArray_helper(int[] array, int start, int end) {

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
	private static void rotateArray(int[] array, int pivotPoint) {

		roateArray_helper(array, 0, pivotPoint - 1);

		roateArray_helper(array, pivotPoint, array.length - 1);

		roateArray_helper(array, 0, array.length - 1);
	}

	/***
	 * treat rotated array as two line segments in top-left(2nd) and bottom-right(4th) quadrant
	 * http://lintcode.com/en/problem/search-in-rotated-sorted-array/
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	private static int indexOfInRotatedArray(int[] array, int target) {
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

	/***
	 * assume each row are sorted and each col is incremental 
	 * [ [1, 3, 5, 7], [2, 4, 7, 8], [3, 5, 9, 10] ]
	 * http://www.lintcode.com/en/problem/search-a-2d-matrix/
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	private static int[] indexOfMatix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int start = 0;
		int end = rows * cols - 1;
		while(start < end){
			int mid = start + (end - start)/2;
			// Tricks to treat it as a 1-D array
			int digital = matrix[mid / cols][mid % cols];
			
			if(digital == target){
				return new int[]{mid/cols, mid%cols};
			}else if(digital > target){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		
		return null;
	}


	private static int removeDuplicatesInSorted(int[] array){
		if(array.length == 0 || array == null){
			return 0;
		}
		
		int uniquePointer = 0;
		for(int i=0; i<array.length; i++){
			if(array[i] != array[uniquePointer]){
				array[++uniquePointer] = array[i];
			}
		}
	
		for(int i=uniquePointer+1; i<array.length; i++){
			array[i] = Integer.MIN_VALUE;
		}
		
		return uniquePointer+1;
	}
	
	private static int[] mergeSortedArray(int[] a1, int[] a2){
		int[] result = new int[a1.length+a2.length];

		int i=0, j=0;
		while(i<a1.length && j<a2.length){
			int a1c = a1[i];
			int a2c = a2[j];
			
			if(a1c < a2c){
				result[i+j] = a1c;
				i++;
			}else{
				result[i+j] = a2c;
				j++;
			}
		}

		for(int m = i; m < a1.length ; m++){
			result[j+m] = a1[m];
		}
		
		for(int m = j; m < a2.length ; m++){
			result[i+m] = a2[m];
		}
		
		return result;
		
	}
}
