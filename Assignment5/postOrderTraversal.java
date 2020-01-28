package Assignment5;

import java.util.LinkedList;
import java.util.List;

/*Q10

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
 */

public class postOrderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		if(root == null) {
			return list;
		}
		postorderTraversal(root,list);
		return list;
	}

	// recursive function for post order
	private void postorderTraversal(TreeNode node,List<Integer> list ){
		if(node != null){
			postorderTraversal(node.left, list);
			postorderTraversal(node.right, list);
			list.add(node.val);
		}
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

	public static void main(String[] args) {
		postOrderTraversal tree = new postOrderTraversal();
		TreeNode root = tree.CreateTree();
		List<Integer> result = tree.postorderTraversal(root);
		for(Integer n : result) {
			System.out.print(n + " ");
		}
	}
}
