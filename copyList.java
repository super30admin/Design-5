// TC:SC= O(n)
class Solution {
    HashMap<Node, Node>map;
    public Node copyRandomList(Node head) {
    //null case
        if(head==null) return null;
        
        map= new HashMap();
        Node curr= head;
        Node copyHead= clone(head);
        Node copyCurr= copyHead;
        
        while(curr!= null){             //Single pass- vishay hard!
            copyCurr.next= clone(curr.next);
            copyCurr.random= clone(curr.random);
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        
        return copyHead;
    }
    
    private Node clone(Node node){
        if (node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node newNode= new Node(node.val);
        map.put(node, newNode);
        return map.get(node);
    }
}
