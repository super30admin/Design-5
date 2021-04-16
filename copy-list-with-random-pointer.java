// Time Complexity :
O(3 * length of linked list ) ==> asmptotically o(length of linked list) where m and n are lengths of the two arrays
// Space Complexity :
o(1)
// Did this code successfully run on Leetcode :
yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach


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
          Node p = head; 
          Node front = head;

          // First round: make copy of each node,
          // and link them together side-by-side in a single list.
          while (p != null) {
            front = p.next;

            Node copy = new Node(p.val);
            p.next = copy;
            copy.next = front;

            p = front;
          }

          // Second round: assign random pointers for the copy nodes.
          p = head;
          while (p != null) {
            if (p.random != null) {
              p.next.random = p.random.next;
            }
            p = p.next.next;
          }

          // Third round: restore the original list, and extract the copy list.
          p = head;
          Node prev = new Node(0);
          Node copy = prev;

          while (p != null) {
            front = p.next.next;

            // extract the copy
            copy.next = p.next;
            copy = copy.next;

            // restore the original list
            p.next = front;

            p = front;
          }

          return prev.next;  
    }
}