package week9.day3;

import java.util.HashMap;

public class CopyRandomList_Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 * //Definition for a Node. class Node { int val; Node next; Node random;
 * 
 * public Node(int val) { this.val = val; this.next = null; this.random = null;
 * } }
 */

class Solution {
	public Node copyRandomList(Node head) {
		if (head == null)
			return head;
		HashMap<Node, Node> map = new HashMap<>();
		Node parent = head;
		Node copyHead = clone(parent, map);
		Node child = copyHead;
		
		while (parent != null) {                         // parent random not null
			child.next = clone(parent.next, map);
			child.random = clone(parent.random, map);
			parent = parent.next;
			child = child.next;
		}
		return copyHead;
	}

	private Node clone(Node node, HashMap<Node, Node> map) {
		if (node == null)
			return null; // if random is null, return null
		if (map.containsKey(node))
			return map.get(node);
		Node copy = new Node(node.val);
		map.put(node, copy);
		return copy;
	}

}
