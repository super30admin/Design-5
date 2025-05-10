// TC: 3n
// SC: O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;

        while(curr != null) { //created deep copies
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;

            curr = curr.next.next;
        }

        curr = head;

        while(curr != null) { // random pointers
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

       //separate list and its deep copy
       curr = head;
       Node copyCurr = curr.next;
       Node copyHead = copyCurr;

       while(curr != null) {
        curr.next = curr.next.next;
        if(copyCurr.next != null)  {
            copyCurr.next = copyCurr.next.next;
        }

        curr = curr.next;
        copyCurr = copyCurr.next;

       }
        return copyHead;
    }
}
