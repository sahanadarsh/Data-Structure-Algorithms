package FinalExam;

import java.util.Arrays;

/*
Q4
Given an integer array with all positive numbers and no duplicates,
find the number of possible combinations that add up to a positive integer target.

Example:
nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */

public class CombinationSum {

	public static int combinationSum(int[] nums, int target) {
		if(nums.length == 0) {
			return 0;
		}
		int[] arr = new int[target+1];
		Arrays.fill(arr,Integer.MIN_VALUE);
		return combinationSum(nums,target,arr);
	}

	private static int combinationSum(int[] nums,int rem,int[] arr){
		if(arr[rem] != Integer.MIN_VALUE) {
			return arr[rem];
		}else if(rem <= 0) {
			return 1;
		}
		int result = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] <= rem) {
				result = result + combinationSum(nums,rem-nums[i],arr);
			}
		}
		arr[rem] = result;
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int target = 4;
		System.out.println(combinationSum(nums,target));
	}

}
