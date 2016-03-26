package dfs;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			return true;
			
		}
		if (root.left == null && root.right == null && root.val != sum) {
			return false;
		}
		return dfs(root, 0,sum);
	}
	public boolean dfs(TreeNode root, int currSum,int Sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && currSum + root.val == Sum) {
			return true;
		}
		if (root.left == null && root.right == null && currSum + root.val != Sum) {
			return false;
		}
		boolean has = false;
		if (root.left != null) {
			has = dfs(root.left, currSum + root.val, Sum);
		}
		if (has) {
			return has;
		}
		else if (root.right != null) {
			has = dfs(root.right, currSum + root.val, Sum);
		}
		return has;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(3);
		PathSum pathSum = new PathSum();
		System.out.println(pathSum.hasPathSum(root, 1));
		
	}
	
}
