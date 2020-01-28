package Assignment4;

import java.util.Stack;

/* Q11
Implement a queue by using two stacks and Optimize poll function(Dequeue() in C#).
 */

public class QueueOptimizePoll {

	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();

	public void add(int data) {
		s1.push(data);
	}

	/*	In this implementation poll() method returns null if stack is empty

   public Integer poll() {
		if(s1.size() == 0 ) {
			return null;
		}
		while(s1.size() > 0){
			s2.push(s1.pop());
		}
		int retVal = s2.pop();

		while(s2.size() > 0){
			s1.push(s2.pop());
		}
		return retVal;
	}
	 */

	//In this implementation poll() method returns Integer.MIN_VALUE if stack is empty
	public int poll() {
		if(s1.size() == 0 ) {
			//or throw exception
			System.out.print("stack is empty, returning interger min value ");
			return Integer.MIN_VALUE;
		}
		while(s1.size() > 0){
			s2.push(s1.pop());
		}
		int retVal = s2.pop();

		while(s2.size() > 0){
			s1.push(s2.pop());
		}
		return retVal;
	}

	public int getCount() {
		return s1.size();
	}
	

	public  void printQueue() {
		s1.forEach(k ->{
			System.out.println(""+k);
		});
	}

	public static void main(String[] args) {
		QueueOptimizePoll queue = new QueueOptimizePoll();
		queue.add(1);
		queue.add(2);  
		queue.add(5);
		queue.add(9);
		System.out.println("Queue elements are: ");
		queue.printQueue();
		System.out.println("size of the queue: " + queue.getCount());
		System.out.println("Popped element: " + queue.poll());
		System.out.println("Popped element: " + queue.poll());
		System.out.println("size of the queue: " + queue.getCount());
	}
}
