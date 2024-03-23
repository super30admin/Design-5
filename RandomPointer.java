// TC: O(n)
// SC: O(n) in 1st; O(1) in 2nd

// Approach: Make clone nodes and map them to original nodes while making
// the list. On second pass, connect the random pointers

import java.util.HashMap;
import java.util.Map;

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

class RandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cloneHead = new Node(head.val);
        map.put(head, cloneHead);

        Node temp = head.next;
        Node prev = cloneHead;

        while (temp != null) {
            Node cloneNode = new Node(temp.val);
            prev.next = cloneNode;
            prev = cloneNode;
            map.put(temp, cloneNode);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            Node cloneNode = map.get(temp);
            cloneNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return cloneHead;
    }

    public Node copyRandomListNoExtraMemory(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        Node cloneNode = null;

        // interlock the nodes
        while (temp != null) {
            cloneNode = new Node(temp.val);
            cloneNode.next = temp.next;
            temp.next = cloneNode;
            temp = cloneNode.next;
        }

        temp = head;
        cloneNode = head.next;
        // random pointers
        while (temp != null) {
            cloneNode.random = temp.random != null ? temp.random.next : null;
            temp = cloneNode.next;
            if (cloneNode.next != null) {
                cloneNode = cloneNode.next.next;
            }
        }

        Node cloneHead = head.next;
        temp = head;
        cloneNode = head.next;
        // revert the two lists
        while (temp != null) {
            temp.next = cloneNode.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            temp = temp.next;
            cloneNode = cloneNode.next;
        }

        return cloneHead;
    }
}