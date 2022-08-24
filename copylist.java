// TC :O(n)
// SC: O(n)

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
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        map = new HashMap<>();
        Node copyhead = clone(head);
        
        Node curr = head;
        Node copycurr = copyhead;
        while(curr!=null){
            copycurr.next = clone(curr.next);
            copycurr.random = clone(curr.random);
            curr = curr.next;
            copycurr = copycurr.next;
        }
        return copyhead;
        
    }
    private Node clone(Node node){
        if(node == null) return null;
        
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newnode = new Node(node.val);
        map.put(node,newnode);
        return newnode;
    }
}