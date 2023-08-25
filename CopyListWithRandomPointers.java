// Time Complexity : O(n);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class CopyListWithRandomPointers {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        // create deepcopy and insert inbetween
        while(curr!=null)
        {
            Node deepCopy = new Node(curr.val);
            deepCopy.next = curr.next;
            curr.next = deepCopy;

            curr = curr.next.next;
        }

        // set random pointers for deep copies
        curr = head;
        while(curr!=null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // split the copies from original
        curr = head;
        Node copyCurr = head.next;
        Node copyHead = head.next;
        while(curr!=null)
        {
            curr.next = curr.next.next;
            if(copyCurr.next!=null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}
