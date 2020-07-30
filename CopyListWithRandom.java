// Time Complexity: O(n)
// Space Complexity: O(1)
//Referred Keerti's soluiton.

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
        Node curr = head;        
       
        while(curr != null){
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;            
            curr = next;
        }        
        curr = head;                
        while(curr != null){
            if(curr.next != null)
                curr.next.random = curr.random != null ? curr.random.next : null;            
            curr = curr.next != null ? curr.next.next : null;
        }        
       
        Node orig = head, copy = head.next, newHead = copy;
        while(orig != null && copy != null){            
            orig.next = orig.next != null ? orig.next.next : null;
            copy.next = copy.next != null ? copy.next.next : null;            
            orig = orig.next;
            copy = copy.next;
        }
        return newHead;
    }
}