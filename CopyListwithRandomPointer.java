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

// 1st Approach
// TC: O(n) all the nodes are traversed
// SC: O(n) as new LinkedList is created.

// 2nd Approach
// TC: O(n) all the nodes are traversed
// SC: O(1) as the existing LinkedList are modified to store the clones
public class CopyListwithRandomPointer {
    static Map<Node, Node> map;

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        print(copyRandomListFirstApproach(node)); // 1->2->3->4->5->
        print(copyRandomListSecondApproach(node)); // 1->2->3->4->5->
    }

    // Using the O(n) space complexity approach
    public static Node copyRandomListFirstApproach(Node head) {
        if (head == null)
            return null;
        map = new HashMap<>();
        Node curr = head;
        Node copyHead = clone(head);
        Node currCopy = copyHead;
        while (curr != null) {
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }

    // Clone method is a utility method for cloning
    private static Node clone(Node node) {
        if (node == null)
            return null;
        if (!map.isEmpty() && map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }

    // Using the O(1) space complexity approach
    public static Node copyRandomListSecondApproach(Node head) {
        if (head == null)
            return null;
        // 1 Create clones and assign pointers
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }
        // 2 random pointers management
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // 3 deallocate pointers
        curr = head;
        Node copyHead = curr.next;
        Node currCopy = copyHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (currCopy.next == null)
                break;
            currCopy.next = currCopy.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }

    private static void print(Node node) {
        if (node == null)
            return;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
}