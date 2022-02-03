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
// Time Complexity :O(n) for deep copy and set random pointers and separating two lists
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null) return null;
        
        Node curr=head;
       //deep copy of the lists
        while(curr!=null){
            Node copyNode=new Node(curr.val);
            copyNode.next=curr.next;
            curr.next=copyNode;
            if(curr.random!=null)
            {curr.next.random=curr.random.next;}
            curr=curr.next.next;
        }
        curr=head;
        //copy random pointers
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        
        //separate two lists
        curr=head;
        Node copyHead=curr.next;
        Node copyCurr=copyHead;
        
        while(curr!=null && curr.next!=null){
            curr.next=curr.next.next;
            if(copyCurr.next!=null)
            {copyCurr.next=copyCurr.next.next;}
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        return copyHead;
        }
    
}