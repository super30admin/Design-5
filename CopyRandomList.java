// Time Complexity : O(n) 
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: Create a new node attached to the next pointer of each node in the head.
// Then add the random pointer of the new nodes to their respective pointers with the help of old random pointers next value. Then split 
// new nodes from the list.
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

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node curr = head;
        while(curr!=null){
            Node next=curr.next;
            curr.next= new Node(curr.val);
            curr.next.next=next;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        Node newList = curr.next;
        Node newHead = newList;
            while(curr!=null){
                curr.next=curr.next.next;
                if(newList.next!=null)
                    newList.next=newList.next.next;
                newList=newList.next;  
                curr=curr.next;
        }
        return newHead;
    }
}