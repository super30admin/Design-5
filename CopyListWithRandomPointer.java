//TC = O(N)
//SC = O(N)
import java.util.*;
public class CopyListWithRandomPointer{

    public static HashMap<Node,Node> map;
    public static Node copyRandomList(Node head)
    {
        if(head == null) return null;

        map = new HashMap<>();

        Node copyHead = clone(head);

        Node curr = head;
        Node copyCurr = copyHead;

        while(curr!=null)
        {
            copyCurr.next=clone(curr.next);
            copyCurr.random=clone(curr.random);
            curr=curr.next;
            copyCurr=copyCurr.next;
        }

        return copyHead;
    }

    private static Node clone(Node head)
    {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node copyNode = new Node(head.val);

        map.put(head, copyNode);

        return copyNode;
    }

}