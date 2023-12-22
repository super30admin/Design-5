/* Time Complexity : O(n)
 *  n - size of the list */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 

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
        if (head == null) return head;
        //create deep copy with the original list
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        //Map the random pointers on the deep copied list
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //Split the list
        curr = head;
        Node copyCurr = head.next;
        Node copyHead = copyCurr;
        while(curr != null){
            curr.next = copyCurr.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}