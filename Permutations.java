package dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	/**
	 * 全排列就是从第一个数字起每个数分别与它后面的数字交换
	 * 解题思路：字符交换加dfs。
	 * 将第0个字符和从第0开始的每个字符进行交换，对于交换后的结果，再从第1个字符开始交换。一直到最后一个字符。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		dfs(0, nums, result);
		return result;
	}

	public void dfs(int i, int[] nums, List<List<Integer>> result) {
		List<Integer> tmp = new ArrayList<>();
		if (i == nums.length) {
			for (int j = 0; j < nums.length; j++) {
				tmp.add(nums[j]);
			}
			result.add(tmp);
			return;

		}
		for (int j = i; j < nums.length; j++) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			dfs(i + 1, nums, result);
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
