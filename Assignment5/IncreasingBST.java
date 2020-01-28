package Assignment5;

import java.util.LinkedList;
import java.util.Queue;

/*Q2
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
 */

public class IncreasingBST {

	public TreeNode increasingBST(TreeNode root) {
		if(root == null) {
			return null;
		}
		Queue<Integer> q = new LinkedList<>();
		TreeNode out = new TreeNode(0);
		TreeNode pres = out;
		inOrder(root,q);
		while(!q.isEmpty()) {
			pres.right = new TreeNode(q.remove());
			pres = pres.right;
		}
		return out.right;
	}

	private void inOrder(TreeNode node, Queue<Integer> q){
		if(node != null){
			inOrder(node.left, q);
			q.add(node.val);
			inOrder(node.right, q);
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
		IncreasingBST tree = new IncreasingBST();
		TreeNode root = tree.CreateTree();
		TreeNode out = tree.increasingBST(root);
		tree.printTree(out);
	}
}
