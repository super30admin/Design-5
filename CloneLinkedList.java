// Time Complexity :
            /*          Approach 1: Use HashMap: O(n) where n is the number of nodes
                        Approach 2: Without storage: O(3n) = O(n) where n is the number of nodes (Three pass algo)
// Space Complexity : 
            /*          Approach 1: Use HashMap: O(n) where n is the number of cloned nodes maintained in the hashMap
                        Approach 2: Without storage: O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially, thought of keeping a map of the node and its random pointer node which is not feasible
/* Algorithm: In approach 1, maintain the original node and its copied node. The original node in the map will get you its equivalent cloned node
and hte pointers in the original node will help you to maintain the pointers in the cloned node as well since you are creating the map of original
nodes and its copy along with the pointer nodes and their copy in the map. You have the next and random node available whenever you want to create the
pointer to the equivalent node. In approahc 2 its a three pass algo, 1st pass => Create copies and maintain a relation between original node and copeid node
and in 2nd pass => Adjust the random pointers of the cloned nodes, 3rd pass => Restore the next pointers of original and the cloned linked list using 
the connections they have with each other.
*/

// APPROACH 1 : USE HASHMAP
class Solution {
    HashMap<Node, Node> store;
    public Node copyRandomList(Node head) {
        if(head == null){return null;}
        store = new HashMap<>();                                                                // Storing the node's clones
        Node temp = head;
        while(temp != null){
            Node curr = copyNode(temp);                                                     // Create a clone of node
            curr.random = copyNode(temp.random);                                    // Create a clone of the random node 
            curr.next = copyNode(temp.next);                                                    // Create a clone of the next node 
            temp = temp.next;
          }
        head = store.get(head);                                                                 // Get the head for the cloned linked list
        return head;
    }
    private Node copyNode(Node temp){
        Node new_node=null;
        if(temp != null && !store.containsKey(temp)){                                           // If the map doesnt contains the cloned node created
        new_node = new Node(temp.val);
        store.put(temp, new_node);                                                              // Create a new node and put it in the map
        } else {
            return store.get(temp);                                                     // Return the created cloned node
        }
        return new_node;                                                                    // return null 
    }
}

// APPROACH 2 : WITHOUT STORAGE
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){return null;}
        Node temp = head;                                                               // Curr will play role of cloned node, temp will be original node
        Node curr = null;
        while(temp != null){
            curr = new Node(temp.val);
            curr.next = temp.next;                                                              // Pass 1 : Connect the orginal and the cloned node with each other
            temp.next = curr;                                                                   
            temp = curr.next;                                                           // temp moving using the curr's (cloned node) next pointer to the temp's next (original next node of temp)
        }
        temp = head;
        curr = temp.next;
        while(temp != null){                                                                        // Pass 2 : Connect all the random pointers as it is
            if(temp.random != null) curr.random = temp.random.next;                             // Curr (cloned node) random will be random of the temp (original) node
            temp = curr.next;
            if(temp != null) curr = temp.next;                                                              // Move the curr to the next cloned node
        }
        temp = head;
        head = temp.next;                                                                               // Move the head to the cloned node head
        curr = head;
        while(temp != null){
            temp.next = curr.next;                                                          // Pass 3: Restore the next pointers for curr and temp
            temp = temp.next;
            if(temp != null) curr.next = temp.next;                                         // Using each other's connection
            curr = curr.next;
        }
        return head;
    }
}