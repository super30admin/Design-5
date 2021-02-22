import java.util.HashMap;
import com.util.customlist.*;

public class CopyListWithRandomPointer {
	// Time Complexity : O(n) 
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : yes
	// Any problem you faced while coding this : No
	// Your code here along with comments explaining your approach
	/*
	 * This is an approach which uses an extra space to create the new nodes of the deep copy created separately.
	 */
	HashMap<Node, Node> map;
    public Node copyRandomList1(Node head) {
        if(head == null) return head;
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node currCopy = copyHead;
        while(curr != null){
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }
    
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
    
    // Time Complexity : O(n) 
 	// Space Complexity : O(1)
 	// Did this code successfully run on Leetcode : yes
 	// Any problem you faced while coding this : No
 	// Your code here along with comments explaining your approach
 	/*
 	 * This is an approach which does not use any extra space as the deep copy will be created within the original list 
 	 * and the random pointers will be created again within the original list
 	 * and finally the original list will be split to get the deep copy list.
 	 */
    public Node copyRandomList2(Node head) {
        if(head == null) return head;
        //create deep copies and put them next to the original nodes
        Node curr = head;
        while(curr != null){
            Node currCopy = new Node(curr.val);
            currCopy.next = curr.next;
            curr.next = currCopy;
            curr = curr.next.next;
        }
        //create random pointers on the copy list
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //split the lists
        curr = head;
        Node copyHead = head.next;
        Node currCopy = head.next;
        while(curr != null){
            curr.next = curr.next.next;
            if(currCopy.next != null){
                currCopy.next = currCopy.next.next;
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }
    
}
