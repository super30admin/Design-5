
//TC - O(N)
//SC - O(N)
import java.util.*;

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

class Solution {
	HashMap<Node, Node> map;

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		map = new HashMap<>();
		Node currCopy = clone(head);
		Node curr = head;
		while (curr != null) {
			currCopy.random = clone(curr.random);
			currCopy.next = clone(curr.next);
			curr = curr.next;
			currCopy = currCopy.next;
		}
		return map.get(head);
	}

	private Node clone(Node node) {
		if (node == null)
			return null;
		if (map.containsKey(node)) {
			return map.get(node);
		}
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		return newNode;
	}
}