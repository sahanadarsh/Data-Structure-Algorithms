package MidTerm;

import java.util.Stack;

/* Q11 Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.

Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.*/

public class ValidateStackSequences {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		if(pushed.length == 0 && popped.length == 0) {
			return true;
		}
		if(pushed.length == 0 || popped.length == 0 || (pushed.length != popped.length)) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int poppedIdx = 0;
		for(int pushedIdx = 0; pushedIdx < pushed.length; pushedIdx++) {
			stack.push(pushed[pushedIdx]);
			if(stack.peek() == popped[poppedIdx]) {
				while(!stack.isEmpty() && stack.peek() == popped[poppedIdx]) {
					stack.pop();
					poppedIdx++;
				}
			}
		}

		while(!stack.isEmpty() && poppedIdx < popped.length) {
			if(popped[poppedIdx] != stack.pop()) {
				return false;
			}
			poppedIdx++;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		System.out.println(validateStackSequences(pushed, popped));
	}
}
