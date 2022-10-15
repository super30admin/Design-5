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
//tc - o(3n)
//sc-o(1)
class Solution {
    public Node copyRandomList(Node head) {
        //null
        if(head == null)return head;
        //create a deep copy and put next to the node
        Node curr = head;
        while(curr != null) //o(n)
        {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        //create random pointers
        curr = head;
        Node copycurr = curr.next;
        while(curr != null) // o(n)
        {
            if(curr.random != null)
            {
              copycurr.random = curr.random.next;
            }
            curr = curr.next.next;
             if(copycurr.next != null) copycurr = copycurr.next.next;

        }
        //split
        curr = head;
        Node copyHead = curr.next;
        copycurr = curr.next;
        while(curr != null)//o(n)
        {
            curr.next = curr.next.next;
            if(copycurr.next != null)
            copycurr.next = curr.next.next;

            curr = curr.next;
            copycurr = copycurr.next;


        }
        return copyHead;
    }
}