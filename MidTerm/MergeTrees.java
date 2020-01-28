package MidTerm;

import java.util.LinkedList;
import java.util.Queue;

/* Q10 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

 */

public class MergeTrees {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null) {
			return null;
		}
		if( t1 == null) {
			return t2;
		}
		if( t2 == null) {
			return t1;
		}
		return mergeBinaryTrees(t1, t2);
	}

	private TreeNode mergeBinaryTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null) {
			return t2;
		}
		if( t2 == null) {
			return t1;
		}
		t1.val = t1.val + t2.val;
		t1.left = mergeBinaryTrees(t1.left, t2.left);
		t1.right = mergeBinaryTrees(t1.right, t2.right);
		return t1;
	}

	public TreeNode CreateTree1(){
		TreeNode root1= new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		return root1;
	}

	public TreeNode CreateTree2(){
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		return root2;
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
		MergeTrees tree = new MergeTrees();
		TreeNode root1 = tree.CreateTree1();
		TreeNode root2 = tree.CreateTree2();
		TreeNode result = tree.mergeTrees(root1, root2);
		tree.printTree(result);
	}
}
