/**
 * Uses a HashMap to map original nodes to their cloned counterparts in two passes.
 * First pass creates all nodes; second pass assigns next and random using the map.
 * Time: O(n) for two traversals, Space: O(n) for storing node mappings.
 */
class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node current = head;
        Map<Node, Node> hmap = new HashMap<>();

        // First pass: create clone nodes and store mapping (original -> clone)
        while (current != null) {
            Node n = new Node(current.val);
            hmap.put(current, n);
            current = current.next;
        }

        current = head;

        // Second pass: assign next and random pointers using the map
        while (current != null) {
            Node newN = hmap.get(current);

            // Key idea: map.get(null) safely returns null → handles tail and null random
            newN.next = hmap.get(current.next);
            newN.random = hmap.get(current.random);

            current = current.next;
        }

        // Edge case: if head is null, map.get(null) returns null → correct behavior
        return hmap.get(head);
    }
}