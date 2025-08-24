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
    
    // TC: O(n)
    // SC: O(1) without using a map
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }

        cur = head;

        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = cur.next;
        Node copyCur = copyHead;

        while (cur != null) {
            cur.next = copyCur.next;
            if (cur.next != null) {
                copyCur.next = cur.next.next;
            }
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return copyHead;
    }



    // TC: O(n)
    // SC: O(n)
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        
        Node copyHead = new Node(-1);
        Node copyCur = copyHead;

        Map<Node, Node> map = new HashMap<>();

        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            copyCur.next = newNode;
            cur = cur.next;
            copyCur = copyCur.next;
        }

        cur = head;
        copyCur = copyHead.next;

        while (cur != null) {
            if (cur.random != null) {
                copyCur.random = map.get(cur.random);
            }
            
            cur = cur.next;
            copyCur = copyCur.next;
        }
        
        return copyHead.next;        
        
    }
    
}