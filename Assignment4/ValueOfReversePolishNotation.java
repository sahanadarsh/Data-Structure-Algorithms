package Assignment4;

import java.util.Stack;

/* Q6
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:
Division between two integers should truncate toward zero.
The given RPN expression is always valid.
That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
 */

public class ValueOfReversePolishNotation {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> s1 = new Stack<>();
		String op = "/*+-"; 
		for(int i = 0; i < tokens.length; i++) {
			if(!op.contains(tokens[i])) {
				s1.push(Integer.valueOf(tokens[i]));
			}else {
				if(!s1.isEmpty()) {
					int num1 = s1.pop();
					int num2 = s1.pop();
					if(tokens[i].equals("*"))
						s1.push(num2 * num1);
					if(tokens[i].equals("/"))
						s1.push(num2 / num1);
					if(tokens[i].equals("+"))
						s1.push(num2 + num1);
					if(tokens[i].equals("-"))
						s1.push(num2 - num1);
				}else {
					throw new IllegalArgumentException("Invalid input");
				}
			}
		}
		return s1.pop();
	}

	public static void main(String[] args) {
		String[] ip = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println("Output: " + evalRPN(ip) );
	}
}
