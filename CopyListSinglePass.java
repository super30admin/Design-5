// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/copy-list-with-random-pointer/
// Any problem you faced while coding this : No

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
        Node copyHead = clone(head,map);
        Node copyCurr = copyHead;
        while(curr!=null){
            copyCurr.next = clone(curr.next,map);
            copyCurr.random = clone(curr.random,map);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    private Node clone(Node node,HashMap<Node,Node>map){
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        return newNode;
    }
}
