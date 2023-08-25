// Time Complexity : O(n);
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

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

public class CopyListWithRandomPointerWithHashMap {

    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;

        while(curr!=null)
        {
            if(curr.next!=null)
            {
                copyCurr.next = clone(curr.next);
            }
            if(curr.random !=null)
            {
                copyCurr.random = clone(curr.random);
            }

            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    public Node clone(Node node)
    {
        if(!map.containsKey(node))
        {
            Node newNode = new Node(node.val);
            map.put(node,newNode);
        }

        return map.get(node);

    }
}
