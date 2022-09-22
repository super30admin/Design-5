//ALGO 1:
//TC: O(n)
//SC: O(n)
//Leetcode : successful
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        this.map = new HashMap<>();
        Node copyHead = clone(head); //clonig the head of original to the copylist
        Node curr = head;            //
        Node copycurr = copyHead;    // current nodes starting from head nodes
        while(curr!=null){           // till the node is null, not *** curr.next!= null since we need to know the random of the last pointer also
            copycurr.next = clone(curr.next);
            copycurr.random = clone(curr.random);
            curr = curr.next;
            copycurr = copycurr.next;
        }
        return copyHead;
    }
    
    private Node clone(Node node){
        if(node == null)
            return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        return newNode;
    }
}


//BEST SOLN:

//TC: O(n)
//SC: O(1)

// Approach:
//step1: traverse through the actual list and make a newNode at each node with the current node values and join it to the current.next
//step2: traverse from the head of the combines list, find the random of the curr node to the add the random's next to the next node of current 
//step3: remove the added nodes by using the next.next
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        this.map = new HashMap<>();
         if (head == null) {
      return null;
    }
        Node curr = head;
        
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        
        curr = head;
    
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            else
                curr.next.random = null ;
            //curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }
        
    Node new_curr = head;
    Node copyhead = head.next;
    Node newHead = copyhead;
    while(new_curr!=null){
        new_curr.next = new_curr.next.next;
        if(copyhead.next!=null){
                copyhead.next = copyhead.next.next;
            }
            else
                copyhead.next = null ;
       // copyhead.next = (copyhead.next != null) ? copyhead.next.next : null;
        //copycurr.next = copycurr.next.next;
        new_curr = new_curr.next;
        copyhead = copyhead.next;
    }
    return newHead;
    
    }
}