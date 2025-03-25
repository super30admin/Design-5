class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        while (curr!=null) {
            Node currCopy = new Node(curr.val);
            currCopy.next = curr.next;
            curr.next = currCopy;
            curr = curr.next.next;
        }

        curr = head;
        while (curr!=null) {
            if(curr.random!=null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node result = curr.next;
        Node currNext = result;
        while (curr != null) {
            curr.next = curr.next.next;
            if(currNext.next!=null)
                currNext.next = currNext.next.next;
            curr = curr.next;
            currNext = currNext.next;
        }

        return result;
    }
}
