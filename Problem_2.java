//Time Complexity:O(n)
//Space Comlpexity:O(1)
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
        if(head==null) return head;
        Node curr= head;
        //making combined list with duplicates
        while(curr!=null){
            Node currCopy=new Node(curr.val);
            currCopy.next=curr.next;
            curr.next=currCopy;
            curr=curr.next.next;
        }
        curr=head;
        //Setting random
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        //Dividing duplicate from original
        curr=head;
        Node copyHead=curr.next;
        Node currCopy= curr.next;
        while(curr!=null){
            curr.next=currCopy.next;
            if(currCopy.next!=null){
                currCopy.next=currCopy.next.next;
            }
            curr=curr.next;
            currCopy=currCopy.next;
        }
        return copyHead;
    }
}