package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

public class postInOrder {
	
	public TreeNode buildTree1(int[] postorder, int[] inorder, Index pIndex) {
		return  getTreeFromInorderAndPostorder(postorder, inorder, 0,  inorder.length -1, pIndex);
	}


	public TreeNode getTreeFromInorderAndPostorder(int[] postOrder,int[] inOrder,int start, int end, Index pIndex){

		if( start > end) {
			return null;
		}
		TreeNode node = new TreeNode(postOrder[pIndex.index]);
		pIndex.index--;

		int inOrderIndex = findIndex(inOrder, start, end, node.val);
	
		node.right = getTreeFromInorderAndPostorder(postOrder, inOrder, inOrderIndex +1, end, pIndex);
		node.left = getTreeFromInorderAndPostorder(postOrder, inOrder, start, inOrderIndex - 1, pIndex);
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
		postInOrder tree = new postInOrder(); 
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 }; 
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 
		Index pIndex = new Index(); 
		pIndex.index = post.length - 1; 
		TreeNode root = tree.buildTree1(post, in, pIndex);  
		tree.printTree(root); 
	} 
} 

class Index{
	int index;
}


