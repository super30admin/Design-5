
time complexity: O(n)
space complexity: O(n)

//using hashmap to store the node values and traversing through it

class Solution {
    public Node copyRandomList(Node head) {
    if (head == null)
	    return null;
	HashMap<Node, Node> map = new HashMap<Node, Node>();
	Node newHead = new Node(head.val);
 
	Node p = head;
	Node q = newHead;
	map.put(head, newHead);
 
	p = p.next;
	while (p != null) {
		Node temp = new Node(p.val);
		map.put(p, temp);
		q.next = temp;
		q = temp;
		p = p.next;
	}
 
	p = head;
	q = newHead;
	while (p != null) {
		if (p.random != null)
			q.random = map.get(p.random);
		else
			q.random = null;
 
		p = p.next;
		q = q.next;
	}
 
	return newHead;  
    }
}