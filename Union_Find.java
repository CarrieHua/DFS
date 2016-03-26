package dfs;

import java.util.ArrayList;
import java.util.List;

public class Union_Find {

	int row;
	int colum;
	int[] parent;
	int[] rank;
	public Union_Find(char[][] grid) {
		row = grid.length;
		colum = grid[0].length;
		parent = new int[row * colum];
		rank = new int[row * colum];		
		for (int i = 0; i < row * colum; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

	}

	public int find(int p) {
		List<Integer> needShortCutsNode = new ArrayList<>();
		while (parent[p] != p) {
			needShortCutsNode.add(p);
			p = parent[p];
		}
		for (Integer i : needShortCutsNode) {
			parent[i] = p;
		}
		return p;
	}

	public void union(int x, int y) {
		if (x == y) {
			return;
		}
		int p1 = find(x);
		int p2 = find(y);
		if (rank[p1] > rank[p2]) {
			parent[p2] = p1;
		}else if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
		}else {
			rank[p1] = rank[p1] + 1;
			parent[p2] = p1;
		}
	}
	
	public boolean inside(int x, int y) {
		if (x >= 0 && x <row && y >= 0 && y < colum ) {
			return true;
		}
		return false;
	}
}
