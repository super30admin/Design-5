//approach - 1
//take a hashmap to store the mapping of the OG and copied nodes. 
//we will traverse through OG list and make next poiter connection accordingly into the copy list. 
// then we will traverse through the OG list again and then we will make random pointer conention to the Copy list. 
//tc - O(n)+O(n); sc  - hashmap = O(n)

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
    Map<Node,Node> map ;
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;
        
        map = new HashMap<>();
        
       
        Node curr = head;
        //add first node to start
        Node copyHead = new Node(curr.val);
        Node copyCurr = copyHead;
        map.put(curr, copyCurr);
        
        //check mapping and create and store node in Map; contains both next and random  pointer connection
        while(curr != null)
        {
            //check if that entry exist in map? if not create one and then update pointers
            Node copynext = getMapping(curr.next);
            
            if(copynext != null)
            {
                copyCurr.next = copynext;    
            }
            
            //for random pointer
            if(curr.random != null)
            {
              Node copyRandom = getMapping(curr.random);
                copyCurr.random = copyRandom;
            }
            //advance pointer           
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
        
        
    }
    private Node getMapping(Node currnext)
    {
        if(currnext == null) return null;
        
        //check if map contains it
        if(map.containsKey(currnext))
            return map.get(currnext);
        //we dont have in map
        Node newNode = new Node(currnext.val);
        map.put(currnext, newNode);
        return newNode;
    }
}






/*
approach 2
traverse through the OG list and see if curr pointer has a entry in Map, if not, we dont have copy of that node, so we will put an entry for that and will create a copy node
, now we will check the next pointer , and create its copy if not available, and same we will do with the random pointer. 
//TC - O(n) as we can do both of the connection in one pass
//sc - O(n) - we still need map for OG and copied node connection. 
*/

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
    Map<Node,Node> map ;
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;
       
        Node curr = head;
              
        //step-1 create a copy node adjacent to its original
        while(curr != null)
        {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            
            //advance the curr and copy curr
            curr = curr.next.next;
            
        }
        
        
        //step-2 connect random pointers
        curr = head;
        while(curr != null)
        {
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
       
        //step -3 extract the copy list out of OG
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = curr.next;
        
        while(curr != null)
        {
            curr.next = copyCurr.next;
            
            //advance curr
            curr = curr.next;
            
            if(curr == null) break;
            copyCurr.next = curr.next;
            
            //advance copyCurr
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
   
}