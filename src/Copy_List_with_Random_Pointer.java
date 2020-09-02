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

public class Copy_List_with_Random_Pointer {
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node temp = head;
		Node random;

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
