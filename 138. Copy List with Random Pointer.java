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

        Node node = head;
        Node copyHead = null;

        // Deep Copy
        while(node != null){
            Node n = new Node(node.val, node.next, node.random);
            if(copyHead == null) copyHead = n;
            node.next = n;
            node = n.next;
        }

        // Random copy
        node = head;
        while(node != null){
            node = node.next;
            node.random = node.random != null ? node.random.next : null;
            node = node.next;
        }

        // Seperate the lists
        node = head;
        while(node != null){
            Node copy = node.next;
            node.next = copy.next;
            copy.next = copy.next == null ? null : copy.next.next;
            node = node.next;
        }

        return copyHead;
        
    }
}
