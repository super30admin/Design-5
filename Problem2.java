package Design_5;

/**
 * Firstly we are copying the next pointers from the given list to a new list.
 * And to maintain the order and to know which new node is a copy of which given
 * node we store each new node created just after the given node. Once this is
 * done, we again traverse to assign random pointers and detach both the lists
 * from each other
 * 
 * Time Complexity : O(n)- where n is the length of the given list
 * 
 * Space Complexity : If we don't consider the entire new list formed as the o/p
 * then O(n). Else O(1).
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem2 {
	public Node copyRandomList(Node head) {
		if (head == null)
			return head;
		Node curr = head;
		Node prev = curr;
		Node currNew = new Node(curr.val);
		curr = curr.next;
		prev.next = currNew;
		currNew.next = curr;

		while (curr != null) {
			prev = curr;
			currNew = new Node(curr.val);
			curr = curr.next;
			prev.next = currNew;
			currNew.next = curr;
		}

		curr = head;
		currNew = curr.next;

		while (curr != null) {
			if (curr.random != null) {
				currNew.random = curr.random.next;
			} else
				currNew.random = null;
			curr = curr.next.next;
			if (null != currNew.next)
				currNew = currNew.next.next;
		}

		curr = head;
		currNew = curr.next;
		Node newHead = currNew;

		while (currNew != null) {
			curr.next = curr.next.next;
			curr = curr.next;
			if (currNew.next != null)
				currNew.next = currNew.next.next;

			if (currNew != null)
				currNew = currNew.next;
		}
		currNew = head;
		while (currNew != null) {
			currNew = currNew.next;
		}

		return newHead;

	}
	
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

}
