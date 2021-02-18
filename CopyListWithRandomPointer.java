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

// Recursive Solution
// Time Complexity: O(n)
// Space Complexity with recursive stack: O(N)
class Solution {
 HashMap<Node, Node> map = new HashMap<>();

 public Node copyRandomList(Node head) {
     if(head == null) {
         return null;
     }

     if(map.containsKey(head)) {
         return map.get(head);
     }

     Node node = new Node(head.val);
     map.put(head, node);

     node.next = copyRandomList(head.next);
     node.random = copyRandomList(head.random);

     return node;
 }
}