// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            map.put(curr,newNode);
            curr=curr.next;
        }
        
        Node newCurr=head;
        while(newCurr!=null){
            map.get(newCurr).next=map.get(newCurr.next);
            newCurr=newCurr.next;
        }
        
        newCurr=head;
        while(newCurr!=null){
            map.get(newCurr).random=map.get(newCurr.random);
               newCurr=newCurr.next;
        }
        
        return map.get(head);
    }
    
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
}