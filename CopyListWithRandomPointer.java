//time complexity : O(n) n is size of list
//space complexity : O(1)

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

    //code 2 - without auxillary space

    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        Node curr = head;

        //step 1 - create clone nodes next to original nodes in the list
        while(curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = curr.next.next;
        }

        //step2 - finish random pointers of clones list
        curr = head;
        //Node copyCurr = head.next;

        while(curr != null) {
            if(curr.random != null) {
                //copyCurr.random = curr.random.next;
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //step 3 - split the lists
        curr = head;
        Node copyCurr = head.next;
        Node copyHead = copyCurr;

        while(curr != null) {
            curr.next = curr.next.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;

    }
}
