package FinalExam;

import java.util.Stack;

/*
Q3
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and
removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
 */

public class RemoveDuplicates {

	public static String removeDuplicates(String s, int k) {
		if(s.length() == 0) {
			return null;
		}
		Stack<Character> charStack = new Stack<>(); 
		Stack<Integer> countStack = new Stack<>(); 
		for(char c : s.toCharArray()) {
			if(charStack.isEmpty() || c != charStack.peek()) {
				countStack.push(1);
			} else {
				countStack.push(countStack.peek() + 1); 
			}
			charStack.push(c); 
			if(countStack.peek() == k) {
				for(int i = 1; i <= k; i++) {
					countStack.pop();
					charStack.pop();  
				}
			}
		}
		StringBuilder sb = new StringBuilder(); 
		while(!charStack.isEmpty()) {
			sb.append(charStack.pop()); 
		}
		return new String(sb.reverse()); 	    
	}

	public static void main(String[] args) {
		String s = "deeedbbcccbdaa";
		int k = 3;
		System.out.println(removeDuplicates(s,k));
	}

}


