// Time Complexity :O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
1. Create duplicateNode n attach it next to original node 
2. set duplicate node's random node
3. separate both lists

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
        if(head == null  )
        {
            return null;
        } 
      
       
        Node curr = head;
  
       // step1. make new duplicateNodes and attach to original nodes
        while(curr != null)
        {
         Node  deepNode = new Node(curr.val);
            deepNode.next = curr.next;
            curr.next = deepNode;
         
            curr = curr.next.next;
        }
        
        // attach duplicateNode's random
        curr = head;
         while(curr != null)
        {
             if(curr.random != null)
           curr.next.random = curr.random.next;
           curr = curr.next.next;
        }
        
        curr = head;
       Node deepHead = curr.next;
          Node head_old = deepHead;
    // step3. saperate both the lists duplicate and original
         while(curr != null)
        {
             curr.next = curr.next.next;
             
             if(deepHead.next != null)
          deepHead.next = deepHead.next.next;
          deepHead =   deepHead.next;
           curr = curr.next;
        }
        
        return head_old;
    }
}