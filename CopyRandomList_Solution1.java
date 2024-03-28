package week9.day3;

import java.util.HashMap;

public class CopyRandomList_Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
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

class Solution1 {
 public Node copyRandomList(Node head) {
     if(head==null) return head;
     Node parent = head;
     Node copyHead = new Node(parent.val);
     Node child = copyHead;
     HashMap<Node, Node> map = new HashMap<>();
     map.put(parent, child);
     // creating nodes and next
     while (parent.next != null) {
         parent = parent.next; //13
         Node newNode = new Node(parent.val); //13
         copyHead.next = newNode; //7 ->13
         copyHead = copyHead.next;
         map.put(parent, copyHead); //13
         
     }
     // creating random ptr
     parent = head;
     while (parent != null) {
         if (parent.random != null) {
             Node parentRandom = parent.random; //7
             Node currNode = map.get(parent); //13
             Node newRandom = map.get(parentRandom); //7
             currNode.random = newRandom;
         }
         parent = parent.next;
     }
     return child;
 }
}