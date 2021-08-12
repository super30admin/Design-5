// Time Complexity : O(n)
// Space Complexity : O(n)


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
        if(head == null)
            return head;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        Node newCur = cloneNode(head, map);
        Node newHead = newCur;
        while(cur != null){
            newCur.next = cloneNode(cur.next, map);
            newCur.random = cloneNode(cur.random, map);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
    
    private Node cloneNode(Node node, Map<Node, Node> map){
        if(node == null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}