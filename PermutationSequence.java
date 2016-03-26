package dfs;

import java.util.ArrayList;

public class PermutationSequence {

	
	/**
	 * ��n!�������У���һλ��Ԫ������(n-1)!һ����ֵģ�Ҳ��˵���p = k / (n-1)!����ô���е��ʼһ��Ԫ��һ����nums[p]��
	 * ������n��Ԫ�أ���K��permutation��  a1, a2, a3, .....   ..., an
	 * ��ôa1����һ�������أ�
	 * ��ô������ǰ�a1ȥ������ôʣ�µ�permutationΪ
	 * a2, a3, .... .... an, ����n-1��Ԫ�ء� n-1��Ԫ�ع���(n-1)!�����У���ô����Ϳ���֪��
	 * �����K1 = K
	 * a1 = K1 / (n-1)!
	 * ͬ��a2��ֵ�����Ƶ�Ϊ
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
