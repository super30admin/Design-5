/*
 * TC: O(N)
 * SC: O(N)
 */
import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointers {
    // Definition for a Node.
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // map to store the visited nodes
    Map<Node, Node> visited = new HashMap<>();

    /**
     * Clones the given node if it is not already cloned,
     * stores the cloned node in the visited map,
     * and returns the cloned node.
     */
    Node getClonedNode(Node node) {
        visited.putIfAbsent(node, (node == null ? null : new Node(node.val)));
        return visited.get(node);
    }

    public Node copyRandomList(Node head) {
        Node copyHead = getClonedNode(head);
        Node ptr = head;
        Node copyPtr = copyHead;
        while (ptr != null) {
            // copy the next node
            copyPtr.next = getClonedNode(ptr.next);
            // copy the random node
            copyPtr.random = getClonedNode(ptr.random);
            // move to the next node in the original list
            ptr = ptr.next;
            // move to the next node in the copied list
            copyPtr = copyPtr.next;
        }
        return copyHead;
    }
}
