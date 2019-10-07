package Assignment3;

//Q10
/*
 * You are given two non-empty linked lists representing two non-negative integers.
   The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	Follow up:
	What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
	Example:
	Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 8 -> 0 -> 7
 */

public class Add2Numbers {

	public static void main(String[] args) {
		LinkList l1 = new LinkList();
		l1.AddToTail(7);
		l1.AddToTail(2);
		l1.AddToTail(4);
		l1.AddToTail(3);
		LinkList l2 = new LinkList();
		l2.AddToTail(5);
		l2.AddToTail(6);
		l2.AddToTail(4);
		printList(l1.getHeadNode());
		printList(l2.getHeadNode());
		System.out.println("Sum of two linked lists : ");
		printList(addTwoNumbers(l1.getHeadNode(), l2.getHeadNode()));
		System.out.println("Alternate Solution to find out Sum of two linked lists : ");
		printList(add2Numbers(l1.getHeadNode(), l2.getHeadNode()));

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int l1length = 0;
		int l2length = 0;
		ListNode templ1 = l1;
		ListNode templ2 = l2;

		//getting list1 length
		while (templ1 != null) {
			l1length++;
			templ1 = templ1.next;
		}

		//getting list2 length
		while (templ2 != null) {
			l2length++;
			templ2 = templ2.next;
		}

		//calling recursive function
		ListNode output =  recursive(l1, l2, l1length, l2length);

		if(output.val == 0){
			return output.next;
		}else{
			return output;
		}
	}

	public static ListNode recursive(ListNode l1, ListNode l2, int l1length, int l2length){

		//Condition to return from recursive call
		if (l1 == null && l2 == null) {
			return new ListNode(0);
		}

		ListNode temp;
		ListNode node;
		int sum=0;

		if (l1length > l2length) {
			node = recursive(l1.next, l2, l1length - 1, l2length);
			sum = l1.val + node.val;
		} else if (l1length < l2length) {
			node = recursive(l1, l2.next, l1length, l2length - 1);
			sum = l1.val + node.val;
		} else {
			node = recursive(l1.next, l2.next, l1length - 1, l2length - 1);
			sum = l1.val + l2.val + node.val;
		}

		node.val = sum % 10;
		sum = sum/10;
		temp = new ListNode(sum);
		temp.next = node;
		return temp;
	}


	public static ListNode add2Numbers(ListNode l1, ListNode l2) {
		int count = 0;

		long num1;
		long num2;

		ListNode temp = l1;
		while (temp != null) {
			count = count + 1;
			temp = temp.next;
		}

		//Extract number 1
		num1 = returnIntegerValue(l1, count-1);
		temp = l2;
		count = 0;
		while (temp != null) {
			count = count + 1;
			temp = temp.next;
		}

		//Extract number 2
		num2 = returnIntegerValue(l2, count-1);

		//sum of number 1 and number 2
		long result = num1 + num2;
		long tem = result;

		//convert sum to link list
		LinkList op = new LinkList();
		if( tem == 0) {
			op.AddToTail(0);;
			return op.getHeadNode();
		}
		while (tem != 0) {
			op.AddToHead((int) (tem % 10));
			tem = tem / 10;
		}
		return op.getHeadNode();
	}

	public static long returnIntegerValue(ListNode n, long digits) {

		if (n.next == null) {
			return n.val;
		}
		long result = (long) (n.val *  Math.pow(10, digits) + returnIntegerValue(n.next, digits-1));
		return result;
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
