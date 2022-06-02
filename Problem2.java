public class Problem2 {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    // TC : O(n)
    // SC : O(1)
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        // step 1 create deep copy
        while (curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }
        // step 2 : take care of random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = curr.next;
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next == null) break;
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}
