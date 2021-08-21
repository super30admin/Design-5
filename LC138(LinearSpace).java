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
    Map<Node, Node> copyMap;
    public Node copyRandomList(Node head) {
        
        copyMap = new HashMap<>();
        
        if(head == null) {
            return null;
        }
        
        Node cloneHead = clone(head);
        Node curr = head;
        Node copyCurr = cloneHead;
        
        while(curr != null) {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return cloneHead;
    }
    
    private Node clone(Node node) {
        if(node == null) {
            return null;
        }
        
        if(copyMap.containsKey(node)) {
            return copyMap.get(node);
        }
        
        Node copyNode = new Node(node.val);
        copyMap.put(node, copyNode);
        return copyNode;
    }
}

//Time : O(n)
//Space : O(n)