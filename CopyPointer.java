// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/copy-list-with-random-pointer/
// Any problem you faced while coding this : No

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
        if(head==null) return null;
        // create deep copy and put next to current node
        Node curr = head;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // create random pointers
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // split both the list
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;
        while(curr!=null){
            curr.next = curr.next.next;
            if(copyCurr.next!=null){
                copyCurr.next=copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
         return copyHead;
    }
}
