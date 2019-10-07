package Assignment3;


//Q1
/*
	Given a linked list, remove the n-th node from the end of list and return its head.
	Example:
	Given linked list: 1->2->3->4->5, and n = 2.
	After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

public class RemoveNthNode {

	public static void main(String[] args) {

		LinkList list = new LinkList();
		list.AddToTail(1);
		list.AddToTail(2);
		list.AddToTail(3);
		list.AddToTail(4);
		list.AddToTail(5);
		printList(list.getHeadNode());		
		printList(removeNthFromEnd(list.getHeadNode(), 2));

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode temp = new ListNode(0);
		temp.next = head;
		if(head == null || n == 0) {
			return head;
		}
		int listLength = 0;
		while(head != null) {
			listLength++;
			head = head.next;
		}
		if(n > listLength || n < 0) {
			throw new IllegalArgumentException("invalid input");
		}
		int l = listLength-n;
		head = temp;
		for(int i = 0; i < l; i++) {
			head = head.next;
		}
		head.next = head.next.next;
		return temp.next;
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
