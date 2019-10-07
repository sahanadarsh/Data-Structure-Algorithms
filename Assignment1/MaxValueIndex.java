package Assignment1;

/* Q1
 * Given an array nums, write a function to find the first maximum value's index. 
 * If there is no index that satisfies the conditions in the problem statement, we should return -1.
 * Input: [3,5,6,2,1,9] Output: 5
 * Explanation: 9 is the maximum value, and its index is 5.

 * Input: [2,4,4,1] Output: 1
 * Explanation: 4 is the maximum value, and the first 4's index is 1.
 */

public class MaxValueIndex {

	public static void main(String[] args) {
		int[] arr = {8,7,6};
		int max = maxIndex(arr);
		System.out.println("Maximum Value is at index: " + max);
	}

	public static  int maxIndex(int[] arr) {
		if(arr.length == 0){ 
			return -1;
		}
		
		int max = arr[0];
		int index = 0;
		
        
		//get first maximum value index
		for(int i=0;i<arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;

	}  

}
