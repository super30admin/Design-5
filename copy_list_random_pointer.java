package codes;

public class copy_list_random_pointer {
	  // o(n) tc and spc
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        map=new HashMap<>();
        
        //create a deep copy of head
        Node copyHead=clone(head);
        
        Node curr=head;
         
        Node currCopy =copyHead;
        
        
        while(curr!=null){
            currCopy.next=clone(curr.next);
            currCopy.random=clone(curr.random);
            currCopy=currCopy.next;
            curr=curr.next;
            
        }
        return copyHead;
    }
    
    
private Node clone(Node node){
    if(node==null) return null;
    
    if(map.containsKey(node)){
        return map.get(node);
    }
    
    
    
    Node newNode = new Node(node.val);
    
    map.put(node, newNode);
    
    return newNode;
}
}
