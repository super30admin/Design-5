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
// This solution uses a 3 fold approach
// Step 1 includes cloning each node and attaching it immediately after the original node
// Step 2 is clong random node. Trick here is to find the random node by going to that node and looking for next
// Step 3 is to detach both the lists
class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;

        // Node cloning
        while(curr!=null) {
            Node node = new Node(curr.val);
            Node temp = curr.next;
            curr.next = node;
            node.next = temp;
            curr = node.next;
        }

        curr=head;
        Node next = head.next, newNode = head.next;
        // Random pointer mapping
        while(curr!=null) {
            next=curr.next;
            if(curr.random!=null) next.random = curr.random.next;
            curr=next.next;
        }

        // Dividing the linkedlist
        curr = head;
        Node newHead = head.next;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;                
            if (copy.next != null) {
                copy.next = copy.next.next; 
            }
            curr = curr.next;
        }

        return newNode;
    }
}
