package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		String s = "";
		int left = n;
		int right = n;
		generate(s + '(', left - 1, right, result);
		return result;
	}

	public void generate(String s, int left, int right, List<String> result) {
		if (left == 0 && right == 0) {
			result.add(s);
			return;
		}
		if (left > 0) {
			generate(s + '(', left - 1, right, result);
		}
		if (right > 0 && left < right) {					
			generate(s + ')', left, right - 1,result);
		}
	}
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(8));
	}

}
