// Time Complexity :O(n) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {

  public Node copyRandomList(Node head) {
    if (head == null)
      return head;

    // create new node
    Node cur = head;
    while (cur != null) {
      Node temp = cur.next;
      cur.next = new Node(cur.val);
      cur.next.next = temp;
      cur = temp;
    }

    // create random links
    cur = head;
    while (cur != null) {
      if (cur.random != null) {
        cur.next.random = cur.random.next;
      }
      cur = cur.next.next;
    }

    // separate lists
    cur = head;
    Node newhead = cur.next;
    Node pnew = newhead;

    while (cur != null) {
      cur.next = cur.next.next;
      if (pnew.next != null) {
        pnew.next = pnew.next.next;
      }
      cur = cur.next;
      pnew = pnew.next;
    }
    return newhead;
  }

}