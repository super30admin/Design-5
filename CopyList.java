// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

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
        if(head == null){
            return null;
        }
        Node cur = head;
        
        while(cur!=null){
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        cur = head;
        while(cur !=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        Node copyHead = cur.next;
        Node copyCur = cur.next;
        
        while(cur!=null){
            cur.next = copyCur.next;
            if(copyCur.next==null) break;
            copyCur.next = copyCur.next.next;
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return copyHead;
    }
}