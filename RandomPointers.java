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

//Time - O(n)
//Space - O(1)
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head ==null){
            return null;
        }
        Node curr = head;
        while(curr!= null){
            Node cpNode = new Node(curr.val);
            cpNode.next = curr.next;
            curr.next = cpNode;
            curr = curr.next.next;
        }
        
        curr = head;
        Node cpCurr = head.next;
        while(curr!=null){
            if(curr.random!=null){
              curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        Node returnVal= head.next;
        curr = head;
        cpCurr = head.next;
        while(curr!=null){
            curr.next = curr.next.next;
            if(cpCurr.next!=null){
                 cpCurr.next = cpCurr.next.next;
            }
            curr = curr.next;
            cpCurr =cpCurr.next;
        }
        return returnVal;
        
    }
}