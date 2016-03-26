package dfs;


import java.util.ArrayList;
import java.util.Stack;

public class SymmetricTree {
/*	private ArrayList<Integer> left_list = new ArrayList<>();
	private ArrayList<Integer> right_list = new ArrayList<>();
	public boolean isSymmetric(TreeNode root) {
		left_list.clear();
		right_list.clear();
		
		if (root == null || (root.left == null && root.right == null)) 
			return true;
		dfsLeft(root);
		dfsRight(root);
		
		//return left_list.equals(right_list);
		int len = left_list.size();
		for (int i =0; i < len; i ++) {
			if (left_list.get(i) != right_list.get(i)) {
				return false;
			}
		}
		return true;
	}

	public void dfsLeft(TreeNode root) {
		if (root == null ) {
			
			return;
		}
		dfsLeft(root.left);			
		dfsLeft(root.right);

	}

	public void dfsRight(TreeNode root) {
		if (root == null) {			
			return;
		}
		dfsRight(root.right);
		dfsRight(root.left);		
	}*/
	/*
	public boolean isSymmetric(TreeNode root) {
		if (root == null ||(root.left == null && root.right ==null)) {
			return true;
		}
		return isSymmetricHelp(root.left,root.right);
	}
	public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}*/
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode left, right;
		if (root.left != null) {
			if (root.right == null) {
				return false;
			}
			stack.push(root.left);
			stack.push(root.right);			
		}
		else if (root.right == null) {
			return false;
		}
		
		while (!stack.isEmpty()) {
			if (stack.size() % 2 != 0) {
				return false;
			}
			right = stack.pop();
			left = stack.pop();
			if (right.val != left.val) {
				return false;
			}
			if (left.left != null ) {
				if (right.right == null) {
					return false;
				}
				  stack.push(left.left);
				  stack.push(right.right);
			}
			else if (right.right != null) {
				return false;
			}
			if (left.right != null) {
				if (right.left == null) {
					return false;
				}
				stack.push(left.right);
				stack.push(right.left);
			}
			else if (right.left != null) {
				return false;
			}
		}
		return true;
	}
	public void testCase() {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(4);
		root1.right.right = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(3);
		root2.right.left = new TreeNode(2);
		ArrayList<TreeNode> rootList = new ArrayList<>();
		rootList.add(root1);
		rootList.add(root2);
		for (TreeNode treeNode : rootList) {
			System.out.println(isSymmetric(treeNode));
		}
	}
	public static void main(String[] args) {
		SymmetricTree symmetricTree = new SymmetricTree();
		symmetricTree.testCase();
	}
}
