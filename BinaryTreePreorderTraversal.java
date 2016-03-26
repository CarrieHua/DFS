package dfs;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreePreorderTraversal {
	List<Integer> preOrder = new ArrayList<>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return preOrder;
		}		
		preOrder.add(root.val);
		if (root.left != null) {
			preorderTraversal(root.left);
		}
		if (root.right != null) {
			preorderTraversal(root.right);	
		}
		
		return preOrder;
	}
	
	public void print(List<Integer> list) {
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinaryTreePreorderTraversal bTraversal = new BinaryTreePreorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		bTraversal.print(bTraversal.preorderTraversal(root));
		
	}

}
