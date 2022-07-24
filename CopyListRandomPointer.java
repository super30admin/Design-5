//TC - O(n)
//SC - O(1)
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
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node curr = head;
        while(curr != null){
            Node newnode = new Node(curr.val);
            newnode.next = curr.next;
            curr.next = newnode;
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
        Node copycurr = head.next;
        Node copyhead = copycurr;
        while(curr != null){
           curr.next = curr.next.next;
            if(copycurr.next != null){
                copycurr.next = copycurr.next.next;
            }
            curr = curr.next;
            copycurr = copycurr.next;
        }
        return copyhead;
    }
}
