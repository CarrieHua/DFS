package dfs;

public class NumberofIslands {
	int m;
	int n;

	/**
	 * DFS
	 * 思路：DFS、BFS。只要遍历一遍，碰到一个1，就把它周围所有相连的1都标记为非1，这样整个遍历过程中碰到的1的个数就是所求解。
	 * @param grid
	 * @return
	 */
	public int numIslands2(char[][] grid) {
		m = grid.length;
		if (m == 0) {
			return 0;
		}
		n = grid[0].length;
		if (n == 0) {
			return 0;
		}
		int numIslands = 0;
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if (grid[i][j] != '1') {
					continue;
				}
				numIslands ++;
				dfs(i, j, grid);
			}
		}
		return numIslands;
	}
	public void dfs(int row, int colum, char[][] grid) {
		if (row < 0 || row >= m || colum < 0 || colum >= n) {
			return;
		}
		if (grid[row][colum] == '1') {
			grid[row][colum] = '2';			
			dfs(row - 1, colum, grid);
			dfs(row + 1, colum, grid);
			dfs(row, colum - 1, grid);
			dfs(row, colum + 1, grid);
			
		}
	}

	/**
	 * Union_Find
	 * 
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		Union_Find uFind = new Union_Find(grid);
		int N = uFind.row;
		int M = uFind.colum;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != '0') {
					int tmp = i * M + j;
					if (uFind.inside(i - 1, j) && grid[i - 1][j] != '0') {
						uFind.union(tmp, tmp - M);
					}
					if (uFind.inside(i + 1, j) && grid[i + 1][j] != '0') {
						uFind.union(tmp, tmp + M);
					}
					if (uFind.inside(i, j - 1) && grid[i][j - 1] != '0') {
						uFind.union(tmp, tmp - 1);
					}
					if (uFind.inside(i, j + 1) && grid[i][j + 1] != '0') {
						uFind.union(tmp, tmp + 1);
					}
				}
			}
		}
		int islands = 0, i = 0;
		while (i < N * M) {
			if (uFind.parent[i] == i && grid[i / M][i % M] != '0') {
				islands++;
			}
			i++;
		}
		return islands;
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		char[][] grid2 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		char[][] grid3 = { { '1', '0', '1', '1', '1' }, { '1', '0', '1', '0', '1' }, { '1', '1', '1', '0', '1' } };
		NumberofIslands nIslands = new NumberofIslands();
		System.out.println(nIslands.numIslands2(grid));
		System.out.println(nIslands.numIslands2(grid2));
		System.out.println(nIslands.numIslands2(grid3));

	}
}
