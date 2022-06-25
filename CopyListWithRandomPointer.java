//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr =head;
        
        // create duplicates and put them in between the orginal list
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr = curr.next.next;
        }
        //set random pointers
        
        curr=head;
        while(curr != null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr= curr.next.next;
        }
        //divide the list
        
        curr = head;
        Node copyCurr = curr.next;
        Node deepHead =copyCurr;
        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        
    return deepHead;    
    }
}
