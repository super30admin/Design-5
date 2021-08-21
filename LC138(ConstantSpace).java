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
        
        //base case 
        if(head == null) {
            return null;
        }
        
        //deep copy at every node
        Node curr = head;
        while(curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        
        //set random pointers of every node
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
               curr.next.random = curr.random.next; 
            }
            curr = curr.next.next;
        }
        
        //splitting the original and cloned nodes
        curr = head;
        Node copyHead = head.next;
        Node copyNode = copyHead;
        
        while(curr != null) {
            curr.next = curr.next.next;
            if(copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }
            curr = curr.next;
            copyNode = copyNode.next;
        }
        
        
        return copyHead;
    }
}

//Time : O(n)
//Space : O(1)