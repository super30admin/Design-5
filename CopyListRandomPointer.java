// Time Complexity :O(n)
// Space Complexity :O(1)
// Algorithm
public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        // create head clone
        Node curr = head;
        
        // link copy of new node as next node
        while(curr != null)
        {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            // move curr to next curr
            curr = copy.next;
        }
        
        curr = head;
        // link random
        while(curr != null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // break the links
        curr = head;
        Node copy = curr.next;
        Node copyHead = copy;
        
        while(curr != null)
        {
            curr.next = curr.next.next;
            if(copy.next == null)
                break;
            copy.next = copy.next.next;
            
            curr = curr.next;
            copy = copy.next;
            
        }
        
        return copyHead;
    }
}
// Time Complexity :O(n)
// Space Complexity :O(n)
// Brute Force
public class CopyListRandomPointer {
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        map = new HashMap<>();
        // create head clone
        Node copyHead = clone(head);
        
        Node curr = head;
        Node copyCurr = copyHead;
        
        // link next make copy of next elements
        while(curr != null)
        {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);

            curr = curr.next;
            copyCurr = copyCurr.next; 
        }
        
        
        return copyHead;
    }
    
    private Node clone(Node node)
    {
        if(node == null)
            return null;
        
        if(map.containsKey(node))
            return map.get(node);
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        
        return copy;
    }
}