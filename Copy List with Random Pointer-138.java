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

// Time Complexity: O(n) where n is number of nodes
//Space Complexity: O(n) where n is number of nodes
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
         if(head == null){
            return head;
        }

        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr != null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        return copyHead;
    }
    private Node clone(Node node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}
