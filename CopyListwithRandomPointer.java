// TC: O(3n)
// SC: O(1)
/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // create duplicate nodes right next to originals
        while (curr != null) {
            Node currCopy = new Node(curr.val);
            currCopy.next = curr.next;
            curr.next = currCopy;
            curr = curr.next.next;
        }

        curr = head;
        Node currCopy = curr.next;

        // connect random pointers
        while (curr != null) {
            if (curr.random != null) {
                currCopy.random = curr.random.next;
            } else {
                currCopy.random = null;
            }

            curr = curr.next.next;
            if (currCopy.next != null) {
                currCopy = currCopy.next.next;
            }
        }

        curr = head;
        currCopy = head.next;
        Node copyHead = head.next;

        //Split the lists
        while (curr != null) {
            curr.next = curr.next.next;
            if (currCopy.next != null) {
                currCopy.next = currCopy.next.next;
            }

            curr = curr.next;
            currCopy = currCopy.next;
        }

        return copyHead;
    }
}