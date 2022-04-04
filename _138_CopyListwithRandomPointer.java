// Time Complexity : o(3(n)) whree nis length of list
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// add clone nodes in front of original nodes
// attach random pointer of clone nodes using random pointer of origina nodes
// break clone nodes from original lista nd add them together using dummy pointer
class Solution {
    public Node copyRandomList(Node head) {

        if(head == null) return head;

        // add clone nodes in front of original nodes
        Node temp = head;

        while(temp != null){
            Node curr = new Node(temp.val);

            Node next = temp.next;
            temp.next = curr;
            curr.next = next;

            temp = next;
        }

        // attach random pointer of clone nodes using random pointer of origina nodes
        temp = head;
        while( temp != null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }

        // break clone nodes from original lista nd add them together using dummy pointer
        Node dummy = new Node(Integer.MIN_VALUE);
        Node temp1 = dummy;

        temp = head;
        while(temp != null){

            Node dummyNext = temp.next;
            Node nextOriginal = dummyNext.next;

            dummy.next = dummyNext;
            dummyNext.next = null;
            dummy = dummyNext;

            temp.next = nextOriginal;
            temp = nextOriginal;

        }

        return temp1.next;
    }
}
