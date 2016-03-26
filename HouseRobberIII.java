package dfs;

public class HouseRobberIII {
	/**
	 * dfs all the nodes of the tree, each node return two number, int[] num,
	 * num[0] is the max value while rob this node, num[1] is max value while
	 * not rob this value. Current node return value only depend on its
	 * children's value. Transform function should be very easy to understand.
	 * 
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] num = dfs(root);
		return Math.max(num[0], num[1]);

	}

	public int[] dfs(TreeNode x) {
		if (x == null) {
			return new int[2];
		}
		int[] left = dfs(x.left);
		int[] right = dfs(x.right);
		int[] res = new int[2];
		res[0] = left[1] + right[1] + x.val;
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
}
