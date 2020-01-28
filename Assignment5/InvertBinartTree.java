package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q3
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */

public class InvertBinartTree {

	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		Queue<TreeNode> q1 = new LinkedList<>();
		q1.add(root);
		while(q1.size() != 0){
			TreeNode node = q1.poll();
			// Swap left and right nodes
			TreeNode temp = node.right;
			node.right = node.left;
			node.left = temp;
			if(node.right != null)
				q1.add(node.right);
			if(node.left != null)
				q1.add(node.left);
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
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(4);
		root.right.left.left = new TreeNode(11);
		root.right.left.right = new TreeNode(14);
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
		InvertBinartTree tree = new InvertBinartTree();
		TreeNode root = tree.CreateTree();
		TreeNode result = tree.invertTree(root);
		tree.printTree(result);
	}
}
