// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node curr = head;
        Node copyCurr = clone(curr);
        while(curr!=null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr=curr.next;
            copyCurr=copyCurr.next; 
        }
        return map.get(head);
    }
    
    public Node clone(Node node){
        if(node==null)return null;
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}