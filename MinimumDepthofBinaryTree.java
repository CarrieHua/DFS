package dfs;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		TreeNode node = root;
		int level = 0;
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.add(node);
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			if (!queue1.isEmpty()) {
				while (!queue1.isEmpty()) {
					node = queue1.remove();
					if (node.left == null && node.right == null)
						return level + 1;
					if (node.left != null)
						queue2.add(node.left);
					if (node.right != null)
						queue2.add(node.right);

				}
				level = level + 1;
			} else {
				while (!queue2.isEmpty()) {
					node = queue2.remove();
					if (node.left == null && node.right == null)
						return level + 1;
					if (node.left != null)
						queue1.add(node.left);
					if (node.right != null)
						queue1.add(node.right);

				}
				level = level + 1;
			}
		}
		return level;

	}

	public void test() {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		TreeNode root2 = null;
		TreeNode root3 = new TreeNode(1);
		ArrayList<TreeNode> rootList = new ArrayList<>();
		rootList.add(root1);
		rootList.add(root2);
		rootList.add(root3);
		for (TreeNode treeNode : rootList) {
			System.out.println(minDepth(treeNode));
		}
	}

	public static void main(String[] args) {
		MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
		minimumDepthofBinaryTree.test();
	}
}
