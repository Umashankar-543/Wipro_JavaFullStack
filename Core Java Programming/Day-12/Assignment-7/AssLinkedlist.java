package Assignment_7;

public class AssLinkedlist {
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		ListNode mergedHead = MergeSortedLinkedLists.mergeLists(head1, head2);
		while (mergedHead != null) {
			System.out.print(mergedHead.val + " ");
			mergedHead = mergedHead.next;
		}
		System.out.println();
	}
}
