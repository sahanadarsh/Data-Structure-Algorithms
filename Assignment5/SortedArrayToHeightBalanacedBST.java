package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q4
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

public class SortedArrayToHeightBalanacedBST {

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBst(nums, 0, nums.length - 1);
	}
	
	private TreeNode sortedArrayToBst(int[] nums, int startIndex, int endIndex ) {
		if(startIndex > endIndex ) {
			return null;
		}
		int mid = (startIndex + endIndex)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBst(nums, startIndex, mid -1);
		root.right = sortedArrayToBst(nums, mid+1, endIndex);
		return root;
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
		int[] nums = {-10,-3,0,5,9};
		SortedArrayToHeightBalanacedBST tree = new SortedArrayToHeightBalanacedBST();
		TreeNode result = tree.sortedArrayToBST(nums);
		tree.printTree(result);
	}
}
