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
    Map<Node, Node> m = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node curr=head;
        Node copyhead=clone(head);
        Node copycurr = copyhead;
        while (curr.next!=null) {
            copycurr.next = clone(curr.next);
            curr = curr.next;
            copycurr=copycurr.next;
        }
        curr=head;
        copycurr=copyhead;
        while (curr!=null) {
            if (m.containsKey(curr.random)) {
                copycurr.random = m.get(curr.random);
            }
            curr = curr.next;
            copycurr=copycurr.next;
        }
        return copyhead;
    }
    private Node clone(Node curr) {
        if(m.containsKey(curr)) {
            return m.get(curr);
        }
        Node copycurr = new Node(curr.val);
        m.put(curr, copycurr);
        return copycurr;

    }
}
