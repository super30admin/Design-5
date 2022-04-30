//TC : O(3 * N) ===== O(N)
//SC : O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)    return null;

        //Create copy of node to next of node itself
        
        Node curr = head;
        while(curr != null){
            Node tempNode = new Node(curr.val);
            tempNode.next = curr.next;
            curr.next = tempNode;
            curr = curr.next.next;
            
        }
        
        
        //Set the random copies of deep copies of node
        curr = head;
        Node newHead = head.next; // Will return this node as head of Deepcopies of list
        Node tempHead = newHead;    
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        tempHead = newHead;
        //Split the list of deepcopies from curr list
        
        while(curr != null){
            curr.next = curr.next.next;
            if(tempHead.next != null)
                tempHead.next = tempHead.next.next;
            
            curr = curr.next;
            tempHead = tempHead.next;    
        }
        
        
        
        return newHead; 
    }
}



//TC : O(N)
//SC : O(N) -- To store one-to-one mapping of new copies of node

/*
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null)    return null;
        
        map = new HashMap<>();
        
        Node newHead = createCopy(head); //  Head of List of deep copies
        
        Node curr = head;
        Node newCurr = newHead;
        
        while(curr != null){
            newCurr.next = createCopy(curr.next); // Setting the next node of Deepcopy of list
            if(curr.random != null){
                newCurr.random = createCopy(curr.random); // Setting the random if it is there
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
    public Node createCopy(Node node){ 
        if(node == null)    return null;
        if(map.containsKey(node))   return map.get(node); // If node is in map 
        
        Node newNode = new Node(node.val); // Make new Node and put the pair in map AND return newNOde
        map.put(node, newNode);
        return newNode;
    }
}

*/