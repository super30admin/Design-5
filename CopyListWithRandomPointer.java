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

//TC: O(n)
//SC: O(n)
class Solution {
    Map<Node, Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr!=null){
            Node currCopy = clone(curr);
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return map.get(head);
    }
    
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}
