package Assignment2;

//Question: 9
/*
 * Smallest Difference pair between two sorted arrays
 * 
 * There are two sorted arrays, we have to find the pair which has smallest
 * difference,
 */

public class smallestDistancePair {

	public static void main(String[] args) {
		Integer[] arr1 = {2, 3, 4, 14, 34, 51};
		Integer[] arr2 = {11, 20, 39, 53, 67, 100};
		Integer output = smallestPairDifference(arr1, arr2);
		System.out.println(output);

	}

	public static Integer smallestPairDifference(Integer[] arr1, Integer[] arr2) {

		//checking error case
		if(arr1.length == 0 || arr2.length == 0) {
			return -1;
		}
		Integer minDiff = Integer.MAX_VALUE;
		int m = 0;
		int n = 0;

		//iterate through all the elements
		while(arr1.length > m && arr2.length > n) {

			//Check if difference is less than previous Diff
			if(Math.abs(arr1[m]-arr2[n]) < minDiff) {
				minDiff = Math.abs(arr1[m]-arr2[n]);
			}

			//Increment m or n based on smallest difference
			if(arr1[m] < arr2[n]){
				m++;
			}else {
				n++;
			}
		}
		return minDiff;
	}
}
