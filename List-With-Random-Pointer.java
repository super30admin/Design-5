

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    
    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }
       
        map = new HashMap<>();
       
        Node copyHead = clone(head);
      
        Node curr = head;
        
        Node copyCurr = copyHead;
       
        while (curr != null) {
           
            Node node = clone(curr.next);
           
            copyCurr.next = node;
           
            node = clone(curr.random);
           
            copyCurr.random = node;
           
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    private Node clone(Node node) {
       
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
       
        Node newNode = new Node(node.val);
        
        map.put(node, newNode);
        
        return newNode;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public Node copyRandomList(Node head) {
       
        if (head == null) {
            return null;
        }
       
        Node curr = head;
       
        while (curr != null) {
            
            Node newNode = new Node(curr.val);
            
            newNode.next = curr.next;
            
            curr.next = newNode;
         
            curr = curr.next.next;
        }
       
        curr = head;
        
        while (curr != null) {
           
            if (curr.random != null) {
                
                curr.next.random = curr.random.next;
            }
            
            curr = curr.next.next;
        }
       
        curr = head;
    
        Node copyHead = curr.next;
       
        Node copyCurr = copyHead;
    
        while (curr != null) {
         
            curr.next = curr.next.next;
            // If we are at last node, break
            if (copyCurr.next == null) {
                break;
            }
            // Else make 1`->2`
            copyCurr.next = copyCurr.next.next;
            // Move both pointers
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
       
        return copyHead;
    }
}