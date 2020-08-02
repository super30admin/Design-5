// Time Complexity : O(n) n-number of nodes 
// Space Complexity : O(n) n nodes are stored in hashmap
// Did this code successfully run on Leetcode : Yes
// https://leetcode.com/problems/copy-list-with-random-pointer/

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
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        map=new HashMap<>();
        Node curr=clone(head);
        Node original=head;
        while(original!=null)
        {
            curr.next=clone(original.next);
            curr.random=clone(original.random);
            original=original.next;
            curr=curr.next;
        }
        
        return map.get(head);
    }
    
    public Node clone(Node node)
    {
        if(node==null) return null;
        if(!map.containsKey(node))
        {
            Node newNode=new Node(node.val);
            map.put(node,newNode);
        }
        return map.get(node);
    }
}