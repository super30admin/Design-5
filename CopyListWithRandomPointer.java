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

// Time complexity: O(N)
// Space complexity: O(N)
import java.util.*;

class Solution {
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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node curr = head;
        Node copyCurr = clone(head);
        
        while(curr != null)
        {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return map.get(head);

    }
    
    public Node clone(Node n)
    {
        if(n == null)
        {
            return null;
        }
        if(!map.containsKey(n))
        {
            map.put(n, new Node(n.val));
        }
        return map.get(n);
    }
}