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
    //tc - o(n)
    //sc-o(n)
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        Node copyHead = Clone(head);
        Node copycurr = copyHead;
        while(curr != null)
        {
           copycurr.next = Clone(curr.next);
           copycurr.random = Clone(curr.random);

           curr = curr.next;
           copycurr = copycurr.next;
        }
        
        return copyHead;

    }
    private Node Clone(Node node)
    {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}