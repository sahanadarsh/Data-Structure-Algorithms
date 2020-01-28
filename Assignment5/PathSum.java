package Assignment5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*Q9
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class PathSum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		LinkedList<Integer> list = new LinkedList<>();
		List<List<Integer>> outList = new ArrayList<List<Integer>>();
		pathSum(root, list, 0, sum, outList);
		return outList;

	}

	private void pathSum(TreeNode node, LinkedList<Integer>  list, int ptr, int sum, List<List<Integer>> outList){

		if(node == null) {
			return;
		}
		list.add(node.val);
		if((node.left == null && node.right == null) && (sum == (ptr + node.val))){
			outList.add(new ArrayList<>(list));
		}
		pathSum(node.left, list, ptr +node.val, sum, outList);
		pathSum(node.right, list, ptr +node.val, sum, outList);
		list.pollLast();
	}

	public TreeNode CreateTree(){
		TreeNode root= new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		return root;
	}

	public static void main(String[] args) {
		PathSum tree = new PathSum();
		TreeNode root = tree.CreateTree();
		int sum = 22;
		List<List<Integer>> result = tree.pathSum(root, sum);
		for (int i = 0; i < result.size(); i++) { 
			for (int j = 0; j < result.get(i).size(); j++) { 
				System.out.print(result.get(i).get(j) + " "); 
			} 
			System.out.println(); 
		} 
	}
}
