package Assignment3;

//Q9
/*
 * Reverse a linked list from position m to n. Do it in one-pass.
	Note: 1 <= m <= n <= length of list.

	Example:
	Input: 1->2->3->4->5->NULL, m = 2, n = 4
	Output: 1->4->3->2->5->NULL
 */

public class ReverseLinkListFromMToN {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.AddToTail(1);
		list.AddToTail(2);
		list.AddToTail(3);
		list.AddToTail(4);
		list.AddToTail(5);
		list.AddToTail(6);
		printList(list.getHeadNode());
		printList(reverseBetween(list.getHeadNode(),2,5));
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {

		int listLength = 0;
		ListNode temp = head;

		while(temp != null) {
			listLength++;
			temp = temp.next;
		}

		if( m < 1 || m > n || n < 1 || m > listLength || n > listLength) {
			System.out.println("Invalid inputs");
			throw new IllegalArgumentException("Invalid inputs");
		}

		if(head == null || head.next == null || m == n) {
			return head;
		}

		ListNode back = null;
		ListNode mid = head;
		ListNode front = head.next;

		for(int i = 1; i < m; i++) {
			back = mid;
			mid = front;
			front = front.next;
		}

		ListNode temp1 = back;

		for(int i = 0; i <= (n-m); i++) {
			mid.next = back;
			back = mid;
			mid = front;
			if(front != null) {
				front = front.next;
			}
		}

		ListNode temp2;
		if(temp1 != null) {
			temp2 = temp1.next;
			temp1.next = back;
			temp2.next = mid;
		} else {
			head.next = mid;
			head = back;
		}
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
}
