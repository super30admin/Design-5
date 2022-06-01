
class Solution {

    //Time Complexity: 0(n) where n is the no. of nodes
    //Space complexity: 0(n)
    //Did it successfully run on leetcode:Yes
    //Did you face any problem while coding: No

    //In brief explain your code

    HashMap<Node, Node> map;    //I am declaring a hashmap to store the address of original node and the copy node
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        map = new HashMap<>();
        Node curr = head;   //creating a current pointer that will traverse through the linked list
        Node copyhead = clone(head);    //creating the copy node that will point to the head
        Node copycurr = copyhead;   //assigning the head of the copynode to the copycurrent
        while(curr != null){    //traversing the linked list to create new copy nodes as well as random pointers
            copycurr.next = clone(curr.next);   //making a copy of the nodes from original nodes
            copycurr.random = clone(curr.random);   //creating a copy of random nodes
            curr = curr.next;   //moving current pointer ahead
            copycurr = copycurr.next;   //moving copy's pointer ahead
        }

        return copyhead;    //returning the head of the copy node linked list
    }
    public Node clone(Node node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){  //if the  node is present that means copy node is already created, then returning the address of the copy node
            return map.get(node);
        }
        Node copynode = new Node(node.val); //if not, then creating a new copy node and storing the address of node and copy in hashmap
        map.put(node, copynode);
        return copynode;
    }
}

//Optimizing on space
class Solution {

    //Time Complexity: 0(n) where n is the no. of nodes
    //Space complexity: 0(1)
    //Did it successfully run on leetcode:Yes
    //Did you face any problem while coding: No

    //In brief explain your code

    public Node copyRandomList(Node head) {
        Node curr = head;
        //Creating deep copy
        while(curr != null){
            Node copynode = new Node(curr.val);
            copynode.next = curr.next;
            curr.next = copynode;
            curr = curr.next.next;
        }
        //Assigning random
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;

            }
            curr = curr.next.next;
        }
        //Braking deep copy and original into separate linked list
        curr = head;
        Node copyhead = head.next;
        Node copynode = curr.next;
        while(curr != null){
            curr.next = curr.next.next;
            if(copynode.next == null){
                break;
            }
            copynode.next = copynode.next.next;
            curr = curr.next;
            copynode = copynode.next;
        }
        return copyhead;
    }
}