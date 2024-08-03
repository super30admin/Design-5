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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        // With using extra Space
        // map = new HashMap<>();
        // Node copyHead = clone(head);
        // Node curr = head;
        // Node copyCurr = copyHead;
        // while(curr != null) {
        //     Node copyNode = clone(curr.next);
        //     copyCurr.next = copyNode;
        //     Node copyRandom = clone(curr.random);
        //     copyCurr.random = copyRandom;
        //     curr = curr.next;
        //     copyCurr = copyCurr.next;
        // }
        // return copyHead;

        // Without using extra Space
        // 1. Create a copy of the node and place the copy next to the original node
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // 2. Fill the random pointer of each copy
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // 3. Break the linked list into 2 lists
        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;
        while(curr != null) {
            curr.next = copyCurr.next;
            if(copyCurr.next == null) {
                break;
            }
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    private Node clone(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}
