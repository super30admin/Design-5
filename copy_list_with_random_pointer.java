// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;
        while (curr!=null){
            Node copyNode=new Node(curr.val);
            copyNode.next=curr.next;
            curr.next=copyNode;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        curr=head;
        Node copyHead=curr.next;
        Node copyCurr=curr.next;
        while(curr!=null){
            curr.next=copyCurr.next;
            if(copyCurr.next==null) break;
            copyCurr.next=copyCurr.next.next;
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        return copyHead;
    }
}