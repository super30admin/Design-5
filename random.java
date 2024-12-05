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
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node temp=new Node(curr.val);
            temp.next=curr.next;
            curr.next=temp;
            curr=curr.next.next;
        }
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        curr=head;
        Node copycurr=curr.next;
        Node copyhead=curr.next;
        while(copycurr.next!=null){
            curr.next=curr.next.next;
            curr=curr.next;
            copycurr.next=copycurr.next.next;
            copycurr=copycurr.next;
        }
        curr.next=curr.next.next;
        return copyhead;
    }
}
