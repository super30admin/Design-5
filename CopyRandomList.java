// Problem 138. Copy List with Random Pointer
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
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
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        Node curr = head;
        Node copyCurr = copyHead;
        // Make a deep copy list without random pointers
        while (curr.next != null) {
            Node copyNode = new Node(curr.next.val);
            map.put(curr.next, copyNode);
            copyCurr.next = copyNode;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        // Lets take care of random pointers
        curr = head;
        copyCurr = copyHead;
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
