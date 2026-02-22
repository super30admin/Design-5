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
// Solution - Copy Next and Random Pointers Approach
// TC - O(n) - iterate over list 3 times.
// SC - O(1) - no extra space used. Only copied nodes are used which are not counted towards space complexity.
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node current = head;
        Node copyCurrent = new Node(head.val);
        Node copyHead = copyCurrent;
        while (current != null) {
            copyCurrent.next = current.next;
            current.next = copyCurrent;
            current = current.next.next;
            if (current != null) {
                copyCurrent = new Node(current.val);
            }

        }

        current = head;

        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;

        while (current != null) {
            Node copy = current.next; // 7`
            current.next = current.next.next; // 7-13

            current = current.next; // 13
            if (current != null) { //
                copy.next = current.next; // 7` -> 13`
            }

        }
        return copyHead;

    }
}