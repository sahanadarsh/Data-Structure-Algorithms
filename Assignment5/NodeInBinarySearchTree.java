package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q1
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value.
Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2     
     / \   
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */

public class NodeInBinarySearchTree {

	public TreeNode searchBST(TreeNode root, int val) {

		if(root == null) {
			return null;
		}
		if(root.val == val) {
			return root;
		}
		if(root.val < val) {
			return searchBST(root.right, val);
		}else {
			return searchBST(root.left, val);
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
		root.right.left.right = new TreeNode(16);
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
		NodeInBinarySearchTree tree = new NodeInBinarySearchTree();
		TreeNode root = tree.CreateTree();
		TreeNode result = tree.searchBST(root,15);
		tree.printTree(result);
	}
}
