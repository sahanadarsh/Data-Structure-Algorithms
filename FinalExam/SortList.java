package FinalExam;

/*
Q8
Sort a linked list in O(n log n) time using constant space complexity.
Examples:
Input: 4->2->1->3
Output: 1->2->3->4

Input: -1->5->3->4->0
Output: -1->0->3->4->5
 */

public class SortList {

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode middle = getMidAndThenSplit(head);
		head = sortList(head);
		middle = sortList(middle);
		return mergeSort(head, middle);
	}

	private static ListNode getMidAndThenSplit(ListNode head) {
		ListNode mid;
		ListNode curr;
		ListNode preSlow = null;
		mid = curr = head;
		while (curr != null && curr.next != null) {
			preSlow = mid;
			mid = mid.next;
			curr = curr.next.next;
		}
		preSlow.next = null;
		return mid;
	}

	private static ListNode mergeSort(ListNode firstHalf, ListNode secondHalf) {
		ListNode temp = new ListNode(0);
		ListNode prev = temp;
		while (firstHalf != null || secondHalf != null) {
			if (secondHalf == null || (firstHalf != null && secondHalf.val > firstHalf.val)) {
				prev.next = firstHalf;
				firstHalf = firstHalf.next;
			} else {
				prev.next = secondHalf;
				secondHalf = secondHalf.next;
			}
			prev = prev.next;
		}
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

	public static void main(String[] args) {
		LinkList l1 = new LinkList();
		l1.AddToTail(4);
		l1.AddToTail(2);
		l1.AddToTail(1);
		l1.AddToTail(3);
		System.out.println("Before sort: ");
		printList(l1.getHeadNode());
		System.out.println("After sort: ");
		printList(sortList(l1.getHeadNode()));
	}

}
