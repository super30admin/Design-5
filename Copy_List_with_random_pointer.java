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
        if(head == null) return null;
        
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //split list
        curr = head;
        Node copyHead  = head.next;
        Node currCopy = copyHead;
        while(curr != null){
            curr.next = curr.next.next;
            if(curr.next != null){
                currCopy.next = currCopy.next.next;
                
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }
}

//TC: O(N)
//SC: O(1)
