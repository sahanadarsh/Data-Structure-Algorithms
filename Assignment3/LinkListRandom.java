package Assignment3;


public class LinkListRandom{

	private Node head;

	public Node getHead() {
		return this.head;
	}

	public  LinkListRandom(){
		head = null;
	}

	public void AddNodes(){
		Node one = new Node(1,null,null);
		Node two = new Node(2,null,null);

		one.next = two;
		one.random = two;
		two.random = two;

		head = one;
	}
}
