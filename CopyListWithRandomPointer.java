package design5;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
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
	
	//Time Complexity : O(n)
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        // Create deep copy and point to next
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        // Create random pointers
        curr = head;
        while(curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        // Split the copy from original
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;
        while(curr != null) {
            curr.next = curr.next.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
        return copyHead;
    }
	
	//Single pass algorithm
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	Map<Node, Node> map1;
    public Node copyRandomList1(Node head) {
        if(head == null)
            return head;
        map1 = new HashMap<>();
        Node copyHeadPtr = clone1(head);
        Node copyHead = copyHeadPtr;
        Node curr = head;
        while(curr != null) {
            copyHead.next = clone1(curr.next);
            copyHead.random = clone1(curr.random);
            curr = curr.next;
            copyHead = copyHead.next;
        }
        
        return copyHeadPtr;
    }
    
    private Node clone1(Node node) {
        if(node == null)
            return null;
        if(map1.containsKey(node))
            return map1.get(node);
        Node copyNode = new Node(node.val);
        map1.put(node, copyNode);
        return copyNode;
    }
	
	//2 pass algorithm
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	Map<Node, Node> map2;
    public Node copyRandomList2(Node head) {
        if(head == null)
            return head;
        map2 = new HashMap<>();
        Node copyHeadPtr = clone2(head);
        Node copyHead = copyHeadPtr;
        Node curr = head;
        curr = curr.next;
        while(curr != null) {
            copyHead.next = clone2(curr);
            copyHead = copyHead.next;
            curr = curr.next;
        }
        
        copyHead = copyHeadPtr;
        curr = head;
        while(curr != null) {
            if(curr.random != null)
                copyHead.random = map2.get(curr.random);
            curr = curr.next;
            copyHead = copyHead.next;
        }
        
        return copyHeadPtr;
    }
    
    private Node clone2(Node node) {
        if(map2.containsKey(node))
            return map2.get(node);
        Node copyNode = new Node(node.val);
        map2.put(node, copyNode);
        return copyNode;
    }
}
