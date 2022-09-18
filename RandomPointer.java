//TC : O(n)
//SC : O(n)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
  
  HashMap<Node, Node> visited = new HashMap<Node, Node>();

  public Node getClonedNode(Node node) {
    
    if (node != null) {
      if (this.visited.containsKey(node)) {
          
        return this.visited.get(node);
          
      } else {
        
        this.visited.put(node, new Node(node.val, null, null));
        return this.visited.get(node);
          
      }
    }
    return null;
  }

  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    Node oldNode = head;

    Node newNode = new Node(oldNode.val);
    this.visited.put(oldNode, newNode);

    while (oldNode != null) {

      newNode.random = this.getClonedNode(oldNode.random);
      newNode.next = this.getClonedNode(oldNode.next);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return this.visited.get(head);
  }
}
