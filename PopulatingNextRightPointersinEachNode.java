package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null && root.next == null)) {
			return;
		}
		Queue<TreeLinkNode> q1 = new LinkedList<>();
		Queue<TreeLinkNode> q2 = new LinkedList<>();
		q1.offer(root);
		TreeLinkNode node;
		while (!q1.isEmpty() || !q2.isEmpty()) {
			while (!q1.isEmpty()) {
				node = q1.poll();
				if (node.left != null) {
					q2.offer(node.left);
				}
				if (node.right != null) {
					q2.offer(node.right);
				}
				if (!q1.isEmpty()) {
					node.next = q1.peek();
				}else {
					node.next = null;
				}
			}
			while (!q2.isEmpty()) {
				node = q2.poll();
				if (node.left != null) {
					q1.offer(node.left);
				}
				if (node.right != null) {
					q1.offer(node.right);
				}
				if (!q2.isEmpty()) {
					node.next = q2.peek();
				}else {
					node.next = null;
				}
				
			}
		}
	}
	public void connect2(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null && root.next == null)) {
			return;
		}
		TreeLinkNode level_start = root;
		while (level_start != null) {
			TreeLinkNode curr = level_start;
			while (curr != null) {
				if (curr.left != null) {
					curr.left.next = curr.right;
				}
				if (curr.right != null && (curr.next != null)) {
					curr.right.next = curr.next.left;
				}
				curr = curr.next;
			}
			level_start = level_start.left;
		}
	}
}
