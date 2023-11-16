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

// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    
    public Node copyRandomList(Node head) {
        
        Node dummyHead = new Node(-1);
        Map<Node, Node> oldToNewNodes = new HashMap<>();        // creating map from old node to new node

        Node old = head;
        Node pointer = dummyHead;
        
        while(old != null) {

            Node copy = new Node(old.val);         
            pointer.next = copy;                                // creating new linked list
            
            oldToNewNodes.put(old, copy);                       // maintaining map

            pointer = copy;

            old = old.next;
        
        }

        old = head;
        pointer = dummyHead.next;

        while(old != null) {
            
            pointer.random = oldToNewNodes.get(old.random);     // get random of old node and get mapping of it from map to get new random node

            old = old.next;
            pointer = pointer.next;

        }
        
        return dummyHead.next;

    }

}
