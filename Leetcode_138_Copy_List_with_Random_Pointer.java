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
/*Brute -force
TC: O(n)
sc: O(n)*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        Map<Node, Node> map = new HashMap<>();

        // just create a copy and put mapping in Map
        while (curr != null) {
            if (!map.containsKey(curr)) {
                Node newNode = new Node(curr.val);
                map.put(curr, newNode);
            }
            curr = curr.next;
        }

        // create connection with Next Pointers
        curr = head;
        Node copyCurr = map.get(head);

        while (curr != null && curr.next != null) {
            copyCurr.next = map.get(curr.next);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        // create connection with Random Pointer

        curr = head;
        copyCurr = map.get(head);

        while (curr != null) {
            if (curr.random != null) {
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return map.get(head);
    }
}

/*
 * Brute -force
 * TC: O(n) -1 pass
 * sc: O(n)
 */

class Solution {
    Map<Node, Node> map;

    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;
        map = new HashMap<>();
        Node newCurr = new Node(curr.val);
        map.put(curr, newCurr);

        // just create a copy and put mapping in Map
        while (curr != null) {
            newCurr.next = clone(curr.next);
            newCurr.random = clone(curr.random);

            curr = curr.next;
            newCurr = newCurr.next;
        }

        return map.get(head);
    }

    private Node clone(Node node) {
        if (node == null)
            return null;

        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}

/*
 * TC: O(n) -3 pass
 * sc: O(1)
 * 3 steps
 * 1. create copy, and assign curr.next to copycurr
 * 2. second pass to assign random pointers
 * 3. deatch both linkedlist and return copied list!
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        Node curr = head;

        // assigning curr.next to copy || 1-> 1' -> 2 -> 2'
        while (curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }

        curr = head;
        Node copy = curr.next;

        // connecting Random pointers!
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;

            if (curr.next != null)
                curr = curr.next.next;
        }

        // seprate both the list 1->2->3 ; 1' -> 2' -> 3'; appropriate assignment of
        // Next pointer!
        curr = head;
        Node copyHead = head.next;
        copy = head.next;
        while (curr != null && curr.next != null) {
            curr.next = curr.next.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
            copy = copy.next;

        }

        return copyHead;
    }
}