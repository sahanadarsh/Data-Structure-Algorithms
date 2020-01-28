package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q6
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 */

public class ConstructMaximumBinaryTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length == 0){ 
			return null;
		}
		return constructMaximumBinaryTree(nums, 0, nums.length);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if(start == end) {
			return null;
		}
		int maxIndex = getMaxValueIndex(nums, start, end);
		TreeNode node = new TreeNode(nums[maxIndex]);
		node.left = constructMaximumBinaryTree(nums, start, maxIndex);
		node.right = constructMaximumBinaryTree(nums, maxIndex+1, end);
		return node;	
	}

	//get maximum value Index
	public int getMaxValueIndex(int[] nums, int startIndex, int endIndex) {
		int max = nums[startIndex];
		int index = startIndex;
		for(int i=startIndex;i<endIndex;i++) {
			if(max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		return index;
	}

	public void printTree(TreeNode root){
		if(root == null)
			System.out.println("[]");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(queue.size() != 0){
			TreeNode node = queue.remove();
			if(node != null){
				System.out.print(node.val + " ,");
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}else{
				System.out.println();
				if(queue.size() == 0)
					break;
				queue.add(null);
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {3,2,1,6,0,5};
		ConstructMaximumBinaryTree tree = new ConstructMaximumBinaryTree();
		TreeNode result = tree.constructMaximumBinaryTree(nums);
		tree.printTree(result);
	}
}
