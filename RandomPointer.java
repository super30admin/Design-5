 // Time - O(n) where n is the length of Linked List
 // Space - O(n) 

import java.util.*;

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


public class RandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node tempHead = head;
        while (tempHead != null){
            map.put(tempHead, new Node(tempHead.val));
            tempHead = tempHead.next;
        }

       Node tempHead1 = head;
        while (tempHead1 != null){
            Node node = map.get(tempHead1);
            node.random = map.get(tempHead1.random);
            node.next = map.get(tempHead1.next);
            tempHead1 = tempHead1.next;
        }
        return map.get(head);
    }
}