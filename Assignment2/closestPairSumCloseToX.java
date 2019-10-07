package Assignment2;

//Question: 5
// Find closest pair from two sorted arrays
/*
 * There are two sorted arrays, and a number X. Find two numbers one from each
 * array such that sum of both of them comes closest to number X
 * 
 * Input: arr1[] = {5, 6, 8, 10, 24}; arr2[] = {12, 15, 20, 25, 30}; x = 51
 * Output: 24 and 25
 * 
 * 
 */

public class closestPairSumCloseToX {

	public static void main(String[] args) {
		Integer[] arr1 = {5, 6, 8, 10, 24};
		Integer[] arr2 = {12, 15, 20, 25, 30};
		int X = 51;
		closestPairSumClosestToX(arr1, arr2, X);
	}

	public static void closestPairSumClosestToX(Integer[] arr1, Integer[] arr2, int X) {

		if(arr1.length == 0 || arr2.length == 0) {
			throw new ArrayIndexOutOfBoundsException("Not Implemented");
		}

		//i and j holds the indices of sum closest to X
		int i = 0;
		int j = 0;

		//m and n represents the start indices of arr1 and arr2
		int m = 0;
		int n = 0;

		//reverse array2 
		reverseArray(arr2);

		int diff = Integer.MAX_VALUE;

		while(arr1.length > m && arr2.length > n) {

			//Check if difference is less than previous diff
			if(Math.abs(arr1[m]+arr2[n] - X) < diff) {
				i = m;
				j = n;
				diff = (Math.abs(arr1[m]+arr2[n] - X));
			}

			//Increment m or n based on current sum less than or greater than X
			if(Math.abs(arr1[m]+arr2[n]) < X){
				m++;
			}else {
				n++;
			}
		}
		System.out.println("closest sum elements are " + arr1[i] + "," + arr2[j] );
	}

	//In place reverse array
	public static Integer[] reverseArray(Integer[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int temp = -1;
		while(start<end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}

}
