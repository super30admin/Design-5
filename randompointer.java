//TC: O(n) — three linear passes over the list.
//SC: O(1) auxiliary — uses in-place interleaving.

//interleave copies A' after each original A (A -> A' -> B -> B' -> ...).
//set randoms via neighbors: A'.random = A.random == null ? null : A.random.next.
//detach the copied list by restoring originals’ next and chaining copies’ next; return copied head.

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

        curr = head;

        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }
        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;

        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null)
            {
                copyCurr.next = copyCurr.next.next;
            }

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}