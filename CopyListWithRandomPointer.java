//  Time Complexity: O(n)
//  Space Complexity: O(1)

public class CopyListWithRandomPointer {

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

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node c = head;
        Node n = head.next;

        while (c != null) {
            Node t = new Node(c.val);
            c.next = t;
            t.next = n;

            c = n;
            if (n != null)
                n = n.next;
        }

        c = head;
        while (c != null) {
            if (c.random != null)
                c.next.random = c.random.next;
            c = c.next.next;
        }

        c = head;
        Node nh = c.next;
        Node t = nh;

        while (c != null) {
            c.next = c.next.next;
            c = c.next;

            if (c != null)
                t.next  = c.next;

            t = t.next;
        }

        return nh;
    }
}
