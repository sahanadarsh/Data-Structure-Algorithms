package FinalExam;

import java.util.ArrayList;
import java.util.List;

/*
Q12
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

public class GenerateParenthesis {

	public static List<String> generateParenthesis(int n){
		List<String> combinations = new ArrayList<String>();
		char[] arr = new char[n*2];
		generateParenthesis(arr, 0, combinations);
		return combinations;
	}

	private static void generateParenthesis( char[] arr, int current, List<String> result){
		if(current == arr.length){
			// check if this is valid parenthesis combination
			if(isValidParenthesis(arr)) {
				result.add(new String(arr));
			}
		}else {
			arr[current] = '(';
			generateParenthesis(arr, current +1, result);
			arr[current] = ')';
			generateParenthesis(arr, current +1, result);
		}
	}

	private static boolean isValidParenthesis(char[] arr){
		int balance = 0;
		for (char ch: arr) {
			if(ch == '(') {
				balance ++;
			}else {
				balance --;
			}
			if(balance < 0) {
				return  false;
			}
		}
		return  balance == 0;
	}

	public static void main(String[] args) {
		int n = 3;
		List<String> result = generateParenthesis(n);
		for(String s : result) {
			System.out.print(s);
			System.out.println("");
		}
	}
}
