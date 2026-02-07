// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// pass1: create deep copy nodes in between the original nodes
// pass2: assign the random pointers for the deep copy using curr nodes
// pass3: remove the connection between original and deep copy nodes and return the head of deep copy

class Solution {
        public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        // create nodes in bwtween
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // assign random pointers
        curr = head;
        while (curr != null) {
            Node copyCurr = curr.next;
            if(curr.random != null){
                copyCurr.random = curr.random.next;
            }
            curr = copyCurr.next;
        }

        // remove conncetion
        curr = head;
        Node newHead = curr.next;

        while (curr != null) {
            Node copyCurr = curr.next;
            curr.next = copyCurr.next;
            curr = copyCurr.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
        }

        return newHead;
    }
}