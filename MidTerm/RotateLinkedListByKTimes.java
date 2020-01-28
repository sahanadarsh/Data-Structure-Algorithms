package MidTerm;

/* Q3 Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL */

public class RotateLinkedListByKTimes {

	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0) {
			return head;
		}
		int size = 1;
		ListNode oldHead = head;
		ListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
			size++;
		}
		temp.next = oldHead;
		temp = oldHead;
		for(int i = 0; i < (size-(k % size) - 1); i++) {
			temp = temp.next;
		}
		head = temp.next;
		temp.next = null;
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
		int k = 2;
		ListNode newHead = rotateRight(list.getHeadNode(), k);
		list.setHeadNode(newHead);
		printList(list.getHeadNode());
	}
}
