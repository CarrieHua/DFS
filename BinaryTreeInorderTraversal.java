package dfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	List<Integer> inOrder = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return inOrder;
		}
		if (root.left == null) {
			inOrder.add(root.val);
			if (root.right != null) {
				inorderTraversal(root.right);
			}
			else {
				return inOrder;
			}
		}
		else {
			inorderTraversal(root.left);
			inOrder.add(root.val);
			if (root.right != null) {
				inorderTraversal(root.right);	
			}
		}
		
		return inOrder;
    }
	public void print(List<Integer> list) {
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinaryTreeInorderTraversal bTraversal = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		bTraversal.print(bTraversal.inorderTraversal(root));
		
	}
}
