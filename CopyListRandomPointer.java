import java.util.HashMap;

// Time Complexity: O(n) where n is the number of nodes in the linked list.
// Space Complexity: O(n) for the HashMap to store the cloned nodes.

// Intuition: The algorithm uses a HashMap to map original nodes to their cloned counterparts. 
// We iterate through the original linked list, to create a deep copy of the list.
// For each node, we create a new node with the same value and set its next and random pointers using the HashMap.
// This ensures that the new list maintains the same structure as the original list, including the random pointers.
// The getClonedNode method checks if a node has already been cloned and returns the cloned node from the HashMap, 
// or creates a new one if it doesn't exist.
// The copyRandomList method initializes the process by creating the head of the new list and 
// iterating through the original list to populate the next and random pointers of the cloned nodes.

public class CopyListRandomPointer {
    HashMap<Node, Node> clonedMap = new HashMap();

    public Node getClonedNode(Node node) {
        if (node != null) {
            clonedMap.computeIfAbsent(node, n -> new Node(node.val));
            return clonedMap.get(node);
        }
        return null;
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node oldNode = head;
        Node copyList = new Node(head.val);
        clonedMap.put(oldNode, copyList);

        while (oldNode != null) {
            copyList.next = getClonedNode(oldNode.next);
            copyList.random = getClonedNode(oldNode.random);

            oldNode = oldNode.next;
            copyList = copyList.next;
            clonedMap.put(oldNode, copyList);

        }
        return clonedMap.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
