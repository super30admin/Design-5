//Tc: O(n);
//sc: o(1);


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

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
		return null;
 
	    Node curr = head;
 
	// copy every node and insert to list
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // copy random pointer for each new node
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // break list to two
        curr = head;
        Node newHead = head.next;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            curr = curr.next;
        }

        return newHead;
    }
}