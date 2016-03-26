package dfs;

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		if (len < 1) {
			return null;
		}
		if (len == 1) {
			TreeNode root = new TreeNode(nums[0]);
			return root;
		}
		int start = 0;
		int end = len - 1;
		return constrct(nums, start, end);
	}

	public TreeNode constrct(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = constrct(nums, start, mid - 1);
		root.right = constrct(nums, mid + 1, end);
		return root;
	}

	public static void main(String[] args) {
		ConvertSortedArraytoBinarySearchTree cTree = new ConvertSortedArraytoBinarySearchTree();
		int[] nums = { 1, 3 };
		cTree.sortedArrayToBST(nums);
	}
}
