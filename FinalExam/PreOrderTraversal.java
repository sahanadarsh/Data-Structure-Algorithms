package FinalExam;

import java.util.LinkedList;
import java.util.List;
/*
Q10
Given a binary tree, return the preorder traversal of its nodes' values.
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
 */

public class PreOrderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		if(root == null) {
			return list;
		}
		preorderTraversal(root,list);
		return list;
	}

	// recursive function for pre order
	private void preorderTraversal(TreeNode node,List<Integer> list ){
		if(node != null){
			list.add(node.val);
			preorderTraversal(node.left, list);
			preorderTraversal(node.right, list);
		}
	}

	public TreeNode CreateTree(){
		TreeNode root= new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		return root;
	}

	public static void main(String[] args) {
		PreOrderTraversal tree = new PreOrderTraversal();
		TreeNode root = tree.CreateTree();
		List<Integer> result = tree.preorderTraversal(root);
		for(Integer n : result) {
			System.out.print(n + " ");
		}
	}

}
