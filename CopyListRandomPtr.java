/*
Time Complexity - O(n) where n is the number of nodes in the linkedlist.
Space Complexity - O(1)
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null)
            return null;

        Node itr = head;
        while(itr != null) {
            Node node = new Node(itr.val);
            node.next = itr.next;
            node.random = itr.random;
            itr.next = node;
            itr = itr.next.next;
        }

        itr = head.next;
        while(itr != null) {
            itr.random = itr.random == null ? null : itr.random.next;
            if(itr.next == null)
                break;
            itr = itr.next.next;
        }

        itr = head;
        Node newHead = itr.next, itr2 = newHead;
        while(itr != null){
            itr.next = itr.next == null ? null : itr.next.next;
            itr = itr.next;
            itr2.next = itr2.next == null ? null : itr2.next.next;
            itr2 = itr2.next;
        }

        return newHead;
    }
}
