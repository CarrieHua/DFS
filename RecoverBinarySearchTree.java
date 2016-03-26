package dfs;

import java.util.LinkedList;

/**
 * what we are comparing is the current node and its previous node in the
 * "in order traversal".
 * 
 * @author Administrator
 *
 */
public class RecoverBinarySearchTree {

	TreeNode firstElement = null;
	TreeNode secondElement = null;
	// The reason for this initialization is to avoid null pointer exception in
	// the first comparison when prevElement has not been initialized
	TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree2(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer
		// to 6 in the example above)
		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root
		// (refer to 2 in the example above)
		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;

		// End of "do some business"

		traverse(root.right);
	}

	public void recoverTree(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return;
		}
		TreeNode first = null;
		TreeNode second = null;
		TreeNode preElement = new TreeNode(Integer.MIN_VALUE);
		LinkedList<TreeNode> inorder = new LinkedList<>();
		inOrderTraversal(root, inorder);
		for (int i = 0; i < inorder.size(); i++) {
			TreeNode curr = inorder.get(i);
			if (first == null && preElement.val > curr.val) {
				first = preElement;
			}
			if (first != null && preElement.val > curr.val) {
				second = curr;
			}
			preElement = curr;
		}

		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	public void inOrderTraversal(TreeNode root, LinkedList<TreeNode> inorder) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left, inorder);
		inorder.add(root);
		inOrderTraversal(root.right, inorder);
	}

	public void recoverTree3(TreeNode root) {
		TreeNode current = root;
		TreeNode prev = null;
		TreeNode node1 = null;
		TreeNode node2 = null;
		while (current != null) {
			if (current.left == null) {
				if (prev != null) {
					if (prev.val >= current.val) {
						if (node1 == null)
							node1 = prev;
						node2 = current;
					}
				}
				prev = current;
				current = current.right;
			} else {
				TreeNode t = current.left;
				while (t.right != null && t.right != current)
					t = t.right;
				if (t.right == null) {
					t.right = current;
					current = current.left;
				} else {
					t.right = null;
					if (prev != null) {
						if (prev.val >= current.val) {
							if (node1 == null)
								node1 = prev;
							node2 = current;
						}
					}
					prev = current;
					current = current.right;
				}
			}
		}
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(1);
		RecoverBinarySearchTree rBinarySearchTree = new RecoverBinarySearchTree();
		rBinarySearchTree.recoverTree2(root);
	}
}
