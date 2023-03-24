/*
// Definition for a Node.
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
*/

//Time Complexity : O(N) 
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * At each node, create a duplicate for that current node. and attach it to next
 * to the current node. this duplicate node will connect to the current node's
 * next. This way all duplicates will be created. After that in another
 * iteration, update random pointers for the duplicates. This will be done by
 * getting current node's random.next. Once this is done, we will separate the
 * duplicates from the original. Return duplicate nodes' head.
 *
 */
class Solution {
	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node curr = head;

		while (curr != null) {
			Node node = new Node(curr.val);
			node.next = curr.next;
			curr.next = node;
			curr = node.next;
		}

		Node temp = head;
		while (temp != null) {
			temp.next.random = temp.random != null ? temp.random.next : null;
			temp = temp.next.next;
		}

		Node p1 = head, p2 = head.next;
		Node newHead = head.next;
		while (p1 != null) {
			p1.next = p1.next.next;
			p2.next = p2.next != null ? p2.next.next : null;
			p1 = p1.next;
			p2 = p2.next;
		}
		return newHead;
	}
}