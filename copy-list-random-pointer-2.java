//tc id O(n)
//sc is O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        // create a copy of every node and place it next to original node

        while (curr != null) {
            Node copycurr = new Node(curr.val);
            copycurr.next = curr.next;
            curr.next = copycurr;
            curr = curr.next.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;

            }
            curr = curr.next.next;
        }

        // now we separate the lists
        curr = head;
        Node copycurr = curr.next;
        Node copyHead = curr.next;

        while (curr != null) {
            curr.next = curr.next.next;
            if (copycurr.next != null) {
                copycurr.next = copycurr.next.next;
            }

            curr = curr.next;
            copycurr = copycurr.next;
        }

        return copyHead;
    }
}