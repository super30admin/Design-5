//Problem 112: Copy List with Random Pointer-Optimized
//TC: O(N)
//SC: O(1)

//Optimized: Without Using Extra Space
/*Steps: 
     1) Create a new node and attach it with the existing node
     2) Attach random pointers
     3) Removing older list
*/

class Solution112 {

    class Node{
        Node next,random;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        
        if(head==null) return head;
        
        //1) create a new node and attach it with the existing node
        Node curr = head;
        
        while(curr!=null){
            
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            
            curr = temp.next;
        }
        
        
        //Attach random pointers
        curr = head;
        Node deepCurr = head.next;
        
        while(curr!=null){
            
          if(curr.random!=null) {
              curr.next.random = curr.random.next;
           } 
              
          curr = curr.next.next;    
        }
        
        //Removing older list
        curr = head;
        Node resHead = deepCurr = head.next;
        
        while(curr!=null){
            
            curr.next = deepCurr.next;
             if(deepCurr.next!=null){
               deepCurr.next = deepCurr.next.next;     
             }
            
            curr = curr.next;
            deepCurr = deepCurr.next;
        }
        
        return resHead;
    }
}