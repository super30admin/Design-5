/* Time Complexity : O(n)
 *  n - size of the list */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 

/*
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
*/

//Two pass solution

class Solution {
    public Node copyRandomList(Node head) {
		if (head == null) return head;
        Node copyHead = new Node(head);
        //Map to hold the link between original and copied node
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, copyHead);
        Node curr = head;
        Node copyCurr = copyHead;
        //1st pass: Create copy of the nodes and link then using next pointer by traversing the original list and populate map
        while(curr.next != null){
            Node newNode = new Node(curr.next.val);
            copyCurr.next = newNode;
            curr = curr.next;
            copyCurr = copyCurr.next;
            map.put(curr, copyCurr);
        }
        //2nd pass: Traverse the original list and map the nodes using the random pointers with the help of map populated during 1st pass
        curr = head;
        copyCurr = copyHead;
        while(curr != null){
            if(curr.random != null){
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}