// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//https://leetcode.com/problems/copy-list-with-random-pointer
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
    
    //keep map of original node and its cloned node
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        map = new HashMap<>();
        
        Node curr = head;
        Node prev = null;
        
        while(curr != null) {
            //create clone of current node and create next link from prev node to clonned node
            Node temp = clone(curr);
            if(prev != null){
                prev.next = temp;
            }
            
            prev = temp;
            curr = curr.next;
        }
        
        return map.get(head);
    }
    
    private Node clone(Node root) {
        //if clone of root already created, return it
        if(map.containsKey(root)) {
            return map.get(root);
        }else {
            //create clone node and put its mapping in the map
            Node cloned = new Node(root.val);
            map.put(root, cloned);
            
            //if there is random node for root, create clone of that node as well and create linking between cloned and random node
            if(root.random != null) {
                Node clonnedRandom = clone(root.random);
                cloned.random = clonnedRandom;
            }
            
            return cloned;
        }
    }
}