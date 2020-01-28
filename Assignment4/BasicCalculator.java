package Assignment4;

import java.util.Stack;

/* Bonus (LC224 Basic Calculator)
Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Input: "1 + 1"
Output: 2
Input: " 2-1 + 2 "
Output: 3
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
 */

public class BasicCalculator {

	public static int calculate(String s) {
		Stack<String> s1 = new Stack<>();
		Stack<String> s2 = new Stack<>();
		char[] ipExpr = s.toCharArray();
		if(s.isEmpty()) {
			throw new IllegalArgumentException("Invalid input");
		}

		for (int i = 0; i < ipExpr.length; i++) {
			if(ipExpr[i] == '+' || ipExpr[i] == '-'|| ipExpr[i] == '(') {
				s1.push(Character.toString(ipExpr[i]));
			}else if(Character.isDigit(ipExpr[i])) {
				//extract full number and then push 
				StringBuilder sb = new StringBuilder();
				while(Character.isDigit(ipExpr[i]))	{
					sb.append(ipExpr[i]);
					i++;
					if(i >= ipExpr.length) {
						break;
					}
				}
				i = i-1;
				s1.push(sb.toString());
			}else if(ipExpr[i] == ')'){
				//pop and evaluate expression within "(" and ")"
				while(!s1.peek().equals("(")) {
					s2.push(s1.pop());
				}
				int num1 = 0;
				if(!s2.isEmpty()) {
					num1 = Integer.valueOf(s2.pop());
				}
				while(!s2.isEmpty()) {
					String operator = s2.pop();
					int num2 = Integer.valueOf(s2.pop());
					if(operator.equals("+")) {
						num1 = num1 + num2;
					}else if(operator.equals("-")){
						num1 = num1 - num2;
					}
				}
				//pop "(" from stack 1
				s1.pop();
				//push evaluated expression output within "(" and ")" back to stack 1
				s1.push(String.valueOf(num1));
			}
		}

		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		int n1 = 0;
		if(!s2.isEmpty()) {
			n1 = Integer.valueOf(s2.pop());
		}
		while(!s2.isEmpty()) {
			String op = s2.pop();
			int n2 = Integer.valueOf(s2.pop());
			if(op.equals("+")) {
				n1 = n1 + n2;
			}else if(op.equals("-")){
				n1 = n1 - n2;
			}
		}
		return n1;
	}


	public static void main(String[] args) {
		String s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));
	}
}
