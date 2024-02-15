/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(3n)
    n - nodes in linkedlist
* 
* Space Complexity: O(1)
* 
*/

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

public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        // iterate and create copy nodes after original nodes
        while (curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;

            if (copy.next != null) {
                copy = copy.next.next;
            }
        }

        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;

        // connect random pointers
        while (curr != null) {
            if (curr.random != null) {
                copyCurr.random = curr.random.next;
            }

            curr = curr.next.next;

            if (copyCurr.next != null) {
                copyCurr = copyCurr.next.next;
            }
        }

        curr = head;
        copyCurr = copyHead;

        // split the linkedlist
        while (curr != null) {
            curr.next = copyCurr.next;

            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}