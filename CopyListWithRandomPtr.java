
//TC - O(n)
//SC - O(1) - Most LL problems can be solved with O(1)
//Approach - Do not use a hashmap to store the clone of each node. Instead, create the clone of each node next to the current node. 
//place the random pointers accordingly

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //Create a copy of a node next to the original node
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
            
        }
        //Place the random ptr of each copy
        curr = head;
        while(curr != null){
        if(curr.random != null){
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
        }
        //Break LL into 2 LLinkedList - set next ptrs
        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;
        while(curr != null){
            curr.next = copyCurr.next;
            if(copyCurr.next == null){
                break;
            }
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        return copyHead;
    }
}