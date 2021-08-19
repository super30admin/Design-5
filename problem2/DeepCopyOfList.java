// Time Complexity : O(n), n -> Number of elements in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyOfList {
	Map<Node, Node> copyMap;

	/********************* HashMap - One Pass Solution *********************/
	// Time Complexity : O(n), n -> Number of elements in the list
	// Space Complexity : O(n), n -> Size of HashMap
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public Node copyRandomListHashMap(Node head) {
		if (head == null) {
			return null;
		}

		copyMap = new HashMap<Node, Node>();

		Node cloneHead = clone(head);
		Node curr = head;
		Node currCopy = cloneHead;

		while (curr != null) {
			currCopy.next = clone(curr.next);
			currCopy.random = clone(curr.random);

			curr = curr.next;
			currCopy = currCopy.next;
		}

		return cloneHead;
	}

	private Node clone(Node node) {
		if (node == null) {
			return null;
		}

		if (copyMap.containsKey(node)) {
			return copyMap.get(node);
		}

		Node newNode = new Node(node.val);
		copyMap.put(node, newNode);
		return newNode;
	}

	/********************* O(1) Space - Three Pass Solution *********************/
	// Time Complexity : O(n), n -> Number of elements in the list
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		// Create Deep Copies as next pointers to original nodes
		Node curr = head;
		while (curr != null) {
			Node currCopy = new Node(curr.val);
			currCopy.next = curr.next;
			curr.next = currCopy;
			curr = curr.next.next;
		}

		// Connect Random Pointers to Deep Copies
		curr = head;
		while (curr != null) {
			if (curr.random != null) {
				curr.next.random = curr.random.next;
			}

			curr = curr.next.next;
		}

		// Disconnect Deep Copy Nodes
		curr = head;
		Node copyHead = curr.next;
		Node currCopy = copyHead;
		while (curr != null) {
			curr.next = curr.next.next;
			if (currCopy.next != null)
				currCopy.next = currCopy.next.next;
			curr = curr.next;
			currCopy = currCopy.next;
		}

		return copyHead;
	}

	private void printList(Node head) {
		Node node = head;

		while (node != null) {
			System.out.print("Node: " + node.val + ", Next Pointer: " + (node.next != null ? node.next.val : "null")
					+ ", Random Pointer: " + (node.random != null ? node.random.val : "null"));
			System.out.println();
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DeepCopyOfList obj = new DeepCopyOfList();
		Node head = new Node(7);
		head.next = new Node(13);
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);

		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;
		System.out.println("Original List:");
		obj.printList(head);

		Node headCopy = obj.copyRandomList(head);

		System.out.println("Deep Copy of List:");
		obj.printList(headCopy);

	}

}
