package Dec9;

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

class CopyListWithRandomPtrOptimized {
 
 /*
 Time complexity: O(n)
 Space complexity: O(1) because no extra space used.
 
 Approach: No extra space used, so O(1) space complexity.
 
 */

 public Node copyRandomList(Node head) {
    
     // edge
     if (head == null) {
         return null;
     }
     Node curr = head;
     // Step 1: Create deep copy nodes and put them adjacent to original nodes
     while (curr != null) {
         Node newCurr = new Node(curr.val);
         Node temp = curr.next;
         curr.next = newCurr;
         newCurr.next = temp;
         curr = curr.next.next; // = currCopy.next or temp
     }
     // Step 2: Create random pointers of deep copy nodes
     curr = head;
     while (curr != null) {
         if (curr.random != null) {
             curr.next.random = curr.random.next;
         }
         curr = curr.next.next;
     }
     // Step 3: Split the list into original and copied list
     curr = head; // current on original list
     Node copyHead = curr.next;
     Node currCopy = copyHead; // current on copy list
     while (curr != null) {
         curr.next = curr.next.next;
         if (currCopy.next != null) {
             currCopy.next = currCopy.next.next;
         }
         curr = curr.next;
         currCopy = currCopy.next;
     }
     
     return copyHead;
     
 }
 
}