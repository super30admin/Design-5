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

// tc: O(N)
// sc: O(N)

class Solution {

  public Node copyRandomList(Node head) {
    //first pass -> create a new node without any link and add it to hashmap
    Node temp = head;
    HashMap<Node, Node> map = new HashMap<>();

    while (temp != null) {
      Node temp2 = new Node(temp.val);
      map.put(temp, temp2);
      temp = temp.next;
    }

    temp = head;

    while (temp != null) {
      Node temp2 = map.get(temp.next);
      Node temp3 = map.get(temp.random);
      Node curr = map.get(temp);

      curr.next = temp2;
      curr.random = temp3;
      temp = temp.next;
    }

    return map.get(head);
  }
}
