package MidTerm;

/* Q4 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL */

public class OddEvenList {

	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = odd.next;
		ListNode temp = even;
		while(odd.next != null && odd.next.next != null) {
			odd.next = odd.next.next;
			temp.next = odd.next.next;
			odd = odd.next;
			temp = temp.next;
		}
		odd.next = even;		
		return head;
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

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.AddToTail(1);
		list.AddToTail(2);
		list.AddToTail(3);
		list.AddToTail(4);
		list.AddToTail(5);
		printList(list.getHeadNode());	
		ListNode newHead = oddEvenList(list.getHeadNode());
		list.setHeadNode(newHead);
		printList(list.getHeadNode());
	}
}
