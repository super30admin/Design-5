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
// // 1 pass Solution TC = O(n) , SC = O(n) using HashMap
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head == null) return null;
//         HashMap<Node,Node> map = new HashMap<>();
//         Node curr = head;
//         Node copycurr = clone(head,map);
//         Node copyHead = copycurr;
//         while(curr != null){
//             if(curr.random != null){
//                 copycurr.random = clone(curr.random,map);
//             }
//             copycurr.next = clone(curr.next,map);
//             curr = curr.next;
//             copycurr = copycurr.next;
//         }

//         return copyHead;
//     }
//     private Node clone(Node node, HashMap<Node,Node> map){
//         if(node == null) return null;
//         if(!map.containsKey(node)){
//             map.put(node,new Node(node.val));
//         }
//         return map.get(node);
//     }
// }
// ###########################################################################################
// 2 pass Solution TC = O(n) , SC = O(n) using HashMap
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head == null) return null;
//         HashMap<Node,Node> map = new HashMap<>();
//         Node curr = head;
//         Node copycurr = new Node(head.val);
//         Node copyHead = copycurr;
//         map.put(curr,copycurr);
//         // 1st pass copy without random pointers and create hashmap
//         while(curr.next != null){
//             copycurr.next = new Node(curr.next.val);
//             map.put(curr.next,copycurr.next);
//             curr = curr.next;
//             copycurr = copycurr.next;
//         }
//         curr = head;
//         copycurr = copyHead;
//         // 2nd pass copy the random pointers
//         while(curr != null){
//             if(curr.random != null){
//                 copycurr.random = map.get(curr.random);
//             }
//             curr = curr.next;
//             copycurr = copycurr.next;
//         }
//         return copyHead;
//     }
// }
// ###########################################################################################

// BEST SOLUTION -- 
// 3 pass Solution TC = O(n) , SC = O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // 1st pass
        // copy all the nodes without random pointers
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        Node copycurr = head.next;
        Node copyHead = head.next;
        // 2nd pass
        // copy all the random pointers
        while(curr != null){
            if(curr.random != null){
                copycurr.random = curr.random.next; // because the new node is always next to old node and we want to connect copy curr to new node hence '.random.next'
                
            }
            curr = curr.next.next;
            if(copycurr.next != null) copycurr = copycurr.next.next;
        }
        curr = head;
        copycurr = head.next;
        // 3rd pass
        // Remove unnecessary connections and split the lists into 2 separate ones
        while(curr != null){
            curr.next = curr.next.next;
            if(copycurr.next != null) copycurr.next = copycurr.next.next;
            curr = curr.next;
            copycurr = copycurr.next;
        }

        return copyHead;
    }

}