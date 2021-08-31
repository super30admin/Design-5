//O(1) Space - Three Pass Solution
// T.C : O(N), N -> No of elements in the list
// S.C : O(1)
class CopyListwithRandomPointer2 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            Node currentCopy = new Node(current.val);
            currentCopy.next = current.next;
            current.next = currentCopy;
            current = current.next.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        current = head;
        Node copyHead = current.next;
        Node currentCopy = copyHead;
        while (current != null) {
            current.next = current.next.next;
            if (currentCopy.next != null)
                currentCopy.next = currentCopy.next.next;
            current = current.next;
            currentCopy = currentCopy.next;
        }

        return copyHead;
    }
}