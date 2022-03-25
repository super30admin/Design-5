//Tc: o(n)
//Space :o(1)

class Solution {
   
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //o(1) space Solution
        Node curr = head;
        while( curr != null){
            Node CopyNode = new Node(curr.val);
            CopyNode.next = curr.next;
            curr.next = CopyNode;
            curr = curr.next.next;
        }
        
        curr= head;
        while(curr != null){
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
                
            }
            curr = curr.next.next;
            
        }
        //split
        curr = head;
        Node CopyHead = head.next;
        Node CopyCurr = CopyHead;
        while(curr != null){  
            
            curr.next = curr.next.next;
            if(CopyCurr.next != null){
                CopyCurr.next = CopyCurr.next.next;
            }
            
            curr = curr.next;
            CopyCurr = CopyCurr.next;      
        }   
        
        return CopyHead;
    }}
