// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        Node copyHead = new Node(head.val);
        Node currCopy = copyHead;

        currCopy.next = curr.next;
        curr.next = currCopy;
        curr = curr.next.next;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
            currCopy = currCopy.next.next;
        }

        curr = head;
        currCopy = head.next;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        currCopy = head.next;

        while (curr.next.next != null) {
            curr.next = curr.next.next;
            currCopy.next = currCopy.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }
        curr.next = null;
        currCopy.next = null;

        return copyHead;

    }
}