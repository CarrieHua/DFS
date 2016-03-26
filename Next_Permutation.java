package dfs;


public class Next_Permutation {
	
	/**
	 * 1 Start from its last element, traverse backward to find the first one with index i that satisfy num[i-1] < num[i].
	 * So, elements from num[i] to num[n-1] is reversely sorted.
	 * 2 To find the next permutation, we have to swap some numbers at different positions, to minimize the increased amount, 
	 * we have to make the highest changed position as high as possible. 
	 * Notice that index larger than or equal to i is not possible as num[i,n-1] is reversely sorted.
	 * So, we want to increase the number at index i-1, clearly, swap it with the smallest number between num[i,n-1] 
	 * that is larger than num[i-1].
	 * 3 The last step is to make the remaining higher position part as small as possible, 
	 * we just have to reversely sort the num[i,n-1]
	 * @param nums
	 */

	public void nextPermutation(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return;
		}
		int index = n - 1;
		while (index > 0) {
			if (nums[index - 1] < nums[index]) {
				break;
			}
			index = index - 1;
		}
		if (index == 0) {
			reverseSort(nums, index, n - 1);
			return;
		}
		int val = nums[index - 1];
		int j = n - 1;
		while (j >= index) {
			if (nums[j] > val) {
				break;
			}
			j --;
		}
		swap(nums, j, index - 1);
		reverseSort(nums, index, n - 1);
		return;
	}
	public void swap ( int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public void reverseSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		for (int i = start; i <= (start + end)/2; i ++) {
			swap(nums, i, start + end - i);
		}
	}
	

	public static void main(String[] args) {
		int[] nums = { 1, 4, 6, 5, 3, 2 };
		Next_Permutation np = new Next_Permutation();
		np.nextPermutation(nums);
		System.out.println(nums.toString());
	}
}
