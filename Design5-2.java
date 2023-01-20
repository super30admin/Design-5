// Copy List with Random Pointer

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


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
        if(head == null) return null;
        Node curr = head;
        while(curr != null){
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }
        //create the rand ptr on deep copy list
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
                curr = curr.next.next;
            } else {
                curr = curr.next.next;
            }
        }
        //split the lists
        curr = head;
        Node deepCopyHead = head.next;
        Node copyCurr = deepCopyHead;
        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return deepCopyHead;

    }
}