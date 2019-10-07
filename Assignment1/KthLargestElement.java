package Assignment1;

/* Q2
 * Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5

 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */

public class KthLargestElement {

	public static void main(String[] args) {
		int[] nums = {6,5,3,1,8,7,2,4};
		int k = 3;
		System.out.println(findKthLargest(nums,k));

	}

	public static int findKthLargest(int[] nums, int k) {
		if(nums == null || k < 1 || k> nums.length) {
			return -1;
		} else {
			int value = quickSort(nums, 0, nums.length - 1,nums.length -k);
			return nums[value];
			
		}
	}
	
	//sorting elements
	public static int quickSort(int[] arr, int low, int high,int k) {
		if(low < high) {
			int pos = partition(arr, low, high);
			if(k == pos){
				return pos;
			}else if(k < pos ){
			   return quickSort(arr, low, pos - 1,k);
			} else
			    return quickSort(arr, pos + 1, high,k);
		}
		return k;
	}

    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low -1;
        
        for(int k = low; k < high; k++){
            if(arr[k] <= pivot){
                wall++;
                Swap(arr,k,wall);
            }
        }
        Swap(arr,high,wall+1);
        return wall+1;

    }

    //swapping two elements
	public static void Swap(int[] nums, int i, int j) {
		if(i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
			return;
		} else { 
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
