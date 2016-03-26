package dfs;

import java.util.ArrayList;


public class BalancedBinaryTree {

	boolean result = true;
	public boolean isBalanced(TreeNode root) {
		
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		maxDepth(root);
		return result;
	}
	public int maxDepth(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
		if (Math.abs(l - r) > 1) {
			result = false;
			return -1;
		}
		return 1 + Math.max(l, r);
	}



	public void test() {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(1);		
		root2.right = new TreeNode(3);
		root2.right.right = new TreeNode(4);
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.right = new TreeNode(3);
		
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.right = new TreeNode(2);
		root4.left.left = new TreeNode(2);
		root4.left.right = new TreeNode(3);
		root4.left.left.right = new TreeNode(3);
		root4.left.left.left = new TreeNode(3);
		root4.left.left.right = new TreeNode(4);
		root4.left.left.right.left = new TreeNode(4);
		ArrayList<TreeNode> rootList = new ArrayList<>();
		rootList.add(root1);
		rootList.add(root2);
		rootList.add(root3);
		rootList.add(root4);
		for (TreeNode treeNode : rootList) {
			System.out.println(isBalanced(treeNode));
		}

	}

	public static void main(String[] args) {
		BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
		balancedBinaryTree.test();
	}
}
