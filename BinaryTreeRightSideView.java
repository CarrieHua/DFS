package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<>();
		if (root == null) {
			return rightView;
		}
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		TreeNode node;
		q1.offer(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			if (!q1.isEmpty()) {
				rightView.add(q1.peek().val);
			}
			while (!q1.isEmpty()) {
				node = q1.poll();
				if (node.right != null) {
					q2.offer(node.right);
				}
				if (node.left != null) {
					q2.offer(node.left);
				}
			}

			if (!q2.isEmpty()) {
				rightView.add(q2.peek().val);
			}
			while (!q2.isEmpty()) {
				node = q2.poll();
				if (node.right != null) {
					q1.offer(node.right);
				}
				if (node.left != null) {
					q1.offer(node.left);
				}
			}

		}
		return rightView;
	}
	

	public List<Integer> rightSideView2 (TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return result;
		}
		queue.offer(root);
		while (queue.size() != 0) {
			int size = queue.size();
			for (int i =0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (i == 0) {
					result.add(cur.val);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
			}
		}
		return result;
		
	}
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		List<Integer> result = rightSideView(root);
		for (Integer integer : result) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
		binaryTreeRightSideView.test();
	}
}
