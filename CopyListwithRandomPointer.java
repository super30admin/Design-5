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
// 0(n)
// 0(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return null;
        }

        Node curr = head;

        while(curr!=null)
        {
            Node copyNode = new  Node(curr.val);
            copyNode.next=curr.next;
            curr.next=copyNode;
            curr=curr.next.next;
        }

        curr = head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;;
        }

        curr = head;
        Node coppyhead=curr.next;
        Node coppyCur=curr.next;

        while(curr!=null)
        {
            curr.next=coppyCur.next;
            if(coppyCur.next == null) break;
            coppyCur.next=coppyCur.next.next;
            curr=curr.next;
            coppyCur=coppyCur.next;
        }

        return coppyhead;

    }
}