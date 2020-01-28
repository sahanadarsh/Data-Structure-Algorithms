package Assignment4;

import java.util.Stack;

/* Q5
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
/** initialize your data structure here. */

public class MinStack {

	private Stack<Integer> main;
	private Stack<Integer> temp;

	public MinStack() {
		main = new Stack<>();
		temp = new Stack<>();
	}

	public void push(int x) {
		if(main.size() == 0){
			main.push(x);
			temp.push(x);
			return;
		}

		if(x <= temp.peek() ){
			temp.push(x);
		}
		main.push(x);
	}

	public void pop() {
		if(!main.isEmpty()) {
			int var = main.pop();
			if(var == temp.peek()) {
				temp.pop();
			}
		}
		// return main.pop();
	}

	public int top() {
		if(!main.isEmpty()) {
			return main.peek();
		} else {
			System.out.println("Stack is empty, so returning int min value as ");
			return Integer.MIN_VALUE;
		}
	}

	public int getMin() {
		if(!temp.isEmpty()) {
			return temp.peek();
		} else {
			System.out.print("Stack is empty, so returning int default mininum value as ");
			return Integer.MIN_VALUE;
		}
	}

	public static void main(String[] args) {
		MinStack s = new MinStack();
		s.push(5124);
		s.push(-1024);
		s.push(-1023);
		s.push(512);
		System.out.println("Minimum element of the stack: " + s.getMin());
		System.out.println("Top element of the stack: " + s.top());
		s.pop();
		System.out.println("Minimum element of the stack: " + s.getMin());
		System.out.println("Top element of the stack: " + s.top());
	}
}
