//HashMap - One Pass Solution
/// T.C : O(N), N -> No of elements in the list
// S.C : O(N)

import java.util.*;

public class CopyListwithRandomPointer {
        Map<Node, Node> copyMap;
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            copyMap = new HashMap<Node, Node>();

            Node cloneHead = clone(head);
            Node curr = head;
            Node currCopy = cloneHead;

            while (curr != null) {
                currCopy.next = clone(curr.next);
                currCopy.random = clone(curr.random);

                curr = curr.next;
                currCopy = currCopy.next;
            }

            return cloneHead;
        }

        private Node clone(Node node) {
            if (node == null) {
                return null;
            }

            if (copyMap.containsKey(node)) {
                return copyMap.get(node);
            }

            Node newNode = new Node(node.val);
            copyMap.put(node, newNode);
            return newNode;
        }
    }

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
