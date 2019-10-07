package Assignment1;

/* Q3
 * Given an array of integers, return index of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class IndicesOfTwoNums {

	public static void main(String[] args) {
		int[] nums = {3,3,2,8,10,7,5,};
		int target = 6;
		int optArray[] = twoSum(nums,target);
		System.out.println("["+optArray[0]+","+optArray[1]+"]");

	}

   public static int[] twoSum(int[] nums, int target) {
	   Map<Integer, Integer> map = new HashMap<>();
	   
	   //save the index as hash value and number as key
	   for(int i = 0; i < nums.length; i++) {
		   map.put(nums[i],i);  
	   }
	   
	   //check if the complement exit in HashMap and get its index
	   for(int i = 0; i < nums.length; i++) {
		   int num2 = target - nums[i];
		   if(map.containsKey(num2) && map.get(num2) != i) {
			  return (new int[] {i, map.get(num2)});
           }
	   }
	   return new int[] {-1,-1};

      }
	}

	   
	   
