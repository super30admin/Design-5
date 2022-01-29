// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We use a hashmap to solve this
// We make use of Hashmap for cloning purpose
// we got through the list and create a clone

class Solution {
    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;
        while (curr != null) {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;

    }

    private Node clone(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We first create a large list that clones adjacent to the orginal nodes
// then we assign random pointers
// then we detach the clone from the original
class Solution {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;

        while (curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        curr = head;

        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;

        }
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next == null)
                break;
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;

    }

}