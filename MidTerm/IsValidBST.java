package MidTerm;

import java.util.LinkedList;
import java.util.Queue;

/* Q8 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.*/


public class IsValidBST {

	long n = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		if(root.left != null) {
			if(root.left.val > root.val ){
				return false;
			}else {
				if(!isValidBST(root.left)) {
					return false;
				}
			}
		}
		if(root.val <= n) {
			return false;
		}
		n = root.val;
		if(root.right != null) {
			if(root.right.val < root.val ){
				return false;
			}else {
				if(!isValidBST(root.right)) {
					return false;
				}
			}
		}
		return true;
	}

	public TreeNode CreateTree(){
		TreeNode root= new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
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
		IsValidBST tree = new IsValidBST();
		TreeNode root = tree.CreateTree();
		System.out.println(tree.isValidBST(root));
	}
}
