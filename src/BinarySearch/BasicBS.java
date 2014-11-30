package BinarySearch;

import java.util.Arrays;

/**
 * Created by jovi on 11/30/2014.
 */
public class BasicBS {

    public static void main(String[] args){

        int[] array = new int[]{1, 3, 7, 9, 11, 35, 36};
        System.out.println(Arrays.toString(array));


        System.out.println("==> index of 7 : " + BasicBS.indexOf(array, 7));

        BasicBS.rotateArray(array, 3);
        System.out.println("==> rotated at 3: "+Arrays.toString(array));

	    System.out.println("==> index of 7 in rotated: "+ BasicBS.indexOfInRotatedArray(array, 7));

    }

    private static int indexOf(int[] array, int target){
        int start = 0;
        int end = array.length-1;
        int mid;

        while(start + 1 < end){
            mid = start + (end-start)/2;

            if(array[mid] == target){
                end = mid;
            }else if(array[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(array[end] == target){
            return end;
        }
        if(array[start] ==  target){
            return start;
        }

        return -1;

    }

    private static void roateArray_helper(int[] array, int start, int end){

        if(array.length < 2) return;

        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotateArray(int[] array, int pivotPoint){

        roateArray_helper(array, 0, pivotPoint-1);

        roateArray_helper(array, pivotPoint, array.length-1);

        roateArray_helper(array, 0, array.length-1);
    }

    private static int indexOfInRotatedArray(int[] array, int target){
        int start = 0;
        int end = array.length - 1;

        int mid;


        while(start + 1 < end){
            mid = start + (end - start)/2;

            if(array[mid]==target){
                start = mid;
	            break;
            }

	        if(array[start] < array[mid]){
		        if(array[start] <= target && target <= array[mid]){
			        end = mid;
		        }else{
			        start = mid;
		        }
	        }else{
				if(array[mid] <= target && target <= array[end]){
					start = mid;
				}else{
					end = mid;
				}
	        }
        }

	    if(array[start] == target){
		    return start;
	    }
	    if(array[end] == target){
		    return end;
	    }

	    return -1;
    }
}
