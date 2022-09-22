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
     HashMap<Node, Node> hm1= new HashMap<>();
     HashMap<Node,Node>  hm2=new HashMap<>();   
    
     Node p=head;
     Node p2=null;
        
     Node head2=p2;
     
        
           while(p!=null){
	           
	    Node n=new Node(p.val);
	             
               
	    if(head2==null){head2=n;  p2=n; }
	    else {  p2.next=n; p2=p2.next;}
	    hm1.put(p,n);
               
	    hm2.put(p,p.random);
	  
	    p=p.next;
	            
	        }
    
        p2=head2;
        p=head;
        
        while(p!=null){
        Node n1=hm1.get(p);
        Node n2=hm1.get(hm2.get(p));
         
           n1.random=n2;
           p2=p2.next;
            
            p=p.next;
        }
        return head2;
        
        
    }
}
