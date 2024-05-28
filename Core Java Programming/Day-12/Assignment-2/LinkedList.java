package Assignment_2;

public class LinkedList {
	Node head;
	
	public void append(int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		Node middle = Node.findMiddle(list.head);
		if(middle != null) {
			System.out.println("The middle element is:" + middle.data);
		}
		else {
			System.out.println("The list is empty");
		}
	}

}
