// Time Complexity : O(N)// actually O(3N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. space optimized version to the hashmap solution.
 * 2. step 1: create a copy nodes and add it to the existing list like 1->1'->2->2'->3->3'...
 * 3  step 2: now mark the random pointers. 1 random pointer's next will be 1' random pointer.
 * 4. split the list to copy and original and return original head.
 */
public class CopyListwithRandomOptimized {

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {

		if (head == null)
			return null;

		Node cur = head;

		// create new copies and add in between
		while (cur != null) {
			Node copy = new Node(cur.val);

			copy.next = cur.next;
			cur.next = copy;

			cur = cur.next.next;
		}

		cur = head;

		// create random links on copies
		while (cur != null) {
			if (cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}

		// split copy and original list
		cur = head;
		Node copyHead = cur.next;
		Node copyCur = copyHead;

		while (cur != null) {
			cur.next = cur.next.next;
			if (cur.next != null)
				copyCur.next = cur.next.next;

			cur = cur.next;
			copyCur = copyCur.next;
		}

		return copyHead;

	}

}
