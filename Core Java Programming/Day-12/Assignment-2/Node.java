package Assignment_2;

public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	public static Node findMiddle(Node head) {
		if(head == null) {
			return null;
		}
		
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
