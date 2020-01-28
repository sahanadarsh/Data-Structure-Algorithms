package MidTerm;

/* Bonus Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n). */

public class ProductExceptItself {

	public static int[] productExceptSelf(int[] nums) {
		if(nums.length == 0) {
			return new int[]{};
		}
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		left[0] = 1;
		int preProduct = 1; 
		for(int i = 1; i < left.length; i++) {
			preProduct = preProduct * nums[i-1];
			left[i] = preProduct;
		}
		preProduct = 1;
		for(int i = right.length-2; i >= 0; i--) {
			preProduct = nums[i+1] * preProduct;
			right[i] = preProduct * left[i];
		}
		right[right.length-1] = left[left.length -1];	
		return right;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] out = productExceptSelf(nums);
		for(int i : out) {
			System.out.print(i + " ");
		}
	}
}
