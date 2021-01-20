// Time - O(N)
// Space - O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        
        Node curr = head;
        
        // create new list
        while(curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = curr.next.next;
        }
        curr = head;
        // deal with random
        while(curr !=null) {
            if(curr.random!=null){
                curr.next.random = curr.random.next;                
            }
            curr = curr.next.next;
        }
        // break the list
        curr = head;
        Node newList = curr.next;
        Node dummy = newList;
        while(curr!=null) {
            curr.next = curr.next.next;
            if(newList.next!=null) {
                newList.next = newList.next.next;
            }
            curr = curr.next;
            newList = newList.next;
        }
        return dummy;
    }
}

// Time - O(N)
// Space - O(N)
class Solution {
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        map = new HashMap<>();
        Node curr = head;
        Node newList = clone(head);
        Node dummy = newList;
        
        while(curr!=null) {      
            
            // copy and move forward
            newList.next = clone(curr.next);
            newList.random = clone(curr.random);
            
            // moving next
            curr = curr.next;
            newList = newList.next;
        }
        
        return dummy;
    }
        
    private Node clone(Node head) {
        
        if(head == null) {
            return head;
        }
        if(map.containsKey(head)) {
            return map.get(head);
        }
        Node copy = new Node(head.val);
        map.put(head, copy);
        
        return copy;
        
    }
}
