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

//Approach - use a map to store the node and a new copy of that node
//this map will help to avoid creating more objects of the same node

//Time Complexity - O(N) - N is the number of nodes
//Space Complexity - O(N)
class Solution {
  HashMap<Node, Node> map = new HashMap<>();

  public Node copyRandomList(Node head) {
    if(head == null){
      return head;
    }

    Node copyHead = clone(head);
    Node curr = head;
    Node currCopy = copyHead;


    while(curr != null){
      currCopy.next = clone(curr.next);
      currCopy.random = clone(curr.random);

      curr = curr.next;
      currCopy = currCopy.next;
    }
    return copyHead;
  }

  private Node clone(Node node){
    if(node == null){
      return node;
    }
    if(map.containsKey(node)){
      return map.get(node);
    }

    Node newNode = new Node(node.val);
    map.put(node, newNode);
    return newNode;
  }
}
