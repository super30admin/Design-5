// TC: O(n)
// SC: O(n)

class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        //2 pointers on original & copy
        Node curr = head;
        Node currCopy = clone(head);
        //iterate
        while(curr != null) {
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            //move
            currCopy = currCopy.next;
            curr = curr.next;
        }
        return map.get(head);
    }
    private Node clone(Node p) {
        if(p == null) {
            return null;
        }
        if(map.containsKey(p)) {
            return map.get(p);
        }
        Node newNode = new Node(p.val);
        map.put(p, newNode);
        return newNode;
    }
}