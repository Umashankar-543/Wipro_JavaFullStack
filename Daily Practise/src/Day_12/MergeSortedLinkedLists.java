package Day_12;

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