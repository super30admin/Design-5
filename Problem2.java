
// Time Complexity : O(m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        while(curr!=null){
            Node copy = curr.next;
            if(curr.random!=null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        Node copyHead = curr.next;
        while(curr!=null){
            Node copy = curr.next;
            curr.next = copy.next;
            if(copy.next!=null)
                copy.next = copy.next.next;
            curr = curr.next;
        }
        return copyHead;
    }
}