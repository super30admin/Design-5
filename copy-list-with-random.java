//time complexity O(n)
//space complexity O(n)

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
        map = new HashMap<>();
        if(head == null) return null;
        Node curr = head;
        Node currCopy = clone(curr);
        while(curr != null){
            currCopy.random = clone(curr.random);
            currCopy.next = clone(curr.next);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return map.get(head);
    }
            private Node clone(Node original){
            if(original == null) return null;
            Node copy = map.get(original);
            if(copy == null){
                copy = new Node(original.val);
                map.put(original, copy);
            }
            return copy;
        }
}
