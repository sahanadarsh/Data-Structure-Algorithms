package MidTerm;

/* Q5 Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.


Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6 */

public class ScoreOfBalancedParenthesis {

	public static int scoreOfParentheses(String S) {
		char[] arr = S.toCharArray();
		int output = 0;
		int temp = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == '(') {
				if(temp == 0) {
					temp = 1;
				}else {
					temp = temp*2;
				}
			}else {
				if(arr[i-1] == '(') {
					output = output + temp;
				}
				temp = (temp / 2);	
			}
		}
		return output;
	}

	public static void main(String[] args) {
		String s = "(()(()))";
		System.out.println(scoreOfParentheses(s));
	}
}
