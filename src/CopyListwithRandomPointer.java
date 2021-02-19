import java.util.HashMap;

/* 
 * The complexity of the algorithm is O(n) where  n is no  of nodes.
 * Space complexity is O(n) where  n is no  of nodes .
 */

/*  without extra space
 * The complexity of the algorithm is O(n) where  n is no  of nodes.
 * Space complexity is O(1) 
 */

public class CopyListwithRandomPointer {

	// without extra space

	public Node copyRandomList1(Node head) {

		if (head == null)
			return head;

		// create deep copies

		Node curr = head;

		while (curr != null) {

			Node currCopy = new Node(curr.val);
			currCopy.next = curr.next;
			curr.next = currCopy;
			curr = curr.next.next;
			// currCopy.next= currCopy.next.next;

		}

		// random pointer

		curr = head;

		while (curr != null) {

			if (curr.random != null)
				curr.next.random = curr.random.next;

			curr = curr.next.next;

		}

		// split the list

		curr = head;
		Node currCopy = head.next;
		Node currHead = head.next;
		while (curr != null) {

			curr.next = curr.next.next;

			if (currCopy.next != null)
				currCopy.next = currCopy.next.next;
			curr = curr.next;
			currCopy = currCopy.next;
		}

		return currHead;
	}

	// extra space

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

	HashMap<Node, Node> map;

	public Node copyRandomList(Node head) {

		if (head == null)
			return head;

		map = new HashMap();
		Node currHead = clone(head);
		Node curr = head;
		Node currCopy = currHead;

		while (curr != null) {

			currCopy.next = clone(curr.next);
			currCopy.random = clone(curr.random);
			curr = curr.next;
			currCopy = currCopy.next;

		}
		return currHead;
	}

	private Node clone(Node node) {

		if (node == null)
			return node;
		if (map.containsKey(node))
			return map.get(node);
		Node newNode = new Node(node.val);
		map.put(node, newNode);

		return newNode;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
