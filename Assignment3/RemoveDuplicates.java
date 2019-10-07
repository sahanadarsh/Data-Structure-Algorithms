package Assignment3;

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.AddToTail(1);
		list.AddToTail(1);
		list.AddToTail(1);
		list.AddToTail(4);
		list.AddToTail(4);
		printList(list.getHeadNode());		
		ListNode newHead = deleteDuplicates(list.getHeadNode());
		list.setHeadNode(newHead);
		printList(list.getHeadNode());
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode curNode = head;
		while(curNode != null && curNode.next != null ) {
			if(curNode.getVal() == curNode.next.getVal()) {
				curNode.next = curNode.next.next;
			}else {
				curNode = curNode.next;
			}
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
