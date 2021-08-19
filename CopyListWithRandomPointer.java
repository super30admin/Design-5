// Time Complexity : O(n), n = number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // creating adjacent new nodes
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // assign random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // split the linked list
        curr = head;
        Node copy = head.next;
        Node copyHead = head.next;
        while(curr !=null){
            curr.next = curr.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            curr = curr.next;
            copy = copy.next;
        }
        return copyHead;
    }
}