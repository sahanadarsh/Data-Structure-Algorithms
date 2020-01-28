package Assignment4;

import java.util.Stack;

/* Q2
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Input: "()"
Output: true

Input: "()[]{}"
Output: true

Input: "(]"
Output: false

Input: "{[]}"
Output: true
 */

public class InputStringValid {

	public static boolean isValid(String s) {
		char[] exp = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0 ; i < exp.length ; i ++){
			if(exp[i] == '{' ||  exp[i] == '(' || exp[i] == '['){
				stack.push(exp[i]);
			}
			if(exp[i] == '}' ||  exp[i] == ')' || exp[i] == ']'){
				if(stack.isEmpty())
					return false;
				char test = stack.pop();
				if(! AreMatching( test, exp[i]))
					return false;
			}
		}
		return stack.isEmpty() ;
	}

	public static boolean AreMatching( char one, char two){

		if(one == '(' && two == ')')
			return true;
		if(one == '{' && two == '}')
			return true;
		if(one == '[' && two == ']')
			return true;
		return false;
	}

	public static void main(String[] args) {
		String s = "{[]}";
		if(isValid(s)) {
			System.out.println("Input string is valid");
		} else {
			System.out.println("Input string is not valid");
		}
	}
}
