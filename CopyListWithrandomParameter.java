// Time - o(n)
// Space complexity -O(1)
// Solved on leetcod e- yes
// faced any issues - no

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave copied nodes with original nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Restore original list and extract the copied list
        current = head;
        Node pseudoHead = new Node(0);
        Node copyCurrent = pseudoHead;

        while (current != null) {
            Node copy = current.next;
            current.next = copy.next;
            copyCurrent.next = copy;

            current = current.next;
            copyCurrent = copyCurrent.next;
        }

        return pseudoHead.next;
    }
}
