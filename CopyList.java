// Efficient solution | Time: O(N) | Space: O(1)

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
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // first creating a clone and juxtaposing the cloned element next to original
        while(curr != null) {
            Node prev = curr;
            curr = curr.next;
            Node cloned = clone(prev);
            prev.next = cloned;
            cloned.next = curr;
        }
        curr = head;
        // establishing connection between cloned node and cloned random pointers wrt actual input node
        while(curr != null && curr.next != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node deepHead = curr.next;
        Node copyCurrent = curr.next;
        // extracting out the cloned nodes out of the LL
        // reverting the original connections on the input LL
        while(curr != null && curr.next != null) {

            curr.next = curr.next.next;
            curr = curr.next;
            if(curr != null) {
                copyCurrent.next = curr.next;
                copyCurrent = copyCurrent.next;
            }
        }

        return deepHead;
    }

    private Node clone(Node head) {
        Node newNode = new Node(head.val);
        return newNode;
    }
}


// Brute force | Graph based | Space : O(N)
class Solution {
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node curr = head;
        Node deepHead = clone(head);
        Node copyCurrent = deepHead;
        // making a key value pair between original and clone nodes
        // establishing connections accordingly
        while(curr != null) {
            Node randomNode = clone(curr.random);
            copyCurrent.random = randomNode;
            curr = curr.next;
            copyCurrent.next = clone(curr);
            copyCurrent = copyCurrent.next;
        }
        return deepHead;
    }

    private Node clone(Node head) {
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        return newNode;
    }
}