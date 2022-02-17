// Time Complexity : Add : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(head == null)
            return null;

        
        // First pass to create duplicate Nodes
        Node curr = head;  
        while(curr != null){  // T.C - O(n)   S.C - O(1), no extra space used
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            
            curr = curr.next.next;
        }

        
        //Second pass to join with random pointers
        curr = head;  
        while(curr != null){  // T.C - O(n)
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //Seperate the original and copy 
        curr = head;  
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        while(curr != null){  // T.C - O(n)
            curr.next = curr.next.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
        
    }
}
