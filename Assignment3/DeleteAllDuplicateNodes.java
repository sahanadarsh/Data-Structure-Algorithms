package Assignment3;

//Q3
/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	Example 1:
	Input: 1->2->3->3->4->4->5
	Output: 1->2->5
	Example 2:

	Input: 1->1->1->2->3
	Output: 2->3
 */

public class DeleteAllDuplicateNodes {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.AddToTail(1);
		list.AddToTail(2);
		list.AddToTail(2);
		list.AddToTail(3);
		list.AddToTail(4);
		printList(list.getHeadNode());		
		ListNode newHead = deleteDuplicates(list.getHeadNode());
		list.setHeadNode(newHead);
		printList(list.getHeadNode());


	}

	public static ListNode deleteDuplicates(ListNode head) {

		ListNode prev;
		ListNode cur;
		ListNode node0 = new ListNode(0);
		node0.next = head;

		prev = node0;
		cur = head;

		while (cur != null) {

			while (cur.next != null && prev.next.getVal() == cur.next.getVal()) {
				cur = cur.next;
			}
			if (cur != prev.next) {
				prev.next = cur.next;					
			} else {
				prev = prev.next;
			}
			cur = cur.next;
		}

		return node0.next;
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
