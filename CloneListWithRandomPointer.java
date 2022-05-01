/**
 * Time complexity is O(n)
 * space complexity is O(n)
 */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node, Node> clones = new HashMap<>();
        Node iter = head;
        
        while(iter != null) {
            clones.put(iter, new Node(iter.val));
            iter = iter.next;
        }
        
        iter = head;
        
        while(iter != null) {
            Node clone = clones.get(iter);
            clone.next = clones.get(iter.next);
            clone.random = clones.get(iter.random);
            
            iter = iter.next;
        }
        
        return clones.get(head);
        
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