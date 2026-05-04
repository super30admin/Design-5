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

// O(n) time, O(n) space
// class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null) return null;

//         Map<Node, Node> map = new HashMap<>();

//         Node curr = head;
//         Node copyCurr = new Node(curr.val);
        
//         map.put(curr, copyCurr);

//         while (curr.next != null) {
//             copyCurr.next = new Node(curr.next.val);
//             map.put(curr.next, copyCurr.next);

//             curr = curr.next;
//             copyCurr = copyCurr.next;
//         }

//         // random pointer connections
//         curr = head;
//         copyCurr = map.get(curr);
        
//         while (curr != null) {
//             if (curr.random != null) {
//                 copyCurr.random = map.get(curr.random);
//             }

//             curr = curr.next;
//             copyCurr = copyCurr.next;
//         }

//         return map.get(head);
//     }
// }

// O(n) time, O(1) space
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        
        while (curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next; // place copyCurr next to curr
            curr.next = copyCurr;

            curr = curr.next.next;
        }

        curr = head;
        Node copyCurr = curr.next;

        while (curr != null) { // random pointers
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;
        copyCurr = curr.next;
        Node copyHead = copyCurr;

        while (curr != null) { // separate list from deep copy
            curr.next = curr.next.next;
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }

            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
}