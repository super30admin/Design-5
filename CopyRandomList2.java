// Time Complexity : O(n)
// Space Complexity : O(1)

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
        if(head == null)
            return head;
        //add new nodes
        Node cur = head;
        while(cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            
            cur = cur.next.next;
        }
        
        //update random pointer
        cur = head;
        while(cur != null){
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        
        //split
        cur = head;
        Node newHead = cur.next;
        Node newCur = newHead;
        
        while(cur != null){
            cur.next = cur.next.next;
            if(newCur.next != null)
                newCur.next = newCur.next.next;
            cur= cur.next;
            newCur = newCur.next;
        }
        
        return newHead;
    }
}