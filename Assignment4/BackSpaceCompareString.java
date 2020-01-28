package Assignment4;

import java.util.Arrays;
import java.util.Stack;

/* Q4
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
 */

public class BackSpaceCompareString{

	public static boolean backspaceCompare(String S, String T) {

		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		boolean flag = true;
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) != '#') {
				stack1.push(S.charAt(i));
			}else {
				if(!stack1.isEmpty()) {
					stack1.pop();
				}
			}
		}
		for(int j = 0; j < T.length(); j++) {
			if(T.charAt(j) != '#') {
				stack2.push(T.charAt(j));
			}else {
				if(!stack2.isEmpty()) {
					stack2.pop();
				}
			}
		}
		printStack(stack1);
		printStack(stack2);

		if(stack1.size() != stack2.size()) {
			flag = false;
		} else {
			while(!stack1.isEmpty() && !stack2.isEmpty()) {
				if(stack1.peek() == stack2.peek()) {
					stack1.pop();
					stack2.pop();
				} else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	public static  void printStack(Stack<Character> s) {
		System.out.println(Arrays.toString(s.toArray()));
	}

	public static void main(String[] args) {
		String S = "ab#c";
		String T = "ad#c";
		System.out.println(backspaceCompare(S, T));
	}

}
