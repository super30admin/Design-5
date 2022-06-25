// Time Complexity :O(n) where n is no of elements in linked list
// Space Complexity :O(n) hashmap space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    private HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        // original head
        Node curr = head;
        // deepCopy head
        Node deepHead = clone(head);
        Node copyCurr = deepHead;
        // traversing to create deep copy
        while (curr != null) {
            copyCurr.next = clone(curr.next);
            if (curr.random != null)
                copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return deepHead;
    }

    // to create deepCopy
    public Node clone(Node node) {
        if (node == null)
            return null;
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            return newNode;
        }
        return map.get(node);
    }
}
// --------------WITHOUT HASHMAP-------------------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        // original head
        Node curr = head;
        // traversing to create deep copy
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;

        }
        curr = head;
        // traversing to create random pointers
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyCurr = head.next;
        Node deepHead = head.next;
        // to remove extra nodes
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        return deepHead;
    }

}