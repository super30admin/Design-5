// Time Complexity : O(n)
// Space Complexity : O(n)

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
    private Node createList(Node head){
        Node curr = head;
        Node copyHead = null;
        Node copyCurr = copyHead;
        
        while(curr!=null){
            Node node = new Node(curr.val);
            if(copyHead == null){
                copyHead = copyCurr = node;
                curr = curr.next;
                continue;
            }
            copyCurr.next = node;
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        return copyHead;
    }
    
    private Node createRandom(Node head, Node copyHead){
        Node curr = head;
        Node copyCurr = copyHead;
        
        while(curr!=null){
            copyCurr.random = findRandom(head, copyHead, curr.random); //returns random pointer of given node.
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
    
    private Node findRandom(Node head, Node copyHead, Node node){
        Node curr = head;
        Node copyCurr = copyHead;
        
        while(curr!=node){
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        
        return copyCurr;
    }
    
    public Node copyRandomList(Node head) {
        Node copyHead = null;
        Node copyCurr = copyHead;
        
        //Creates list without random pointers.
        copyHead = createList(head);
        
        //Creating random pointers.
        copyHead = createRandom(head, copyHead);
        
        return copyHead;
    }
}