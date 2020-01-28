package FinalExam;

import java.util.HashMap;
import java.util.Map;

/*
Q1
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
After doing so, return the head of the final linked list.  You may return any such answer.


(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example:
Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.

Input: head = [1,2,3,-3,4]
Output: [1,2,4]

Input: head = [1,2,3,-3,-2]
Output: [1]
 */

public class RemoveZeroSumSublists {

	public static ListNode removeZeroSumSublists(ListNode head) {
		if(head == null) {
			return head;
		}
		Map<Integer, ListNode> map = new HashMap<>();
		ListNode temp = new ListNode(0);
		int sum = 0;
		temp.next = head;
		ListNode curr = temp;
		while( curr != null) {
			sum = sum + curr.val;
			map.put(sum, curr);
			curr = curr.next;
		}
		sum = 0;
		curr = temp;
		while( curr != null) {
			sum = sum + curr.val;
			curr.next = map.get(sum).next;
			curr = curr.next;
		}
		return temp.next;	
	}		

	public static void main(String[] args) {
		LinkList l1 = new LinkList();
		l1.AddToTail(1);
		l1.AddToTail(2);
		l1.AddToTail(-3 );
		l1.AddToTail(3);
		l1.AddToTail(1);
		LinkList.printList(l1.getHeadNode());
		ListNode result = removeZeroSumSublists(l1.getHeadNode());
		LinkList.printList(result);
	}	
}
