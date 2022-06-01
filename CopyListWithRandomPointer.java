// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: recursive with hashmap

public class CopyListWithRandomPointer {
    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        if (visited.containsKey(head)) {
            return visited.get(head);
        }
        Node node = new Node(head.val, null, null);
        visited.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}
