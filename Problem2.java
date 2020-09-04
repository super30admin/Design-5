// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashMap;

// Your code here along with comments explaining your approach
// Approach 1: Using HashMap
// 1. We clone the element.
// 2. For every element we have mapping of cloned element.(Original -> Cloned)
// 3. Now for random pointer we update the reference to cloned from the HashMap.
// Time Complexity : O(2n) = O(n)
//      n: number of elements in the list
//    For 2 pass-> cloning, random
// Space Complexity :O(n)
//    For HashMap
class Problem2S1 {

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

    /** Copy the list */
    public Node copyRandomList(Node head) {
        
        // edge case
        if(head == null)
            return null;
        
        // create hashMap of original and cloned elements
        HashMap<Node, Node> myMap = new HashMap<>();
        // 1st pass -> clone all elements

        // pointers
        Node current = head;
        Node copyCurrent= null;
        while(current != null){

            // clone the element
            Node copyNode = cloneNode(current);
            // add to the map
            myMap.put(current, copyNode);
            // for 1st the cloned element
            if(copyCurrent == null){
                copyCurrent = copyNode;
            // update the next
            }else{
                copyCurrent.next = copyNode;
                copyCurrent = copyCurrent.next;
            }

            // move current
            current = current.next; 
        }
        
        // 2nd pass -> move random pointer to new clone elements
        current = myMap.get(head);
        // iterate cloned list
        while(current != null ){

            // check random not null
            if(current.random != null)
                // update to clone element 's reference
                current.random = myMap.get(current.random);
            // move current
            current = current.next;
        }
        
        // new Head
        return myMap.get(head);
    }
    
    /** Clones a Node clones and the random pointer */
    private Node cloneNode(Node current){

        // base casae
        if(current ==  null)
            return null;
        // create new node
        Node newNode =  new Node(current.val);
        // copy random pointer 's reference
        newNode.random = current.random;

        // return new node
        return newNode;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using Pointers
// 1. We clone the element and attach to original elements' next
// 2. Now for every cloned element, we move change random pointer's reference to cloned elemnet.
// 3. Now we split the into origin and clone list by updating their next.
// Time Complexity : O(3n) = O(n)
//      n: number of elements in the list
//    For 3 pass-> cloning, random, splitting
// Space Complexity :O(1)
//      As we are using only pointers
class Problem2S2 {

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

    /** Copy random list */
    public Node copyRandomList(Node head) {
        
        // edge case
        if(head == null)
            return null;
        
        // 1st pass -> clone all elements of linked list
        Node current = head;
        // iterate list
        while(current != null){

            // clone current
            Node copyNode = cloneNode(current);

            // attach cloned to current
            current.next = copyNode;
            // move to original list 's next
            current = current.next.next; 
        }
        
        // 2nd pass -> move random pointer to new clone element
        // Random's next is cloned node
        current = head;
        // iterate list
        while(current != null ){

            // check random not null
            if(current.random != null)
                current.next.random = current.random.next;
            // move to next
            current = current.next.next;
        }
        
        // 3rd pass -> split the list
        Node newHead = head.next; // cloned Head's reference
        Node copyCurrent = head.next; // pointer
        current = head; // pointer
        
        // reaching end of the list
        while(current != null){
            
            // getting original linked list
            current.next = copyCurrent.next;

            // check we have reached the end
            if(copyCurrent.next != null){

                // link cloned list 's next
                copyCurrent.next = copyCurrent.next.next;
                // move cloned 's current
                copyCurrent = copyCurrent.next;
            }

            // move original 's current
            current = current.next;
        }
        
        return newHead;
    }
    
    /** Clones a Node clones and the next pointer */
    private Node cloneNode(Node current){

        // edge case
        if(current ==  null)
            return null;
        // create a new node
        Node newNode =  new Node(current.val);
        // copy reference
        newNode.next = current.next;
        // return new Node
        return newNode;
    }
}