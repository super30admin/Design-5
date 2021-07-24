// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandom {

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
		Map<Node, Node> map = new HashMap<>();

		Node cur = head;
		Node copyHead = new Node(head.val);
		Node copyCur = copyHead;

		map.put(cur, copyCur);
		while (cur != null) {
			if (cur.next != null) {
				if (!map.containsKey(cur.next)) {
					map.put(cur.next, new Node(cur.next.val));
				}
				copyCur.next = map.get(cur.next);
			}

			if (cur.random != null) {
				if (!map.containsKey(cur.random)) {
					map.put(cur.random, new Node(cur.random.val));
				}
				copyCur.random = map.get(cur.random);
			}
			cur = cur.next;
			copyCur = copyCur.next;
		}
		return copyHead;
	}

}
