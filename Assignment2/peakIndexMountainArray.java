package Assignment2;

//Question: 3

/*
 * Let's call an array A a mountain if the following properties hold: A.length
 * >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ...
 * A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] Given an array that is
 * definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i]
 * > A[i+1] > ... > A[A.length - 1].
 * 
 * Example 1: Input: [0,1,0] Output: 1 Example 2: Input: [0,2,1,0] Output: 1
 */

public class peakIndexMountainArray {

	public static void main(String[] args){
		Integer[] A = {0,2,1,0};
		Integer output = peakIndexInMountainArray(A);
		System.out.println(output);
	}

	public static Integer peakIndexInMountainArray(Integer[] A){

		if(A.length == 0) {
			return -1;
		}
		int peakIndex =  -1;
		for(int i = 0; i < A.length -1; i++) {
			if( A[i] < A[i+1]) {
				//continue as long as next element is greater
				continue;
			} else {
				peakIndex = i;
				//break on reaching the peak
				break;
			}
		}
		return peakIndex ;
	}
}
