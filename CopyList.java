// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class CopyList {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        //make random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //split lists
        curr = head;
        Node copyHead = head.next;
        Node copy = head.next;
        while(curr != null){
            curr.next = curr.next.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            curr = curr.next;
            copy = copy.next;
        }
        return copyHead;
    }
}