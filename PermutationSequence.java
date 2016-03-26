package dfs;

import java.util.ArrayList;

public class PermutationSequence {

	
	/**
	 * 在n!个排列中，第一位的元素总是(n-1)!一组出现的，也就说如果p = k / (n-1)!，那么排列的最开始一个元素一定是nums[p]。
	 * 假设有n个元素，第K个permutation是  a1, a2, a3, .....   ..., an
	 * 那么a1是哪一个数字呢？
	 * 那么这里，我们把a1去掉，那么剩下的permutation为
	 * a2, a3, .... .... an, 共计n-1个元素。 n-1个元素共有(n-1)!组排列，那么这里就可以知道
	 * 设变量K1 = K
	 * a1 = K1 / (n-1)!
	 * 同理，a2的值可以推导为
	 * K2 = K1 % (n-1)!;   a2 = K2 / (n-2)!
	 * ......
	 * K(n-1) = K(n-2) /2!; a(n-1) = K(n-1) / 1!
	 * an = K(n-1)
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {

		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
		// change k to be index
		k --;
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i ++) {
			mod = mod * i;
		}
		String result = "";
		//find sequence
		for (int i = 0; i < n; i ++) {
			mod = mod / (n - i);
			int curIndex = k / mod; // find the right number (curIndex) of
			k = k % mod; //update k
			// get number according to curIndex
			result += numberList.get(curIndex);
			//remove from list
			numberList.remove(curIndex);
		}
		return result.toString();
		
	}

	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(3, 3));
	}
}
