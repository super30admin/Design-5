//Time Complexity: O(N) where N is the number of nodes in the linkedlist
//Space Complexity: O(1)

//Successfully runs on leetcode: 0 ms

//Approach: In this algorithm, we are first creating a deep copy of each node and placing them next to the corresponding nodes.
//Then we separate the two lists - the original one and the deep copy one and return the head of the deep copy list.


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

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        while(curr != null)
        {
            Node currCopy = new Node(curr.val);
            currCopy.next = curr.next;
            curr.next = currCopy;
            curr = curr.next.next;
        }
        
        curr = head;
        while(curr != null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node copyHead = head.next;
        Node currCopy = head.next;
        
        while(curr != null)
        {
            curr.next = curr.next.next;
            if(currCopy.next != null)
            {
                currCopy.next = currCopy.next.next;
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
    }
}