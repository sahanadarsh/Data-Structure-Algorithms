package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q5
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
 * 
          20     13
 */

public class GreaterBST {

	private int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		if( root != null) {
			convertBST(root.right);
			sum = sum + root.val;
			root.val =sum;
			convertBST(root.left);
		}
		return root;
	}

	public TreeNode CreateTree(){
		TreeNode root= new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(17);
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
		GreaterBST tree = new GreaterBST();
		TreeNode root = tree.CreateTree();
		TreeNode result = tree.convertBST(root);
		tree.printTree(result);
	}
}
