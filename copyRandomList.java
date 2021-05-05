// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class Solution {
    public Node copyRandomList(Node head) {
      if (head == null) return null;

      Map<Node, Node> map = new HashMap<Node, Node>();

      // loop 1. copy all the nodes
      Node node = head;
      while (node != null) {
        map.put(node, new Node(node.val));
        node = node.next;
      }

      // loop 2. assign next and random pointers
      node = head;
      while (node != null) {
        map.get(node).next = map.get(node.next);
        map.get(node).random = map.get(node.random);
        node = node.next;
      }

      return map.get(head);
    }
}
