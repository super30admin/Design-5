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
//Optimized Solution
//Time Complexity - O(n)
//Space COmplexity - O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        while(curr != null){ // Step1 : Creating the deep copy and place them adjecent to the original node
            Node currCopy = new Node(curr.val);
            Node temp = curr.next;
            curr.next = currCopy;
            currCopy.next = temp; 
            curr = curr.next.next;
        }
        
        
        //Step2 : connecting the random pointer
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;    
            }
            curr = curr.next.next;
        }
        
        
        //Step3: Seperating the original and deep copy nodes
        curr = head;
        Node copyHead = curr.next;
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