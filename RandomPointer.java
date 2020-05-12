// Time Complexity : O(n) 
// Space Complexity : O(n)
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
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        
        Node node  = new Node(head.val);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
         
        return node;
        
    }
}