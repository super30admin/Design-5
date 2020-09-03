import java.util.*;
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
/*************************************Using HashMap*********************************/
//Time Complexity :O(n), number of nodes
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

/**Using HashMap, we keep the original node as key and the copy as value
 * Iterate through the original, while creating a copy for its next node and random node
 * Every time we check if it is present in the hashmap before copying
 * We return map(head) to get the head of the copy.
 * **/
public class Copy_List_with_Random_Pointer {
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node temp = head;

		while(temp != null){
			Node cloneNode = new Node(temp.val);    //cloning the data initially from original list
			map.put(temp, cloneNode);   //inserting the original and cloned node in map
			temp = temp.next;   //moving temp to next
		}

		temp = head;

		while(temp != null){
			Node curr = map.get(temp);  // get the curr node from map
			curr.next = map.get(temp.next);     //pointing original node.next to curr.next

			curr.random = map.get(temp.random);  //pointing original node.random to curr.random

			temp = temp.next;

		}
		return map.get(head);
	}
}

/*************************************Without Extra Space*********************************/
//Time Complexity :O(n), number of nodes
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

class Copy_List_with_Random_Pointer_3Pass {
	public Node copyRandomList(Node head) {
		if(head == null)
			return null;
		//first pass to make copies and store it next to each other
		Node curr = head;

		while(curr != null){
			Node temp = curr.next;
			Node copyCurr = new Node(curr.val);
			curr.next = copyCurr;
			copyCurr.next = temp;  
			curr = copyCurr.next;
		}
		//second pass to populate the random pointer of copy list
		curr = head;
		while(curr != null){
			if(curr.random != null){
				curr.next.random = curr.random.next;   
			}
			curr = curr.next.next;
		}
		// third pass to split the lists
		curr = head;
		Node copyHead = head.next;
		Node currCopy = copyHead;
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