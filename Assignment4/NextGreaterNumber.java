package Assignment4;

import java.util.HashMap;
import java.util.Map;

/* Q1
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
If it does not exist, output -1 for this number.

Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

 */

public class NextGreaterNumber{

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		if(nums1.length == 0) {
			return nums1;
		}
		Map<Integer, Integer> map = new HashMap<>();		
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], -1);
			if(nums2.length != 0) {
				map.put(nums2[i],-1); 
			}
		}
		for (int i = nums2.length -2; i >= 0; i--) {
			int temp = nums2[i+1];
			while(nums2[i] >= temp && temp != -1) {
				temp = map.get(temp);
			}
			map.put(nums2[i], temp);
		}

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.get(nums1[i]);        
		}
		return nums1; 
	}

	public static void main(String args[]){  
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] res =  nextGreaterElement(nums1, nums2);
		for(int i =0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}  

}
