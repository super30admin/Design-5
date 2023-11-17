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


// ******************** Modifying given linked list, without extra space ********************

// Time Complexity:  O(n)
// Space Complexity: O(1)


class Solution {

    Map<Node, Node> oldToNewNodes;
    
    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Node old = head;
        Node copy;
        
        while(old != null) {                         // adding new nodes in between
            copy = new Node(old.val);
            copy.next = old.next;
            old.next = copy;

            old = old.next.next;
        }

        old = head;

        while(old != null) {                         // setting up random pointers for new nodes
            if(old.random != null) 
                old.next.random = old.random.next;
            old = old.next.next;
        }

        old = head;
        copy = head.next;
        Node ans = copy;

        while(copy.next != null) {                   // removing unnecessary pointers and get two seperate lists

            old.next = old.next.next;
            copy.next = copy.next.next;

            old = old.next;
            copy = copy.next;
        }
        old.next = old.next.next;

        return ans;

    }

}











// // Time Complexity:  O(n)
// // Space Complexity: O(n)



// // ******************** Iterating once ********************

// class Solution {

//     Map<Node, Node> oldToNewNodes;
    
//     public Node copyRandomList(Node head) {
        
//         Node dummyHead = new Node(-1);
//         oldToNewNodes = new HashMap<>();            // creating map from old node to new node

//         Node curr = copy(head);
//         dummyHead.next = curr;
        
//         while(head != null) {

//             curr.next = copy(head.next);            // updating next pointer
//             curr.random = copy(head.random);        // updating random pointer

//             head = head.next;
//             curr = curr.next;
        
//         }

//         return dummyHead.next;

//     }

//     private Node copy(Node node) {
//         if(node == null) return null;
//         if(oldToNewNodes.containsKey(node)) {        // if mapping is already there
//             return oldToNewNodes.get(node);
//         }
//         Node newNode = new Node(node.val);           // if not, create new node
//         oldToNewNodes.put(node, newNode);            // and create mapping
//         return newNode;
//     }

// }







// // ******************** Iterating twice ********************

// class Solution {
    
//     public Node copyRandomList(Node head) {
        
//         Node dummyHead = new Node(-1);
//         Map<Node, Node> oldToNewNodes = new HashMap<>();        // creating map from old node to new node

//         Node old = head;
//         Node pointer = dummyHead;
        
//         while(old != null) {

//             Node copy = new Node(old.val);         
//             pointer.next = copy;                                // creating new linked list
            
//             oldToNewNodes.put(old, copy);                       // maintaining map

//             pointer = copy;

//             old = old.next;
        
//         }

//         old = head;
//         pointer = dummyHead.next;

//         while(old != null) {
            
//             pointer.random = oldToNewNodes.get(old.random);     // get random of old node and get mapping of it from map to get new random node

//             old = old.next;
//             pointer = pointer.next;

//         }
        
//         return dummyHead.next;

//     }

// }
