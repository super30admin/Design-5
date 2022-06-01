// TC: O(n) where n is the number of nodes in the linked list.
// SC: O(1).
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

class RandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // 1. Create deep copy. 1->1`->2->2`
        while(curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }
        // 2. Random pointer
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // 3. Split
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = curr.next;
        while(curr != null) {
            curr.next = curr.next.next;
            if(copyCurr.next == null) break;
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
            
        }
        return copyHead;
    }
    
    // HashMap Approach. TC: O(n), SC: O(n).
//     HashMap<Node, Node> map;
//     public Node copyRandomList(Node head) {
//         if(head == null) return null;
//         map = new HashMap<>();
//         Node copyHead = clone(head);
//         Node curr = head;
//         Node copyCurr = copyHead;
        
//         while(curr != null) {
//             copyCurr.next = clone(curr.next);
//             copyCurr.random = clone(curr.random);
//             curr = curr.next;
//             copyCurr = copyCurr.next;
//         }
//         return copyHead;
//     }
    
//     private Node clone(Node node) {
//         if(node == null) return null;
//         if(map.containsKey(node)) 
//             return map.get(node);
//         Node copyNode = new Node(node.val);
//         map.put(node, copyNode);
//         return copyNode;
//     }
}