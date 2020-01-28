package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q8
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

public class BuildTree {

	int preIndex = 0;
	

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return  getTreeFromInorderAndPreorder(preorder, inorder, 0,  inorder.length -1);
	}

	public TreeNode getTreeFromInorderAndPreorder(int[] preOrder,int[] inOrder,int start, int end){

		if( start > end) {
			return null;
		}
		TreeNode node = new TreeNode(preOrder[preIndex]);
		preIndex ++;

		int inOrderIndex = findIndex(inOrder, start, end, node.val);

		node.left = getTreeFromInorderAndPreorder(preOrder, inOrder, start, inOrderIndex - 1);
		node.right = getTreeFromInorderAndPreorder(preOrder, inOrder, inOrderIndex +1, end);
		return  node;
	}

	private int findIndex(int[] arr, int start, int end, int val){
		int i;
		for(i = start ; i < end; i++){
			if(arr[i] == val) {
				return i;
			}
		}
		return i;
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
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		BuildTree tree = new BuildTree();
		TreeNode result = tree.buildTree(preorder, inorder);
		tree.printTree(result);
	}
}
