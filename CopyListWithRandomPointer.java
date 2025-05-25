// Time Complexity : O(n) n = no of nodes
// Space Complexity : O(n), for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Start at the root node and traverse down the tree.
//   - If both p and q values are less than root, LCA lies in the left subtree.
//   - If both p and q values are greater than root, LCA lies in the right subtree.
//   - If p and q are on opposite sides (or one equals the root), then the current root is the LCA.

import  java.util.*;

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

public class CopyListWithRandomPointer {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        this.map = new HashMap<>();

        Node curr = head;
        Node copyCurr = new Node(curr.val);
        map.put(curr, copyCurr);

        while(curr.next != null) {
            Node newNode = new Node(curr.next.val);
            copyCurr.next = newNode;
            map.put(curr.next, newNode);

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        curr = head;
        copyCurr = map.get(curr);

        while(curr != null) {
            if(curr.random != null) {
                copyCurr.random = map.get(curr.random);
            }

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyListWithRandomPointer solver = new CopyListWithRandomPointer();
        Node copiedHead = solver.copyRandomList(node1);

        System.out.println("Original and copied list values:");
        Node curr = node1;
        Node copy = copiedHead;
        while (curr != null && copy != null) {
            System.out.println("Original: " + curr.val + ", Random: " + (curr.random != null ? curr.random.val : "null"));
            System.out.println("Copy:    " + copy.val + ", Random: " + (copy.random != null ? copy.random.val : "null"));
            curr = curr.next;
            copy = copy.next;
            System.out.println("---");
        }
    }
}
