package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		dfs(0, nums, result);
		return new ArrayList<List<Integer>>(result);

	}

	public void dfs(int i, int[] nums, Set<List<Integer>> result) {
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

	/**
	 * 我们把数组排序后，可以从空集开始，不断添加没有使用过的数字形成新的set，
	 * 直到这个set的长度等于nums数组的长度那么就找到了一个Permutation。
	 * 用DFS搜索解比较直接。但是这题要注意判断重复数字的情况，对于排序后的数组从前向后迭代，重复数字肯定是相邻数字，
	 * 那么如果当前数字等于前一个相邻数字而前一个数字没有使用， 说明添加这个数字到尾部所形成的分支已经在之前搜索过，不必再搜索一次，可以剪掉，直接返回。
	 * 
	 * 注意向结果List中添加新的Permutation时要添加拷贝而不是原来的对象引用，
	 * 否则后面对state的操作会覆盖之前添加的Permutation，这是很容易犯的的错误，要特别小心。
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteUnique2(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		List<Integer> state = new ArrayList<>();		
		traversal(nums, result, state, new boolean[nums.length]);
		return result;
	}

	public void traversal(int[] nums, List<List<Integer>> result, List<Integer> state, boolean[] used) {
		if (state.size() == nums.length) {
			result.add(new ArrayList(state));//add a copy
			return;
		}
		for (int i = 0; i < used.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;// judge duplicate
			if (!used[i]) {
				used[i] = true;
				state.add(nums[i]);
				traversal(nums, result, state, used);
				state.remove(state.size() - 1);
				used[i] = false;
			}
		}

	}
}
