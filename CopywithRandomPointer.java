class CopywithRandomPointer {

    HashMap<Node,Node> map = new HashMap<>();
    /*
      Time : O(N) | one time pass, 
      Space : O(N) | Additional HashMap is created
      Leetcode : YES
    */
    /*
      Approach :
      1. While passing through list, create copy of curr node + next node + random node.
      2. To know if curr node is already created (maybe it was referenced via random pointer earlier) keep {Node, ClonedNode} in hashmap.
      
    */    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        Node clonedHead = clone(head);
        Node clonedCurr = clonedHead;
        while(curr != null){
            clonedCurr.next = clone(curr.next);
            clonedCurr.random = clone(curr.random);
            curr = curr.next;
            clonedCurr  = clonedCurr.next;
        }
        
        return clonedHead;
    }
    
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node))
            return map.get(node);
        
        Node cloned = new Node(node.val);
        
        map.put(node,cloned);
        return cloned;
    }

    /*
      Time : O(N) | adding a deepcopy in list + creating random pointer + removing deepcopy from original list | O(3N)
      Space : O(1) | Not using any additional space
      Leetcode : YES
    */
    /*
      Approach :
      1. create a deepcopy of each node and add it as next item in the list.
      2. Now we have 1 -> 1' -> 2 - > 2' -> 3 -> 3' kind of list. create deepcopy's random pointers.
      3. Remove deepcopied list and bring original list to it's state.
    */
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        Node clonedCurr ;
        while(curr != null){
            clonedCurr = new Node(curr.val);
            Node temp = curr.next;
            curr.next = clonedCurr;
            clonedCurr.next = temp;
            curr = curr.next.next;
        }
        
        Node clonedHead = head.next;
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            if(curr.next != null){
                curr = curr.next.next;
            }
        }
        
        clonedCurr = clonedHead;
        curr = head;
        while(curr != null){
            curr.next = clonedCurr.next;
            if(clonedCurr.next != null)clonedCurr.next = clonedCurr.next.next;
            curr = curr.next;
            clonedCurr = clonedCurr.next;
            
        }
        
        return clonedHead;
    }

  
}
