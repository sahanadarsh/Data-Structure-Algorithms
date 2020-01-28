package Assignment4;

import java.util.Stack;

/* Q3
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.

MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
 */

public class MyQueue {

	private Stack<Integer> s1;
	private Stack<Integer> s2;

	public MyQueue(){
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		s1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(s1.size() == 0 ) {
			// or throw exception or return null
			System.out.print("stack is empty, returning interger min value ");
			return Integer.MIN_VALUE;
		}
		/*another solution to pop element
				int returnValue = s1.get(0);
				s1.removeElementAt(0);
				return returnValue;
		*/
		while(s1.size() > 0){
			s2.push(s1.pop());
		}
		int retVal = s2.pop();

		while(s2.size() > 0){
			s1.push(s2.pop());
		}
		return retVal;
	}

	/** Get the front element. */
	/** In this implementation peek() method returns Integer.MIN_VALUE if stack is empty */
	public int peek() {
		if(!s1.isEmpty()) {
			return s1.firstElement();
		} else {
			// or throw exception
			System.out.print("stack is empty, returning interger min value ");
			return Integer.MIN_VALUE;
		}
	}
/*	In this implementation peek() method returns null if stack is empty
 
	public Integer peek() {
		if(!s1.isEmpty()) {
			return s1.firstElement();
		} else {
			return null;
		}
	}
*/

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1.isEmpty();
	}

	public  void printQueue() {
		s1.forEach(k ->{
			System.out.println(""+k);
		});
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);  
		queue.push(5);
		queue.push(9);
		System.out.println("Queue elements are: ");
		queue.printQueue();
		System.out.println("Popped element: " + queue.pop());
		System.out.println("Popped element: " + queue.pop());
		System.out.println("peek element: " + queue.peek());
		System.out.println("Queue is empty: " + queue.empty());
	}
}
