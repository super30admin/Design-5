// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class CopyListWithRandom {
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
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        //make deep copy and put them next to original
        
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        //create Random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //separate the original and deep copy
        
        curr = head;
        Node copyCurr = head.next;
        Node deepHead = copyCurr;
        while(curr != null){
            curr.next = curr.next.next;
            curr = curr.next;
            if(curr != null){
                copyCurr.next = copyCurr.next.next;
                copyCurr = copyCurr.next;
            }
            else{
                copyCurr.next = null;
            }
            
        }
        return deepHead;
    }
}
