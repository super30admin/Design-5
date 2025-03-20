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
// linear solution with O(1) space
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        return null;
       Node cur = head;
        while(cur!=null)
        {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        cur = head;
        //create the random pointers
        while(cur!=null)
        {
            if(cur.random!=null)
            {
                cur.next.random=cur.random.next;

            }
            cur = cur.next.next;
        }

        //split the lists
        cur = head;
        Node copyHead = cur.next;
        Node copyCur = cur.next;
        while(cur!=null)
        {
            cur.next=cur.next.next;
            if(copyCur.next!=null)
            {
                copyCur.next= copyCur.next.next;
            }
            cur = cur.next;
            copyCur=copyCur.next;
        }
        return copyHead;
    }
    
}

//Time Complexity (TC): O(n)
//Space Complexity (SC): O(1)