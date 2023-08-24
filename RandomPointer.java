// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*
 * First Iteration add the clone nodes in between 
 * secod Iteration update the random pointers
 * third iteration separate the old linkedlist from new linkedlist
 */


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


class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                Node copy = curr.next;
                copy.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node iter = new Node(-1);
        Node dup = iter;

        while(curr != null){
            Node copy = curr.next;
            dup.next = copy;
            curr.next = copy.next;
            curr = curr.next;
            dup = dup.next;
        }
        return iter.next;

    }
}