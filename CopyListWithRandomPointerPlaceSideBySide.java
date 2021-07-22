// TC: O(n)
// SC: O(n)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        // create deep copy
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // create all random pointers
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //split
        curr = head;
        Node copyHead = head.next;
        Node currCopy = copyHead;
        while(curr != null) {
            curr.next = curr.next.next;
            if(currCopy.next != null) {
                currCopy.next = currCopy.next.next;
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }

}