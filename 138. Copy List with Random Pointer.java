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

// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        //Step 1: Place all deep copies next to the original nodes
        Node curr = head;
        
        while(curr != null){
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        
        //Step 2: Set the random pointer of each copied nodes
        curr = head;
        
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //Step 3: Break/Split the two lists
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = curr.next;
        
        while(curr != null){
            curr.next = copyCurr.next;
            if(copyCurr.next == null) break;
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}