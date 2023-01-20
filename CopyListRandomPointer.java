//https://leetcode.com/problems/copy-list-with-random-pointer
//TC:o(n)
//SC: o(1)
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
        Node copyHead = new Node(head.val);
        Node copy = copyHead;
        int i =0;
        while(curr!=null){
            if(curr.next!=null){
                Node newNode = new Node(curr.next.val);
                copy.next = curr.next;
                curr.next = copy;
                curr = copy.next;
                copy = newNode;
            }else{
                curr.next = copy;
                break;
            }            
        }
        curr = head;     
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        copy = copyHead;
        while(copy.next != null){    
            curr.next = copy.next;
            curr = curr.next;
            copy.next = curr.next;
            copy = copy.next;
        }
        curr.next = null;
        
        return copyHead;
    }
}
