//Time Complexity: o(n)
//Space Complexity: o(1)
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
        //Create a linkedlist of original node and copy node next to each other
        while(head != null)
        {
            Node curcopy = new Node(head.val);
            curcopy.next = head.next;
            head.next = curcopy;
            head = head.next.next;
        }
        head = curr;
        //So now the copy nodes random and original nodes randmon will be adjacent
        //so copy.random  = original.randmon.next as they are adjacent
        while(head != null)
        {
            if(head.random != null)
                head.next.random = head.random.next;
            head = head.next.next;
        }
        Node copy = curr.next;
        Node result = copy;
        //Seperate original and copy arrays by assigning them to next.next so we skip intermediate nodes
        while (curr != null)
        {
            curr.next = curr.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            curr = curr.next;
            copy = copy.next;
        }
        return result;
    }
}