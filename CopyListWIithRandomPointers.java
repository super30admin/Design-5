//Time complexity : O(n)
//Space Complexity :O(1)
/*Approach
-creating copy nodes adjacent to the original nodes and linking them in the original list itself.
-going again through the list to connect random pointers
-separating them into original list and copied list
 */
public class CopyListWIithRandomPointers {
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
    
    public Node copyRandomList(Node head) {
        if(head ==  null)return null;
         Node curr = head;
         while(curr != null){
             Node newNode = new Node(curr.val);
             newNode.next = curr.next;
             curr.next = newNode;
             curr= curr.next.next;
         }
         // for random pointers
         curr = head;
         while(curr != null){
             if(curr.random != null){
                 curr.next.random = curr.random.next;
             }
             curr = curr.next.next;
         }
         
         curr = head;
         Node copyHead = curr.next;
         Node currCopy = copyHead;
         while(currCopy.next != null){
             curr.next = currCopy.next;
             currCopy.next = currCopy.next.next;
             curr = curr.next;
             currCopy = currCopy.next;
         }
         curr.next = null;
         return copyHead;
     }  
}
