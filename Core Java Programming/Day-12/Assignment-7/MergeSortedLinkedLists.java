package Assignment_7;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class MergeSortedLinkedLists {
	public static ListNode mergeLists(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				current.next = head1;
				head1 = head1.next;
			} else {
				current.next = head2;
				head2 = head2.next;
			}
			current = current.next;
		}
		current.next = (head1 != null) ? head1 : head2;
		return dummy.next;
	}
}