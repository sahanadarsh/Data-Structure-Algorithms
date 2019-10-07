package Assignment3;

//Q2
/*
 * Given a linked list, swap every two adjacent nodes and return its head.
	You may not modify the values in the list's nodes, only nodes itself may be changed.
	Example:
	Given 1->2->3->4, you should return the list as 2->1->4->3.
 */

public class Swap2AdjacentNodes {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.AddToTail(1);
		list.AddToTail(2);
		list.AddToTail(3);
		list.AddToTail(4);
		list.AddToTail(5);
		printList(list.getHeadNode());
		printList(swapPairs(list.getHeadNode()));
	}

	public static ListNode swapPairs(ListNode head) {
		
		//Initializing current to head
		ListNode current = head;
		ListNode front;
		ListNode back;
		
		//Condition to return from recursive call
		if (current == null || current.next == null) {
			return head;
		}
		
		//Call swapPairs recursively to reach the end
		back = swapPairs(current.next.next);
		
	    //swapping the two adjacent nodes 
		front = current.next;
		current.next = back;
		front.next = current; 
		
		return front;
	}

	public static void printList(ListNode head){
		ListNode temp = head;
		while(temp != null){
			if (temp.next != null) {
				System.out.print(temp.val + " -> ");
			} else {
				System.out.print(temp.val);	
			}
			temp = temp.next;
		}
		System.out.println("");
	}
}
