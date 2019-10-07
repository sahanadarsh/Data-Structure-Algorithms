package Assignment3;

//Q6
/*
 * Sort a linked list using insertion sort.
	A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
	With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list

	Algorithm of Insertion Sort:
	Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
	At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
	It repeats until no input elements remain.

	Example 1:
	Input: 4->2->1->3
	Output: 1->2->3->4
	Example 2:

	Input: -1->5->3->4->0
	Output: -1->0->3->4->5
 */

public class InsertionSortLinkedList {

	public static void main(String[] args) {
		LinkList list = new LinkList();
				list.AddToTail(1);
				list.AddToTail(10);
				list.AddToTail(4);
				list.AddToTail(8);
				list.AddToTail(0);
				list.AddToTail(6);
		printList(list.getHeadNode());
		System.out.println("In-place Insertion sort");
		printList(insertionInPlaceSortList(list.getHeadNode()));
		System.out.println("Insertion sort by growing output list");
		printList(insertionSortList(list.getHeadNode()));

	}
	public static ListNode insertionSortList(ListNode head) {
			ListNode temp = head;
			ListNode result = null;
			while(temp != null) {
				result = addNodeToSortedList(result,temp.val);
				temp =temp.next;
			}
           return result;
	}
	public static ListNode addNodeToSortedList(ListNode head,int n) {
		ListNode cur = head;
		ListNode pre = head;
		ListNode dummy = new ListNode(n);
		if(head == null) {
			return dummy;
		}
		if(n < cur.val) {
			dummy.next = head;
			head = dummy;
			return head;
		}
		while(n >= cur.val) {
			pre = cur;
			cur = cur.next;
			if( cur == null) {
				break;
			}
		}
		pre.next= dummy;
		dummy.next = cur;
		return head;
	}


	public static ListNode insertionInPlaceSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode dummy = new ListNode(0);
		while (first != null) {
			ListNode node  = dummy;
			while (node.next != null && node.next.val < first.val) {
				node = node.next;
			}
			ListNode next = node.next;
			node.next = new ListNode(first.val);
			node.next.next = next;
			first = first.next;
		}
		return dummy.next;
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
