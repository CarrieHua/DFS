package dfs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
	List<TreeNode> list = new ArrayList<>();

	public boolean isValidBST(TreeNode root) {
		inorderTraversal(root);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).val > list.get(i + 1).val) {
				return false;
			}
		}
		return true;
	}

	public void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		list.add(root);
		inorderTraversal(root.right);
	}
}
