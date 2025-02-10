// Copy List with random pointer
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
    //Time Complexity - > O(n)
    //Space Complexity -> O(1)
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        head = createCopy(curr);
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyHead= curr.next;
        Node copyCurr = copyHead;
        while(curr!=null){
            curr.next = curr.next.next;
            if(copyCurr.next!=null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
            
        }
        return copyHead;
        
    }

    private Node createCopy(Node curr){
       if(curr == null) return null;
       Node currHead = curr;
       while(curr!=null){
          Node copyCurr = new Node(curr.val);
          copyCurr.next = curr.next;
          curr.next = copyCurr;
          curr = curr.next.next;
       }

       return currHead;

    }

}