package MidTerm;

/* Q2 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1 */

public class Search {

	public static int search(int[] nums, int target) {
		if(nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end  = nums.length - 1;
		int mid;
		while(start < end) {
			mid = (start + end) / 2;
			if( target == nums[mid]) {
				return mid;
			}
			if( target == nums[start]) {
				return start;
			}
			if( target == nums[end]) {
				return end;
			}
			if((nums[start] < nums[mid]) && (nums[start] < target) && (target < nums[mid])) {
				end = mid - 1;
				continue;
			}
			if((nums[mid] < nums[end]) && (nums[mid] < target) && (target < nums[end])) {
				start = mid + 1;
				continue;
			}
			if((nums[mid] > nums[end]) && ((target < nums[end]) || (target > nums[mid]))) {
				start = mid + 1;
				continue;
			}
			if((nums[start] > nums[mid]) && ((target > nums[start]) || (target < nums[mid]))){
				end = mid - 1;
				continue;
			}
			return -1;
		}
		if(nums[start] == target) {
			return start;
		}else {
			return -1;
		}
	}	

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, target));
	}
}
