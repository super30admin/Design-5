/*
Time Complexity: O(N) traverse the given nodes in Linked list
Space Complexity: O(1) constant space as we are returning the reqd linnked list constructed.
*/
class Solution {
    // HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        //Base
        if(head == null){
            return null;
        }
        //Logic
        //1. Create a copy and joint next pointers
        Node curr = head;
        // Node copy = curr;
        while(curr!=null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next; 
        }    
        //2. Copy random pointers
        curr = head;
        Node copy = curr.next;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next; //***NOTE***
            }
            curr = curr.next.next;
            // copy = curr.next;
        }
        
        //3. De-link the linked lists formed
        //Re-set the copy pointer/head to curr.next
        curr = head;
        Node copyHead = curr.next;
        copy = curr.next;
        while(curr!=null){
            curr.next = curr.next.next;
            if(copy.next!=null){
                copy.next = copy.next.next;
            }
            curr = curr.next;
            copy = copy.next;
        }
        return copyHead;
    }
}
