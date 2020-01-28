package MidTerm;

import java.util.Stack;

/* Q12 You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.


Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq" */

public class ReverseParenthesis {

	public static String reverseParentheses(String s) {
		if(s.length() <= 0) {
			return null;
		}
		char[] arr = s.toCharArray();
		Stack<String> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ')') {
				st.push(Character.toString(arr[i]));
			} else {
				// Remove ')'
				StringBuilder sb = new StringBuilder();
				while (!st.isEmpty() && !st.peek().equals("(") ){
					sb.append(st.pop());
				}
				// Remove '('
				st.pop();

				sb.reverse();
				st.push(sb.toString());
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String s = "(u(love)i)";
		System.out.println(reverseParentheses(s));
	}
}
