import java.util.HashMap;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node currCopy = new Node(head.val);
        map.put(curr, currCopy);

        while (curr.next != null) {
            Node newNode = new Node(curr.next.val);
            currCopy.next = newNode;
            map.put(curr.next, newNode);
            curr = curr.next;
            currCopy = currCopy.next;
        }

        curr = head;
        currCopy = map.get(curr);

        while (curr != null) {
            if (curr.random != null) {
                Node randomP = curr.random;
                currCopy.random = map.get(randomP);
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return map.get(head);
    }
}

//TC: O(2n), SC: O(n)

//Approach - 2
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
        if (head == null)
            return null;

        this.map = new HashMap<>();

        Node curr = head;
        Node newCopy = clone(curr);

        while (curr != null) {
            newCopy.next = clone(curr.next);
            newCopy.random = clone(curr.random);

            curr = curr.next;
            newCopy = newCopy.next;
        }

        return map.get(head);
    }

    private Node clone(Node curr) {
        if (curr == null)
            return null;
        if (map.containsKey(curr))
            return map.get(curr);
        map.put(curr, new Node(curr.val));
        return  map.get(curr);
    }
}

//TC: O(n), SC: O(n)