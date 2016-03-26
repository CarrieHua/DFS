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
	 * ���ǰ���������󣬿��Դӿռ���ʼ���������û��ʹ�ù��������γ��µ�set��
	 * ֱ�����set�ĳ��ȵ���nums����ĳ�����ô���ҵ���һ��Permutation��
	 * ��DFS������Ƚ�ֱ�ӡ���������Ҫע���ж��ظ����ֵ���������������������ǰ���������ظ����ֿ϶����������֣�
	 * ��ô�����ǰ���ֵ���ǰһ���������ֶ�ǰһ������û��ʹ�ã� ˵�����������ֵ�β�����γɵķ�֧�Ѿ���֮ǰ������������������һ�Σ����Լ�����ֱ�ӷ��ء�
	 * 
	 * ע������List������µ�PermutationʱҪ��ӿ���������ԭ���Ķ������ã�
	 * ��������state�Ĳ����Ḳ��֮ǰ��ӵ�Permutation�����Ǻ����׷��ĵĴ���Ҫ�ر�С�ġ�
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
