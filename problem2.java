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

class copyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node curr = head;
        while(curr != null){
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = curr.next;
        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next == null) break;
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
}

//O(n)
//O(1)