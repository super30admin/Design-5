// TC => O(n)
// SC => O(n)

/*
// Definition for a Node.
public class Node {
    public int val;
    public Node next;
    public Node random;
    
    public Node(int _val) {
        val = _val;
        next = null;
        random = null;
    }
}
*/

public class Solution
{
    Dictionary<Node, Node> lookup = new Dictionary<Node, Node>();
    public Node CopyRandomList(Node head)
    {
        if (head == null)
        {
            return head;
        }

        Node current = head;
        Node dummyNode = new Node(-1);
        Node currentCopy = GetClone(current);
        dummyNode.next = currentCopy;

        while (current != null)
        {
            currentCopy.next = GetClone(current.next);
            currentCopy.random = GetClone(current.random);

            current = current.next;
            currentCopy = currentCopy.next;
        }

        return dummyNode.next;
    }

    public Node GetClone(Node head)
    {
        if (head == null)
        {
            return head;
        }

        if (lookup.ContainsKey(head))
        {
            return lookup[head];
        }

        var node = new Node(head.val);
        lookup.Add(head, node);

        return node;
    }
}