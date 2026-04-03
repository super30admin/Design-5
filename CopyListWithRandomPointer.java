// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
First, we will create deep copy nodes between existing nodes in the original list. Next pass, we iterate through
the list and establish random pointers between these deep copy nodes if applicable.In the next pass, we go
through the list again and separate the deep copy nodes along with their respective pointers from the original
list nodes.
 */
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
        if(head == null)
            return head;

        Node curr = head;

        while(curr != null) { // create deep copy nodes first with next pointers between the existing nodes
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;

            curr = curr.next.next;
        }

        curr = head;

        while(curr != null) { // connecting random pointers
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;

        while(curr != null) { // separate the deep copies connected to original list
            curr.next = curr.next.next;
            if(copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}