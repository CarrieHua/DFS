package dfs;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	/**
	 * ȫ���о��Ǵӵ�һ��������ÿ�����ֱ�������������ֽ���
	 * ����˼·���ַ�������dfs��
	 * ����0���ַ��ʹӵ�0��ʼ��ÿ���ַ����н��������ڽ�����Ľ�����ٴӵ�1���ַ���ʼ������һֱ�����һ���ַ���
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
