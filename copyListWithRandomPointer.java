// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node curr = head;
        Node currCopy = clone(head);
        while(curr != null) {
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return map.get(head);
    }
    
    public Node clone(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node temp = new Node(head.val);
        map.put(head, temp);
        return temp;
    }
}
