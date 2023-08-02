
// Definition for a Node.

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

// O(n) time O(n) space
// class Solution {
// public Node copyRandomList(Node head) {
// if (head == null)
// return null;
// HashMap<Node, Node> map = new HashMap<>();
// Node copyHead = new Node(head.val);
// map.put(head, copyHead);
// Node curr = head;
// Node cpcurr = copyHead;
// while (curr != null) {
// cpcurr.next = clone(curr.next, map);
// cpcurr.random = clone(curr.random, map);
// curr = curr.next;
// cpcurr = cpcurr.next;
// }
// return copyHead;
// }

// private Node clone(Node node, HashMap<Node, Node> map) {
// if (node == null)
// return null;
// if (!map.containsKey(node)) {
// Node newNode = new Node(node.val);
// map.put(node, newNode);
// }
// return map.get(node);
// }
// }

// O(n) time O(1) space
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        Node copyCurr = head.next;
        Node copyHead = head.next;
        while (curr != null) {
            if (curr.random != null) {
                copyCurr.random = curr.random.next;
            }
            curr = curr.next.next;
            if (copyCurr.next != null)
                copyCurr = copyCurr.next.next;
        }
        curr = head;
        copyCurr = head.next;
        while (curr != null) {
            curr.next = curr.next.next;
            if (copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}