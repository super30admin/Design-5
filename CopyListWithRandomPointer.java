// Time Complexity : O(n) where n = number of elements in linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//138. Copy List with Random Pointer (Medium) - https://leetcode.com/problems/copy-list-with-random-pointer/
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
    
    //HashMap<Node, Node> map;
    
    public Node copyRandomList(Node head) {
        // Time Complexity : O(n) where n = number of elements in linked list
    	// Space Complexity : O(n) where n = number of elements in linked list
//        this.map = new HashMap<>();
//        
//        Node curr = head;
//        Node copyHead = clone(head);
//        Node copyCurr = copyHead;
//        
//        while (curr != null) { // O(n)
//            copyCurr.next = clone(curr.next);
//            copyCurr.random = clone(curr.random);
//            curr = curr.next;
//            copyCurr = copyCurr.next;
//        }
//        
//        return copyHead;
//    }
//    
//    private Node clone(Node node) {
//        if (node == null) return null;
//        
//        if (map.containsKey(node)) return map.get(node);
//        
//        Node newNode = new Node(node.val);
//        map.put(node, newNode);
//        return newNode;
    	
    	// Time Complexity : O(n) where n = number of elements in linked list
    	// Space Complexity : O(1) 
    	if (head == null) return head;
        
        Node curr = head;
        
        // Create new nodes and link to adjacent of original nodes
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        // Create random pointers
        curr = head;
        
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            
            curr = curr.next.next;
        }
        
        // Remove links with original nodes
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
}