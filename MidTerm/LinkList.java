package MidTerm;

public class LinkList {
	private ListNode head;

	public ListNode getHeadNode() {
		return this.head;
	}

	public void setHeadNode(ListNode n) {
		this.head = n;
	}

	public void AddToHead(int data)
	{
		ListNode n = new ListNode(data);
		n.next = head;
		head = n;
	}
	public void AddToTail(int data)
	{
		ListNode n = new ListNode(data);
		if (head == null)
		{
			head = n;
			return;
		}
		ListNode temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp.next = n;
	}
}
