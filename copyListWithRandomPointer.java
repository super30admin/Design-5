// Time Complexity - O(n)
// Space Complexity - 1 - O(n), 2 - O(1)


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

// 1. With hashmap
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head==null) return null;
//         Map<Node, Node> hashmap = new HashMap<>();
//         Node current = head;
//         while(current!=null){
//             hashmap.put(current, new Node(current.val));
//             current=current.next;
//         }
//         current=head;
//         while(current!=null){
//             hashmap.get(current).next = hashmap.get(current.next);
//             hashmap.get(current).random = hashmap.get(current.random);
//             current=current.next;
//         }
//         return hashmap.get(head);
//     }
// }

// 2. Without hashmap
class Solution {
  public Node copyRandomList(Node head) {
    if(head == null) return null;
    // 1. Create a copy of node and place the node next to the original node
    Node curr = head;
    while(curr != null) {
      Node newNode = new Node(curr.val);
      newNode.next = curr.next;
      curr.next = newNode;
      curr = curr.next.next;
    }
    // 2. Fill the random pointer of each copy
    curr = head;
    while(curr != null) {
      if(curr.random != null) {
        curr.next.random = curr.random.next;
      }
      curr = curr.next.next;
    }
    // 3. Fill the next pointer of each copy
    curr = head;
    Node temp = curr.next;
    Node copyHead = temp;
    while(curr != null) {
      curr.next = temp.next;
      if(temp.next == null) break;
      temp.next = curr.next.next;
      curr = curr.next;
      temp = temp.next;
    }
    return copyHead;
  }
}