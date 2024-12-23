import java.util.HashMap;

//Time Complexity: O(n)
//Space Complexity: O(n)
public class problem2 {
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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        this.map = new HashMap<>();
        if (head == null) return null;
        Node cur = head; Node copyCurr= clone(head);
        while (cur != null) {
             copyCurr.next = clone(cur.next);
             copyCurr.random = clone(cur.random);
             cur = cur.next;
             copyCurr= copyCurr.next;
        }
        return map.get(head);
    }
    private Node clone(Node node)
    {
        if (node == null) return null;
        if (!map.containsKey(node))
        {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}
