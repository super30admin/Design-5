import java.util.HashMap;
import java.util.Map;

// Time O(N) where N is the length of Linked List
// Space O(N) 

public class RandomPointer {
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();

		Node temp1 = head;
		while (temp1 != null) {
			Node t1 = new Node(temp1.val);
			map.put(temp1, t1);
			temp1 = temp1.next;
		}

		Node temp2 = head;
		while (temp2 != null) {
			Node t2 = map.get(temp2);
			t2.next = map.get(temp2.next);
			t2.random = map.get(temp2.random);
			temp2 = temp2.next;
		}

		return map.get(head);
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
