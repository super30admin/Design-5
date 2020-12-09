package Dec9;

import java.util.HashMap;
import java.util.Map;

/*
//Definition for a Node.
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

class CopyListWithRandomPtr {
 
 /*
 Time complexity: O(n)
 Space complexity: O(n) because we are using extra space of hashmap of n entries
 
 Approach: Brute force
 
 */
 
 // original node, copy node
 Map<Node, Node> hm;
 
 public Node copyRandomList(Node head) {
     // edge
     if (head == null) {
         return null;
     }
     hm = new HashMap<>();
     
    // Node copyHead = new Node(head.val);
    // hm.put(head, copyHead);
     Node copyHead = clone(head);
     
     Node currCopy = copyHead;
     
     Node curr = head; // pointer for iterating on main list
     while (curr != null) {
         currCopy.next = clone(curr.next);
         currCopy.random = clone(curr.random);
         curr = curr.next;
         currCopy = currCopy.next;
     }
     return copyHead;
 }
 
 private Node clone(Node node) {
    // edge
     if (node == null) {
         return null;
     }
     
     if (hm.containsKey(node)) {
         return hm.get(node);
     }
     Node newNode = new Node(node.val);
     hm.put(node, newNode);
     return newNode;
 }
 
}