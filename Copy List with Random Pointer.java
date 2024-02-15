// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Intersection of Linked lists

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;

        // Step 1 :
        // This will actually merge the original list with newly created nodes one by one
        // It will be 1 -> 1' -> 2 -> 2' -> 3 -> 3'.....

        Node curr = head;

        while(curr != null)
        {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;

            curr = curr.next.next;
        }

        // Step 2 : Setting up the random pointers of deep copy which is newly created nodes

        curr = head;
        while(curr != null)
        {
            // current.random might be null, it might not have a random, applying .next to it will lead to error
            if(curr.random != null) curr.next.random = curr.random.next;

            // This is because we started at 1 and now we need to go to 2, curr.next will just give me 1'
            curr = curr.next.next;
        }

        // Step 3 : Now both the original list and copy list are merged together. Seperate them

        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;

        while(curr != null)
        {
            curr.next = copyCurr.next;

            if(copyCurr.next != null) copyCurr.next = copyCurr.next.next;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}