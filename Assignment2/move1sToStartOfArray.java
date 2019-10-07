package Assignment2;

//Question: 4
// Move all 1's to start of an array in a Binary array.
/*
 * Binary array is an array with numbers 0 and 1, we have to move all the 1's to
 * start of the array in O(n) without extra memory. Do not use count sort. Count
 * sort will do the job in 2*O(n), Hint think like dutch flag
 * 
 * e.g. Input: [1,0,1,0,0,0,1,0,1,1,0] Output: [1,1,1,1,1,0,0,0,0,0,0]
 * 
 * 
 */

public class move1sToStartOfArray {

	public static void main(String[] args) {
		Integer[] arr = {1,0,1,0,0,0,1,0,1,1,0};
		move1sToStart(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void move1sToStart(Integer[] arr) {
		int pivot = 1;

		//check for empty or single element array
		if(arr.length == 0 || arr.length == 1)
			return; 

		int low = 0;
		int high = arr.length -1;

		while(low < high){
			if(arr[low] == pivot){
				low++;
			} else{
				if(arr[high] == pivot) {
					Swap(arr,low,high);
					high--;
				}else {
					//move high to left until we find 1
					while (arr[high] == 0 && low < high) {
						high--;
					}
					Swap(arr,low,high);
					high--;
				}
				low++;
			}
		}
	}

	//swap two elements of an array
	public static void Swap(Integer[] arr, int i, int j) {
		if(i<0 || i >= arr.length || j < 0|| j >= arr.length )
			return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp ;
	}
}
