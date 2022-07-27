//Time complexity: O(N)
//Space complexity: O(N)

/*
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
*/

class Solution {
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        map = new HashMap<>();
        Node copy = clone(head);
        Node curr = head;
        Node currCopy = copy;
        while(curr != null) {
            //handle the next pointer
            currCopy.next = clone(curr.next);
            //handle the random pointer
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copy;
    }

    private Node clone(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}