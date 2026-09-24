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

//Time Complexity: O(2n)
//Space Complexity: O(1)
class Solution {
    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        this.map = new HashMap<>();

        Node curr = head;
        Node copyCurr = new Node(curr.val);
        map.put(curr, copyCurr);

        while (curr.next != null) {
            copyCurr.next = new Node(curr.next.val);
            map.put(curr.next, copyCurr.next);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        curr = head;
        copyCurr = map.get(curr);

        while (curr != null) {
            if (curr.random != null) {
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return map.get(head);
    }
}