package Assignment2;

//Question: 1
/*
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
 * 2 + 7 = 9, return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class IndicesOfTwoNumbers {

	// Question: 1
	/*
	 * Given an array of integers, return indices of the two numbers such that they
	 * add up to a specific target. You may assume that each input would have
	 * exactly one solution, and you may not use the same element twice.
	 * 
	 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
	 * 2 + 7 = 9, return [0, 1].
	 */

	public static void main(String[] args) {
		Integer[] nums = {0,3,6,8,10,7,5,-2,-3};
		Integer target = 9;
		Integer optArray[] = twoSum(nums,target);
		System.out.println("["+optArray[0]+","+optArray[1]+"]");

	}

	public static Integer[] twoSum(Integer[] nums, Integer target) {
		if(nums.length == 0) {
			throw new IllegalArgumentException("array length is 0, Not implemented");
		}

		Map<Integer, Integer> map = new HashMap<>();

		//save the index as hash value and number as key
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i],i);  
		}

		//check if the complement exit in HashMap and get its index
		for(int i = 0; i < nums.length; i++) {
			int num2 = target - nums[i];
			if(map.containsKey(num2) && map.get(num2) != i) {
				return (new Integer[] {i, map.get(num2)});
			}
		}
		throw new IllegalArgumentException("Indices not found");
	}

}
