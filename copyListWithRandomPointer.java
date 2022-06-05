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
//TC : O(n)
//SC : O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        //create duplicate list
        while(curr!=null)
        {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr=curr.next.next;
        }

        //set random pointers
        curr = head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //divide the list
        curr = head;
        Node dupListHead = curr.next;

        while(curr!=null)
        {
            Node temp = curr.next;
            curr.next = curr.next.next;
            if(temp.next==null) break;
            temp.next = temp.next.next;
            curr = curr.next;
        }
        return dupListHead;
    }
}