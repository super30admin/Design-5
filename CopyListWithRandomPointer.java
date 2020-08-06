// Time Complexity : O(n) --> n is the number of nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (138): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        // edge case
        if (head == null) return null;
        
        map = new HashMap<>();
        Node currCopy = clone(head);
        Node curr = head;
        
        while (curr != null) {
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return map.get(head);
    }
    
    private Node clone(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    } 
}