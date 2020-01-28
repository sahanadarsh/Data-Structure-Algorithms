package FinalExam;

/*
Q14
Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
which has the largest product.
Examples:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaxProduct {

	public static int maxProduct(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int product = nums[0];
		int max = nums[0];
		int min = nums[0];
		for(int i = 1; i < nums.length; i++) {
			int temp = min;
			int tempmin = Math.min(max*nums[i],min*nums[i]);
			min = Math.min( tempmin, nums[i]);
			int tempmax = Math.max(max*nums[i],temp*nums[i] );
			max = Math.max(tempmax, nums[i]);
			if(max > product) {
				product = max;
			}
		}    
		return product;
	}

	public static void main(String[] args) {
		int[] nums = {2,3,-2,4};
		System.out.println(maxProduct(nums));
	}

}
