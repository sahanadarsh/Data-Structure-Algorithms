package Assignment2;

import java.util.ArrayList;

// Question: 2

/*
 * Given two arrays, write a function to compute their intersection. Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Note: Each element in the
 * result must be unique. The result can be in any order.
 */

import java.util.HashSet;

public class IntersectionNum {

	public static void main(String[] args) {
		Integer[] nums1 = {1,2,2,1,4,5};
		Integer[] nums2 = {2,2,4,0,5};
		Integer[] output = intersection(nums1, nums2);
		if(output != null) {
			for(int i = 0; i < output.length; i++) {
				System.out.println(output[i]);
			}
		}else {
			System.out.println("No intersection");
		}
	}

	public static Integer[] intersection(Integer[] nums1, Integer[] nums2) {
		if(nums1.length == 0 || nums2.length == 0) {
			return null;
		}
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();

		//add elements of first array to Hashset set1
		for(int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);  
		}

		//add elements of second array to Hashset set2
		for(int i = 0; i < nums2.length; i++) {
			set2.add(nums2[i]);  
		}

		//Array list to hold the intersection elements
		ArrayList<Integer> output = new ArrayList<Integer>();
		for(Integer n : set1) {
			if(set2.contains(n)) {
				output.add(n);
			}
		}
		
		//convert from Array list to array
		Integer[] out = new Integer[output.size()];
		out = output.toArray(out);
		return out;

	}
}
