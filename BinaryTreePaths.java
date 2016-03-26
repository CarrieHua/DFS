package dfs;

import java.util.ArrayList;

import java.util.List;



public class BinaryTreePaths {
	
	/*
	int maxDepth = 0; 
    public int maxDepth(TreeNode root) {        
        if (root == null) {
			return 0;
		}              
		searchDepth(root,1);		
        return maxDepth;
    }
	public void searchDepth(TreeNode root,int currentDepth) {
		if (root.left == null && root.right == null) {
			if (currentDepth > maxDepth) {
				maxDepth = currentDepth;
			}
		}
		if (root.left != null) {
			searchDepth(root.left,currentDepth + 1);
		}
		if (root.right != null) {
			searchDepth(root.right,currentDepth + 1);
		}
	}
	*/
	
	
	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> nodePath = new ArrayList<>();
		if (root != null) {
			searchBT(root, "", nodePath);
		}
		return nodePath;                     
	}
	public void searchBT(TreeNode root, String path, List<String> nodePath) {
		if (root.left == null && root.right == null) {
			nodePath.add(path + root.val);
		}
		if (root.left != null) {
			searchBT(root.left, path  + root.val+ "->", nodePath);
		}
		if (root.right != null) {
			searchBT(root.right, path  + root.val+ "->", nodePath);
		}
	}
	
 	public void testCases() {
		List<TreeNode> testcases = new ArrayList<TreeNode>();

		TreeNode root1 = null;
		testcases.add(root1);

		TreeNode root2 = new TreeNode(1);
		testcases.add(root2);

		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.left.left = new TreeNode(3);
		testcases.add(root3);

		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.right = new TreeNode(3);
		testcases.add(root4);

		TreeNode root5 = new TreeNode(1);
		root5.left = new TreeNode(2);
		root5.right = new TreeNode(3);
		root5.right.left = new TreeNode(4);
		root5.right.right = new TreeNode(5);
		testcases.add(root5);
		for (TreeNode treeNode : testcases) {
//			System.out.println(maxDepth(treeNode));			
		}
		
	}
	
	
 	public void createTestCases() {
		List<TreeNode> testcases = new ArrayList<TreeNode>();

		TreeNode root1 = null;
		testcases.add(root1);

		TreeNode root2 = new TreeNode(1);
		testcases.add(root2);

		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.left.left = new TreeNode(3);
		testcases.add(root3);

		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.right = new TreeNode(3);
		testcases.add(root4);

		TreeNode root5 = new TreeNode(1);
		root5.left = new TreeNode(2);
		root5.right = new TreeNode(3);
		root5.right.left = new TreeNode(4);
		root5.right.right = new TreeNode(5);
		testcases.add(root5);
		for (TreeNode treeNode : testcases) {
			if (treeNode == null) {
				continue;
			}
			List<String> treePath = binaryTreePaths(treeNode);
			for (String string : treePath) {
				System.out.println(string);
			}
			System.out.println();
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
		TreeNode root4 = new TreeNode(1);
		root4.left = new TreeNode(2);
		root4.right = new TreeNode(3);
//		System.out.println(binaryTreePaths.maxDepth(root4));
//		binaryTreePaths.testCases();
//		binaryTreePaths.createTestCases();
		/*
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		binaryTreePaths.binaryTreePaths(root);*/
	}
	
}
