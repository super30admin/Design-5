/* Time Complexity : O(n)
 *  n - size of the list */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 


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
//One pass solution
class Solution {
     HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        //Map to hold the link between original and copied node
        this.map = new HashMap<>();
        Node copyHead = clone(head);
        map.put(head, copyHead);
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr != null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    //To create a copy of a node if not present else return existing node
    private Node clone(Node node){
        if (node == null) return node;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}