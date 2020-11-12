// Time Complexity: O(N)
// Space Complexity: O(N)
// Passed Leetcode

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
    HashMap<Node, Node> nodeMap;
    public Node getNode(Node node) {
        
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);    
        }
        
        Node currNode = new Node(node.val);
        
        nodeMap.put(node, currNode);
        
        return currNode;
        
    }
    public Node copyRandomList(Node head) {
        
        nodeMap = new HashMap<>();
        
        Node tempHead = new Node(-1);
        
        Node prev = tempHead;
        
        while (head != null) {
            
            
            Node curr = getNode(head);
            
            prev.next = curr;
                 
            if (head.random != null)
                curr.random = getNode(head.random);
            
            prev = curr;
            
            head = head.next;
        } 
        
        return tempHead.next;
    }
}