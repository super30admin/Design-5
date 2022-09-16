//TC - O(N);
//SC - O(N);
//LC - 138
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
        map = new HashMap<>();
        if(head==null) return null;
        
        Node copy = clone(head);
        
        Node curr = head;
        Node copyCurr = copy;
        
        while(curr!=null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        
        return copy;
    }
    
    public Node clone(Node root){
        if(root==null) return null;
        if(map.containsKey(root)) return map.get(root);
        Node newNode = new Node(root.val);
        map.put(root,newNode);
        return newNode;
    }
}