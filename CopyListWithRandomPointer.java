public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        // return copyRandomListUsingExtraSpace(head);
        return copyRandomListWithoutSpace(head);
    }

    private Node copyRandomListWithoutSpace(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node currNext = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = currNext;
            curr = currNext;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node originalHead = head;
        Node clonedHead = head.next;
        Node clonedCurr = clonedHead;
        while (originalHead != null) {
            originalHead.next = originalHead.next.next;
            if (clonedCurr.next != null) {
                clonedCurr.next = clonedCurr.next.next;
            }
            originalHead = originalHead.next;
            clonedCurr = clonedCurr.next;
        }
        return clonedHead;
    }

    private Node copyRandomListUsingExtraSpace(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.val);
        Map<Node, Node> originalToClone = new HashMap<>();
        originalToClone.put(head, newHead);
        Node curr = head;
        while (curr != null) {
            newHead.next = getClonedNode(curr.next, originalToClone);
            newHead.random = getClonedNode(curr.random, originalToClone);

            newHead = newHead.next;
            curr = curr.next;
        }
        return originalToClone.get(head);
    }

    private Node getClonedNode(Node n, Map<Node, Node> originalToClone) {
        if (n == null) return null;
        if (originalToClone.containsKey(n)) return originalToClone.get(n);
        Node newNode = new Node(n.val);
        originalToClone.put(n, newNode);
        return newNode;
    }
}
