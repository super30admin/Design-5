// Time Complexity : O(n) because we traverse the linked list three times
// Space Complexity : O(1) excluding the copied nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We create a copy of each node and insert it immediately after its original node.
// Using this interleaved structure, we assign random pointers without extra space by accessing original.random.next.
// Finally, we separate the original and copied nodes to restore the original list and return the deep copy.

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Node curr = head;

        // insert copied nodes next to originals
        while(curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }

        // assign random pointers
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // separate original and copied lists
        curr = head;
        Node copyCurr = curr.next;
        Node copyCurrHead = copyCurr;

        while(curr != null) {
            curr.next = curr.next.next;

            if(copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyCurrHead;
    }
}