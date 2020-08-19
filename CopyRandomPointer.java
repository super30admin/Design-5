//Time - O(n)
//Space - O(n)

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        
        Node curr = head;
        Node copy = clone(head);
        while(curr!=null){
            copy.next = clone(curr.next);
            copy.random=clone(curr.random);
            curr=curr.next;
            copy=copy.next;
        }
        return map.get(head);
        
    }
    
    private Node clone(Node node){
        if(node==null) return node;
        
        if(!map.containsKey(node))
        {
            map.put(node,new Node(node.val));
        }
        
        return map.get(node);
        
    }
}
