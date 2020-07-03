//time o(n)
//space o(n)
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        map = new HashMap<>();
        
        Node cur = head;
        Node copyCur = clone(cur);
        map.put(head, copyCur);
        
        while(cur != null) {
            copyCur.next = clone(cur.next);
            copyCur.random = clone(cur.random);
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return map.get(head);
    }
    
    private Node clone(Node node) {
        if(node == null)
            return null;
        if(!map.containsKey(node)) {
            Node copy = new Node(node.val);
            map.put(node, copy);
        }
        return map.get(node);
    }
}