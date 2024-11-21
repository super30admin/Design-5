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
//brute force, traverse first for deep copy linked list, traverse second to deep copy random nodes, use hashmap for 
//to keep track of deepcopy nodes tc- O(2n), sc- O(n)
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head == null) return null;
//         HashMap<Node, Node> map = new HashMap<>();

//         Node curr = head;
//         Node copyHead = new Node(head.val);//creating deep copy of head
//         Node copyCurr = copyHead;

//         map.put(head, copyHead);//storing first nodes in map

//         while(curr.next != null){//making deep copy of linkedlist
//             copyCurr.next = new Node(curr.next.val);
//             map.put(curr.next, copyCurr.next);
//             curr = curr.next;
//             copyCurr = copyCurr.next;

//         }

//         copyCurr = copyHead; curr = head;

//         while(curr != null){
//             if(curr.random != null){
//                 copyCurr.random = map.get(curr.random);//assigning curr.random next node to copycurr.random
//             }
//             curr = curr.next;
//             copyCurr = copyCurr.next;
//         }
//         return copyHead;
//     }
// }

// //one pass algo
// class Solution {
//     HashMap<Node, Node> map;
//     public Node copyRandomList(Node head) {
//         if(head == null) return null;
//          this.map = new HashMap<>();

//         Node curr = head;
//         Node copyHead = new Node(head.val);//creating deep copy of head
//         Node copyCurr = copyHead;

//         map.put(head, copyHead);//storing first nodes in map

//         while(curr != null){
//             copyCurr.next = clone(curr.next);
//             copyCurr.random = clone(curr.random);
            
//             curr = curr.next;
//             copyCurr = copyCurr.next;

//         } 
//         return copyHead;   
//     }

//     private Node clone(Node node){//making deep copy of linkedlist and putting in map
//         if(node == null) return null;
//         if(!map.containsKey(node)){
//             map.put(node, new Node(node.val));
//         }
//         return map.get(node);

//     }
// }


//without extra space
class Solution {
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
    
        while(curr != null){//creading copy nodes next to each original node
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        } 
        curr = head;

        while(curr != null){//creating random nodes
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }  

        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;

        while(curr != null){//breaking the connections
           curr.next = copyCurr.next;
           if(copyCurr.next != null){
             copyCurr.next = copyCurr.next.next;
           }
           curr = curr.next;
           copyCurr = copyCurr.next;
        }
        return copyHead;
    }

}