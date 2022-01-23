// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Have a hashmap containing key value pair both as old node and new node. Generate node each time for next and random pointers.
//Map will make sure no duplicate node is created as if key exists , a node will be returned.
//Maintain a copy LinkedList and keep appending nodes.
  

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
    
    HashMap<Node,Node>map;
    public Node copyRandomList(Node head) {
        
        
    if(head==null) return null;
        
    map=new HashMap<>();
    
    Node current = head;
    Node copyHead = generateNode(head);
    Node copyCurrent=copyHead;
       //  System.out.println(copyCurrent.val);
        
            
    while(current!=null){
        
        Node tempNode = generateNode(current.next);
        copyCurrent.next=tempNode;
        copyCurrent.random=generateNode(current.random);
        current=current.next;
        copyCurrent=copyCurrent.next;
    }    
       
        return copyHead;
        
    }
    
    private Node generateNode(Node node){
        
        if(node==null) return null;
        
        if(map.containsKey(node)) return map.get(node);
        Node nextNode = new Node(node.val);
        map.put(node,nextNode);
        return nextNode;
    }
}

