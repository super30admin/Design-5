class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        
        //1. add new nodes 
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        //2. make random pointers
        curr = head;
        while(curr!= null){
            if( curr.random != null){ 
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        //3. split 
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        while(curr != null){
            curr.next = curr.next.next; 
            if(copyCurr.next != null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;      
            }
        
        return copyHead;
    }
}
