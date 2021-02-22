//Problem 112: Copy List with Random Pointer
//TC: O(N)
//SC: O(N)

//Bruteforce: Using Extra Space that is for map
/*Steps: 1) Create a general function getClone(), for creating the node, if not created or to geting any node, if clone is already created 
Iterate over the given node and use getClone() method for finding the deepCopy along with deepCopy next and random;

*/

import java.util.*;
class Solution {

    class Node{
        Node next,random;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    private Map<Node,Node> map;
    public Node copyRandomList(Node head) {
        
        if(head==null) return head;
        map = new HashMap<>();
        Node curr = head;
        
        while(curr!=null){
            
            Node deepCopy   = getClone(curr);
            deepCopy.next   = getClone(curr.next);
            deepCopy.random = getClone(curr.random);
            
            curr = curr.next;
        }
        
        return map.get(head);
    }
    
    private Node getClone(Node curr){
        
        if(curr==null) return null;
        
        if(map.containsKey(curr)){
            return map.get(curr);
        }
        
        map.put(curr,new Node(curr.val));
        
        return map.get(curr);
        
    }
}