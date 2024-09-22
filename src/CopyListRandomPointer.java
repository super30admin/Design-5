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


// Iterate over the list and put the references in a map
// Iterate over the list again and map the next and random pointers accordingly. Get the references from map
// TC: O(n)
// SC: O(n)
class CopyListRandomPointer {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node,Node> map = new HashMap<>();
        while(curr!= null) {
            Node newNode = new Node(curr.val);
            if(!map.containsKey(curr)) {
                map.put(curr,newNode);
            }
            curr = curr.next;
        }
        curr = head;
        Node head1 = map.get(curr);
        Node curr1 = head1;
        while(curr!=null) {
            curr1.next = map.get(curr.next);
            if(curr.random!= null) {
                curr1.random = map.get(curr.random);
            }
            curr = curr.next;
            curr1 = curr1.next;
        }
    return head1;
    }
}



// Iterate over the list and put the references in a map and point next and random pointers at the same time
// TC: O(n)
// SC: O(n)
class Solution {
 public Node copyRandomList(Node head) {
     if(head == null) return null;
     Node curr = head;
     Map<Node,Node> map = new HashMap<>();
     Node head1 = new Node(head.val);
     map.put(head,head1);
     Node curr1 = head1;
     while(curr!= null) {
         if(curr.next!=null) {
             if(!map.containsKey(curr.next)) {
                 Node newNode = new Node(curr.next.val);
                 map.put(curr.next,newNode);
             }
             curr1.next = map.get(curr.next);
         }

         if(curr.random!= null) {
             Node randomNode = new Node(curr.random.val);
             if(!map.containsKey(curr.random)) {
                 map.put(curr.random,randomNode);
             }
             curr1.random = map.get(curr.random);
         }
         curr = curr.next;
         curr1 = curr1.next;
     }
     return head1;
 }
}


// Create a list with nodes and its deep copies as next nodes.
// Then point the random pointers
// Now separate the list with nodes and its deep copies
// TC: O(n)
// SC: O(1)
class Solution {
 public Node copyRandomList(Node head) {
     if(head == null) return null;
     Node curr = head;
     Node head1 = new Node(head.val);
     while(curr!=null) {
         Node newNode = new Node(curr.val);
         newNode.next = curr.next;
         curr.next = newNode;
         curr = curr.next.next;
     }
     curr = head;
     while(curr!=null) {
         if(curr.random!= null) {
             curr.next.random = curr.random.next;
         }
         curr=curr.next.next;
     }
     curr = head;
     Node copyHead = head.next;
     Node curr1 = copyHead;
     while(curr!= null) {
         curr.next = curr.next.next;
         if(curr1.next!= null) {
             curr1.next = curr1.next.next;
         }
         curr = curr.next;
         curr1 = curr1.next;
     }
     return copyHead;
 }
}