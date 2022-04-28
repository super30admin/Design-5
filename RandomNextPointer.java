public class RandomNextPointer {
  /**
    Time Complexity: O(n)
    Space Complexity O(1)

    Were you able to solve this on leetcode? Yes
    */
    public Node copyRandomList(Node head) {
      if(head == null) { return null; }
      
      // create the copyNodes and put them right next to the original nodes.
      Node curr = head;
      while(curr != null) {
          Node temp = curr.next;
          Node copyCurr = new Node(curr.val);
          curr.next = copyCurr;
          copyCurr.next = temp;
          curr = temp;
      }
      
      // fill the random pointer on all the newly created copy nodes
      curr = head;
      
      while(curr != null) {
          Node randomPointer = curr.random;
          
          if(randomPointer != null) {
              Node copyCurr = curr.next;
              copyCurr.random = randomPointer.next;
          }
          
          curr = curr.next.next;
      }
      
      // break the linked list to isolate the new copy list
      curr = head;
      Node newHead = head.next;
      while(curr != null) {
          Node copyCurr = curr.next;
          curr.next = copyCurr.next;
          curr = curr.next;
          if(curr != null) copyCurr.next = curr.next;
      }
      
      return newHead;
  }
}
