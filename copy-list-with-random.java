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
