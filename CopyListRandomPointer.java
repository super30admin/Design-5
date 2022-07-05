// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        HashMap<Node,Node>map = new HashMap<Node,Node>();
        Node node = head;
        while(node!=null){
            map.put(node,new Node(node.val));
            node = node.next;
        }
        
        node = head;
        while(node!=null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}