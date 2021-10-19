// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class copyListWithRandPts {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node tmp = head;

        while(tmp!=null)
        {
            Node p = tmp;
            Node _node = new Node(p.val);
            _node.next = p.next;
            p.next = _node;
            tmp=_node.next;
        }

        Node rand = head;
        while(rand!=null)
        {
            if(rand.random!=null)
                rand.next.random = rand.random.next;
            else
                rand.next.random = null;
            rand = rand.next.next;
        }

        Node p1 = head;
        Node copy = p1.next;
        Node p2 = copy;
        while(p1!=null && p2!=null)
        {
            p1.next = p2.next;
            p1 = p2;
            p2 = p1.next;
        }

        return copy;
    }
}
