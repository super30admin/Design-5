// O(n) time complexity
// O(1) space complexity

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
        if (head == null) return null;
        
        
        // Creating a new weaved list of original and copied nodes
        Node ptr = head;
        
        while (ptr != null){
            // cloned node
            Node newNode = new Node(ptr.val);
            
            // inserting cloned node just next to original node
            // A->B becomes A->A'->B->>B
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        
        ptr = head;
        
        // Now link random pointers of new nodes created by iterating newly created list and use original nodes random pointers to assign references to random pointers for cloned nodes
        while (ptr != null){
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        // unweave linked list to get original linked list and cloned list
        Node ptrOldList = head;
        Node ptrNewList = head.next;
        Node headOld = head.next;
        while (ptrOldList != null){
            ptrOldList.next = ptrOldList.next.next;
            ptrNewList.next = (ptrNewList.next != null) ? ptrNewList.next.next : null;
            ptrOldList = ptrOldList.next;
            ptrNewList = ptrNewList.next;
        }
        
        return headOld;
    }
}