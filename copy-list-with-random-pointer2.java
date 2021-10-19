//Time complexity: O(N)
//Space complexity: O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node curr = head;
        //create a deep copy and put it next to original node
        while(curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        curr = head;
        //create the random pointers for the deep copy
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //split the original and the deep copy list
        curr = head;
        Node copyHead = head.next;
        Node currCopy = head.next;
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