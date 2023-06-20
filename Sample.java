## Problem 2: Copy List with Random Pointer (https://leetcode.com/problems/copy-list-with-random-pointer/)

// Time Complexity - 0(n)
// Space Complexity - 0(1)

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
        if (head == null) {
            return null;
        }
        Node curr = head;
        while(curr != null) {
            Node newnode = new Node(curr.val);
            newnode.next = curr.next;
            curr.next = newnode;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;

        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next == null) {
                break;
            }
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;       
    }
}
