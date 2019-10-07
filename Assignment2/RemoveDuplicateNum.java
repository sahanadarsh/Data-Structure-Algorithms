package Assignment2;

// Question: 8
/*
 * Remove Duplicates from Sorted Array Given a sorted array nums, remove the
 * duplicates in-place such that each element appear only once and return the
 * new length. Do not allocate extra space for another array, you must do this
 * by modifying the input array in-place with O(1) extra memory.
 * 
 * Example 1: Given nums = [1,1,2], Your function should return length = 2, with
 * the first two elements of nums being 1 and 2 respectively. Example 2: Given
 * nums = [0,0,1,1,1,2,2,3,3,4], Your function should return length = 5, with
 * the first five elements of nums being modified to 0, 1, 2, 3, and 4
 * respectively.
 */

public class RemoveDuplicateNum {

	public static void main(String[] args) {
		Integer[] arr = {0,0,1,1,1,2,2,3,3,4};
		Integer length = removeDuplicates(arr);
		System.out.println("New length is " + length);
		for(int i =0; i < length ; i++) {
	    	System.out.println(arr[i]);
	    }
	}
		
	public static Integer removeDuplicates(Integer[] arr) {
		if(arr.length == 0)
			return 0;
		Integer index = 0;
		int i = 1;
		
		//copy distinct elements to start of array
		while( i < arr.length ) {
			if(arr[i] != arr[index]) {
				index++;
				arr[index] = arr[i];
			}
			i++;
		}
	    return index+1;
    }

}
	
	


