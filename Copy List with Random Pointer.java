
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

//Two Path Solution with Time O(n)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        //create deep copy and put next to org node
        Node curr = head;
        while(curr != null)
        {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        //create random pointers
        curr = head;
        while(curr != null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //split both the lists
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;
        
        while(curr != null)
        {
            curr.next = curr.next.next;
            if(copyCurr.next != null)
            {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}