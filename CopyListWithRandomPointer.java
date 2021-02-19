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
// TC : O(N)
// SC :  O(1)
// Did it run sucessfully on Leetcode? : Yes
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
          return null;
        Node curr = head;
        // Inserting the cloned node just next to the original node.
        while ( curr != null)
        {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        
        // copy random nodes
        curr = head;
        while ( curr != null)
        {
         // check if pointer.random is null, if not assign pointer.random.next to pointer.next.random
           curr.next.random = curr.random != null ?  curr.random.next : null;
           curr = curr.next.next;
        }
        
        //  /* Detach the lists */
        curr = head;
        Node copyListHead = head.next;
        while ( curr != null)
        {
            Node temp = curr.next;
            curr.next = temp.next;
            temp.next = curr.next != null ? curr.next.next : null;
            curr = curr.next;
        }
        return copyListHead;
    }
}

// Using HashMap
// TC: O(N)
// SC: O(N)
// Did it run sucessfully on Leetcode? : Yes
// class Solution {
//      HashMap<Node, Node> map;
//     public Node copyRandomList(Node head) {
//         if (head == null)
//           return null;
//         map = new HashMap();
        
//         Node curr = head;
//         Node copyHead = clone(head);
//         Node currCopy = copyHead;
//         while (curr != null)
//         {
//             currCopy.next = clone(curr.next);
//             currCopy.random = clone(curr.random);
//             curr = curr.next;
//             currCopy = currCopy.next;
//         }
//         return copyHead;
//     } 
//     private Node clone(Node node)
//     {
//         if ( node == null )
//             return null;
        
//         if (map.containsKey(node))
//         {
//             return map.get(node);
//         }
        
//         Node newNode = new Node(node.val);
//         map.put(node, newNode);
//         return newNode;
//     }
// }

// Using HashMap
// TC: O(N)
// SC: O(N)
// Did it run sucessfully on Leetcode? : Yes
// class Solution {
//     public Node copyRandomList(Node head) {
//         if (head == null)
//           return null;
//         HashMap<Node, Node> map = new HashMap();
//         Node original = head;
//         Node dummy = new Node(-1);
//         Node copyNode = dummy;
        
//         // map of original node as key and copyNode as value
//         while (original != null)
//         {
//             copyNode.next = new Node(original.val);
//             copyNode = copyNode.next;
//             map.put(original, copyNode);
//             original = original.next;
//         }
//         // Copy random pointers for all copyNodes
//          original = head;
//          copyNode = dummy.next;
//         while (original != null )
//         {
//             copyNode.random = map.get(original.random);
//             original = original.next;
//             copyNode = copyNode.next;
            
//         }
//         return dummy.next;
//     }
// }
