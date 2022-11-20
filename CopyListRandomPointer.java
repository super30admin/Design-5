// Time Complexity : O(3N) = O(N)
// Space Complexity: O(1)
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

        //Step 1: Create and place deep copies next to the original nodes
        Node curr = head;
        while(curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }

        //Step 2: Start pointing the random nodes of the deep copies
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;

        }

        // Step 3: Separate out the list into two linked lists
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        while(curr != null) {
            curr.next = copyCurr.next;
            if (copyCurr.next !=null) {
                copyCurr.next = curr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}
