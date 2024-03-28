package week9.day3;

public class CopyRandomList_Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
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
//TC - O(n)
//SC - O(1)
class Solution26 {
 public Node copyRandomList(Node head) {
     if (head == null)
      return head;
     Node parent = head;
     //1. Create deep copy of parent node and store the newNode next to it
     while(parent!=null){
         Node child = new Node(parent.val);
         child.next = parent.next;
         parent.next = child;
         parent = parent.next.next;
     }
     // 2. Make copy of random pointers from parent to child
     parent = head;
     Node child = parent.next;
     while(parent!=null){
         if(parent.random!=null)
             child.random = parent.random.next;
         parent = parent.next.next;
         if(child.next!=null)  //edge case
             child = child.next.next;
     }
     // 3. Detangle parent and child
     parent = head;
     child = parent.next;
     Node childHead = parent.next;
     while(parent!=null){
         parent.next = parent.next.next;
         if(child.next!=null)  //edge case
             child.next = child.next.next;
         parent = parent.next;
         child = child.next;
     }
     return childHead;
 }
}