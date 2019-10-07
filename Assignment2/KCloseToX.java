package Assignment2;

import java.util.Arrays;

//Question: 7
// K Closest numbers to a number X
/*
 * There is a sorted array, and a number X. We want to find K closest elements
 * to a number X
 * 
 * Input: arr1[] = {5, 6, 8, 10,12,21, 24,25,32,37,45,51 }; k = 4 X = 23 Output:
 * [24,25,21]
 */

public class KCloseToX {

	public static void main(String[] args) {
		Integer[] arr = {5, 6, 8, 10, 12, 21, 22, 23, 24, 25, 32, 37, 45, 510};
		Integer k = 4;
		Integer X = 15;
		Integer[] output = kClosestToX(arr, k, X);
		for(Integer i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}

	public static Integer[] kClosestToX(Integer[] arr, Integer k, Integer x) {

		//Checking error case
		if(arr.length == 0 || k <= 0) {
			throw new IllegalArgumentException("Not Implemented");
		}

		//if x is greater than last element return last K elements
		if(x >= arr[arr.length-1]) {
			Integer[] temp = Arrays.copyOfRange(arr, (arr.length-k) , arr.length);
			Integer i,t;

			//Arrange last K elements in reverse order
			for (i = 0; i < (temp.length / 2); i++) { 
				t = temp[i]; 
				temp[i] = temp[temp.length - i - 1]; 
				temp[temp.length - i - 1] = t; 
			}
			return temp;
		}

		//if x is less than first element return first K elements
		if(x <= arr[0]) {
			return Arrays.copyOf(arr, k);
		}

		//creating an output array
		Integer[] out = new Integer[k];

		//Get index of the element closest to x
		Integer index = ClosestElementIndex(arr,x);
		out[0] = arr[index];
		Integer idx = 1;

		Integer rightIndex;
		Integer leftIndex;

		//closest element is last element
		//return last K elements
		if (index == arr.length-1) {
			while(idx < k){
				out[idx] = arr[index-1];
				idx++;
				index--;
			}
			return out;
		} 
		//closest element is first element
		//return first K elements
		else if (index == 0) {
			while(idx < k){
				out[idx] = arr[index+1];
				idx++;
				index++;
			}
			return out;
		} 
		//set right and left index
		else {
			rightIndex = index + 1;
			leftIndex = index - 1;
		}

		//populate k-1 elements in out array
		while(idx < k){
			if(Math.abs(arr[rightIndex] - x) < Math.abs(x - arr[leftIndex]) ) {
				out[idx] = arr[rightIndex];
				idx++;
				if((rightIndex + 1) != arr.length) {
					rightIndex++;
				} else {
					//return remaining elements from left side
					while(idx < k) {
						out[idx] = arr[leftIndex];
						leftIndex--;
						if(leftIndex < -1) {
							throw new IllegalArgumentException("K larger than arry size");
						}
						idx++;
					}
					return out;
				}
			}else {
				out[idx] = arr[leftIndex];
				idx++;
				if(leftIndex != 0) {
					leftIndex--;
				} else {
					//return remaining elements from right side
					while(idx < k) {
						out[idx] = arr[rightIndex];
						rightIndex++;
						if (rightIndex > arr.length) {
							throw new IllegalArgumentException("K larger than arry size");
						}
						idx++;
					}
					return out;
				}
			}
		}
		return out;
	}

	public static Integer ClosestElementIndex(Integer[] arr, Integer x) {
		Integer idx = 0;

		//iterate till element greater than x
		while((arr[idx] <= x) && (idx < arr.length-1)) {
			idx++;
		}

		//return edge cases
		if (arr[idx] == x || idx == 0 || ((idx == arr.length - 1) && (x > arr[idx]))) {
			return idx;
		}

		//return closest element index 
		if (Math.abs(x - arr[idx-1]) < Math.abs(arr[idx] - x)) {
			return idx-1;
		} else {
			return idx; 
		}
	}
}
