//Time complexity O(n)
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
        
        if(head == null){
            
            return null;
        }
        
        Node currNode = head;
        Node copyNode; //= new Node(head.val);
        
        while(currNode != null){
            
            copyNode = new Node(currNode.val);
            copyNode.next = currNode.next;
            currNode.next = copyNode;
            currNode = currNode.next.next;
        }
        
        currNode = head;
        
        while(currNode != null){
            
            if(currNode.random != null){
                
                currNode.next.random = currNode.random.next;
            }
            currNode = currNode.next.next;
        }
        
        currNode = head;
        copyNode = head.next;
        Node result = head.next;
        
        while(currNode != null){
            
            currNode.next =  currNode.next.next;
            if(copyNode.next != null){
             copyNode.next = copyNode.next.next;   
            }
            
            currNode = currNode.next;
            copyNode = copyNode.next;
            
        }
        
        return result;
    }
}