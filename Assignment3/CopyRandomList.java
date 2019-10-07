package Assignment3;

//Q5
/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
	Return a deep copy of the list.
	Example 1:
	Input:
	{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

	Explanation:
	Node 1's value is 1, both of its next and random pointer points to Node 2.
	Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
	Note:
	You must return the copy of the given head as a reference to the cloned list.
 */

public class CopyRandomList {

	public static void main(String[] args) {
		LinkListRandom list = new LinkListRandom();
		list.AddNodes();
		System.out.println("      Original list    ");
		printList(list.getHead());
		Node node = copyRandomList(list.getHead());
		System.out.println("      Copy list    ");
		printList(node);

	}

	public static Node copyRandomList(Node head) {
		if(head == null)
			return null;

		if(head.next == null && head.random == null) {
			Node copyNode = new Node(head.val,null,null);
			return copyNode;
		}

		Node orig = head;
		Node copy = head;

		// create copies of original inside the main list
		while(orig != null){
			Node copyNode = new Node(orig.val,null,null);
			copyNode.next = orig.next;
			orig.next = copyNode;
			orig = orig.next.next;
		}

		// fix the random for the copy node we created
		orig = head;
		copy = head.next;

		while(orig != null){
			if (orig.random == null) {
				copy.random = null;
			} else {
				copy.random = orig.random.next;				
			}
			if(copy.next == null)
				break;
			copy = copy.next.next;
			orig = orig.next.next;
		}

		System.out.println("      original list + copy list    ");
		printList(head);

		// break the copy out of original
		orig = head;
		copy = head.next;
		Node copyReturn = copy;
		while(orig != null){
			orig.next = copy.next;
			orig = orig.next;
			if(orig != null){
				copy.next = orig.next;
				copy = copy.next;
			}
		}
		return copyReturn;
	}

	public static void printList(Node head){
		Node temp = head;
		while(temp != null){
			if (temp.next != null) {
				System.out.println("Node data : " + temp.val + " ->" + " Random pointer : " + (temp.random == null ? null : temp.random.val));
			} else {
				System.out.print("Node data : " + temp.val + " ->" + " Random pointer : " + (temp.random == null ? null : temp.random.val));	
			}
			temp = temp.next;
		}
		System.out.println(" ");
	}
}
