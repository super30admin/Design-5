class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node curr = head;

        while (curr != null) {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = node.next;
        }

        Node temp = head;
        while (temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        Node p1 = head, p2 = head.next;
        Node newHead = head.next;
        while (p1 != null) {
            p1.next = p1.next.next;
            p2.next = p2.next != null ? p2.next.next : null;
            p1 = p1.next;
            p2 = p2.next;
        }
        return newHead;
    }
}