// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes




class Solution {
    public Node copyRandomList(Node head) {
    Node itr=head;
    Node front=head;
    while(itr!=null) //Step 1 for cloning the next Nodes in the original list
    {
        front=itr.next;
        Node copy=new Node(itr.val);
        itr.next=copy;
        copy.next=front;
        itr=front;
    }
    itr=head;
    while(itr!=null) //Step 2 for cloning the random Nodes in the original list
    {
        if(itr.random!=null)
        {
            itr.next.random=itr.random.next;
        }
        itr=itr.next.next;
    }
    Node dummy=new Node(0);
    Node cp=dummy;
    itr=head;
    while(itr!=null)
    {
        front=itr.next.next;
        cp.next=itr.next;
        itr.next=front;
        cp=cp.next;
        itr=itr.next;
    }
    return dummy.next;
    }
}

