class Node {
    int val;
    Node next, random;

    public Node(int val) {
        this.val = val;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Clone nodes and insert right after original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. Assign random pointers to copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // 3. Separate original and copied lists
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;

            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return dummyHead.next;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
