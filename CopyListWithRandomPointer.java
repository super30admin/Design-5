// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

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

        if(head == null) return null;
        Node curr = head;

        //1. Deep copy of nodes and place it next to original node
        while(curr != null){
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }

        //2. Make connections of random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        //3. Split lists by fixing next pointers
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;

        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next; // coz next pointer is fixed
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

}
