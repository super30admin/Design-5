// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node currCopy = copyHead;
        
        while(curr != null){
            // handle the next ptr
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}

// *******************************************

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
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // create deep copy put next to original nodes
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        // create random ptr of deep copies
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        // split
        curr = head;
        Node copyHead = head.next;
        Node currCopy = head.next;
        
        while(curr != null){
            curr.next = curr.next.next;
            if(currCopy.next != null)
                currCopy.next = currCopy.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }
}