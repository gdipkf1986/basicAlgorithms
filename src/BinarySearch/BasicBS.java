package BinarySearch;

import java.util.Arrays;

/**
 * Created by jovi on 11/30/2014.
 */
public class BasicBS {

	public static void main(String[] args){

		int[] array = BasicBS.random(7, 1, 30, true);
		
		System.out.println("==> array: "+Arrays.toString(array));

		System.out.println("\n==> index of 7 : " + BasicBS.indexOf(array, 7));

		BasicBS.rotateArray(array, 3);
		System.out.println("\n==> rotated at 3: "+Arrays.toString(array));

		System.out.println("\n==> index of 7 in rotated: "+ BasicBS.indexOfInRotatedArray(array, 7));
	
		int[][] matrix = new int[][]{
			{1, 3, 5, 7}
			,{2, 4, 6, 8}
			,{3, 5, 9, 10}
		};
		System.out.println("\n==> matrinx: [");
		for(int i=0; i<matrix.length;i++){
			System.out.println("\t"+Arrays.toString(matrix[i]));
		}
		System.out.println("]");
		
		System.out.println("==> index of 9 in matrix: "+ Arrays.toString(BasicBS.indexOfMatix(matrix, 9) )) ;
		
		System.out.println("==> peak index in array"+Arrays.toString(array)+" : "+BasicBS.findAPeakIndex(array, 0, array.length-1));
		
		
		int[] a1 = BasicBS.random(5, 1, 10, true);
		int[] a2 = BasicBS.random(5, 2, 15, true);
		System.out.println("==> sort from "+Arrays.toString(a1)+","+Arrays.toString(a2));
	}
	
	
	private static int[] random(int size, Integer min, Integer max, Boolean sorted){
		
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

	//http://lintcode.com/en/problem/find-a-peak/
	//http://courses.csail.mit.edu/6.006/spring11/lectures/lec02.pdf
	//http://courses.csail.mit.edu/6.006/spring11/rec/rec02.pdf
	/**
	 * 1. 如何保证一定有一个峰值: array[1] > array[0] && array[end] < array[end-1], 前半段向上, 后半段向下, 题目假设元素不重复
	 * 2. 在 array 中取最中间一个值 m = array[middle], 如果它同时比左右两边的值都大, 它就是峰值 
	 * 3. 否则, 把 m 和它右边的邻值 mr 比较, 以判断它的走势, 如果 mr > m, 说明右边是向上升的, 类似于右斜线 /, 那右边一定有一个峰值, 从mr开始到最后一个结点重复第二步
	 * 4. 如果 mr < m,  说明右边是下降的, 类似于斜线 \, 结合第一条, 那左边一定有一个峰值, 从array[0]到m的前一个结点重复第二步
	 * @param array
	 * @param i
	 * @param j
	 * @return
	 */
	private static int findAPeakIndex(int[] array, int i, int j){
		
		
		if( j == i + 1){
			return array[j] > array[i] ? j : i;
		}else if(j==i){
			return j;
		}
		
		int mid = (i+j)/2;
		
		if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
			return mid;
		}
		
		if(array[mid+1] > array[mid]){
			return findAPeakIndex(array, mid+1, j);
		}
		
		if(array[mid+1] < array[mid]){
			return findAPeakIndex(array, i, mid-1);
		}
		
		
		return -1;
	}

	private static int findPeakInMatrix(){
		return -1;
	}

	private static int[] mergeSortedArray(int[] a1, int[] a2){
		return new int[]{};
	}
}
