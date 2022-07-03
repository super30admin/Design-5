// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // original head
        Node curr = head;
        // traversing to create deep copy
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;

        }
        curr = head;
        // traversing to create random pointers
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyCurr = head.next;
        Node deepHead = head.next;
        // to remove extra nodes
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        return deepHead;
    }

}