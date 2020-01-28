package Assignment5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Q7
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 */

public class inOrderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		if(root == null) {
			return list;
		}
		inorderTraversal(root,list);
		return list;
	}
	
	 public static void levelOrder(TreeNode root){
	        if(root == null)
	            return;

	        // Take a queue and enqueue root and null
	        // every level ending is signified by null
	        // since there is just one node at root we enqueue root as well as null
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        queue.add(null);

	        
	        while(queue.size() != 0){
	            
	            TreeNode node = queue.remove();
	            // If the node is not null print it and enqueue its left and right child 
	            // if they exist
	            if(node != null){
	                System.out.print(node.val + " ,");
	                if(node.left != null)
	                    queue.add(node.left);
	                if(node.right != null)
	                    queue.add(node.right);
	            }else{
	                // We have reached a new level 
	                // Check is queue is empty, if yes then we are done 
	                // otherwise print a new line and enqueue a new null for next level
	                System.out.println();
	                if(queue.size() == 0)
	                    break;
	                queue.add(null);
	            }
	        }
	    }

	// recursive function for in order
	private void inorderTraversal(TreeNode node,List<Integer> list ){
		if(node != null){
			inorderTraversal(node.left, list);
			list.add(node.val);
			inorderTraversal(node.right, list);
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
		inOrderTraversal tree = new inOrderTraversal();
		TreeNode root = tree.CreateTree();
		//List<Integer> result = tree.inorderTraversal(root);
//		for(Integer n : result) {
//			System.out.print(n + " ");
//		}
		levelOrder(root);
	}
}
