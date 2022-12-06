public class Problem2 {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        // Base case
        if (head == null)
            return null;
        // Creating clone nodes next to original nodes
        Node node = head;
        while (node != null) {
            Node clone = new Node(node.val);
            clone.next = node.next;
            node.next = clone;
            node = node.next.next;
        }
        // Populating random pointers in clone nodes
        node = head;
        while (node != null) {
            Node clone = node.next;
            if (node.random != null)
                clone.random = node.random.next;
            node = node.next.next;
        }
        // Extracting clone nodes
        node = head;
        Node clonehead = head.next;
        Node clone = head.next;
        while (node != null) {
            node.next = node.next.next;
            if (clone.next != null)
                clone.next = clone.next.next;
            else
                clone.next = null;
            node = node.next;
            clone = clone.next;
        }
        return clonehead;
    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node head = n1;
        Node n2 = n1;
        for (int i = 1; i < 10; i++) {
            n1.next = new Node(i);
            if (i % 2 == 0) {
                n1.random = n2;
                n2 = n2.next;
            }
            n1 = n1.next;
        }
        n1.next = null;
        Node n3 = copyRandomList(head);
        for (int i = 0; i < 10; i++) {
            System.out.print(n3.val + "->");
            n3 = n3.next;
        }
        System.out.print("null");
    }
}
