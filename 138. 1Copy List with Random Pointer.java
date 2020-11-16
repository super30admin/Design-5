class Solution {// time of O(n) and space of O(1)
    public Node copyRandomList(Node head) {
        if(head == null)
            return null ;
        
        //creating a new linked list after every element of old linked list
        Node ptr = head ;
        while(ptr != null){
            //creating and adding new node after current node
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next ;
            ptr.next = newNode ;
            ptr = newNode.next ;
        }
        //setting the random pointer
        ptr = head;
        while(ptr!= null){
            ptr.next.random = (ptr.random!= null) ?  ptr.random.next:null;
            ptr = ptr.next.next;
        }
        // Unweave the linked list
        Node ptrold = head ;
        Node ptrnew = head.next;
        Node newHead = ptrnew ;
        while(ptrold != null){
            ptrold.next =ptrold.next.next;
            ptrnew.next=(ptrnew.next != null)?ptrnew.next.next: null;
            ptrold = ptrold.next;
            ptrnew=ptrnew.next;
        }
        return newHead;
    }
}