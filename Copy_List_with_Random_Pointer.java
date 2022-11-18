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

// TC : O(n)
// SC : O(1)

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        Node curr = head;
        
        while(curr != null) {
            Node dupCur = new Node(curr.val);
            dupCur.next = curr.next;
            curr.next = dupCur;
            curr = curr.next.next;
        }
        
        curr = head;
        
        while(curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        curr = head;
        Node dupCur = curr.next;
        Node result = curr.next; 
        
        while(curr != null) {
            
            curr.next = dupCur.next;
            if(dupCur.next == null) break;
            
            dupCur.next = dupCur.next.next;
            curr = curr.next;
            dupCur = dupCur.next;
        }
        
        return result;
        
    }
}
